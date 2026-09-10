package com.app;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;


@WebServlet("/Register")
public class Register extends HttpServlet {
	    
	
	// Email regex pattern
    private static final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
    private static final Pattern EMAIL_PATTERN = Pattern.compile(EMAIL_REGEX);
    private static final Pattern ALPHANUMERIC_PATTERN = Pattern.compile("^[a-zA-Z0-9]+$");
    private static final Pattern NUMERIC_PATTERN = Pattern.compile("^[0-9]+$");

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
		
		  String login_username = request.getParameter("username");
		  String contact = request.getParameter("user_contact");
		  String email = request.getParameter("user_register_email");
		  
		  //to check all 3 values are not null
		  
		  if(login_username == null || contact == null || email == null) {
            if(login_username == null) {
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
	    		pw.println("toastr.error('You cannot register with empty username.');");
	    		pw.println("setTimeout(function() {");
	    		pw.println("window.location.href='register.jsp';");
	    		pw.println("},2000);"); // Redirect after 2 seconds
	    		pw.println("});");
	    		pw.println("</script>");
	    		pw.println("</body>");
	    		pw.println("</html>");     
	    		
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
	    		pw.println("toastr.error('You cannot register with empty contact detail.');");
	    		pw.println("setTimeout(function() {");
	    		pw.println("window.location.href='register.jsp';");
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
	    		pw.println("toastr.error('You cannot register with empty email address.');");
	    		pw.println("setTimeout(function() {");
	    		pw.println("window.location.href='register.jsp';");
	    		pw.println("},2000);"); // Redirect after 2 seconds
	    		pw.println("});");
	    		pw.println("</script>");
	    		pw.println("</body>");
	    		pw.println("</html>");  
            }
			  
		  }else {

			  // to check all 3 values length for given input
			  
			  int username_length = login_username.length();
			  int contact_length = contact.length();
			  int email_length = email.length();
			  
			  if((username_length < 5 || username_length > 20) || (contact_length < 10 || contact_length > 10) || (email_length < 9 || email_length > 30)) {
			    if(username_length < 5 || username_length > 20) {
			    	if(username_length < 5) {
			    		response.setContentType("text/html; charset=UTF-8");
			    		PrintWriter pw = response.getWriter();
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
			    		pw.println("toastr.error('You cannot register with username less than 5 characters.');");
			    		pw.println("setTimeout(function() {");
			    		pw.println("window.location.href='register.jsp';");
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
			    		pw.println("toastr.error('You cannot register with username more than 20 characters.');");
			    		pw.println("setTimeout(function() {");
			    		pw.println("window.location.href='register.jsp';");
			    		pw.println("},2000);"); // Redirect after 2 seconds
			    		pw.println("});");
			    		pw.println("</script>");
			    		pw.println("</body>");
			    		pw.println("</html>");		
			    		
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
			    		pw.println("toastr.error('You cannot register with less than 10 contact values.');");
			    		pw.println("setTimeout(function() {");
			    		pw.println("window.location.href='register.jsp';");
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
			    		pw.println("toastr.error('You cannot register with less than 10 contact values.');");
			    		pw.println("setTimeout(function() {");
			    		pw.println("window.location.href='register.jsp';");
			    		pw.println("},2000);"); // Redirect after 2 seconds
			    		pw.println("});");
			    		pw.println("</script>");
			    		pw.println("</body>");
			    		pw.println("</html>");	
			    		
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
			    		pw.println("toastr.error('You cannot register with email less than 9 characters.');");
			    		pw.println("setTimeout(function() {");
			    		pw.println("window.location.href='register.jsp';");
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
			    		pw.println("toastr.error('You cannot register with email more than 30 characters.');");
			    		pw.println("setTimeout(function() {");
			    		pw.println("window.location.href='register.jsp';");
			    		pw.println("},2000);"); // Redirect after 2 seconds
			    		pw.println("});");
			    		pw.println("</script>");
			    		pw.println("</body>");
			    		pw.println("</html>");		    	   
			       }
			    } 
			  }else {
				  
				  
				  //check for field patterns
				  
				  boolean usernamePatterIsCorrect = isAlphanumeric(login_username);
				  boolean usercontactPatternIsCorrect = isOnlyNumeric(contact);
				  boolean userEmailPatternIsCorrect = isValidEmail(email);
				  
				  if((!usernamePatterIsCorrect) || (!usercontactPatternIsCorrect) || (!userEmailPatternIsCorrect)) {
 
					  if(!usernamePatterIsCorrect) {
						    
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
				    		pw.println("toastr.error('You cannot register with incorrect input format for username field.');");
				    		pw.println("setTimeout(function() {");
				    		pw.println("window.location.href='register.jsp';");
				    		pw.println("},2000);"); // Redirect after 2 seconds
				    		pw.println("});");
				    		pw.println("</script>");
				    		pw.println("</body>");
				    		pw.println("</html>");
				    		
					  }else if(!usercontactPatternIsCorrect) {
						   
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
				    		pw.println("toastr.error('You cannot register with incorrect input format for contact field.');");
				    		pw.println("setTimeout(function() {");
				    		pw.println("window.location.href='register.jsp';");
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
				    		pw.println("toastr.error('You cannot register with incorrect email format.');");
				    		pw.println("setTimeout(function() {");
				    		pw.println("window.location.href='register.jsp';");
				    		pw.println("},2000);"); // Redirect after 2 seconds
				    		pw.println("});");
				    		pw.println("</script>");
				    		pw.println("</body>");
				    		pw.println("</html>");
					  }
			    		
				  }else {				  
				  boolean userEmailExists = check_user_email_exists(ps, con, contact);
				  if(!userEmailExists) {
					  try {
							 
                          String session = login_username+ Math.round(Math.random() * 100000000);
                          String default_renew_type = "Free Tier";
                          int default_limit_count_id = 1;
                      	
			              boolean isInsertedPartiallyDetailsIntoUserRegistration = 	insert_into_user_register_details(ps, con, login_username, contact, email);
                          
			              //read newly inserted user entry 
			              int user_id = read_user_id(ps, con);
			       
			              //store created session 
                  		  HttpSession session02 = request.getSession(true);
                  		  session02.setAttribute("username", login_username);
			              
			              // create new session entry for newly created user
			              boolean isInsertedIntoUserSession = insert_into_user_session(ps, con, session, user_id);
			       
			              // create new renew entry for newly created user
			              boolean isInsertedUserDetailToFreeTier = insert_user_for_free_tier(ps, con,default_renew_type,default_limit_count_id,user_id);  
			              
			              if((!isInsertedPartiallyDetailsIntoUserRegistration) || (!isInsertedIntoUserSession) || (!isInsertedUserDetailToFreeTier) ) {
                        
                              if(!isInsertedPartiallyDetailsIntoUserRegistration) {
                            	  
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
        			    		pw.println("toastr.error('Something went wrong while submitting registration details, Please try again!');");
        			    		pw.println("setTimeout(function() {");
        			    		pw.println("window.location.href='register.jsp';");
        			    		pw.println("},2000);"); // Redirect after 2 seconds
        			    		pw.println("});");
        			    		pw.println("</script>");
        			    		pw.println("</body>");
        			    		pw.println("</html>"); 
        			    		
                              }else if(!isInsertedIntoUserSession) {
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
            			    		pw.println("toastr.error('Something went wrong while updating details for session, Please try again!');");
            			    		pw.println("setTimeout(function() {");
            			    		pw.println("window.location.href='register.jsp';");
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
          			    		pw.println("toastr.error('Something went wrong while updating details for renew, Please try again!');");
          			    		pw.println("setTimeout(function() {");
          			    		pw.println("window.location.href='register.jsp';");
          			    		pw.println("},2000);"); // Redirect after 2 seconds
          			    		pw.println("});");
          			    		pw.println("</script>");
          			    		pw.println("</body>");
          			    		pw.println("</html>"); 
                              }
                               
                            
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
				    		pw.println("toastr.success('You have successfully registered.');");
				    		pw.println("setTimeout(function() {");
				    		pw.println("window.location.href='set_password.jsp';");
				    		pw.println("},2000);"); // Redirect after 2 seconds
				    		pw.println("});");
				    		pw.println("</script>");
				    		pw.println("</body>");
				    		pw.println("</html>"); 
			              }
					  }
					  catch(Exception e) {
						  e.printStackTrace();
					  }	 
			    		
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
			    		pw.println("toastr.error('Entered email is already been registered, Please Sign-in.');");
			    		pw.println("setTimeout(function() {");
			    		pw.println("window.location.href='register.jsp';");
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
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	
    private boolean isValidEmail(String email) {
        if (email == null) return false;
        Matcher matcher = EMAIL_PATTERN.matcher(email);
        return matcher.matches();
    }
    
    private static boolean isAlphanumeric(String text) {
        if (text == null) {
            return false;
        }
        Matcher matcher = ALPHANUMERIC_PATTERN.matcher(text);
        return matcher.matches();
    }
    
    private static boolean isOnlyNumeric(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        Matcher matcher = NUMERIC_PATTERN.matcher(str);
        return matcher.matches();
    }

	private boolean insert_user_for_free_tier(PreparedStatement ps, Connection con, String default_renew_type, int default_limit_count_id, int user_id) {
		boolean flag = false;
		try {
			ps = con.prepareStatement("insert into flyinginvite_renew_table(renew_type, limit_count_id, user_id)values(?,?,?);");
			ps.setString(1, default_renew_type);
			ps.setInt(2, default_limit_count_id);
			ps.setInt(3, user_id);
			ps.executeUpdate();
			flag = true;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	
	
	private int read_user_id(PreparedStatement ps, Connection con) {
		try {
		  ps = con.prepareStatement("select max(user_id) as user_id from flyinginvite_user_info_details;");	
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
	
	private boolean insert_into_user_session(PreparedStatement ps, Connection con, String session, int userId) {
		boolean flag = false;
		try {
			ps = con.prepareStatement("insert into flyinginvite_user_session_details(session_name, user_id)values(?,?);");
			ps.setString(1, session);
			ps.setInt(2, userId);
			ps.executeUpdate();
			flag = true;
		}
		catch(Exception e) {
		  e.printStackTrace();	
		}
		return flag;
	}
	
	private boolean check_user_email_exists(PreparedStatement ps, Connection con, String contact) {
		boolean flag = false;
		try {
			ps = con.prepareStatement("select user_email from flyinginvite_user_info_details where user_contact = ?;");
			ps.setString(1, contact);
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
	
	private boolean insert_into_user_register_details(PreparedStatement ps, Connection con, String username, String contact, String email) {
		boolean flag= false;
		try {
	    	ps = con.prepareStatement("insert into flyinginvite_user_info_details(user_name, user_contact, user_email)values(?,?,?);");
			ps.setString(1, username);
			ps.setString(2, contact);
			ps.setString(3, email);
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
