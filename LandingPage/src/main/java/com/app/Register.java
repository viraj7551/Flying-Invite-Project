package com.app;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;


@WebServlet("/Register")
public class Register extends HttpServlet {
	    
	   Connection con;
	   PreparedStatement ps;
	   PrintWriter pw;
	    
		public void init(ServletConfig config) {
			String driver = "com.mysql.cj.jdbc.Driver";
			String url = "jdbc:mysql://88.222.214.58:3306/flyinginvite_invitation";
			String username = "root";
			String password = "13Viraj@6937";
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
		  String email = request.getParameter("user_email");
		  
		  //to check all 3 values are not null
		  
		  if(login_username == null || contact == null || email == null) {
            if(login_username == null) {
			    pw.println("<script type=\"text/javascript\">"); 
			    pw.println("alert('name cannot be empty, please enter your name');");  
			    pw.println("location='register.jsp';");
			    pw.println("</script>");            	
            }else if(contact == null) {
			    pw.println("<script type=\"text/javascript\">"); 
			    pw.println("alert('contact cannot be emptym please enter your contact detail');");  
			    pw.println("location='register.jsp';");
			    pw.println("</script>"); 
            }else {
			    pw.println("<script type=\"text/javascript\">"); 
			    pw.println("alert('email cannot be empty, please enter your email');");  
			    pw.println("location='register.jsp';");
			    pw.println("</script>"); 
            }
			  
		  }else {

			  // to check all 3 values length for given input
			  
			  int username_length = login_username.length();
			  int contact_length = contact.length();
			  int email_length = email.length();
			  
			  if((username_length < 5 || username_length > 20) || (contact_length < 10 || contact_length > 10) || (email_length < 12 || email_length > 30)) {
			    if(username_length < 5 || username_length > 20) {
			    	if(username_length < 5) {
					    pw.println("<script type=\"text/javascript\">"); 
					    pw.println("alert('You cannot be submit name less than 5 characters');");  
					    pw.println("location='register.jsp';");
					    pw.println("</script>");			    		
			    	}else {
					    pw.println("<script type=\"text/javascript\">"); 
					    pw.println("alert('You cannot enter name more than 20 characters');");  
					    pw.println("location='register.jsp';");
					    pw.println("</script>");			    		
			    	}
			    }else if(contact_length < 10 || contact_length > 10) {
			      if(contact_length < 10) {
					    pw.println("<script type=\"text/javascript\">"); 
					    pw.println("alert('You cannot submit contact less than 10 values');");  
					    pw.println("location='register.jsp';");
					    pw.println("</script>");			    	  
			      }else {
					    pw.println("<script type=\"text/javascript\">"); 
					    pw.println("alert('You cannot submit contact more than 10 values');");  
					    pw.println("location='register.jsp';");
					    pw.println("</script>");			    	  
			      }
			    }else {
			       if(email_length < 12) {
					    pw.println("<script type=\"text/javascript\">"); 
					    pw.println("alert('You cannot submit with incorrect email');");  
					    pw.println("location='register.jsp';");
					    pw.println("</script>");	
			       }else {
					    pw.println("<script type=\"text/javascript\">"); 
					    pw.println("alert('You cannot submit with more than set email value');");  
					    pw.println("location='register.jsp';");
					    pw.println("</script>");			    	   
			       }
			    } 
			  }else {
				  
				  boolean userEmailExists = check_user_email_exists(ps, con, contact);
				  if(userEmailExists) {
					    pw.println("<script type=\"text/javascript\">"); 
					    pw.println("alert('Enter email is already registered! Please Sign-In');");  
					    pw.println("location='register.jsp';");
					    pw.println("</script>");
				  }else {
					    
						  try {
				              boolean isInsertedPartiallyDetailsIntoUserRegistration = 	insert_into_user_register_details(ps, con, login_username, contact, email);
				              if(isInsertedPartiallyDetailsIntoUserRegistration) {

                                int user_id = read_user_id(ps, con);
                                String session = login_username+ Math.round(Math.random() * 100000000);
                                boolean isInsertedIntoUserSession = insert_into_user_session(ps, con, session, user_id);
                                if(isInsertedIntoUserSession) {
                          		  HttpSession session01 = request.getSession(true);
                          		  session01.setAttribute("username", login_username);     
								    pw.println("<script type=\"text/javascript\">");   
								    pw.println("location='reset_password.jsp';");
								    pw.println("</script>");
                                }else {
								    pw.println("<script type=\"text/javascript\">");   
								    pw.println("alert('user details cannot be inserted successfully ! something went wrong into user session');");  
								    pw.println("location='register.jsp';");
								    pw.println("</script>");
                                }
                                
				              }else {
								    pw.println("<script type=\"text/javascript\">");   
								    pw.println("alert('Something went wrong');");  
								    pw.println("location='register.jsp';");
								    pw.println("</script>");
				              }
						  }
						  catch(Exception e) {
							  e.printStackTrace();
						  }	 
				     }
			  }
		  }
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
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
