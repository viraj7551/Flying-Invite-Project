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

@WebServlet("/removeDetail")
public class RemoveDetail extends HttpServlet {

	public Connection con;
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
		
		String userId =   request.getParameter("userId");
        String venue_id = request.getParameter("venue_id");
        String template_id = request.getParameter("template_id");
        String page_id = request.getParameter("page_id");
        String event_id = request.getParameter("event_id");
		
		//tables 
		String user_info = "user_info";
        String event_info = "event_info";
		String venue_info = "venue_info";
		String template_info = "template_info";
		String page_info = "page_info";
		boolean success = false;
		
		HttpSession session = request.getSession(true);
		
		if(session.getAttribute("username") != null) {
			try {
			    String deleteParent1 = "DELETE FROM user_info WHERE userId = ?";
			    String deleteParent2 = "DELETE FROM event_info WHERE event_id = ?";
	            String deleteParent3 = "DELETE FROM venue_info WHERE venue_id = ?";
	            String deleteParent4 = "DELETE FROM template_info WHERE template_id = ?";
	            String deleteParent5 = "DELETE FROM page_info WHERE page_id = ?";
	            try {
	            	PreparedStatement stmt1 = con.prepareStatement(deleteParent1);
	            	PreparedStatement stmt2 = con.prepareStatement(deleteParent2);
	            	PreparedStatement stmt3 = con.prepareStatement(deleteParent3);
	            	PreparedStatement stmt4 = con.prepareStatement(deleteParent4);
	            	PreparedStatement stmt5 = con.prepareStatement(deleteParent5);
	            	 
	            	if (userId != null) {
	                    stmt1.setInt(1,Integer.parseInt(userId));
	                    stmt1.executeUpdate();
	                }
	                if (event_info != null) {
	                    stmt2.setInt(1,Integer.parseInt(event_id));
	                    stmt2.executeUpdate();
	                }
	                if (venue_info != null) {
	                    stmt3.setInt(1,Integer.parseInt(venue_id));
	                    stmt3.executeUpdate();
	                }
	                if (template_info != null) {
	                    stmt4.setInt(1, Integer.parseInt(template_id));
	                    stmt4.executeUpdate();
	                }
	                if (page_info != null) {
	                    stmt5.setInt(1, Integer.parseInt(page_id));
	                    stmt5.executeUpdate();
	                }
	                success = true;
	                resetAutoIncrement(con,user_info);
	                resetAutoIncrement(con,event_info);
	                resetAutoIncrement(con,venue_info);
	                resetAutoIncrement(con,template_info);
	                resetAutoIncrement(con,page_info);
	                
	            }
	            
	            catch(Exception e) {
	            	e.printStackTrace();
	            }

		}
		catch(Exception e) {
			e.printStackTrace();
		}
     }
		
		if(success) {
		    request.getSession(false); 
		    pw.println("<script type=\"text/javascript\">"); 
		    pw.println("alert('record deleted successfully..!');"); 
		    pw.println("location='dashboard.jsp';"); 
		    pw.println("</script>"); 
		}else {
		    request.getSession(false); 
		    pw.println("<script type=\"text/javascript\">"); 
		    pw.println("alert('Something went wrong');"); 
		    pw.println("location='view_records.jsp';"); 
		    pw.println("</script>"); 
		}
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
    private void resetAutoIncrement(Connection conn, String tableName) throws SQLException {
        String resetAutoIncrementSQL = "ALTER TABLE " + tableName + " AUTO_INCREMENT = 1";
        try {
        	PreparedStatement ps2 = con.prepareStatement(resetAutoIncrementSQL);
        	ps2.executeUpdate();
        }
        catch(Exception e) {
        	e.printStackTrace();
        }
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
