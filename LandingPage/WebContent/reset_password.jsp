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
<meta property="og:title" content="FlyingInvite | Terms and Condition">
<meta property="og:description" content="India's Interative Invitation">
<meta property="og:url" content="https://flyinginvite.in/">
<meta property="og:type" content="website">
<meta property="og:site_name" content="FlyingInvite">
<meta property="og:image" content="https://red-katalin-50.tiiny.site/">
<meta property="og:image:type" content="image/jpeg">
<meta property="og:image:width" content="1200">
<meta property="og:image:height" content="630">
<meta name="viewport" content="width=device-width,  initial-scale=1,shrink-to-fit=no" />
<link rel="icon" href="/favicon.ico" type="image/x-icon">
<link rel="icon" href=" ./assets/images/loggo.png" type="image/png">
  <link rel="preconnect" href="https://fonts.googleapis.com">
  <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
  <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@100;200;300;400;500;600;700;800;900&display=swap" rel="stylesheet">

  <title>FlyingInvite | Special Invite</title>

  <!-- Bootstrap core CSS -->
  <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">


  <!-- Additional CSS Files -->
  <link rel="stylesheet" href="./assets/css/fontawesome.css">
  <link rel="stylesheet" href="./assets/css/app.css">
  <link rel="stylesheet" href="./assets/css/animated.css">
  <link rel="stylesheet" href="./assets/css/owl.css">
  <link rel="stylesheet" href="./assets/css/style.css">
  <link rel="stylesheet"  href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" />
  <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons/font/bootstrap-icons.css" rel="stylesheet">
  <link rel="stylesheet"  href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" />
  
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
     String session_name = (String) request.getSession().getAttribute("session_name");
     if(session_name == null){
    	 response.sendRedirect("verify_email.jsp");
     }else{
    
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


<div class="main" style="margin: 80px auto;">
    <h1 class="text-danger text-center"> <a href="index.jsp"><i class="bi bi-arrow-left fs-1"></i></a> RESET PASSWORD </h1>
    <div class="container mt-5">
        <div class="row justify-content-center">
            <div class="col-md-6">
                <div class="card">
                    <div class="card-body">
                        <form id="reset_password" method = "post" action="ResetPassword">
                            <div class="form-group">
                                <label for="password">
                                   New Password
                                 </label>
                                <div class="input-group"> 
                                   <input type="password" 
                                        class="form-control" 
                                        id="password" 
                                        name="reset_new_password"
                                        placeholder="Enter password"
                                       required />
                                    
                                <button class="btn btn-outline-secondary" type="button" id="togglePassword">
                                   <!-- Bootstrap Icons used as visual indicators -->
                                         <i class="fa fa-eye" id="toggleIcon"></i>
                                 </button>
                                 </div> 
                            </div>
                            
                            <div class="form-group">
                                <label for="password">
                                    Confirm Password
                                </label>
                             <div class="input-group">   
                                <input type="password" 
                                       class="form-control" 
                                       id="password02"
                                       name="reset_confirm_password" 
                                       placeholder="Enter confirm password"
                                    required />
                                    
                              <!-- Toggle Visibility Button -->
                              <button class="btn btn-outline-secondary" type="button" id="togglePassword02">
                                   <!-- Bootstrap Icons used as visual indicators -->
                                  <i class="fa fa-eye" id="toggleIcon"></i>
                             </button>        
                           </div>            
                         </div>
                            <button class="btn btn-danger btn-lg btn-block" style="margin-top:50px;">
                                Reset Password
                            </button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
  </div>

  
<!--------------Footer starts here ------------------------------->

    <%@ include file="/WEB-INF/jsp/common/footer.jsp" %>
   
 <!--------------Footer ends here-------------------------------->  

  <!-- Scripts -->
  <script src="./vendor/jquery/jquery.min.js"></script>
  <script src="./vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
  <script src="./assets/js/owl-carousel.js"></script>
  <script src="./assets/js/animation.js"></script>
  <script src="./assets/js/imagesloaded.js"></script>
  <script src="./assets/js/custom.js"></script>
  <script src="./assets/js/app.js"></script>
  <script src="./assets/js/show_password.js"></script>
  
  <% } %>
</body>
</html>