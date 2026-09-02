<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import="java.util.*" %>
<%@ page import = "java.sql.*"%>
<%@ page import="com.app.DBConnection" %>
<%@ page import="java.sql.Connection" %>
 
    
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
    <title>FlyingInvite | Hero Invite</title>

    <!-- Bootstrap core CSS -->
    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Additional CSS Files -->
    <link rel="stylesheet" href="./assets/css/fontawesome.css">
    <link rel="stylesheet" href="./assets/css/app.css">
    <link rel="stylesheet" href="./assets/css/animated.css">
    <link rel="stylesheet" href="./assets/css/owl.css">
    <link rel="stylesheet" href="./assets/css/style.css">
    <link rel="stylesheet" href="./assets/css/cardList.css">
    <script async src="https://www.googletagmanager.com/gtag/js?id=G-DZ4MP44ET9"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/crypto-js/4.1.1/crypto-js.min.js"></script>
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
       <%@ include file="/WEB-INF/jsp/common/header02.jsp" %>
  
  <!-- ***** Header Area End ***** -->
  
<div class="container" style="margin-top:80px;">
    <div class="heading_container text-center">
          <h3  style="padding:20px; font-family:Arial"> <a href="greetings.jsp"> <i class="bi bi-arrow-left fs-4"></i> </a> RENEW MODEL</h3>
    </div>
    
    <div class="container pt-5">   
     <div class="row">
     <!-- ---------------- Greeting Card01 Starts Here --------------------------------------->
         <div class="col-md-4">
          <div class="container d-flex justify-content-center mt-3">
            <div class="card shadow" style="width: 500px;">
               <div class="carousel-inner">
                 <div class="carousel-item active">
                   <img src= "assets/images/thumbnail/star.png" class="d-block w-100" alt="Slide 1">
                           <div class="card-body text-center">
                               <h5 class="card-title">BASIC</h5>
                               <hr>
                          </div>

                           <div class="container text-left">
                               <span class="card-title">1. Valid till one Month.</span>
                           </div>
                           <div class="container text-left">
                                 <span class="card-title ">2. No watermark once download.</span>
                            </div>
                            <div class="container text-left">
                                <span class="card-title">3. You can download upto 100 templates.</span>
                          </div>
                          
                          <hr>
                          
                           <div class="card-body text-center">
                                <h5>&#8377 4990 /-</h5>
                           </div>
                           
                           <hr>
                          
                          <div class="card-body text-center">
                          
                              <h5> Renew Subscription Today!</h5>
                             <div class="card-body text-center">
                                <span class="card-title"><i class="bi bi-envelope-arrow-down fs-5"> </i> admin@flyinginvite.in</span>
                              </div>
                          </div>
                       
                  </div>
               </div>      
          </div>
       </div>
      </div>
   </div>
   </div>
  </div>


<!-- ----------------- Carousal 1 Slider Code Ends Here ------------------------------------------>


  <!-- ------------Footer starts here ------------------------------->

    <%@ include file="/WEB-INF/jsp/common/footer.jsp" %>
   
 <!-- ------------Footer ends here-------------------------------->  
   
    

  <!-- Scripts -->
  
  <script>
    function openPreview(imageSrc) {
        document.getElementById("modalImage").src = imageSrc;
    }
    
    function downloadIcon(ImageId){
    	let id = document.getElementById("ImageId").value;
        window.location.href = "downloadImage.jsp";
    	
 }
    
</script>
  <script src="./vendor/jquery/jquery.min.js"></script>
  <script src="./vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
  <script src="./assets/js/owl-carousel.js"></script>
  <script src="./assets/js/animation.js"></script>
  <script src="./assets/js/imagesloaded.js"></script>
  <script src="./assets/js/custom.js"></script>
   <script src="./assets/js/downloadFile.js"></script>
  <script src="./assets/js/app.js"></script>
      <script src="./assets/js/logout.js"></script>
  
 
</body>
</html>