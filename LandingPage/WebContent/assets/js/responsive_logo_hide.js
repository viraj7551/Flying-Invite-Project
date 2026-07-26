/**
 *  this file contains the source code when menu burger is active, it hides the brand logo
 */

const container = document.querySelector('.container');
const logo = document.querySelector('#brand_logo');
const burger = document.querySelector('#menu_trigger'); // your burger button

burger.addEventListener('click', () => {
    container.classList.toggle('active');
    if (container.classList.contains('active')) {
        logo.style.display = 'none';
    } else {
        logo.style.display = 'block';
    }
});