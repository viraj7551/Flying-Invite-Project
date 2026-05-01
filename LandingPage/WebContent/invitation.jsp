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
       <button type="button" class="btn btn-outline-primary" id="btn_greeting" onclick="invitations_tab('greetings');">Greetings</button>  
      <button type="button" class="btn btn-outline-primary" id="btn_invitation" onclick="invitations_tab('invitations');">Invitations</button> 
  </div>

<!-- ------------------Badges End Here  ------------------------------------------------------->




<div class="main" id="greetings" style="display:block;">


   <h1 style="padding:60px; font-family:Arial"><a href="index.jsp"> <i class="bi bi-arrow-left fs-3"></i> </a> DIGITAL GREETINGS</h1>

    <!-- ---------------- Card01 Starts Here --------------------------------------->
     <div class="container d-flex justify-content-center">
       <div class="card shadow" style="width: 500px;">
        <div id="cardCarousel" class="carousel slide" data-bs-ride="carousel">
          <div class="carousel-inner">
            <div class="carousel-item active">
              <img src="https://picsum.photos/500/300?random=1" class="d-block w-100" alt="Slide 1">
                <a href="baby_shower_invitations.jsp">
                   <div class="card-body text-center">
                    <h5 class="card-title">Baby Shower Invitations</h5>
                    <p class="card-text">This is a smaller carousel styled like a card.</p>
                 </div>
               </a> 
           </div>
        </div>      
    </div>
  </div>
</div>
    <!-- ----------------- Card01 Ends Here ------------------------------------------>

</div>




<div class="main02" id="invitations" style="display:none;">


   <h1 style="padding:60px; font-family:Arial"><a href="index.jsp"> <i class="bi bi-arrow-left fs-3"></i> </a> DIGITAL INVITATIONS</h1>

    <!-- ---------------- Card01 Starts Here --------------------------------------->
     <div class="container d-flex justify-content-center">
       <div class="card shadow" style="width: 500px;">
        <div id="cardCarousel" class="carousel slide" data-bs-ride="carousel">
          <div class="carousel-inner">
            <div class="carousel-item active">
              <img src="https://picsum.photos/500/300?random=1" class="d-block w-100" alt="Slide 1">
                <a href="baby_shower_invitations.jsp">
                   <div class="card-body text-center">
                    <h5 class="card-title">Baby Shower Invitations</h5>
                    <p class="card-text">This is a smaller carousel styled like a card.</p>
                 </div>
               </a> 
           </div>
        </div>      
    </div>
  </div>
</div>
    <!-- ----------------- Card01 Ends Here ------------------------------------------>

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
</body>
</html>