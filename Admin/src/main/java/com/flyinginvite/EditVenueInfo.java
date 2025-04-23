package com.flyinginvite;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class EditVenueInfo
 */
@WebServlet("/editVenueInfo")
public class EditVenueInfo extends HttpServlet {
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
		int userId = Integer.parseInt(request.getParameter("user_id"));
		int venue_id = Integer.parseInt(request.getParameter("venue_id"));
		String venue_address = request.getParameter("venue_info");
		boolean success = false;
		
	    HttpSession session = request.getSession(true);
	    
	    if(session.getAttribute("username") != null) {
			if(venue_address != null) {
				try {
				    PreparedStatement ps = con.prepareStatement("update venue_info set venue_address=?,userId=? where venue_id=?");
				    ps.setString(1, venue_address);
				    ps.setInt(2,userId);
				    ps.setInt(3, venue_id);
				    ps.executeUpdate();
				    success = true;
				}
				catch(Exception e) {
					e.printStackTrace();
				}	
			} 	
	    }
	   
		if(success) {
			request.getSession(true);
		    pw.println("<script type=\"text/javascript\">"); 
		    pw.println("alert('venue details updated successfully.');"); 
		    pw.println("location='event_info.jsp';"); 
		    pw.println("</script>");
			
		}else {
		    request.getSession(true);
		    pw.println("<script type=\"text/javascript\">"); 
		    pw.println("alert('Something went wrong');"); 
		    pw.println("location='edit_venue_info.jsp';"); 
		    pw.println("</script>"); 
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	public void destroy() {
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
