/**
 *  This file when user session is active and clicks on sign-out it helps to redirect Logout Servlet file
 */

document.getElementById("logout").addEventListener("click", function () {
    if (confirm("Are you sure you want to sign out?")) {
        window.location.href = "Logout";
    }
});