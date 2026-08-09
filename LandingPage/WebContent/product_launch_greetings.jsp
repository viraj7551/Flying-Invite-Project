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
    <script src="https://cdnjs.cloudflare.com/ajax/libs/crypto-js/4.1.1/crypto-js.min.js"></script>
<script>
  window.dataLayer = window.dataLayer || [];
  function gtag(){dataLayer.push(arguments);}
  gtag('js', new Date());

  gtag('config', 'G-DZ4MP44ET9');
</script>

  <style>
        .image-card {
            position: relative;
            overflow: hidden;
            border-radius: 10px;
        }

        .image-card img {
            width: 100%;
            height: 300px;
            object-fit: cover;
            transition: 0.4s ease;
        }

        .overlay {
            position: absolute;
            top: 0;
            left: 0;
            width: 100%;
            height: 100%;
            background: rgba(0, 0, 0, 0.6);
            display: flex;
            justify-content: center;
            align-items: center;
            gap: 25px;
            opacity: 0;
            transition: 0.4s ease;
        }

        .overlay i {
            font-size: 30px;
            color: white;
            cursor: pointer;
            transition: 0.3s;
        }

        .overlay i:hover {
            color: #0d6efd;
        }

        .image-card:hover .overlay {
            opacity: 1;
        }

        .image-card:hover img {
            transform: scale(1.1);
        }

        /* Fullscreen image styling */
        .fullscreen-img {
            width: 100%;
            height: 100vh;
            object-fit: contain;
        }
    </style>
    
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
  
     <%@ include file="/WEB-INF/jsp/common/header02.jsp" %>  
  
  <!-- ***** Header Area End ***** -->



<% 

    ResultSet rs = null;
    Connection con = null;
    PreparedStatement ps = null;
    List<Map<String, Object>> cards = new ArrayList<>();
    Set<Integer> seenIds = new HashSet<>();

    try{
    	
    	   con = DBConnection.getConnection();
		   ps = con.prepareStatement("select template_id,template_title,template_specification,template_tag,category_title,target_title,access_type_title,type_title,price,imageId,filename,image,preview_image from flyinginvite_template Inner Join flyinginvite_template_category using(template_id) Inner Join flyinginvite_template_type using(template_id) Inner Join flyinginvite_target using(template_id) Inner Join flyinginvite_access_type using(template_id) Inner Join flyinginvite_template_price using(template_id) Inner Join template_image using(template_id) where target_title = ?;");
		   ps.setString(1,"product launch greetings");
		   rs = ps.executeQuery();
		   
		   while(rs.next()){  
		
	       int id = rs.getInt("template_id");
		   
  	         if (!seenIds.contains(id)) {
  	    	              seenIds.add(id);
		       	          Map<String, Object> row = new HashMap<>();
		       	          row.put("template_heading", rs.getString("template_title"));
		       	          row.put("template_price", rs.getInt("price"));
		       	          row.put("template_id", rs.getInt("template_id"));
		       	          row.put("template_category", rs.getString("category_title"));
		       	          row.put("target_name", rs.getString("target_title"));
		       	          row.put("template_download_type", rs.getString("access_type_title"));
				       	    
		       	          // get blob
				       	    Blob blob = rs.getBlob("image");
		       	            Blob blob02 = rs.getBlob("preview_image");

				       	  // convert blob -> byte[]
				       	     byte[] bytes = blob.getBytes(1, (int) blob.length());
				       	     byte[] bytes02 = blob02.getBytes(1, (int) blob02.length());

				       	  // convert byte[] -> base64 string
				       	     String base64 = Base64.getEncoder().encodeToString(bytes);
				       	     String base6402 = Base64.getEncoder().encodeToString(bytes02);

				       	  // store base64 instead of blob
				       	    row.put("template_image", base64);
				       	    row.put("preview_image", base6402);
		       	   
		       	            cards.add(row);
  	         }
  	         
		   }
%>

<div class="container" style="margin-top:80px;">

<div class="heading_container text-center">
   <h3 style="padding:10px; font-family:Arial"> <a href="greetings.jsp"> <i class="bi bi-arrow-left fs-4"></i> </a> PRODUCT LAUNCH GREETINGS <span id="greetings_count"></span></h3>
</div>

<div class="container" style="margin-bottom:2px; padding:30px; border:1px solid red; display: none;">
     <div class="row">
         <div class="col-6">
          <span class="d-inline-block mt-2"> <strong>Your subscription has been expired, Please renew to download more ! </strong></span> 
         </div>
         
         <div class="col-6 d-flex justify-content-end">
          <a href="#services" class="btn btn-outline-danger">Renew</a>    
         </div>
     </div>
</div>
</div>


<!-- ---------------- Carousal1 Slider Code Starts Here --------------------------------------->
  
    <div class="container pt-5">   
    <div class="row" style="margin-top:40px;">
    
   <%   

      for(Map<String, Object> card : cards) {
      
      String template_target = card.get("target_name").toString();
         
      if(template_target.equals("product launch greetings")){ %>
       <div class="col-md-4" style="padding-bottom:90px;">   
         <form method="POST" action="downloadImage.jsp">
            <div class="card image-card shadow">
                <img src="data:image/jpeg;base64,<%= card.get("preview_image") %>" alt="Image" id="Image01">
                <div class="overlay">
                    <!-- Preview -->
                    <i class="bi bi-eye-fill"
                       onclick="openPreview('data:image/jpeg;base64,<%= card.get("preview_image") %>')"
                       data-bs-toggle="modal"
                       data-bs-target="#previewModal"></i>

                    <!-- Download -->
                     <button type="submit" onclick="downloadTemplate(this);" class="btn p-0 border-0 bg-transparent"> <i class="bi bi-download"></i></button>
                </div>
                <div class="card-body">
                    
                    
                <!-- Hidden field -->
               <input type="hidden" name="templateId" class="templateId" value="<%= card.get("template_id") %>">
                
                
                    <h5 class=" heading card-title mt-3"> <%= card.get("template_heading") %></h5>
                    <div class="row">
                       <div class="col-md-6">
                             <span class="card-title"><i class="bi bi-check-circle text-success"></i> <%= card.get("template_category") %></span>
                       </div>
                       
                        <div class="col-md-6">
                            <%
                                 Object template_type = card.get("template_download_type");
                                 if(template_type.equals("Free")){ %>
                                 
                                 <span class="card-title text-decoration-line-through"><i class="bi bi-check-circle text-success"></i> &#8377 <%= card.get("template_price") %></span>
                            <% }else{ %>
                                	 <span class="card-title"><i class="bi bi-check-circle text-success"></i> &#8377 <%= card.get("template_price") %></span>
                                
                                <%  } %> 
                       
                       </div>
                       
                       <div class="col-md-6">
                             <span class="card-title"><i class="bi bi-check-circle text-success"></i> <%= card.get("target_name") %></span>
                       </div>
                       
                        <div class="col-md-6">
                             <span class="card-title"><i class="bi bi-check-circle text-success"></i> <%= card.get("template_download_type") %></span>
                       </div>
                       
                       </div>                    
                </div>
            </div>
          </form>
        </div>
        
        <% }else{ %>
        	  <div>
                 <h4 class="text-center">No Cards To Display ... </h4>
              </div>
            <%
              break;
            }
          }     
       %>
        
   </div> 
</div> 


<!-- FULLSCREEN MODAL -->
<div class="modal fade" id="previewModal" tabindex="-1">
    <div class="modal-dialog modal-fullscreen">
        <div class="modal-content bg-dark">
            <div class="modal-header border-0">
                <button type="button" class="btn-close btn-close-white"
                        data-bs-dismiss="modal"></button>
            </div>
            <div class="modal-body p-0 text-center">
                <img id="modalImage" class="fullscreen-img">
            </div>
        </div>
    </div>
</div>   

  <%      
     }
   catch(Exception e){
  	   e.printStackTrace();
     }   
  
  %>

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
  <% 
     }
  %>
 
</body>
</html>