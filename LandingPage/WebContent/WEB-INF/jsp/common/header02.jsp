<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Header File</title>
      <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons/font/bootstrap-icons.css" rel="stylesheet">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.3.3/css/bootstrap.min.css" rel="stylesheet">
     <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.3.3/js/bootstrap.bundle.min.js"></script>
  
</head>


<body>



<nav class="navbar bg-body-tertiary wow slideInDown" style="margin-top:0px; padding:30px; border-bottom:1px solid #ccc;"">
<!-- Example single danger button -->

<div class="container d-flex justify-content-end">
<div class="dropdown" style="padding:15px;">
  <button id="dropdownBtn" style="padding:15px;" class="btn btn-outline-danger dropdown-toggle" type="button" data-bs-toggle="dropdown" onClick="display();" aria-expanded="false">
    Namaste !
  </button>
  <ul class="dropdown-menu" id="menu-option" style="display:none;">
    <li><a class="dropdown-item" href="edit_profile.jsp"> <i class="bi bi-person"> </i> Edit Profile</a></li>
    <li><a class="dropdown-item" href="reset_password.jsp"><i class="bi bi-gear"> </i> Reset Password</a></li>
    <li><a class="dropdown-item" href="greetings.jsp"><i class="bi bi-bookmark-check"></i> Greetings & Invitations</a></li>       
    <li><a class="dropdown-item" href="correct_the.jsp"><i class="bi bi-robot"> </i> CorrectThe</a></li>
    <li><a class="dropdown-item" href="#"><i class="bi bi-cash-coin"> </i> Renew Subscription</a></li>
    <li><hr class="dropdown-divider"></li>
   <li><a class="dropdown-item text-center" href="login.jsp"> <i class="bi bi-power"> </i> Sign-Out</a></li>
   </ul>
  </div>
</div>
</nav>
  

    <script src="./assets/js/logout.js"></script>    
    <script src="./assets/js/dashboard_menu_button.js"></script>  
    
</body>
</html>