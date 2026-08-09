<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta property="og:title" content="FlyingInvite | Home Page">
<meta property="og:description" content="India's Interative Invitation">
<meta property="og:url" content="https://flyinginvite.in/">
<meta property="og:type" content="website">
<meta property="og:site_name" content="FlyingInvite">
<meta property="og:image" content="https://red-katalin-50.tiiny.site/">
<meta property="og:image:type" content="image/jpeg">
<meta property="og:image:width" content="1200">
<meta property="og:image:height" content="630">
<link rel="icon" href="/favicon.ico" type="image/x-icon">
<link rel="icon" href=" ./assets/images/loggo.png" type="image/png">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Poppins:wght@100;200;300;400;500;600;700;800;900&display=swap" rel="stylesheet">
    <!-- Bootstrap 5 CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/bootstrap-icons/font/bootstrap-icons.css" rel="stylesheet">
<title>FlyingInvite | Special Invite</title>

    <!-- Bootstrap core CSS -->
    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
    <!-- Additional CSS Files -->
    <link rel="stylesheet" href="./assets/css/fontawesome.css">
    <link rel="stylesheet" href="./assets/css/app.css">
    <link rel="stylesheet" href="./assets/css/animated.css">
    <link rel="stylesheet" href="./assets/css/owl.css">
    <link rel="stylesheet" href="./assets/css/style.css">
    <script async src="https://www.googletagmanager.com/gtag/js?id=G-DZ4MP44ET9"></script>
<script>
  window.dataLayer = window.dataLayer || [];
  function gtag(){dataLayer.push(arguments);}
  gtag('js', new Date());

  gtag('config', 'G-DZ4MP44ET9');
</script>

</head>
<body>

<%
if(session.getAttribute("session_id") == null){
	session.invalidate();
    response.sendRedirect("login.jsp");
} else{

%>

 <!-- ***** Preloader Start ***** -->
  <div id="js-preloader" class="js-preloader">
    <div class="preloader-inner">
      <span class="dot"></span>
      <div class="dots">
        <span></span>
        <span></span>
        <span></span>
      </div>
    </div>
  </div>
  <!-- ***** Preloader End ***** -->

  <!-- Pre-header Starts -->

  <%@ include file="/WEB-INF/jsp/common/preheader.jsp" %>

  <!-- Pre-header End -->

  <!-- ***** Header Area Start ***** -->
  

  <!-- ***** Header Area Start ***** -->
       <%@ include file="/WEB-INF/jsp/common/header02.jsp" %>
  
  <!-- ***** Header Area End ***** -->

<div class="container" style="margin-top:80px;">
    
    <div class="heading_container text-center">
          <h3  style="padding:20px; font-family:Arial"> <a href="index.jsp#services"> <i class="bi bi-arrow-left fs-4"></i> </a> DIGITAL GREETINGS</h3>
    </div>

<div class="container" style="margin-bottom:2px; padding:30px; border:1px solid red; display: none;">
  <div class="row align-items-center">
    <!-- Text section -->
    <div class="col-12 col-lg-6 mb-2 mb-lg-0">
      <span class="expiry-alert d-inline-block mt-2" style="color:red;">
        <strong>Your subscription has expired, please renew to download more!</strong>
      </span>
    </div>

    <!-- Button section -->
    <div class="col-12 col-lg-6 d-flex justify-content-center justify-content-lg-end">
      <a href="#" id="Sample" class="btn btn-outline-danger">Renew</a>
    </div>
  </div>
 </div>
</div>


</div>

   <div class="container pt-5">   
     <div class="row">
     <!-- ---------------- Greeting Card01 Starts Here --------------------------------------->
         <div class="col-md-4" id = "yoga">
          <div class="container d-flex justify-content-center mt-3">
            <div class="card shadow" style="width: 500px;">
               <div class="carousel-inner">
                 <div class="carousel-item active">
                   <img src= "assets/images/thumbnail/star.png" class="d-block w-100" alt="Slide 1">
                      <a href="candidate_interview_selection_greetings.jsp">
                           <div class="card-body text-center">
                               <h5 class="card-title">Selection Greetings</h5>
                          </div>
                       </a> 
                  </div>
               </div>      
          </div>
       </div>
      </div>
   <!-- ---------------- Greeting Card01 Ends Here --------------------------------------->
   
   
   <!-- ---------------- Greeting Card02 Starts Here --------------------------------------->
         <div class="col-md-4" id = "yoga">
          <div class="container d-flex justify-content-center mt-3">
            <div class="card shadow" style="width: 500px;">
               <div class="carousel-inner">
                 <div class="carousel-item active">
                   <img src= "assets/images/thumbnail/star.png" class="d-block w-100" alt="Slide 1">
                      <a href="on_board_greetings.jsp">
                           <div class="card-body text-center">
                               <h5 class="card-title">Onboard Greetings</h5>
                          </div>
                       </a> 
                  </div>
               </div>      
          </div>
       </div>
      </div>
   <!-- ---------------- Greeting Card02 Ends Here --------------------------------------->
   
      <!-- ---------------- Greeting Card03 Starts Here --------------------------------------->
         <div class="col-md-4" id = "yoga">
          <div class="container d-flex justify-content-center mt-3">
            <div class="card shadow" style="width: 500px;">
               <div class="carousel-inner">
                 <div class="carousel-item active">
                   <img src= "assets/images/thumbnail/star.png" class="d-block w-100" alt="Slide 1">
                      <a href="employee_exit_greetings.jsp">
                           <div class="card-body text-center">
                               <h5 class="card-title">Exit Greetings</h5>
                          </div>
                       </a> 
                  </div>
               </div>      
          </div>
       </div>
      </div>
   <!-- ---------------- Greeting Card03 Ends Here --------------------------------------->
      </div>
      
       <div class="row">
       
       
    <!-- ---------------- Greeting Card04 Starts Here --------------------------------------->
         <div class="col-md-4" id = "yoga">
          <div class="container d-flex justify-content-center mt-3">
            <div class="card shadow" style="width: 500px;">
               <div class="carousel-inner">
                 <div class="carousel-item active">
                   <img src= "assets/images/thumbnail/star.png" class="d-block w-100" alt="Slide 1">
                      <a href="product_launch_greetings.jsp">
                           <div class="card-body text-center">
                               <h5 class="card-title">Product Launch Greetings</h5>
                          </div>
                       </a> 
                  </div>
               </div>      
          </div>
       </div>
      </div>
   <!-- ---------------- Greeting Card04 Ends Here --------------------------------------->
   
   
       <!-- ---------------- Greeting Card05 Starts Here --------------------------------------->
         <div class="col-md-4" id = "yoga">
          <div class="container d-flex justify-content-center mt-3">
            <div class="card shadow" style="width: 500px;">
               <div class="carousel-inner">
                 <div class="carousel-item active">
                   <img src= "assets/images/thumbnail/star.png" class="d-block w-100" alt="Slide 1">
                      <a href="employee_birthday_greetings.jsp">
                           <div class="card-body text-center">
                               <h5 class="card-title">Birthday Greetings</h5>
                          </div>
                       </a> 
                  </div>
               </div>      
          </div>
       </div>
      </div>
   <!-- ---------------- Greeting Card05 Ends Here --------------------------------------->
   
   
          <!-- ---------------- Greeting Card06 Starts Here --------------------------------------->
         <div class="col-md-4" id = "yoga">
          <div class="container d-flex justify-content-center mt-3">
            <div class="card shadow" style="width: 500px;">
               <div class="carousel-inner">
                 <div class="carousel-item active">
                   <img src= "assets/images/thumbnail/star.png" class="d-block w-100" alt="Slide 1">
                      <a href="employee_promotion_greetings.jsp">
                           <div class="card-body text-center">
                               <h5 class="card-title">Promotion Greetings</h5>
                          </div>
                       </a> 
                  </div>
               </div>      
          </div>
       </div>
      </div>
   <!-- ---------------- Greeting Card05 Ends Here --------------------------------------->
   
   </div>
   
  </div>



<div class="main02" id="invitations" style="display:none;">
 <div class="container d-flex justify-content-end my-4">
 <div class="container mt-3">
   <select class="form-select btn-outline-primary" id="invites" onchange="invitation_filter();">
        <option selected>Open this select menu</option>
    </select>
   </div>
</div>

   <h1 style="padding:60px; font-family:Arial"> DIGITAL INVITATIONS</h1>

    <!-- ---------------- Card01 Starts Here --------------------------------------->

   <div class="container mt-5">   
    
     <!-- ---------------- Card01 Starts Here --------------------------------------->
     <!-- 
      <div class="row"> 
       <div class="col-md-4" id="yoga_day_invite">
          <div class="container d-flex justify-content-center mt-3">
            <div class="card shadow" style="width: 500px;">
               <div class="carousel-inner">
                 <div class="carousel-item active">
                   <img src="assets/images/thumbnail/yoga.png" class="d-block w-100" alt="Slide 1">
                      <a href="yoga_day_invitations.jsp">
                           <div class="card-body text-center">
                            <h5 class="card-title">Yoga Day Invitations</h5>
                          </div>
                       </a> 
                  </div>
               </div>      
           </div> 
          </div>
       </div>
      </div>  -->
          
          
        <h2 class="blink_me"  id="coming_soon_header" style=" margin: 0px auto 0px auto;">Coming Soon</h2>

      
   <!-- ---------------- Card01 Ends Here --------------------------------------->
   
    </div> 
</div> 

  
  <!-- ------------Footer starts here ------------------------------->

    <%@ include file="/WEB-INF/jsp/common/footer.jsp" %>
   
 <!-- ------------Footer ends here-------------------------------->  
   

  <!-- Scripts -->
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
  <script src="./vendor/jquery/jquery.min.js"></script>
  <script src="./vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
  <script src="./assets/js/owl-carousel.js"></script>
  <script src="./assets/js/animation.js"></script>
  <script src="./assets/js/imagesloaded.js"></script>
  <script src="./assets/js/custom.js"></script>
  <script src="./assets/js/app.js"></script>
  <script src="./assets/js/script.js"></script>
  <script src="./assets/js/dropdown.js"></script>
  <script src="./assets/js/greeting_drop_down.js"></script>
  <script src="./assets/js/invite_drop_down.js"></script>

<%}%>
</body>
</html>