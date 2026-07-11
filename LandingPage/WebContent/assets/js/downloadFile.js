/**
 * 
 */

function downloadTemplate(submit) {
    const form = submit.closest("form");
    const templateId = form.querySelector(".templateId").value;
    if (!templateId) {
    	window.location.href = "/404.jsp";
        return;
    }
    form.submit();
}