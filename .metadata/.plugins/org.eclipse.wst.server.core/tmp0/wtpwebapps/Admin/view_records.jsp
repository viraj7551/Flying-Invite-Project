<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ page import = "java.sql.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View All Records</title>
<link rel="stylesheet" href="./css/styles.css">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
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
        <%
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://88.222.214.58:3306/flyinginvite_custom";
        String username = "root";
        String password = "13Viraj@2507";
        ResultSet rs = null;
        Connection con = null;
        PreparedStatement ps = null;
        try{
        	Class.forName(driver);
        	con = DriverManager.getConnection(url,username,password);
        	ps= con.prepareStatement("select * from user_info Inner Join venue_info using(userId) inner join template_info using(userId) inner join page_info using(userId) inner join event_info using(venue_id)");
            rs = ps.executeQuery();
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
	
	    <section>
		<div class="input-field form_heading" style="width:130%">
			<h1 style="margin-left:-310px;font-size:16px; color:white;">View All Records</h1>
		    <span><a href="dashboard.jsp" style="color:white; margin-left:890px; font-size:14px;"> Back</a></span>
		</div>
		      <div class="container1">
		          <table style="margin: 20px -350px; padding:20px; font-size:12px;">
                         <thead style="background-color:#2C3E50;">
                            <tr>
                               <td style="padding: 20px; border:1px solid black; color:white;">userId</td>
                               <td style="padding: 20px; border:1px solid black; color:white;">firstname</td>
                               <td style="padding: 20px; border:1px solid black; color:white;">lastname</td> 
                               <td style="padding: 20px; border:1px solid black; color:white;">event_id</td>
                               <td style="padding: 20px; border:1px solid black; color:white;">event_date</td>
                               <td style="padding: 20px; border:1px solid black; color:white;">event_from</td>
                               <td style="padding: 20px; border:1px solid black; color:white;">event_to</td>
                               <td style="padding: 20px; border:1px solid black; color:white;">venue_id</td>
                               <td style="padding: 20px; border:1px solid black; color:white;">template_id</td>
                               <td style="padding: 20px; border:1px solid black; color:white;">template_type</td>
                               <td style="padding: 20px; border:1px solid black; color:white;">page_id</td>
                               <td style="padding: 20px; border:1px solid black; color:white;">Remove</td>
                           </tr>
                        </thead>
                   <tbody style="background-color:#7FA1C3;">
                  <%
                     while(rs.next()){
                   %> 
                    <tr>
                   <td style="padding: 20px; border:1px solid black;"><%= rs.getInt("userId") %></td>
                   <td style="padding: 20px; border:1px solid black;"><%= rs.getString("user_firstname") %></td>
                   <td style="padding: 20px; border:1px solid black;"><%= rs.getString("user_lastname") %></td>
                   <td style="padding: 20px; border:1px solid black;"><%= rs.getInt("event_id") %></td>
                   <td style="padding: 20px; border:1px solid black;"><%= rs.getString("event_date") %></td>
                   <td style="padding: 20px; border:1px solid black;"><%= rs.getString("event_from") %></td>
                   <td style="padding: 20px; border:1px solid black;"><%= rs.getString("event_to") %></td>
                   <td style="padding: 20px; border:1px solid black;"><%= rs.getInt("venue_id") %></td>
                   <td style="padding: 20px; border:1px solid black;"><%= rs.getInt("template_id") %></td>
                   <td style="padding: 20px; border:1px solid black;"><%= rs.getString("template_type") %></td>
                   <td style="padding: 20px; border:1px solid black;"><%= rs.getString("page_id") %></td>
                   <td style="padding: 20px; border:1px solid; cursor:pointer;"><a href="removeDetail?userId=<%=rs.getInt("userId")%>&venue_id=<%= rs.getInt("venue_id")%>&template_id=<%= rs.getInt("template_id")%>&page_id=<%=rs.getInt("page_id")%>&event_id=<%= rs.getInt("event_id")%>"><i class="material-icons" style="color:red;">delete</i></a></td>
                   </tr>
                   <%
                     }
                   %>
                   </tbody>
               </table>
		      </div>
    </section>
    
     <%
                   
        }
        catch(Exception e){
        	e.printStackTrace();
        }
        finally {
            // Close resources
            try { 
            	if (rs != null) 
            		rs.close(); 
            	if (ps != null) 
            		ps.close(); 
            	if (con != null) 
            		con.close(); 
            	} 
            catch (SQLException e) { 
            	e.printStackTrace();
            }
        }
 
%>
	<script type="text/javascript" src="./js/index.js"></script>
</body>
</html>