package com.app;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Pattern;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.mindrot.jbcrypt.BCrypt;


@WebServlet("/SetPassword")
public class SetPassword extends HttpServlet {
    
   Connection con;
   PreparedStatement ps;
   PrintWriter pw;
   
   private static final Pattern VALID_PATTERN = Pattern.compile("^[a-zA-Z0-9@]+$");
   
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
		  HttpSession session = request.getSession(); 
		  String username = (String) session.getAttribute("username");
		  String new_password = request.getParameter("new_password");
		  String confirm_password = request.getParameter("confirm_password");
		  
		  //check if password is not null
		  if((new_password == null) || (confirm_password == null)) {
			  
			  if(new_password == null) {
				  
				   //strictly return with error message if password value is empty
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
		    		pw.println("toastr.error('You cannot set with empty password value.');");
		    		pw.println("setTimeout(function() {");
		    		pw.println("window.location.href='set_password.jsp';");
		    		pw.println("},2000);"); // Redirect after 2 seconds
		    		pw.println("});");
		    		pw.println("</script>");
		    		pw.println("</body>");
		    		pw.println("</html>"); 
		    		
			  }else {
				  
				    //strictly return with error message if confirm password value is empty
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
		    		pw.println("toastr.error('You cannot set with empty confirm-password value.');");
		    		pw.println("setTimeout(function() {");
		    		pw.println("window.location.href='set_password.jsp';");
		    		pw.println("},2000);"); // Redirect after 2 seconds
		    		pw.println("});");
		    		pw.println("</script>");
		    		pw.println("</body>");
		    		pw.println("</html>");		
		    		
			  }

		  }else {
			  
			  //check password and confirm password length.
			  int new_password_length = new_password.length();
			  int confirm_password_length = confirm_password.length();
			  
			  if((new_password_length < 5 || new_password_length > 30) || (confirm_password_length < 5 || confirm_password_length > 30)) {
				  if(new_password_length < 5 || new_password_length > 30) {
					  if(new_password_length < 5) {
						  
						    //strictly return error message if password length is less than 5 characters
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
				    		pw.println("toastr.error('You cannot set password with less than 5 character value.');");
				    		pw.println("setTimeout(function() {");
				    		pw.println("window.location.href='set_password.jsp';");
				    		pw.println("},2000);"); // Redirect after 2 seconds
				    		pw.println("});");
				    		pw.println("</script>");
				    		pw.println("</body>");
				    		pw.println("</html>");	
				    		
					  }else {
						  
						    //strictly return error message if password length is more than 30 characters
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
				    		pw.println("toastr.error('You cannot set with password more than 30 character value.');");
				    		pw.println("setTimeout(function() {");
				    		pw.println("window.location.href='set_password.jsp';");
				    		pw.println("},2000);"); // Redirect after 2 seconds
				    		pw.println("});");
				    		pw.println("</script>");
				    		pw.println("</body>");
				    		pw.println("</html>");			
					  }
				  }else {
					  if(confirm_password_length < 5) {
						    
						   // strictly return error message if confirm password length is less than 5 characters
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
				    		pw.println("toastr.error('You cannot set confirm password with less than 5 character value.');");
				    		pw.println("setTimeout(function() {");
				    		pw.println("window.location.href='set_password.jsp';");
				    		pw.println("},2000);"); // Redirect after 2 seconds
				    		pw.println("});");
				    		pw.println("</script>");
				    		pw.println("</body>");
				    		pw.println("</html>");	
				    		
					  }else {
						  
						    // strictly return error message if confirm password length is more than 30 characters
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
				    		pw.println("toastr.error('You cannot set confirm password more than 30 character value.');");
				    		pw.println("setTimeout(function() {");
				    		pw.println("window.location.href='set_password.jsp';");
				    		pw.println("},2000);"); // Redirect after 2 seconds
				    		pw.println("});");
				    		pw.println("</script>");
				    		pw.println("</body>");
				    		pw.println("</html>");		
				    		
					  }
				  }
			  }else {
				  
				  boolean passwordIsCorrectFormat = isValid(new_password);
				  boolean confirmpasswordIsCorrectFormat = isValid(confirm_password);
				  
				   if(!passwordIsCorrectFormat || !confirmpasswordIsCorrectFormat) {
					  
					   if(!passwordIsCorrectFormat) {
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
				    		pw.println("toastr.error('Please enter password in correct format');");
				    		pw.println("setTimeout(function() {");
				    		pw.println("window.location.href='set_password.jsp';");
				    		pw.println("},2000);"); // Redirect after 2 seconds
				    		pw.println("});");
				    		pw.println("</script>");
				    		pw.println("</body>");
				    		pw.println("</html>");	
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
				    		pw.println("toastr.error('Please enter confirm password in correct format');");
				    		pw.println("setTimeout(function() {");
				    		pw.println("window.location.href='set_password.jsp';");
				    		pw.println("},2000);"); // Redirect after 2 seconds
				    		pw.println("});");
				    		pw.println("</script>");
				    		pw.println("</body>");
				    		pw.println("</html>");
					   }
					   
					   
				   }else {
						  //check password and confirm password are matched or not
						  if(!new_password.equals(confirm_password)) {
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
					    		pw.println("toastr.error('Password and Confirm-Password are mismatched! Please try again..');");
					    		pw.println("setTimeout(function() {");
					    		pw.println("window.location.href='set_password.jsp';");
					    		pw.println("},2000);"); // Redirect after 2 seconds
					    		pw.println("});");
					    		pw.println("</script>");
					    		pw.println("</body>");
					    		pw.println("</html>");		
					    		
						  }else {

						    	   // read user id from user information table
							       int user_id = read_user_id(ps,con,username);
							       
							       
							       //encrypt password before setting into database
							       String hashed_password = encrypt_password(new_password);
							   
								   // insert hashed password for existing user into database
								   boolean isPasswordInserted= insert_into_password(ps, con, hashed_password, user_id);
								   if(!isPasswordInserted) {							    		
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
							    		pw.println("toastr.error('Something went wrong while inserting password details');");
							    		pw.println("setTimeout(function() {");
							    		pw.println("window.location.href='set_password.jsp';");
							    		pw.println("},2000);"); // Redirect after 2 seconds
							    		pw.println("});");
							    		pw.println("</script>");
							    		pw.println("</body>");
							    		pw.println("</html>");
							    		
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
							    		pw.println("toastr.success('Your password details are updated successfully..!');");
							    		pw.println("setTimeout(function() {");
							    		pw.println("window.location.href='login.jsp';");
							    		pw.println("},2000);"); // Redirect after 2 seconds
							    		pw.println("});");
							    		pw.println("</script>");
							    		pw.println("</body>");
							    		pw.println("</html>");
						     }
						  }  
				    }  
			   }
		  }
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	private String encrypt_password(String password) {
		String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt(12));
		return hashedPassword;
	}
	
	private int read_user_id(PreparedStatement ps, Connection con, String username) {
		try {
			ps = con.prepareStatement("select user_id from flyinginvite_user_info_details where user_name = ?;");
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				return rs.getInt("user_id"); 
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return -1;
	}
	
    private static boolean isValid(String input) {
        if (input == null) {
            return false;
        }
        // Alternative quick approach: return input.matches("^[a-zA-Z0-9@]+$");
        return VALID_PATTERN.matcher(input).matches();
    }
    
	private boolean insert_into_password(PreparedStatement ps, Connection con,  String password, int user_id) {
		boolean flag = false;
		try {
			ps = con.prepareStatement("insert into flyinginvite_user_password_details(password, user_id)values(?,?);");
			ps.setString(1, password);
			ps.setInt(2, user_id);
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
