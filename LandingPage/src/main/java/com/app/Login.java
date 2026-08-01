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


@WebServlet("/Login")
public class Login extends HttpServlet {

	   Connection con;
	   PreparedStatement ps;
	   PrintWriter pw;
	    
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

		  response.setContentType("text/html");
		  pw = response.getWriter();
		  
		  String email = request.getParameter("user_email");
		  String password = request.getParameter("user_password");
		  
		  //check for email and password value not null
		  
		  if(email == null || password == null) {
			  if(email == null) {
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
		    		pw.println("toastr.error('Email cannot be empty, Please enter your email.');");
		    		pw.println("setTimeout(function() {");
		    		pw.println("window.location.href='login.jsp';");
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
		    		pw.println("toastr.error('Password cannot be empty, Please enter your password.');");
		    		pw.println("setTimeout(function() {");
		    		pw.println("window.location.href='login.jsp';");
		    		pw.println("},2000);"); // Redirect after 2 seconds
		    		pw.println("});");
		    		pw.println("</script>"); 
			  }
			  
		  }else {
			  
			  //check for email and password length
			  int email_length = email.length();
			  int password_length = password.length();
			  
			  if((email_length < 5 || email_length > 30) || (password_length < 5 || password_length > 30)) {
				  if(email_length < 5 || email_length > 30) {
					  if(email_length < 5) {
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
				    		pw.println("toastr.error('Incorrect email, Please enter correct email!');");
				    		pw.println("setTimeout(function() {");
				    		pw.println("window.location.href='login.jsp';");
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
				    		pw.println("toastr.error('Incorrect email, Please enter correct email!');");
				    		pw.println("setTimeout(function() {");
				    		pw.println("window.location.href='login.jsp';");
				    		pw.println("},2000);"); // Redirect after 2 seconds
				    		pw.println("});");
				    		pw.println("</script>"); 						  
					  }
				  }else {
					  if(password_length < 5) {
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
				    		pw.println("toastr.error('Incorrect password, Please enter correct password!');");
				    		pw.println("setTimeout(function() {");
				    		pw.println("window.location.href='login.jsp';");
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
				    		pw.println("toastr.error('Incorrect password, Please enter correct password!');");
				    		pw.println("setTimeout(function() {");
				    		pw.println("window.location.href='login.jsp';");
				    		pw.println("},2000);"); // Redirect after 2 seconds
				    		pw.println("});");
				    		pw.println("</script>");
					  }
				  }
			  }else {
				  //check for email exist
				  boolean isEmailExist = check_for_email(ps, con, email);
				  
				  if(!isEmailExist) {
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
			    		pw.println("toastr.error('Entered email not exists, Please enter correct email!');");
			    		pw.println("setTimeout(function() {");
			    		pw.println("window.location.href='login.jsp';");
			    		pw.println("},2000);"); // Redirect after 2 seconds
			    		pw.println("});");
			    		pw.println("</script>");
				  }else {
					  
					  //check for correct password
					  String actual_password = check_for_password(ps,con,email);
					  if(!password.equals(actual_password)) {
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
				    		pw.println("toastr.error('Entered password is incorrect, Please enter correct password!');");
				    		pw.println("setTimeout(function() {");
				    		pw.println("window.location.href='login.jsp';");
				    		pw.println("},2000);"); // Redirect after 2 seconds
				    		pw.println("});");
				    		pw.println("</script>");
					  }else {

						  //read user_session id & set into session
						  String session_name = read_user_session(ps, con, email);
                  		  HttpSession session = request.getSession(true);
                  		  session.setAttribute("session_id", session_name); 
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
				    		pw.println("toastr.success('You are validated successfully..!');");
				    		pw.println("setTimeout(function() {");
				    		pw.println("window.location.href='greetings.jsp';");
				    		pw.println("},2000);"); // Redirect after 2 seconds
				    		pw.println("});");
				    		pw.println("</script>");
                  		  
					  }
				  }
			  }
		  }
	}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	private String read_user_session(PreparedStatement ps, Connection con, String email) {
		String session = null;
		try {
			ps = con.prepareStatement("select session_name, user_email from flyinginvite_user_session_details Inner Join flyinginvite_user_info_details using(user_id) where user_email = ?;");
		    ps.setString(1, email);
		    ResultSet rs = ps.executeQuery();
		    if(rs.next()) {
		    	session = rs.getString("session_name");
		    }
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	    return session;
	}
	
	
	private String check_for_password(PreparedStatement ps, Connection con, String email) {
	   String actual_password = null;
	   try {
		   ps = con.prepareStatement("select password from flyinginvite_user_password_details Inner Join flyinginvite_user_info_details using(user_id) where user_email=?;");
		   ps.setString(1, email);
		   ResultSet rs = ps.executeQuery();
		   if(rs.next()) {
			   actual_password = rs.getString("password");
		   }
		   return actual_password;
	   }
	   catch(Exception e) {
		   e.printStackTrace();
	   }
	    return actual_password;
	}
	
	private boolean check_for_email(PreparedStatement ps, Connection con, String email) {
		boolean flag = false;
		try {
			ps = con.prepareStatement("select user_id from flyinginvite_user_info_details where user_email = ?");
			ps.setString(1, email);
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
	
	public void destroy() {
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
