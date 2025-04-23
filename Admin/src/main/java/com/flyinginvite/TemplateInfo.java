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


@WebServlet("/templateInfo")
public class TemplateInfo extends HttpServlet {
	Connection con;
	public void init(ServletConfig config) {
		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://88.222.214.58:3306/flyinginvite_custom";
		String username = "root";
		String password = "13Viraj@2507";
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url,username, password);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    PrintWriter pw = response.getWriter();
	    response.setContentType("text/html");
		String userId = request.getParameter("userId");
	    String template_type = request.getParameter("template_type");
	    boolean success = false;	  
	    boolean isUserExist = read_record(userId);
	    
        HttpSession session = request.getSession(true);
        
	    if(session.getAttribute("username") != null) {
	    	 if(isUserExist) {
	    	        request.getSession(true);
	    		    pw.println("<script type=\"text/javascript\">"); 
	    		    pw.println("alert('template is already set for current user.');"); 
	    		    pw.println("location='template_info.jsp';"); 
	    		    pw.println("</script>");  
	 	    }
	 	    else {
	 	    	try {
	 	    	    if(userId != null && template_type !=null) {
	 	    		PreparedStatement ps = con.prepareStatement("insert into template_info(template_type, userId)values(?,?)");	
	 	    		ps.setString(1, template_type);
	 	    		ps.setInt(2,Integer.parseInt(userId));
	 	    		ps.executeUpdate();
	 	    		success = true;
	 	    	   }
	 	    		else {
	 	    	    	success = false;
	 	    	    }
	 	    	}
	 	    	catch(Exception e) {
	 	    		e.printStackTrace();
	 	    	}
	 	    }
	    }

	    	if(success) {
	   	        request.getSession(true);
	   		    pw.println("<script type=\"text/javascript\">"); 
	   		    pw.println("alert('Template is set for current user.');"); 
	   		    pw.println("location='page_info.jsp';"); 
	   		    pw.println("</script>");  
	    	}else {
	   	        request.getSession(true);
	   		    pw.println("<script type=\"text/javascript\">"); 
	   		    pw.println("alert('something went wrong');"); 
	   		    pw.println("location='template_info.jsp';"); 
	   		    pw.println("</script>");  
	    	}
	}
	
	public boolean read_record(String userId) {
		boolean success=false;
		
		try {
			PreparedStatement ps = con.prepareStatement("select userId from template_info where userId=?");
			ps.setInt(1, Integer.parseInt(userId));
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				success = true;
			}
			
		} catch (SQLException e) {
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
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
