/**
 * 
 */

function encryptText(text) {


    const key = CryptoJS.enc.Utf8.parse("13Viraj@67812345");
    const iv = CryptoJS.enc.Utf8.parse("13Viraj@67812345");

    const encrypted = CryptoJS.AES.encrypt(text, key, {
        iv: iv,
        mode: CryptoJS.mode.CBC,
        padding: CryptoJS.pad.Pkcs7
    });

    return encrypted.toString(); // Base64

}



function downloadTemplate(template){
	
	   // Get nearest card
    const card = template.closest(".card");

    // Get title
    const title = card.querySelector(".heading").innerText.trim();
    

    // Encrypt title
    const encrypted = encryptText(title);

    
    // Set hidden input
    card.querySelector(".encryptedTitle").value = encrypted;

    // Submit form
    button.closest("form").submit();
}