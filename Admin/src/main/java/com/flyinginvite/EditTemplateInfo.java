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


@WebServlet("/editTemplateInfo")
public class EditTemplateInfo extends HttpServlet {
	
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
		int userId = Integer.parseInt(request.getParameter("userId"));
        String template_type = request.getParameter("template_type");
        int template_id = Integer.parseInt(request.getParameter("template_id"));
        
        HttpSession session = request.getSession(true);
        if(session.getAttribute("username") != null) {
            try {
                PreparedStatement ps = con.prepareStatement("update template_info set template_type=?,userId=? where template_id=?");
                ps.setString(1, template_type);
                ps.setInt(2, userId);
                ps.setInt(3, template_id);
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
   		    pw.println("alert('content updated successfully');"); 
   		    pw.println("location='dashboard.jsp';"); 
   		    pw.println("</script>"); 
        }else {
   	        request.getSession(true);
   		    pw.println("<script type=\"text/javascript\">"); 
   		    pw.println("alert('something went wrong');"); 
   		    pw.println("location='edit_template_info.jsp';"); 
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
			e.printStackTrace();
		}
	}
}
