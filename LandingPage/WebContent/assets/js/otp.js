/**
 * 
 */

document.addEventListener("DOMContentLoaded", () => {
    const inputs = document.querySelectorAll(".otp-box");
    const hiddenInput = document.getElementById("fullOtp");
    const form = document.getElementById("otpForm");

    inputs.forEach((input, index) => {
        // Auto-increment forward on input
        input.addEventListener("input", (e) => {
            const currentInput = e.target;
            const nextInput = inputs[index + 1];

            // Filter out non-numeric characters
            currentInput.value = currentInput.value.replace(/[^0-9]/g, '');

            if (currentInput.value.length === 1 && nextInput) {
                nextInput.focus();
            }
            updateHiddenValue();
        });

        // Move backward on Backspace
        input.addEventListener("keydown", (e) => {
            const currentInput = e.target;
            const prevInput = inputs[index - 1];

            if (e.key === "Backspace" && currentInput.value.length === 0 && prevInput) {
                prevInput.focus();
            }
        });

        // Handle Paste event (e.g., user copies a 6-digit code)
        input.addEventListener("paste", (e) => {
            e.preventDefault();
            const pastedData = (e.clipboardData || window.clipboardData).getData("text").trim();
            
            if (/^\d{6}$/.test(pastedData)) { // Check if it's exactly 6 digits
                inputs.forEach((inp, idx) => {
                    inp.value = pastedData[idx];
                });
                inputs[5].focus(); // Focus last box
                updateHiddenValue();
            }
        });
    });

    // Concatenate all 6 box values into the hidden field
    function updateHiddenValue() {
        let combinedValue = "";
        inputs.forEach(input => {
            combinedValue += input.value;
        });
        hiddenInput.value = combinedValue;
    }

    // Ensure the hidden field is fully populated on submit
    form.addEventListener("submit", (e) => {
        updateHiddenValue();
        if (hiddenInput.value.length !== 6) {
            e.preventDefault();
            alert("Please enter a valid 6-digit OTP.");
        }
    });
});