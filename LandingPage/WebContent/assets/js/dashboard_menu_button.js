/**
 *  This snippet helps to open and close drop down for navigation menu list
 */

var button = document.getElementById("dropdownBtn");
var drop_down_menu_options = document.getElementById("menu-option");
var flag = false;

button.addEventListener('click', function () {
	if(flag){
		drop_down_menu_options.style.display="none";
		flag = false;
	}else{
		drop_down_menu_options.style.display="block";
		flag = true;
	}

})