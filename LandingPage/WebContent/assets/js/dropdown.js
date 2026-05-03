/**
 *  Handles drop down list, by changing button text on invitation and greeting page
 */

const items = document.querySelectorAll('.dropdown-item');
const button = document.getElementById('dropdownBtn');

items.forEach(item => {
  item.addEventListener('click', function () {
    button.textContent = this.textContent;
  });
});
