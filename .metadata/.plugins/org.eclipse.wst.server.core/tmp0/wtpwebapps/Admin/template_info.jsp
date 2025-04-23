<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import = "java.sql.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Flying Invite | Set Template Information</title>
<link rel="stylesheet" href="./css/styles.css">
<link rel="preconnect" href="https://fonts.googleapis.com">

<link
	href="https://fonts.googleapis.com/css2?family=Grey+Qo&family=Poppins:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&display=swap"
	rel="stylesheet">
<title>Insert title here</title>
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
	   String driver = "com.mysql.cj.jdbc.Driver";
	   String url = "jdbc:mysql://88.222.214.58:3306/flyinginvite_custom";
	   String username = "root";
	   String password = "13Viraj@2507";
	   try{
		   Class.forName(driver);
		   Connection con = DriverManager.getConnection(url,username,password);
		   PreparedStatement ps = con.prepareStatement("select * from user_info ORDER BY userId DESC LIMIT 1");
		   ResultSet rs = ps.executeQuery();
		   if(rs.next()){
			
	%>

    <section>
		<div class="input-field form_heading">
			<h1>Template <br> Information</h1>
			<a href="edit_template_info.jsp"  style="color:white; margin-left:145px;">Edit</a>
			<a href="dashboard.jsp"  style="color:white; margin-left:10px;"> Back</a>
		</div>
		<div class="section-filter-container" style="width:300px">
			<div class="add_credentials_container">
				<form class="f1" autocomplete="off" action="templateInfo"
					method="post" onSubmit="return validate3();">
					
				    <div class="input-field">
						<label class="lbl">Select User</label>
					</div>
					
					<div class="inputfield">
						<select style="width:100%; padding: 10px;" name="userId">
							  <option value="<%= rs.getInt("userId") %>"><%= rs.getInt("userId") %></option>
							<%
		                         }
	                           }
	                           catch(Exception e){
	                        	   e.printStackTrace();
	                           }
							%>
						</select>
					</div>
					
				<div class="input-field">
						<label class="lbl">Select Template Type</label>
					</div>
					
				    <div class="inputfield">
					   <select style="width:100%; padding: 10px;" name="template_type">
					      <option style="padding: 10px;">Basic</option>
					      <option style="padding: 10px;">Premium</option>
					   </select>
					</div>
				
					
					<div class="formSubmit">
						<input type="submit" value="SET TEMPLATE">
					</div>
				</form>
			</div>
		</div>
    </section>
	<script type="text/javascript" src="./js/index.js"></script>
</body>
</html>