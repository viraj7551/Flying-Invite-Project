<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Flying Invite | Dashboard</title>
<link rel="stylesheet" href="./css/styles.css">
<link rel="preconnect" href="https://fonts.googleapis.com">

<link
	href="https://fonts.googleapis.com/css2?family=Grey+Qo&family=Poppins:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&display=swap"
	rel="stylesheet">
</head>
<body>

 <%
     if(session.getAttribute("username") == null){
    	 response.sendRedirect("administrator.jsp");
     }
 
 %>
	<nav class="navbar">
		<div class="brand-loggo">
			<h3 class="brand-name grey-qo-regular">
				<a href="#">FI</a>
			</h3>
		</div>

		<div class="menu-items">
			<ul>
				<li><a id="myaccount" class="menu-disable" href="javascript:submenu();">
						<h3><%= session.getAttribute("username") %></h3>
				</a></li>
			</ul>
		</div>	
		<div id="submenu_list_option" class="nav-sub-list">
			<ul>
				<li><a href="administrator.jsp">Log Out</a></li>
			</ul>
		</div>
	</nav>	

    <section>

 <span><a href="email_campaign.jsp" style="color:white; padding:20px; margin-left:440px; font-size:12px;">Send Email</a></span>
  
    <div class="container">

        <div class="container-section">
            <ul>
               <li><a href="user_info.jsp">
                   <div class="container-cube">
                      <span>User Info</span>
                   </div>
               </a></li>
            </ul>
          </div>
   
          <div class="container-section">
           <ul>
              <li><a href="venue_info.jsp">
                  <div class="container-cube">
                     <span>Venue Info</span>
                  </div>
              </a></li>
           </ul>
         </div>
   
   
         <div class="container-section">
           <ul>
              <li><a href="event_info.jsp">
                  <div class="container-cube">
                     <span>Event Info</span>
                  </div>
              </a></li>
           </ul>
         </div>
    </div>

    <div class="container">
           <div class="container-section">
            <ul>
               <li><a href="template_info.jsp">
                   <div class="container-cube">
                      <span>Temp Info</span>
                   </div>
               </a></li>
            </ul>
          </div>

        <div class="container-section">
            <ul>
               <li><a href="page_info.jsp">
                   <div class="container-cube">
                      <span>Page Info</span>
                   </div>
               </a></li>
            </ul>
          </div>
          
          <div class="container-section">
            <ul>
               <li><a href="view_records.jsp">
                   <div class="container-cube">
                      <span>View Info</span>
                   </div>
               </a></li>
            </ul>
          </div>
      </div>
     
     </section>
	<script type="text/javascript" src="./js/index.js"></script>
</body>
</html>