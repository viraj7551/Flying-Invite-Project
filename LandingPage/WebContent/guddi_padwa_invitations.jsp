<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import="java.util.*" %>
<%@ page import = "java.sql.*"%>
 
    
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
                <span>
                 <h2 style="margin:40px"><a href="invitation.jsp"> <i class="bi bi-arrow-left fs-3"></i> </a> GUDDI PADWA INVITATIONS</h2>
              </span>

            <!-- ***** Menu End ***** -->
        </div>    
      </div>
    </div>
    
  </header>
  
  <!-- ***** Header Area End ***** -->



<% 
    String driver = "com.mysql.cj.jdbc.Driver";
    String url = "jdbc:mysql://88.222.214.58:3306/flyinginvite_invitation";
    String username = "root";
    String password = "13Viraj@2507";
    ResultSet rs = null;
    Connection con = null;
    PreparedStatement ps = null;
    List<Map<String, Object>> cards = new ArrayList<>();
    Set<Integer> seenIds = new HashSet<>();

    try{
	   	   Class.forName(driver);
	   	   con = DriverManager.getConnection(url,username,password);
		   ps = con.prepareStatement("select * from userInfo Inner Join template using(userId) Inner Join target using(userId) Inner Join festival using(userId);");
		   rs = ps.executeQuery();
		   
		       while(rs.next()){  
		    	    int id = rs.getInt("templateId");
		    	    if (!seenIds.contains(id)) {
		    	    	  seenIds.add(id);
		       	          Map<String, Object> row = new HashMap<>();
		       	          row.put("template_heading", rs.getString("template_heading"));
		       	          row.put("template_price", rs.getInt("template_price"));
		       	          row.put("template_image_url", rs.getString("template_image_url"));
		       	          row.put("template_id", rs.getInt("templateId"));
		       	          row.put("template_category", rs.getString("template_category"));
		       	          row.put("target_name", rs.getString("target_name"));
		       	          cards.add(row);
		    	    }
		        }   
	       rs.close();
	       ps.close();
	       con.close();

%>


<!-- ---------------- Carousal1 Slider Code Starts Here --------------------------------------->
  
   <div class="container mt-5">   
    <div class="row" style="margin-top:180px;">
      
   <%  for(Map<String, Object> card : cards) {  %>
      
         <div class="col-md-4"> 
            <div class="card image-card shadow">
                <img src="https://picsum.photos/500/400" alt="Image" id="Image01">
                <div class="overlay">
                    <!-- Preview -->
                    <i class="bi bi-eye-fill"
                       onclick="openPreview('https://picsum.photos/1200/800')"
                       data-bs-toggle="modal"
                       data-bs-target="#previewModal"></i>

                    <!-- Download -->
                    <a href="downloadImage.jsp">
                        <i class="bi bi-download"></i>
                    </a>

                </div>
                <div class="card-body">
                
                    <h5 class="card-title mt-3"> <%= card.get("template_heading") %></h5>
                 
                 
                       <div class="row">
                       <div class="col-md-6">
                             <span class="card-title"><i class="bi bi-check-circle text-success"></i> <%= card.get("template_category") %></span>
                       </div>
                       
                        <div class="col-md-6">
                            <span class="card-title"><i class="bi bi-check-circle text-success"></i> &#8377 <%= card.get("template_price") %></span>
                       </div>
                       
                       <div class="col-md-6">
                             <span class="card-title"><i class="bi bi-check-circle text-success"></i> <%= card.get("target_name") %></span>
                       </div>
                       
                       </div>                    
                </div>
            </div>
        </div>
        
        <% } %>
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
  <script src="./assets/js/app.js"></script>
</body>
</html>