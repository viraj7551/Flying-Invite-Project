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



@WebServlet("/eventInfo")
public class EventInfo extends HttpServlet {
    Connection con;
    PreparedStatement ps;
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
       String date = request.getParameter("date"); 
	   int venue_id = Integer.parseInt(request.getParameter("venue_id"));
       String time_from = request.getParameter("timefrom");
       String time_to = request.getParameter("timeto");
       boolean success = false;

	   HttpSession session = request.getSession(true);
		
	   if(session.getAttribute("username") != null) {
 
		    boolean eventInfoExist = isEventInfoExist(venue_id);
		    if(!eventInfoExist) {
			       try {
			    	   ps = con.prepareStatement("insert into event_info(event_date, event_from, event_to, venue_id) values(?,?,?,?)");
			           ps.setString(1, date);	 
			    	   ps.setString(2, time_from);
			    	   ps.setString(3, time_to);
			    	   ps.setInt(4, venue_id);
			    	   ps.executeUpdate();
			    	   success = true;
			       }
			       catch(Exception e) {
			    	   e.printStackTrace();
			       }   
		    }else {
	    	    request.getSession(true);
			    pw.println("<script type=\"text/javascript\">"); 
			    pw.println("alert('event info you are trying to add, already exists.');"); 
			    pw.println("location='event_info.jsp';"); 
			    pw.println("</script>"); 
		    }
	   }
	   
       if(success) {
   	        request.getSession(true);
		    pw.println("<script type=\"text/javascript\">"); 
		    pw.println("alert('event details added sucessfully.');"); 
		    pw.println("location='template_info.jsp';"); 
		    pw.println("</script>"); 
       }else {
    	    request.getSession(true);
		    pw.println("<script type=\"text/javascript\">"); 
		    pw.println("alert('Something went wrong');"); 
		    pw.println("location='wedding_info.jsp';"); 
		    pw.println("</script>"); 
       }
	}
	
	public boolean isEventInfoExist(int venue_id) {
		boolean flag = false;
		try {
			ps = con.prepareStatement("select * from event_info where venue_id = ?");
			ps.setInt(1, venue_id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				flag = true;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return flag;
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
