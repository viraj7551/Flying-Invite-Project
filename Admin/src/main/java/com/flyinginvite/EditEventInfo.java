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
 * Servlet implementation class EditEventInfo
 */
@WebServlet("/editEventInfo")
public class EditEventInfo extends HttpServlet {
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
	
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		boolean success = false;
		String wedding_date = request.getParameter("date");
	    int venue_id = Integer.parseInt(request.getParameter("venue_id"));
	    String time_from = request.getParameter("timefrom");
	    String time_to = request.getParameter("timeto");
	    int event_id = Integer.parseInt(request.getParameter("event_id"));

	    HttpSession session = request.getSession(true);
	    if(session.getAttribute("username") != null) {
		    try {
		    	PreparedStatement ps = con.prepareStatement("update event_info set event_date=?,event_from=?,event_to=?,venue_id=? where event_id=?");
		    	ps.setString(1, wedding_date);
		    	ps.setString(2, time_from);
		    	ps.setString(3, time_to);
		    	ps.setInt(4, venue_id);
		    	ps.setInt(5, event_id);
		    	ps.executeUpdate();
		    	success=true;
		    }
		    catch(Exception e) {
		    	e.printStackTrace();
		    }	
	    }
	    
	    if(success) {
	    	 request.getSession(true);
			    pw.println("<script type=\"text/javascript\">"); 
			    pw.println("alert('event details updated sucessfully.');"); 
			    pw.println("location='template_info.jsp';"); 
			    pw.println("</script>"); 
	    }else {
    	    request.getSession(true);
		    pw.println("<script type=\"text/javascript\">"); 
		    pw.println("alert('Something went wrong');"); 
		    pw.println("location='edit_event_info.jsp';"); 
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
