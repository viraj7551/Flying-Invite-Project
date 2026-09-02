package com.app;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import javax.servlet.ServletException;

/**
 * Servlet implementation class EmailAuth
 */
@WebServlet("/EmailAuth")
public class EmailAuth extends HttpServlet {
	
    
    private static final long serialVersionUID = 1L;

    // Email regex pattern
    private static final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
    private static final Pattern EMAIL_PATTERN = Pattern.compile(EMAIL_REGEX);
    private static final String USERNAME = "admin@flyinginvite.in";
    private static final String PASSWORD = "13Viraj@2507";
    private static final int MAX_ATTEMPTS = 3;
    private static final long BLOCK_DURATION_MS = 5 * 60 * 1000; // 5 minutes
    private static final ConcurrentHashMap<String, AttemptInfo> attemptsMap = new ConcurrentHashMap<>();
	PrintWriter pw;
   
    Connection con;
    PreparedStatement ps;
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
		  
		  String to_email = request.getParameter("user_email");
		  
		  if(to_email == null) {
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
	    		pw.println("window.location.href='verify_email.jsp';");
	    		pw.println("},2000);"); // Redirect after 2 seconds
	    		pw.println("});");
	    		pw.println("</script>");
		  } else {
			       boolean isValidEmail = isValidEmail(to_email);
			       if (!isValidEmail) { 
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
			    		pw.println("toastr.error('Please enter correct email address.');");
			    		pw.println("setTimeout(function() {");
			    		pw.println("window.location.href='verify_email.jsp';");
			    		pw.println("},2000);"); // Redirect after 2 seconds
			    		pw.println("});");
			    		pw.println("</script>");
			       }
			       else {
		      	    	 boolean attempt_status = email_attempts(request,response);
		    	    	 if(!attempt_status) {
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
		    		    		pw.println("toastr.error('Too Many Request ! Please try again 5 minutes Later');");
		    		    		pw.println("setTimeout(function() {");
		    		    		pw.println("window.location.href='verify_email.jsp';");
		    		    		pw.println("},2000);"); // Redirect after 2 seconds
		    		    		pw.println("});");
		    		    		pw.println("</script>");
		    				    
		               }else {
				    		 boolean userExist = isUserExists(to_email);
							  if(userExist) {
								  Properties prop = new Properties();
									//prop.put("mail.smtp.host", "smtp.gmail.com");
									prop.put("mail.smtp.host","smtp.hostinger.com");
							        prop.put("mail.smtp.port", "465");
							        prop.put("mail.smtp.auth", "true");
							        prop.put("mail.smtp.socketFactory.port", "465");
							        prop.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
							        
							        Session session = Session.getInstance(prop,
							                new jakarta.mail.Authenticator() {
							                    protected PasswordAuthentication getPasswordAuthentication() {
							                        return new PasswordAuthentication(USERNAME, PASSWORD);
							                    }
							                });

							        try {

							            Message message = new MimeMessage(session);
							            message.setFrom(new InternetAddress("admin@flyinginvite.in"));
							            message.setRecipients(
							                    Message.RecipientType.TO,
							                    InternetAddress.parse(to_email)
							            );
							            

							    		Random rand = new Random();
							            // Generate a random number between 100000 and 999999 (6 digits)
							    		int generated_otp = rand.nextInt(900000) + 100000;  
							            
							            // Store OTP in session
							            HttpSession session02 = request.getSession(true);
							            session02.setAttribute("generatedOTP", generated_otp);
							            
							            HttpSession session03 = request.getSession(true);
							            
							            String session_name = read_session(to_email);
				                        session03.setAttribute("session_name", session_name);
							            
							            
							            message.setSubject("OTP Verification ["+generated_otp+"]");
							            message.setText("Dear User,"
							                    + "\n\n Your OTP is "+generated_otp+""
							                    +"\n\n Best practise is to not share OTP with anyone.");
							            
							            
							            
							            Transport.send(message);       
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
							    		pw.println("toastr.success('OTP is sent your mail.');");
							    		pw.println("setTimeout(function() {");
							    		pw.println("window.location.href='verify_otp.jsp';");
							    		pw.println("},2000);"); // Redirect after 2 seconds
							    		pw.println("});");
							    		pw.println("</script>"); 

							        } catch (MessagingException e) {
							            e.printStackTrace();
							        }
							  }else {
                                 response.sendRedirect("verify_email.jsp");								  
		                   }
		               }
			        }
			    }
         }
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	
	
	
	private boolean email_attempts(HttpServletRequest request, HttpServletResponse response) {
		
		 String clientId = getClientIdentifier(request); // can be IP or session ID
	        AttemptInfo info = attemptsMap.getOrDefault(clientId, new AttemptInfo(0, System.currentTimeMillis()));
	        long currentTime = System.currentTimeMillis();
	        if (info.attempts >= MAX_ATTEMPTS && (currentTime - info.firstAttemptTime) < BLOCK_DURATION_MS) {
	            response.setStatus(HttpServletResponse.SC_REQUEST_TIMEOUT);
	            return false;
	        }
	        if ((currentTime - info.firstAttemptTime) >= BLOCK_DURATION_MS) {
	            // Reset attempts after cooldown
	            info = new AttemptInfo(0, currentTime);
	        }
	        info.attempts++;
	        attemptsMap.put(clientId, info);
	        return true;
	}
	
    private String getClientIdentifier(HttpServletRequest request) {
        // You can enhance this to use session ID, user ID, or fingerprint
        return request.getRemoteAddr();
    }
	
	
    private static class AttemptInfo {
        int attempts;
        long firstAttemptTime;

        AttemptInfo(int attempts, long firstAttemptTime) {
            this.attempts = attempts;
            this.firstAttemptTime = firstAttemptTime;
        }
    }

	public boolean isUserExists(String email) {
		boolean flag = false;
		try {
			ps = con.prepareStatement("select * from flyinginvite_user_info_details where user_email = ?");
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
	
    private boolean isValidEmail(String email) {
       boolean flag = false;
    	if (email == null) {
    		return flag;	
    	}else {
    		Matcher matcher = EMAIL_PATTERN.matcher(email);
            boolean email_matches_to_correct_pattern = matcher.matches();
            if(email_matches_to_correct_pattern) {
            	flag = true;
            }else {
            	flag = false;
            }
    	}
    	return flag;
    }
	
	public String read_session(String email) {
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
	
	public void destroy() {
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}

