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

/**
 * Servlet implementation class EditUserInfo
 */
@WebServlet("/editUserInfo")
public class EditUserInfo extends HttpServlet {
    
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
		boolean success = false;

		if(session.getAttribute("username") != null) {	
			try {
				PreparedStatement ps = con.prepareStatement("update user_info set user_firstname=?, user_lastname=?, user_phone=? where userId=?");
				   ps.setString(1, user_firstname);
				   ps.setString(2, user_lastname);
				   ps.setString(3, user_phone);
				   ps.setInt(4, Integer.parseInt(userId));
				   ps.executeUpdate();
				   success = true;
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		if(success) {
		    request.getSession(true);
		    pw.println("<script type=\"text/javascript\">"); 
		    pw.println("alert('existing user detail updated successfully.');"); 
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
