<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Header File</title>

      <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons/font/bootstrap-icons.css" rel="stylesheet">
</head>

<body>

  <!-- ***** Header Area Start ***** -->
  <header class="header-area header-sticky wow slideInDown" data-wow-duration="0.75s" data-wow-delay="0s">
    <div class="container">
      <div class="row">
        <div class="col-12">
          <nav class="main-nav">
            <!-- ***** Logo Start ***** -->
            <!-- ***** Menu Start ***** -->
            <ul class="nav">
           
              <%
              if(session.getAttribute("session_id") == null){
               %>
                 <li class="scroll-to-section"><button id="login" type="submit" class="btn btn-outline-danger"><a href="login.jsp">Sign-In</a></button></li>
              <%    
                }else{
              %>
              <li class="scroll-to-section"><button id="logout" type="submit" class="btn btn-outline-danger"><a href="login.jsp">Sign-out</a></button></li>                   
            
             <% }
              %>                   
             
            </ul>        
            <a id="menu_trigger" class='menu-trigger'>
                <span>Menu</span>
            </a>

            <!-- ***** Menu End ***** -->
          </nav>
        </div>
      </div>
    </div>
  <!-- ***** Header Area End ***** -->
  </header>
  
    <script src="./assets/js/responsive_logo_hide.js"></script>
    <script src="./assets/js/logout.js"></script>
    
</body>
</html>