<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*" %>
<%@ page import = "java.sql.*"%>
<%@ page import = "com.app.*"%>
<%@ page import="javax.crypto.Cipher" %>
<%@ page import="javax.crypto.spec.IvParameterSpec" %>
<%@ page import="javax.crypto.spec.SecretKeySpec" %>
<%@ page import="java.util.Base64" %>
<%@ page import="java.nio.charset.StandardCharsets" %>


<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta property="og:title" content="FlyingInvite | Entertainment">
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

  <title>FlyingInvite | Hero Invite</title>

      <!-- Bootstrap core CSS -->
    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/bootstrap-icons/font/bootstrap-icons.css" rel="stylesheet">


  <!-- Additional CSS Files -->
  <link rel="stylesheet" href="./assets/css/fontawesome.css">
  <link rel="stylesheet" href="./assets/css/app.css">
  <link rel="stylesheet" href="./assets/css/animated.css">
  <link rel="stylesheet" href="./assets/css/owl.css">
  <link rel="stylesheet" href="./assets/css/style.css">
  <link rel="stylesheet"  href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" />
  <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons/font/bootstrap-icons.css" rel="stylesheet">
  
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/crypto-js/4.1.1/crypto-js.min.js"></script>
    
  
  <script async src="https://www.googletagmanager.com/gtag/js?id=G-DZ4MP44ET9"></script>
<script>
  window.dataLayer = window.dataLayer || [];
  function gtag(){dataLayer.push(arguments);}
  gtag('js', new Date());

  gtag('config', 'G-DZ4MP44ET9');
</script>


</head>
<body>

  <!-- Pre-header Starts -->

  <%@ include file="/WEB-INF/jsp/common/preheader.jsp" %>

  <!-- Pre-header End -->
  
  <!-- ***** Header Area Start ***** -->
       <%@ include file="/WEB-INF/jsp/common/header02.jsp" %>
  
  <!-- ***** Header Area End ***** -->
  
  
  

         <%
                 ResultSet rs = null;
                 Connection con = null;
                 PreparedStatement ps = null;
                 String decrypted_heading_value = null;
                 
                 try{
                	 
                	   int original_tempId = Integer.parseInt(request.getParameter("templateId")); 
                	   int temp_tempId = original_tempId;
                	   
                	   if(temp_tempId != original_tempId){
                		response.sendRedirect("/404.jsp");   
                	   }
                	   
                	   con = DBConnection.getConnection();
             		   ps = con.prepareStatement("select template_title, template_specification, template_tag, price,category_title,access_type_title,preview_image, target_title from flyinginvite_template Inner Join flyinginvite_template_category using(template_id) Inner Join flyinginvite_access_type using(template_id) Inner Join template_image using(template_id) Inner Join flyinginvite_template_price using(template_id) Inner Join flyinginvite_target using(template_id) where template_id = ?;");
             		   ps.setInt(1, original_tempId);
             		   rs = ps.executeQuery();
             		   if(rs.next()){  
             			  
		       	          // get blob
				       	    Blob blob = rs.getBlob("preview_image");

				       	  // convert blob -> byte[]
				       	     byte[] bytes = blob.getBytes(1, (int) blob.length());

				       	  // convert byte[] -> base64 string
				       	     String templateImage = Base64.getEncoder().encodeToString(bytes);
				       	  
				       	  request.setAttribute("template_image", templateImage);
				       	  
				       	  String template_download_tp = rs.getString("access_type_title");
             			   
    %>
    
<div class="container" style="margin-top:180px;">
    
<div class="container mt-5 pt-5">
  <div class="row align-items-center">
 <!-- Left Section Image -->
    <div class="col-md-6 mb-4">
      <img src="data:image/png;base64,${template_image}" class="img-fluid rounded" alt="Customer Image">
    </div>
    
    
 <% if(template_download_tp.equals("Free")){ %>   
 <!-- ---Right Section  -->
 
 <div class="col-md-6">
                 
              <div class="row">
                  <div class="col-6" style="width:100%;">
                         <span class="mb-3"><a href="#" onclick="browser_back();">  <i class="bi bi-arrow-left fs-5"> </i> </a> <%= rs.getString("target_title")%></span>
                  </div>
              </div>
              
              <div class= "row">
                   <div class="col-6 text-left">
                         <h1 class="mb-3"><%= rs.getString("template_title")%></h1>
                   </div>
              </div>
              
              <div class="row">
                   <div class="col-6 text-left pt-3" style="width:100%">
                          <span  class="card-title" style="font-size:32px";><span class=" text-decoration-line-through" style="font-size:32px; color:#FF6060"> &#8377 <%= rs.getString("price")%></span> &#8377 0 </span> 
                  </div>
              </div>    
              
              <div class="row">
                 <div class="col-6 text-left pt-4" style="width:auto;">
                     <span> This template is use for testing purpose, Testing is done on big screen devices and small screen devices. </span>
                 </div>
              </div>
              
              <div class="row pt-2">
                 <div class="col-4 text-center" style="width:auto; padding:10px;">
                      <h6 class="card-title"> #<%= rs.getString("template_tag")%></h6>
                 </div>
                 <div class="col-4 text-center" style="width:auto; padding:10px; ">
                      <h6 class="card-title"> #<%= rs.getString("category_title")%></h6>
                 </div>
                 
                  <div class="col-4 text-center" style="width:auto; padding:10px; ">
                      <h6 class="card-title"> #<%= rs.getString("access_type_title")%></h6>
                 </div>
              </div>
            
             <form method="POST" action="TemplateDownload">
                  <input type= "hidden" name="template_name" value="<%= rs.getString("template_title")%>">
                  <input type= "hidden" name="target_title" value="<%= rs.getString("target_title")%>">
                  
                   <div class="row">
                      <div class="col-6 pt-4" style="width:100%;">
                        <button class="btn btn-danger btn-lg btn-block"> <i class="bi bi-cloud-download"> </i> Download For Free </button>
                      </div>
                   </div>
             </form> 
                   
                   <div class="row">
                      <div class="col-6 pt-4" style="width:100%;">
                        <a class="btn btn-outline-success btn-lg btn-block" href="renew_model.jsp"> <i class="bi bi-cash-coin"> </i> Renew Now </a>
                      </div>
                   </div>          
       </div>   
 <% } else {%>
 
 
  <!-- ---Right Section  -->
 <div class="col-md-6">
 
      <form method="POST" action="TemplateDownload">
      
         <input type= "hidden" name="template_name" value="<%= rs.getString("template_title")%>">
         <input type= "hidden" name="target_title" value="<%= rs.getString("target_title")%>">
         
              <div class="row">
                  <div class="col-6" style="width:100%;">
                         <span class="mb-3"><a href="#" onclick="browser_back();">  <i class="bi bi-arrow-left fs-5"> </i> </a> <%= rs.getString("target_title")%></span>
                  </div>
              </div>
              
              <div class= "row">
                   <div class="col-6 text-left">
                         <h1 class="mb-3"><%= rs.getString("template_title")%></h1>
                   </div>
              </div>
              
              <div class="row">
                   <div class="col-6 text-left pt-3" style="width:100%">
                          <span  class="card-title" style="font-size:32px";> &#8377 <%= rs.getString("price")%></span>   
                  </div>
              </div>    
              
              <div class="row">
                 <div class="col-6 text-left pt-4" style="width:auto;">
                     <span> This template is use for testing purpose, Testing is done on big screen devices and small screen devices. </span>
                 </div>
              </div>
              
              <div class="row pt-2">
                 <div class="col-4 text-center" style="width:auto; padding:10px;">
                      <h6 class="card-title"> #<%= rs.getString("template_tag")%></h6>
                 </div>
                 <div class="col-4 text-center" style="width:auto; padding:10px; ">
                      <h6 class="card-title"> #<%= rs.getString("category_title")%></h6>
                 </div>
                 
                  <div class="col-4 text-center" style="width:auto; padding:10px; ">
                      <h6 class="card-title"> #<%= rs.getString("access_type_title")%></h6>
                 </div>
              </div>

               <input type= "hidden" name="<%= rs.getString("template_title")%>">
              
                   <div class="row">
                      <div class="col-6 pt-4" style="width:100%;">
                        <a class="btn btn-danger btn-lg btn-block" href="renew_model.jsp"> <i class="bi bi-cloud-download"> </i> Download </a>
                      </div>
                   </div>  
            </form>     
       </div> 
  <%}%>
  </div>
</div>
</div>
     
       <%  
           }
           }catch(Exception e){
            e.printStackTrace();
         }   
      %>
  
  <script>
     function browser_back(){
         window.history.back(); 
     }
  
  </script>
  
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
</body>
</html>