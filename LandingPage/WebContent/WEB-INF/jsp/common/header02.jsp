<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Header File</title>
      <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"rel="stylesheet">
      <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons/font/bootstrap-icons.css" rel="stylesheet">
</head>

<body>



<nav class="navbar bg-body-tertiary wow slideInDown" style="margin-top:0px; padding:30px; border-bottom:1px solid #ccc;"">
  <div class="container-fluid justify-content-end" >
<ul class="nav">
              <%
              if(session.getAttribute("session_id") == null){
               %>
                 <li class="scroll-to-section"><a class="btn btn-outline-danger" href="login.jsp" style="padding:11px; width:155px;">Sign-In</a></li>
              <%    
                }else{
              %>
                <li class="scroll-to-section"><a class="btn btn-outline-danger" href="login.jsp" style="padding:11px; width:155px;">Sign-out</a></li>                   
            
             <% }
              %> 
</ul>
  </div>
</nav>


  
    <script src="./assets/js/responsive_logo_hide.js"></script>
    <script src="./assets/js/logout.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>