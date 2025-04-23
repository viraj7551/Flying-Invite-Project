<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.sql.*"%>
    
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Flying Invite | Page Information</title>
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
				<a href="dashboard.jsp">F I</a>
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
	
<%
     Connection con;
     String driver = "com.mysql.cj.jdbc.Driver";
     String url = "jdbc:mysql://88.222.214.58:3306/flyinginvite_custom";
     String username = "root";
     String password = "13Viraj@2507";
     try{
    	 Class.forName(driver);
     }
     catch(Exception e){
    	 e.printStackTrace();
     }
%>

    <section>
		<div class="input-field form_heading">
			<h1>Page Information</h1>
			<a href="edit_page_info.jsp" style="color:white; margin-left:106px;"> Edit</a>
			<a href="dashboard.jsp" style="color:white; margin-left:10px;"> Back</a>
		</div>
		<div class="section-filter-container" style="width:300px;">
			<div class="add_credentials_container">
				<form class="f1" autocomplete="off" action="pageInfo"
					method="post" onSubmit="return validate3();">
					<div class="input-field">
						<label class="lblbrf">Enter Title</label>
					</div>
					<div class="inputfield">
						<input style="width:100%" type="text" name="title" required>
					</div>
					<div class="input-field">
						<label class="lblbrf">Enter Heading1</label>
					</div>
					<div class="inputfield">
						<input style="width:100%" type="text" name="heading1" required>
					</div>
					<div class="input-field">
						<label class="lblbrf">Enter Heading2</label>
					</div>
					<div class="inputfield">
						<input style="width:100%" type="text" name="heading2" required>
					</div>
					<div class="input-field">
						<label class="lblbrf">Select User ID</label>
					</div>					
					<div class="inputfield">
					<%
					try{	
				     con = DriverManager.getConnection(url, username, password);
				     PreparedStatement ps = con.prepareStatement("select * from user_info Order By userId Desc");
			         ResultSet rs = ps.executeQuery();
					%>
						<select style="width:100%; padding: 10px;" name="user_id" required>
						   <%while(rs.next()){ %>
							<option value="<%= rs.getInt("userId") %>"><%= rs.getInt("userId") %></option>
							<% } %>
						</select>
					</div>
				    <%
                         }
                          catch(Exception e){
    	                    e.printStackTrace();
                         }
                     %>
					
					<div class="formSubmit">
						<input type="submit" value="ADD PAGE INFO">
					</div>
				</form>
			</div>
		</div>
    </section>
	<script type="text/javascript" src="./js/index.js"></script>
</body>
</html>