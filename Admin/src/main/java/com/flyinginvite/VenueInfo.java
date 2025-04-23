package com.flyinginvite;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/venueInfo")
public class VenueInfo extends HttpServlet {
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
		boolean success = false;
		String venue_address = request.getParameter("venue_info");
		int user_id = Integer.parseInt(request.getParameter("user_id"));
		
		HttpSession session = request.getSession(true);
		
		if(session.getAttribute("username") != null) {
			boolean userExist = isUserRecordExist(user_id);
			 if(!userExist) {
					try {
						PreparedStatement ps = con.prepareStatement("insert into venue_info(venue_address, userId) values(?,?)");
						ps.setString(1, venue_address);
						ps.setInt(2, user_id);
						ps.executeUpdate();
						success= true;
					}
					catch(Exception e) {
						e.printStackTrace();
					}	
			 }else {
				    pw.println("<script type=\"text/javascript\">"); 
				    pw.println("alert('venue address exists for current user.');"); 
				    pw.println("location='venue_info.jsp';"); 
				    pw.println("</script>");
			 }
		}
		
		if(success) {
		    pw.println("<script type=\"text/javascript\">"); 
		    pw.println("alert('venue details added successfully.');"); 
		    pw.println("location='event_info.jsp';"); 
		    pw.println("</script>");
		}else {
		    pw.println("<script type=\"text/javascript\">"); 
		    pw.println("alert('Something went wrong');"); 
		    pw.println("location='venue_info.jsp';"); 
		    pw.println("</script>");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	public boolean isUserRecordExist(int userId) {
		boolean ans = false;
		try {
			PreparedStatement ps = con.prepareStatement("select * from venue_info where userId = ?");
			ps.setInt(1,userId);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				ans = true;
			}else {
				ans = false;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return ans;
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
