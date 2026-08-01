/**
 * This file constains snippet to show and unshow password field values
 */
// Toggle password visibility and update icon
const togglePassword = document.querySelector('#togglePassword');
const togglePassword02 = document.querySelector('#togglePassword02');
const password = document.querySelector('#password');
const password02 = document.querySelector('#password02');

togglePassword.addEventListener('click', function () {
    const type = password.getAttribute('type') === 'password' ? 'text' : 'password';
    password.setAttribute('type', type);
    this.querySelector('i').classList.toggle('fa-eye-slash');
});


togglePassword02.addEventListener('click', function () {
    const type = password02.getAttribute('type') === 'password' ? 'text' : 'password';
    password02.setAttribute('type', type);
    this.querySelector('i').classList.toggle('fa-eye-slash');
});
