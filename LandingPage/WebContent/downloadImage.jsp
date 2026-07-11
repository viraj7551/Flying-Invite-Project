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

  <title>FlyingInvite | Special Invite</title>

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
             		   ps = con.prepareStatement("select template_heading, template_price, template_category, template_download_type, preview_image from template Inner Join template_image using(templateId) where templateId = ?;");
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
				       	  
				       	  String template_download_tp = rs.getString("template_download_type");
             			   
    %>
    
<div class="container mt-5">
  <div class="row align-items-center">

    <!-- Left Section Image -->
    <div class="col-md-6 mb-4">
      <img src="data:image/png;base64,${template_image}" class="img-fluid rounded" alt="Customer Image">
    </div>

    <!-- Right Section Form -->
    <div class="col-md-6">
      <h3 class="mb-4"> <a href="#" onclick="browser_back();"; return false;> <i class="bi bi-arrow-left fs-4"></i> </a> Customer Details</h3>

 <form action="MyServlet" method="post">
    <div class="row">
          <div class="col-6">
           
                <div class="mb-3">
                   <label class="form-label">First Name</label>
                   <input type="text" name="firstname" class="form-control" placeholder="Enter first name" required>
                </div>
          </div>
          <div class="col-6">
                <div class="mb-3">
                   <label class="form-label">Last Name</label>
                   <input type="text" name="lastname" class="form-control" placeholder="Enter last name" required>
                </div>
          </div>
    </div>
        <div class="mb-3">
          <label class="form-label">Email</label>
          <input type="email" name="email" class="form-control" placeholder="Enter email" required>
        </div>

        <div class="mb-3">
          <label class="form-label">Phone</label>
          <input type="tel" name="phone" class="form-control" placeholder="Enter phone number" required>
        </div>
        
          <div class="mb-3">      
               <h3 class="mb-4">Template Details</h3>
                 <div class="row">
                     <div class="col-6 mb-4">
                         <label class="form-label">Selected Template</label>
                         <input type="text" name="template_heading" class="form-control" value="<%= rs.getString("template_heading") %>" readonly>
                     </div>
                     <div class="col-6 mb-4">
                         <label class="form-label">Template Price - (&#8377)</label>
                         <% if(template_download_tp.equals("Free")) { %>
                         <input type="text" name="template_price" class="form-control" value="0" readonly>
                         <%}else{ %>
                         <input type="text" name="template_price" class="form-control" value="<%= rs.getInt("template_price") %>" readonly>                         
                         <%} %> 
                     </div>
                 </div>
                 
                  <div class="row">
                     <div class="col-6 mb-4">
                         <label class="form-label">Template Type</label>
                         <input type="text" name="template_category" class="form-control" value="<%= rs.getString("template_category") %>" readonly>
                     </div>
                     <div class="col-6 mb-4">
                         <label class="form-label">Download Type</label>
                         <input type="text" name="download_type" class="form-control" value="<%= rs.getString("template_download_type") %>" readonly>
                     </div>
                 </div>
          </div>
          
          <% 
          
             if(template_download_tp.equals("Free")){ %> 
              <button type="submit" class="btn btn-success w-100">Download</button> <br><br>             
             <%} else{ %>
              <button type="submit" class="btn btn-success w-100">Check out</button> <br><br>
              <a href="index.jsp" class="btn btn-danger w-100">Cancel</a>
              
        <% } %>
         
      </form>
    
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