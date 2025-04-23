
function submenu(){
	
	let menuId = document.getElementById("myaccount");
	let accountStatus = menuId.getAttribute("class");
	let subMenu = document.getElementById("submenu_list_option");
	
	if(accountStatus.includes("menu-disable")){
	  menuId.className="menu-enable";
	  subMenu.style.display="block";	
	}else{
		menuId.className="menu-disable";
		subMenu.style.display="none";	
	}
}
function reset(){
    location.reload();
}

function validate1(){
    let username = document.f1.username.value;
	let password = document.f1.password.value;
	username = username.toLowerCase();
	password = password.toLowerCase();
	
	let username_alert = document.querySelector(".username-alert");
	
	// Regular expression to allow only alphanumeric characters
	var alphanumericPattern = /^[a-zA-Z]+$/;
	
	if (!alphanumericPattern.test(firstname)) {
	    username_alert.style.display = "block"; // Show error message
	    return false; // Prevent form submission
	}
	
    return true;  
}

function showPassword(){
	let input_value = document.getElementById("mypassword");
	let type = input_value.getAttribute("type");
	if(type.includes("password")){
       input_value.type = "text";
	}else{
       input_value.type="password";
	}
}
