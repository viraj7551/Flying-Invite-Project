/**
 * 
 */


// ===================================================================
// TRANSLATION TAB
// ===================================================================
document.getElementById('translateForm').addEventListener('submit', function (e) {
    e.preventDefault();

    const sourceText = document.getElementById('sourceText').value.trim();
    const sourceLang = document.getElementById('sourceLang').value;
    const targetLang = document.getElementById('targetLang').value;

    const errorBox = document.getElementById('translateError');
    const resultBlock = document.getElementById('translateResultBlock');
    const spinner = document.getElementById('translateSpinner');

    errorBox.classList.add('d-none');
    resultBlock.classList.add('d-none');

    if (!sourceText) {
        errorBox.textContent = 'Please enter some text to translate.';
        errorBox.classList.remove('d-none');
        return;
    }

    spinner.classList.remove('d-none');

    const params = new URLSearchParams();
    params.append('sourceText', sourceText);
    params.append('sourceLang', sourceLang);
    params.append('targetLang', targetLang);

    fetch('TranslateServlet', {
        method: 'POST',
        headers: { 'Content-Type': 'application/x-www-form-urlencoded' },
        body: params.toString()
    })
        .then(response => response.json())
        .then(data => {
            spinner.classList.add('d-none');
            if (data.error) {
                errorBox.textContent = data.error;
                errorBox.classList.remove('d-none');
                return;
            }
            document.getElementById('translatedTextOutput').textContent = data.translatedText;
            resultBlock.classList.remove('d-none');
        })
        .catch(err => {
            spinner.classList.add('d-none');
            errorBox.textContent = 'Request failed: ' + err;
            errorBox.classList.remove('d-none');
        });
});


// ===================================================================
// SENTENCE CORRECTION TAB
// ===================================================================
document.getElementById('correctForm').addEventListener('submit', function (e) {
    e.preventDefault();

    const inputText = document.getElementById('inputText').value.trim();

    const errorBox = document.getElementById('correctError');
    const resultBlock = document.getElementById('correctResultBlock');
    const spinner = document.getElementById('correctSpinner');

    errorBox.classList.add('d-none');
    resultBlock.classList.add('d-none');

    if (!inputText) {
        errorBox.textContent = 'Please enter some text to check.';
        errorBox.classList.remove('d-none');
        return;
    }

    spinner.classList.remove('d-none');

    const params = new URLSearchParams();
    params.append('text', inputText);

    fetch('CorrectServlet', {
        method: 'POST',
        headers: { 'Content-Type': 'application/x-www-form-urlencoded' },
        body: params.toString()
    })
        .then(response => response.json())
        .then(data => {
            spinner.classList.add('d-none');
            if (data.error) {
                errorBox.textContent = data.error;
                errorBox.classList.remove('d-none');
                return;
            }

            document.getElementById('correctedTextOutput').textContent = data.correctedText;

            const diffHtml = buildWordDiffHtml(data.originalText, data.correctedText);
            document.getElementById('diffOutput').innerHTML = diffHtml;

            resultBlock.classList.remove('d-none');
        })
        .catch(err => {
            spinner.classList.add('d-none');
            errorBox.textContent = 'Request failed: ' + err;
            errorBox.classList.remove('d-none');
        });
});


// ===================================================================
// Simple word-level diff (LCS based) - highlights removed vs added words
// ===================================================================
function buildWordDiffHtml(originalText, correctedText) {
    const originalWords = originalText.split(/\s+/).filter(w => w.length > 0);
    const correctedWords = correctedText.split(/\s+/).filter(w => w.length > 0);

    const n = originalWords.length;
    const m = correctedWords.length;

    // Build LCS length table
    const lcs = Array.from({ length: n + 1 }, () => new Array(m + 1).fill(0));
    for (let i = 1; i <= n; i++) {
        for (let j = 1; j <= m; j++) {
            if (originalWords[i - 1] === correctedWords[j - 1]) {
                lcs[i][j] = lcs[i - 1][j - 1] + 1;
            } else {
                lcs[i][j] = Math.max(lcs[i - 1][j], lcs[i][j - 1]);
            }
        }
    }

    // Backtrack to build a sequence of operations: equal / removed / added
    const ops = [];
    let i = n, j = m;
    while (i > 0 && j > 0) {
        if (originalWords[i - 1] === correctedWords[j - 1]) {
            ops.push({ type: 'equal', word: originalWords[i - 1] });
            i--; j--;
        } else if (lcs[i - 1][j] >= lcs[i][j - 1]) {
            ops.push({ type: 'removed', word: originalWords[i - 1] });
            i--;
        } else {
            ops.push({ type: 'added', word: correctedWords[j - 1] });
            j--;
        }
    }
    while (i > 0) { ops.push({ type: 'removed', word: originalWords[i - 1] }); i--; }
    while (j > 0) { ops.push({ type: 'added', word: correctedWords[j - 1] }); j--; }

    ops.reverse();

    // Convert ops to HTML spans
    let html = '';
    ops.forEach(op => {
        const escaped = escapeHtml(op.word);
        if (op.type === 'equal') {
            html += '<span class="diff-unchanged">' + escaped + '</span> ';
        } else if (op.type === 'removed') {
            html += '<span class="diff-removed">' + escaped + '</span> ';
        } else if (op.type === 'added') {
            html += '<span class="diff-added">' + escaped + '</span> ';
        }
    });

    return html;
}

function escapeHtml(str) {
    const div = document.createElement('div');
    div.textContent = str;
    return div.innerHTML;
}
