package com.flyinginvite;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/userInfo")
public class UserInfo extends HttpServlet {
    Connection con;
    
    public void init(ServletConfig config) {
		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://88.222.214.58:3306/flyinginvite_custom";
		String username = "root";
		String password = "13Viraj@2507";
    	try {
    		Class.forName(driver);
    		con = DriverManager.getConnection(url,username,password);
    	}
    	catch(Exception e) {
    		e.printStackTrace();
    	}
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    PrintWriter pw = response.getWriter();
		response.setContentType("text/html");
		String user_firstname = request.getParameter("user_firstname");
		String user_lastname = request.getParameter("user_lastname");
		String user_phone = request.getParameter("user_phone");
		String userId = request.getParameter("userId");
	    HttpSession session = request.getSession(true);
		boolean isUserPresent = read_record(user_phone);
		boolean success = false;

		if(session.getAttribute("username") != null) {	
			if(isUserPresent) {
			    request.getSession(true);
			    pw.println("<script type=\"text/javascript\">"); 
			    pw.println("alert('new user trying to add already exists.');"); 
			    pw.println("location='user_info.jsp';"); 
			    pw.println("</script>"); 
			}else {
				success = insert_record(user_firstname, user_lastname, user_phone);
			}	
		}
		
		if(success) {
		    request.getSession(true);
		    pw.println("<script type=\"text/javascript\">"); 
		    pw.println("alert('new user added successfully.');"); 
		    pw.println("location='venue_info.jsp';");
		    pw.println("</script>"); 
		}else {
		    request.getSession(true); 
		    pw.println("<script type=\"text/javascript\">"); 
		    pw.println("alert('Something went wrong');"); 
		    pw.println("location='user_info.jsp';"); 
		    pw.println("</script>"); 
		}

	}
	
	public boolean read_record(String user_phone) {
		boolean success =false;
		try {
			PreparedStatement ps = con.prepareStatement("select * from user_info where user_phone = ?");
			   ps.setString(1, user_phone );
			   ResultSet rs = ps.executeQuery();
			   if(rs.next()) {
				   success = true;   
			   }
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return success;
	}
	
	public boolean insert_record(String firstname, String lastname, String phone) {
		boolean success = false;
		try {
		   PreparedStatement ps = con.prepareStatement("insert into user_info(user_firstname, user_lastname, user_phone)values(?,?,?)");
		   ps.setString(1, firstname);
		   ps.setString(2, lastname);
		   ps.setString(3, phone);
		   ps.executeUpdate();
		   success = true;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return success;
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	public void destroy() {
	  try {
		  con.close();
	  }
	  catch(Exception e) {
		  e.printStackTrace();
	  }
	}
}
