package com.app;

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


@WebServlet("/EditProfile")
public class EditProfile extends HttpServlet {

	   PrintWriter pw;
	   Connection con;
	   PreparedStatement ps;
	    
	public void init(ServletConfig config) {
		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://88.222.214.58:3306/flyinginvite_invitation";
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

		String username = request.getParameter("username");
		String contact = request.getParameter("user_contact");
		String email = request.getParameter("user_email");
		 pw = response.getWriter();
		
		if(username == null || contact == null || email == null) {
		   if(username == null) {
	    		pw.println("<!DOCTYPE html>");
	    		pw.println("<html>");
	    		pw.println("<head>");
	    		pw.println("<link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/toastr.min.css'>");
	    		pw.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js'></script>");
	    		pw.println("<script src='https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/toastr.min.js'></script>");
	    		pw.println("</head>");
	    		pw.println("<body>");
	    		pw.println("<script>");
	    		pw.println("$(function() {");
	    		pw.println("toastr.error('You cannot submit with empty username.');");
	    		pw.println("setTimeout(function() {");
	    		pw.println("window.location.href='edit_profile.jsp';");
	    		pw.println("},2000);"); // Redirect after 2 seconds
	    		pw.println("});");
	    		pw.println("</script>");
		   }else if(contact == null) {
	    		pw.println("<!DOCTYPE html>");
	    		pw.println("<html>");
	    		pw.println("<head>");
	    		pw.println("<link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/toastr.min.css'>");
	    		pw.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js'></script>");
	    		pw.println("<script src='https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/toastr.min.js'></script>");
	    		pw.println("</head>");
	    		pw.println("<body>");
	    		pw.println("<script>");
	    		pw.println("$(function() {");
	    		pw.println("toastr.error('You cannot submit with empty contact.');");
	    		pw.println("setTimeout(function() {");
	    		pw.println("window.location.href='edit_profile.jsp';");
	    		pw.println("},2000);"); // Redirect after 2 seconds
	    		pw.println("});");
	    		pw.println("</script>");
		   }else {
	    		pw.println("<!DOCTYPE html>");
	    		pw.println("<html>");
	    		pw.println("<head>");
	    		pw.println("<link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/toastr.min.css'>");
	    		pw.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js'></script>");
	    		pw.println("<script src='https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/toastr.min.js'></script>");
	    		pw.println("</head>");
	    		pw.println("<body>");
	    		pw.println("<script>");
	    		pw.println("$(function() {");
	    		pw.println("toastr.error('You cannot submit with empty email.');");
	    		pw.println("setTimeout(function() {");
	    		pw.println("window.location.href='edit_profile.jsp';");
	    		pw.println("},2000);"); // Redirect after 2 seconds
	    		pw.println("});");
	    		pw.println("</script>");
		   }
		}else {
	
			int username_length = username.length();
			int contact_length = contact.length();
			int email_length = email.length();
			
			if((username_length < 5 || username_length > 20) || (contact_length < 10 || contact_length > 10) || (email_length < 9 || email_length > 30)) {
				if(username_length < 5 || username_length > 20) {
					if(username_length < 5) {
			    		pw.println("<!DOCTYPE html>");
			    		pw.println("<html>");
			    		pw.println("<head>");
			    		pw.println("<link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/toastr.min.css'>");
			    		pw.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js'></script>");
			    		pw.println("<script src='https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/toastr.min.js'></script>");
			    		pw.println("</head>");
			    		pw.println("<body>");
			    		pw.println("<script>");
			    		pw.println("$(function() {");
			    		pw.println("toastr.error('You cannot submit with username less than 5 characters.');");
			    		pw.println("setTimeout(function() {");
			    		pw.println("window.location.href='edit_profile.jsp';");
			    		pw.println("},2000);"); // Redirect after 2 seconds
			    		pw.println("});");
			    		pw.println("</script>");						
					}else {
			    		pw.println("<!DOCTYPE html>");
			    		pw.println("<html>");
			    		pw.println("<head>");
			    		pw.println("<link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/toastr.min.css'>");
			    		pw.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js'></script>");
			    		pw.println("<script src='https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/toastr.min.js'></script>");
			    		pw.println("</head>");
			    		pw.println("<body>");
			    		pw.println("<script>");
			    		pw.println("$(function() {");
			    		pw.println("toastr.error('You cannot submit with username more than 20 characters.');");
			    		pw.println("setTimeout(function() {");
			    		pw.println("window.location.href='edit_profile.jsp';");
			    		pw.println("},2000);"); // Redirect after 2 seconds
			    		pw.println("});");
			    		pw.println("</script>");						
					}
				}else if(contact_length < 10 || contact_length > 10) {
					if(contact_length < 10) {
			    		pw.println("<!DOCTYPE html>");
			    		pw.println("<html>");
			    		pw.println("<head>");
			    		pw.println("<link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/toastr.min.css'>");
			    		pw.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js'></script>");
			    		pw.println("<script src='https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/toastr.min.js'></script>");
			    		pw.println("</head>");
			    		pw.println("<body>");
			    		pw.println("<script>");
			    		pw.println("$(function() {");
			    		pw.println("toastr.error('You cannot submit with contact less than 10 values.');");
			    		pw.println("setTimeout(function() {");
			    		pw.println("window.location.href='edit_profile.jsp';");
			    		pw.println("},2000);"); // Redirect after 2 seconds
			    		pw.println("});");
			    		pw.println("</script>");						
					}else {
			    		pw.println("<!DOCTYPE html>");
			    		pw.println("<html>");
			    		pw.println("<head>");
			    		pw.println("<link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/toastr.min.css'>");
			    		pw.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js'></script>");
			    		pw.println("<script src='https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/toastr.min.js'></script>");
			    		pw.println("</head>");
			    		pw.println("<body>");
			    		pw.println("<script>");
			    		pw.println("$(function() {");
			    		pw.println("toastr.error('You cannot submit with contact more than 10 values.');");
			    		pw.println("setTimeout(function() {");
			    		pw.println("window.location.href='edit_profile.jsp';");
			    		pw.println("},2000);"); // Redirect after 2 seconds
			    		pw.println("});");
			    		pw.println("</script>");						
					}
				}else {
					if(email_length < 9) {
			    		pw.println("<!DOCTYPE html>");
			    		pw.println("<html>");
			    		pw.println("<head>");
			    		pw.println("<link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/toastr.min.css'>");
			    		pw.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js'></script>");
			    		pw.println("<script src='https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/toastr.min.js'></script>");
			    		pw.println("</head>");
			    		pw.println("<body>");
			    		pw.println("<script>");
			    		pw.println("$(function() {");
			    		pw.println("toastr.error('You cannot submit with email less than 9 characters.');");
			    		pw.println("setTimeout(function() {");
			    		pw.println("window.location.href='edit_profile.jsp';");
			    		pw.println("},2000);"); // Redirect after 2 seconds
			    		pw.println("});");
			    		pw.println("</script>");						
					}else {
			    		pw.println("<!DOCTYPE html>");
			    		pw.println("<html>");
			    		pw.println("<head>");
			    		pw.println("<link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/toastr.min.css'>");
			    		pw.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js'></script>");
			    		pw.println("<script src='https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/toastr.min.js'></script>");
			    		pw.println("</head>");
			    		pw.println("<body>");
			    		pw.println("<script>");
			    		pw.println("$(function() {");
			    		pw.println("toastr.error('You cannot submit with email more than 30 characters.');");
			    		pw.println("setTimeout(function() {");
			    		pw.println("window.location.href='edit_profile.jsp';");
			    		pw.println("},2000);"); // Redirect after 2 seconds
			    		pw.println("});");
			    		pw.println("</script>");
					}
				}
			}else {
        		  HttpSession session = request.getSession(true);
        		  String session_name = (String) session.getAttribute("session_id");
        		  System.out.println(session_name);
        			  
        			  int user_id = read_user_name(session_name);
        			  System.out.println(user_id);
        			  boolean detailsIsUpdated = update_user_info_details(username, contact, email, user_id);
        			  if(detailsIsUpdated) {
    			    		pw.println("<!DOCTYPE html>");
      			    		pw.println("<html>");
      			    		pw.println("<head>");
      			    		pw.println("<link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/toastr.min.css'>");
      			    		pw.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js'></script>");
      			    		pw.println("<script src='https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/toastr.min.js'></script>");
      			    		pw.println("</head>");
      			    		pw.println("<body>");
      			    		pw.println("<script>");
      			    		pw.println("$(function() {");
      			    		pw.println("toastr.success('Your profile details are updated successfully..');");
      			    		pw.println("setTimeout(function() {");
      			    		pw.println("window.location.href='greetings.jsp';");
      			    		pw.println("},2000);"); // Redirect after 2 seconds
      			    		pw.println("});");
      			    		pw.println("</script>"); 
        			  }else {
  			    		pw.println("<!DOCTYPE html>");
  			    		pw.println("<html>");
  			    		pw.println("<head>");
  			    		pw.println("<link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/toastr.min.css'>");
  			    		pw.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js'></script>");
  			    		pw.println("<script src='https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/toastr.min.js'></script>");
  			    		pw.println("</head>");
  			    		pw.println("<body>");
  			    		pw.println("<script>");
  			    		pw.println("$(function() {");
  			    		pw.println("toastr.error('Something went wrong, Please try again !');");
  			    		pw.println("setTimeout(function() {");
  			    		pw.println("window.location.href='edit_profile.jsp';");
  			    		pw.println("},2000);"); // Redirect after 2 seconds
  			    		pw.println("});");
  			    		pw.println("</script>");   
        			  }
        		  }
			}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	private boolean check_username_exist(String session) {
		boolean flag = false;
		try {
			ps = con.prepareStatement("select user_name from flyinginvite_user_info_details Inner Join flyinginvite_user_session_details where session_name = ?;");
		    ps.setString(1, session);
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
	
	
	private boolean check_contact_exist(String session) {
		boolean flag = false;
		try {
			ps = con.prepareStatement("select user_contact from flyinginvite_user_info_details Inner Join flyinginvite_user_session_details where session_name = ?;");
		    ps.setString(1, session);
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
	
	private boolean check_email_exist(String session) {
		boolean flag = false;
		try {
			ps = con.prepareStatement("select user_email from flyinginvite_user_info_details Inner Join flyinginvite_user_session_details where session_name = ?;");
		    ps.setString(1, session);
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
	
	private int read_user_name(String session) {
		int user_id = -1;
		try {
			ps = con.prepareStatement("select user_id from flyinginvite_user_session_details where session_name = ?;");
			ps.setString(1, session);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				user_id = rs.getInt("user_id");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return user_id;
	}
	
	private boolean update_user_info_details(String username, String contact, String email, int user_id) {
		boolean flag = false;
		try {
			ps = con.prepareStatement("update flyinginvite_user_info_details set user_name = ?, user_contact = ?, user_email = ? where user_id = ?;");
			ps.setString(1, username);
			ps.setString(2, contact);
			ps.setString(3, email);
			ps.setInt(4, user_id);
			ps.executeUpdate();
			flag = true;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return flag;
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
