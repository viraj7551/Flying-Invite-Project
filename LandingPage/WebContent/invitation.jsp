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
<link rel="icon" href=" ./assets/images/FlyingInvite.png" type="image/png">
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
  <header class="header-area header-sticky wow slideInDown" data-wow-duration="0.75s" data-wow-delay="0s">
    <div class="container">
      <div class="row">
        <div class="col-12">

            <!-- ***** Menu Start ***** -->
               <nav class="nav nav-pills justify-content-center">
                  <a class="flex-sm-fill text-sm-center nav-link active" aria-current="page" href="#" data-toggle="tooltip" data-placement="right" title="Digital Invitations is and invitation">Electronic Invites</a>
                  <a class="flex-sm-fill text-sm-center nav-link" href="interactive_invitation.jsp" data-toggle="tooltip" data-placement="right" title="Digital Invitations is and invitation">RSVP Invites</a>
            <!-- ***** Menu End ***** -->
          </nav>
        </div>
      </div>
    </div>
  </header>
  
  <!-- ***** Header Area End ***** -->



  <!-- ------------------Badges Start Here ----------------------------------------------------->

  <div class="badges" style="margin-top:180px; text-align:center">
       <button type="button" class="btn btn-outline-primary active" id="btn_greeting" onclick="invitations_tab('greetings');">Greetings</button>  
       <button type="button" class="btn btn-outline-primary" id="btn_invitation" onclick="invitations_tab('invitations');">Invitations</button> 
  </div>

<!-- ------------------Badges End Here  ------------------------------------------------------->



<div class="main" id="greetings" style="display:block;">
 <div class="container d-flex justify-content-end my-4">
 <div class="container mt-3">
   <select class="form-select btn-outline-primary" id="greeting" onchange="greeting_filter();">
        <option selected>Open this select menu</option>
        <option value="Republic Day Greetings">Republic Day Greetings</option>
        <option value="Independence Day Greetings">Independence Day Greetings</option>
        <option value="Ganesh Chatturthi">Ganesh Chatturthi</option>        
        <option value="Guddi Padwa Greetings">Guddi Padwa Greetings</option>
        <option value="Anniversary Greetings">Anniversary Greetings</option>
        <option value="Marriage Greetings">Marriage Greetings</option>
        <option value="Makkar Sankrati Greetings">Makkar Sankrati Greetings</option>
        <option value="Diwali Greetings">Diwali Greetings</option>
        <option value="Birthday Greetings">Birthday Greetings</option>
        <option value="Navratri Greetings">Navratri Greetings</option>
        <option value="Holi Greetings">Holi Greetings</option>
        <option value="Baby Shower Greetings">Baby Shower Greetings</option>
        <option value="Eid Greetings">Eid Greetings</option>
    </select>
   </div>
</div>

   <h1 style="padding:60px; font-family:Arial"> <a href="index.jsp"> <i class="bi bi-arrow-left fs-1"></i> </a> DIGITAL GREETINGS <span id="greetings_count"></span></h1>

   <div class="container mt-5">   
     <div class="row">
     <!-- ---------------- Greeting Card01 Starts Here --------------------------------------->
         <div class="col-md-4" id = "babyshower">
          <div class="container d-flex justify-content-center mt-3">
            <div class="card shadow" style="width: 500px;">
               <div class="carousel-inner">
                 <div class="carousel-item active">
                   <img src="https://picsum.photos/500/300?random=1" class="d-block w-100" alt="Slide 1">
                      <a href="baby_shower_invitations.jsp">
                           <div class="card-body text-center">
                            <h5 class="card-title">Baby Shower Greetings</h5>
                          </div>
                       </a> 
                  </div>
               </div>      
          </div>
       </div>
      </div>
   <!-- ---------------- Greeting Card01 Ends Here --------------------------------------->
   
   <!-- ---------------- Greeting Card02 Starts Here --------------------------------------->
         <div class="col-md-4" id="republic_day">
          <div class="container d-flex justify-content-center mt-3">
            <div class="card shadow" style="width: 500px;">
               <div class="carousel-inner">
                 <div class="carousel-item active">
                   <img src="https://picsum.photos/500/300?random=1" class="d-block w-100" alt="Slide 1">
                      <a href="baby_shower_invitations.jsp">
                           <div class="card-body text-center">
                            <h5 class="card-title">Republic Day Greetings</h5>
                          </div>
                       </a> 
                  </div>
               </div>      
          </div>
       </div>
      </div>
   <!-- ---------------- Greeting Card02 Ends Here --------------------------------------->
   
      <!-- ---------------- Greeting Card03 Starts Here --------------------------------------->
         <div class="col-md-4" id="holi">
          <div class="container d-flex justify-content-center mt-3">
            <div class="card shadow" style="width: 500px;">
               <div class="carousel-inner">
                 <div class="carousel-item active">
                   <img src="https://picsum.photos/500/300?random=1" class="d-block w-100" alt="Slide 1">
                      <a href="baby_shower_invitations.jsp">
                           <div class="card-body text-center">
                            <h5 class="card-title">Holi Greetings</h5>
                          </div>
                       </a> 
                  </div>
               </div>      
          </div>
       </div>
      </div>
   <!-- ---------------- Greeting Card03 Ends Here --------------------------------------->
   
   <!-- ---------------- Greeting Card04 Starts Here --------------------------------------->
         <div class="col-md-4" id="ganesh_chatturthi">
          <div class="container d-flex justify-content-center mt-3">
            <div class="card shadow" style="width: 500px;">
               <div class="carousel-inner">
                 <div class="carousel-item active">
                   <img src="https://picsum.photos/500/300?random=1" class="d-block w-100" alt="Slide 1">
                      <a href="baby_shower_invitations.jsp">
                           <div class="card-body text-center">
                            <h5 class="card-title">Ganesh Chaturthi Greetings</h5>
                          </div>
                       </a> 
                  </div>
               </div>      
          </div>
       </div>
      </div>
   <!-- ---------------- Greeting Card04 Ends Here --------------------------------------->
   
      <!-- ---------------- Greeting Card05 Starts Here --------------------------------------->
         <div class="col-md-4" id="independence_day">
          <div class="container d-flex justify-content-center mt-3">
            <div class="card shadow" style="width: 500px;">
               <div class="carousel-inner">
                 <div class="carousel-item active">
                   <img src="https://picsum.photos/500/300?random=1" class="d-block w-100" alt="Slide 1">
                      <a href="baby_shower_invitations.jsp">
                           <div class="card-body text-center">
                            <h5 class="card-title">Independence Day Greetings</h5>
                          </div>
                       </a> 
                  </div>
               </div>      
          </div>
       </div>
      </div>
   <!-- ---------------- Greeting Card05 Ends Here --------------------------------------->
   
    <!-- ---------------- Greeting Card06 Starts Here --------------------------------------->
         <div class="col-md-4" id="navratri">
          <div class="container d-flex justify-content-center mt-3">
            <div class="card shadow" style="width: 500px;">
               <div class="carousel-inner">
                 <div class="carousel-item active">
                   <img src="https://picsum.photos/500/300?random=1" class="d-block w-100" alt="Slide 1">
                      <a href="baby_shower_invitations.jsp">
                           <div class="card-body text-center">
                            <h5 class="card-title">Navrattri Greetings</h5>
                          </div>
                       </a> 
                  </div>
               </div>      
          </div>
       </div>
      </div>
   <!-- ---------------- Greeting Card06 Ends Here --------------------------------------->
   
   <!-- ---------------- Greeting Card07 Starts Here --------------------------------------->
         <div class="col-md-4" id="birthday">
          <div class="container d-flex justify-content-center mt-3">
            <div class="card shadow" style="width: 500px;">
               <div class="carousel-inner">
                 <div class="carousel-item active">
                   <img src="https://picsum.photos/500/300?random=1" class="d-block w-100" alt="Slide 1">
                      <a href="baby_shower_invitations.jsp">
                           <div class="card-body text-center">
                            <h5 class="card-title">Birthday Greetings</h5>
                          </div>
                       </a> 
                  </div>
               </div>      
          </div>
       </div>
      </div>
   <!-- ---------------- Greeting Card07 Ends Here --------------------------------------->
   
   
      <!-- ---------------- Greeting Card08 Starts Here --------------------------------------->
         <div class="col-md-4" id="diwali">
          <div class="container d-flex justify-content-center mt-3">
            <div class="card shadow" style="width: 500px;">
               <div class="carousel-inner">
                 <div class="carousel-item active">
                   <img src="https://picsum.photos/500/300?random=1" class="d-block w-100" alt="Slide 1">
                      <a href="baby_shower_invitations.jsp">
                           <div class="card-body text-center">
                            <h5 class="card-title"> Diwali Greetings</h5>
                          </div>
                       </a> 
                  </div>
               </div>      
          </div>
       </div>
      </div>
   <!-- ---------------- Greeting Card08 Ends Here --------------------------------------->
   
   <!-- ---------------- Greeting Card09 Starts Here --------------------------------------->
         <div class="col-md-4" id="marriage">
          <div class="container d-flex justify-content-center mt-3">
            <div class="card shadow" style="width: 500px;">
               <div class="carousel-inner">
                 <div class="carousel-item active">
                   <img src="https://picsum.photos/500/300?random=1" class="d-block w-100" alt="Slide 1">
                      <a href="baby_shower_invitations.jsp">
                           <div class="card-body text-center">
                            <h5 class="card-title">Marriage Greetings</h5>
                          </div>
                       </a> 
                  </div>
               </div>      
          </div>
       </div>
      </div>
   <!-- ---------------- Greeting Card09 Ends Here --------------------------------------->
   
  <!-- ---------------- Greeting Card10 Starts Here --------------------------------------->
         <div class="col-md-4" id="makar_sankrant">
          <div  class="container d-flex justify-content-center mt-3">
            <div class="card shadow" style="width: 500px;">
               <div class="carousel-inner">
                 <div class="carousel-item active">
                   <img src="https://picsum.photos/500/300?random=1" class="d-block w-100" alt="Slide 1">
                      <a href="baby_shower_invitations.jsp">
                           <div class="card-body text-center">
                            <h5 class="card-title">Makar Sankrati Greetings</h5>
                          </div>
                       </a> 
                  </div>
               </div>      
          </div>
       </div>
      </div>
   <!-- ---------------- Greeting Card10 Ends Here --------------------------------------->
   
   <!-- ---------------- Greeting Card11 Starts Here --------------------------------------->
         <div class="col-md-4" id="anniversary">
          <div class="container d-flex justify-content-center mt-3">
            <div class="card shadow" style="width: 500px;">
               <div class="carousel-inner">
                 <div class="carousel-item active">
                   <img src="https://picsum.photos/500/300?random=1" class="d-block w-100" alt="Slide 1">
                      <a href="baby_shower_invitations.jsp">
                           <div class="card-body text-center">
                            <h5 class="card-title">Anniversary Greetings</h5>
                          </div>
                       </a> 
                  </div>
               </div>      
          </div>
       </div>
      </div>
   <!-- ---------------- Greeting Card11 Ends Here --------------------------------------->
   
   <!-- ---------------- Greeting Card12 Starts Here --------------------------------------->
         <div class="col-md-4" id="guddi_padwa">
          <div class="container d-flex justify-content-center mt-3">
            <div class="card shadow" style="width: 500px;">
               <div class="carousel-inner">
                 <div class="carousel-item active">
                   <img src="https://picsum.photos/500/300?random=1" class="d-block w-100" alt="Slide 1">
                      <a href="baby_shower_invitations.jsp">
                           <div class="card-body text-center">
                            <h5 class="card-title">Guddi Padwa Greetings</h5>
                          </div>
                       </a> 
                  </div>
               </div>      
          </div>
       </div>
      </div>
   <!-- ---------------- Greeting Card12 Ends Here --------------------------------------->
   
  <!-- ---------------- Greeting Card13 Starts Here --------------------------------------->
         <div class="col-md-4" id="eid">
          <div class="container d-flex justify-content-center mt-3">
            <div class="card shadow" style="width: 500px;">
               <div class="carousel-inner">
                 <div class="carousel-item active">
                   <img src="https://picsum.photos/500/300?random=1" class="d-block w-100" alt="Slide 1">
                      <a href="baby_shower_invitations.jsp">
                           <div class="card-body text-center">
                            <h5 class="card-title">Eid Greetings</h5>
                          </div>
                       </a> 
                  </div>
               </div>      
          </div>
       </div>
      </div>
   <!-- ---------------- Greeting Card13 Ends Here --------------------------------------->
      </div>
   </div>
</div>




<div class="main02" id="invitations" style="display:none;">
 <div class="container d-flex justify-content-end my-4">
 <div class="container mt-3">
   <select class="form-select btn-outline-primary" id="invites" onchange="invitation_filter();">
        <option selected>Open this select menu</option>
        <option value="Republic Day Invitations">Republic Day Invitations</option>
        <option value="Independence Day Invitations">Independence Day Invitations</option>
        <option value="Ganesh Chatturthi Invitations">Ganesh Chatturthi Invitations</option>        
        <option value="Guddi Padwa Invitations">Guddi Padwa Invitations</option>
        <option value="Anniversary Invitations">Anniversary Invitations</option>
        <option value="Marriage Invitations">Marriage Invitations</option>
        <option value="Makkar Sankrati Invitations">Makkar Sankrati Invitations</option>
        <option value="Diwali Invitations">Diwali Invitations</option>
        <option value="Birthday Invitations">Birthday Invitations</option>
        <option value="Navrattri Invitations">Navrattri Invitations</option>
        <option value="Holi Invitations">Holi Invitations</option>
        <option value="Baby Shower Invitations">Baby Shower Invitations</option>
        <option value="Eid Invitations">Eid Invitations</option>
    </select>
   </div>
</div>

   <h1 style="padding:60px; font-family:Arial"> DIGITAL INVITATIONS</h1>

    <!-- ---------------- Card01 Starts Here --------------------------------------->

   <div class="container mt-5">   
    <div class="row">
    
     <!-- ---------------- Card01 Starts Here --------------------------------------->
       <div class="col-md-4" id="baby_shower_invite">
          <div class="container d-flex justify-content-center mt-3">
            <div class="card shadow" style="width: 500px;">
               <div class="carousel-inner">
                 <div class="carousel-item active">
                   <img src="https://picsum.photos/500/300?random=1" class="d-block w-100" alt="Slide 1">
                      <a href="baby_shower_invitations.jsp">
                           <div class="card-body text-center">
                            <h5 class="card-title">Baby Shower Invitations</h5>
                          </div>
                       </a> 
                  </div>
               </div>      
          </div>
       </div>
      </div>
      
   <!-- ---------------- Card01 Ends Here --------------------------------------->
   
       
     <!-- ---------------- Card02 Starts Here --------------------------------------->
       <div class="col-md-4" id="republic_day_invite">
          <div class="container d-flex justify-content-center mt-3">
            <div class="card shadow" style="width: 500px;">
               <div class="carousel-inner">
                 <div class="carousel-item active">
                   <img src="https://picsum.photos/500/300?random=1" class="d-block w-100" alt="Slide 1">
                      <a href="baby_shower_invitations.jsp">
                           <div class="card-body text-center">
                            <h5 class="card-title">Republic Day Invitations</h5>
                          </div>
                       </a> 
                  </div>
               </div>      
          </div>
       </div>
      </div>
      
     <!-- ---------------- Card02 Ends Here --------------------------------------->
   
     <!-- ---------------- Card03 Starts Here --------------------------------------->
       <div class="col-md-4" id="holi_invite">
          <div class="container d-flex justify-content-center mt-3">
            <div class="card shadow" style="width: 500px;">
               <div class="carousel-inner">
                 <div class="carousel-item active">
                   <img src="https://picsum.photos/500/300?random=1" class="d-block w-100" alt="Slide 1">
                      <a href="baby_shower_invitations.jsp">
                           <div class="card-body text-center">
                            <h5 class="card-title">Holi Invitations</h5>
                          </div>
                       </a> 
                  </div>
               </div>      
          </div>
       </div>
      </div>
      
   <!-- ---------------- Card03 Ends Here --------------------------------------->
   
        <!-- ---------------- Card04 Starts Here --------------------------------------->
       <div class="col-md-4" id="ganesh_chaturthi_invite">
          <div class="container d-flex justify-content-center mt-3">
            <div class="card shadow" style="width: 500px;">
               <div class="carousel-inner">
                 <div class="carousel-item active">
                   <img src="https://picsum.photos/500/300?random=1" class="d-block w-100" alt="Slide 1">
                      <a href="baby_shower_invitations.jsp">
                           <div class="card-body text-center">
                            <h5 class="card-title">Ganesh Chatturthi Invitations</h5>
                          </div>
                       </a> 
                  </div>
               </div>      
          </div>
       </div>
      </div>
      
   <!-- ---------------- Card04 Ends Here --------------------------------------->

   <!-- ---------------- Card05 Starts Here --------------------------------------->
       <div class="col-md-4" id="independence_day_invite">
          <div class="container d-flex justify-content-center mt-3">
            <div class="card shadow" style="width: 500px;">
               <div class="carousel-inner">
                 <div class="carousel-item active">
                   <img src="https://picsum.photos/500/300?random=1" class="d-block w-100" alt="Slide 1">
                      <a href="baby_shower_invitations.jsp">
                           <div class="card-body text-center">
                            <h5 class="card-title">Independance Day Invitations</h5>
                          </div>
                       </a> 
                  </div>
               </div>      
          </div>
       </div>
      </div>
      
   <!-- ---------------- Card05 Ends Here --------------------------------------->
   
   <!-- ---------------- Card06 Starts Here --------------------------------------->
       <div class="col-md-4" id="navratri_invite">
          <div class="container d-flex justify-content-center mt-3">
            <div class="card shadow" style="width: 500px;">
               <div class="carousel-inner">
                 <div class="carousel-item active">
                   <img src="https://picsum.photos/500/300?random=1" class="d-block w-100" alt="Slide 1">
                      <a href="baby_shower_invitations.jsp">
                           <div class="card-body text-center">
                            <h5 class="card-title">Navrattri Invitations</h5>
                          </div>
                       </a> 
                  </div>
               </div>      
          </div>
       </div>
      </div>
      
   <!-- ---------------- Card06 Ends Here --------------------------------------->
   
  <!-- ---------------- Card07 Starts Here --------------------------------------->
       <div class="col-md-4" id="birthday_invite">
          <div class="container d-flex justify-content-center mt-3">
            <div class="card shadow" style="width: 500px;">
               <div class="carousel-inner">
                 <div class="carousel-item active">
                   <img src="https://picsum.photos/500/300?random=1" class="d-block w-100" alt="Slide 1">
                      <a href="baby_shower_invitations.jsp">
                           <div class="card-body text-center">
                            <h5 class="card-title">Birthday Invitations</h5>
                          </div>
                       </a> 
                  </div>
               </div>      
          </div>
       </div>
      </div>
      
   <!-- ---------------- Card07 Ends Here --------------------------------------->
   
     <!-- ---------------- Card08 Starts Here --------------------------------------->
       <div class="col-md-4" id="diwali_invite">
          <div class="container d-flex justify-content-center mt-3">
            <div class="card shadow" style="width: 500px;">
               <div class="carousel-inner">
                 <div class="carousel-item active">
                   <img src="https://picsum.photos/500/300?random=1" class="d-block w-100" alt="Slide 1">
                      <a href="baby_shower_invitations.jsp">
                           <div class="card-body text-center">
                            <h5 class="card-title">Diwali Invitations</h5>
                          </div>
                       </a> 
                  </div>
               </div>      
          </div>
       </div>
      </div>
      
   <!-- ---------------- Card08 Ends Here --------------------------------------->
   
  <!-- ---------------- Card09 Starts Here --------------------------------------->
       <div class="col-md-4" id="marriage_invite">
          <div class="container d-flex justify-content-center mt-3">
            <div class="card shadow" style="width: 500px;">
               <div class="carousel-inner">
                 <div class="carousel-item active">
                   <img src="https://picsum.photos/500/300?random=1" class="d-block w-100" alt="Slide 1">
                      <a href="baby_shower_invitations.jsp">
                           <div class="card-body text-center">
                            <h5 class="card-title">Marriage Invitations</h5>
                          </div>
                       </a> 
                  </div>
               </div>      
          </div>
       </div>
      </div>
      
   <!-- ---------------- Card09 Ends Here --------------------------------------->
   
  <!-- ---------------- Card10 Starts Here --------------------------------------->
       <div class="col-md-4" id="makar_sankrant_invite">
          <div class="container d-flex justify-content-center mt-3">
            <div class="card shadow" style="width: 500px;">
               <div class="carousel-inner">
                 <div class="carousel-item active">
                   <img src="https://picsum.photos/500/300?random=1" class="d-block w-100" alt="Slide 1">
                      <a href="baby_shower_invitations.jsp">
                           <div class="card-body text-center">
                            <h5 class="card-title">Makar Sankranti Invitations</h5>
                          </div>
                       </a> 
                  </div>
               </div>      
          </div>
       </div>
      </div>
      
   <!-- ---------------- Card10 Ends Here --------------------------------------->
   
   <!-- ---------------- Card11 Starts Here --------------------------------------->
       <div class="col-md-4" id="anniversary_invite">
          <div class="container d-flex justify-content-center mt-3">
            <div class="card shadow" style="width: 500px;">
               <div class="carousel-inner">
                 <div class="carousel-item active">
                   <img src="https://picsum.photos/500/300?random=1" class="d-block w-100" alt="Slide 1">
                      <a href="baby_shower_invitations.jsp">
                           <div class="card-body text-center">
                            <h5 class="card-title">Anniversary Invitations</h5>
                          </div>
                       </a> 
                  </div>
               </div>      
          </div>
       </div>
      </div>
      
   <!-- ---------------- Card11 Ends Here --------------------------------------->  
   
     <!-- ---------------- Card12 Starts Here --------------------------------------->
       <div class="col-md-4" id="guddi_padwa_invite">
          <div class="container d-flex justify-content-center mt-3">
            <div class="card shadow" style="width: 500px;">
               <div class="carousel-inner">
                 <div class="carousel-item active">
                   <img src="https://picsum.photos/500/300?random=1" class="d-block w-100" alt="Slide 1">
                      <a href="baby_shower_invitations.jsp">
                           <div class="card-body text-center">
                            <h5 class="card-title">Guddi Padwa Invitations</h5>
                          </div>
                       </a> 
                  </div>
               </div>      
          </div>
       </div>
      </div>
      
   <!-- ---------------- Card12 Ends Here --------------------------------------->
   
   <!-- ---------------- Card13 Starts Here --------------------------------------->
       <div class="col-md-4" id="eid_invite">
          <div class="container d-flex justify-content-center mt-3">
            <div class="card shadow" style="width: 500px;">
               <div class="carousel-inner">
                 <div class="carousel-item active">
                   <img src="https://picsum.photos/500/300?random=1" class="d-block w-100" alt="Slide 1">
                      <a href="baby_shower_invitations.jsp">
                           <div class="card-body text-center">
                            <h5 class="card-title">Eid Invitations</h5>
                          </div>
                       </a> 
                  </div>
               </div>      
          </div>
       </div>
      </div>
      
   <!-- ---------------- Card13 Ends Here --------------------------------------->
   
     </div> 
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
</body>
</html>