package com.app;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Base64;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;

@WebServlet("/TemplateDownload")
public class DownloadTemplate extends HttpServlet {

    ResultSet rs = null;
    Connection con = null;
    PreparedStatement ps = null;
    PrintWriter pw;
    
    private String template_name = null;
    private int target_id;
    private int access_type_id;
    private int image_id;
    private int type_id;
    private int price_id;
    
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
        
        HttpSession session = request.getSession();
        String session_name = (String)session.getAttribute("session_id");
        
        if(session_name != null) {
            
	        String target_title = request.getParameter("target_title");
            String template_title = request.getParameter("template_name");
               
               
    		int user_id = read_user_id(ps,con,session_name);
		    int total_download_count = read_total_download_count(ps,con,user_id);
		    int limit_count = read_limit_count(ps,con,user_id); 
		    String read_renew_info = read_renew_info(ps,con,user_id);
		    
      		HttpSession session04 = request.getSession(true);
      		session04.setAttribute("total_download_count",total_download_count);
      		session04.setAttribute("limit_count",limit_count);
      		session04.setAttribute("read_renew_info",read_renew_info); 
		    boolean fileIsDownloaded = download_image(request,response, template_title, target_title);
		    
		           if(!fileIsDownloaded) {
		        	   
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
       	    		pw.println("toastr.error('Something went, while downloading image');");
       	    		pw.println("setTimeout(function() {");
       	    		pw.println("window.location.href='greetings.jsp';");
       	    		pw.println("},2000);"); // Redirect after 2 seconds
       	    		pw.println("});");
       	    		pw.println("</script>");
		        	   
		           }else {
                         
		        	   update_backend(template_title, target_title, user_id);
		           }	         			
           }else{
        	   
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
    		pw.println("toastr.error('Something went wrong with login, Please try again!');");
    		pw.println("setTimeout(function() {");
    		pw.println("window.location.href='login.jsp';");
    		pw.println("},2000);"); // Redirect after 2 seconds
    		pw.println("});");
    		pw.println("</script>");
           
           }
        
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	private void update_backend(String template_title, String target_title, int user_id) {
        int template_id = read_template_id(ps,con,template_title, target_title);
        read_target_id(ps,con,template_id);
       read_type_id(ps,con, template_id);
       read_access_type_id(ps,con,template_id);
       read_price_id(ps,con,template_id);
       read_image_id(ps,con, template_id);


		 //Remaining check for text format
		
       LocalDateTime ld = LocalDateTime.now();
       DateTimeFormatter dtf = DateTimeFormatter.ofPattern("YYYY-MM-dd HH:mm:ss");
       String current_date = dtf.format(ld);
	
		
		boolean isInsertedIntoTimestamp = insert_into_timestamp(ps,con, current_date,user_id);
		int timestamp_id = read_time_stamp_id(ps,con, user_id);
		
		boolean isInsertedIntoDownloadEvent = insertIntoDownloadEvent(ps,con,timestamp_id, template_id, user_id);
		
		int renew_id = read_renew_id(ps, con, user_id);
		
		boolean isInsertedIntoOrderTable = insertIntoOrderTable(ps,con, template_title, template_id, target_id, type_id, access_type_id, price_id, image_id, user_id, timestamp_id, renew_id);
		
		if(!isInsertedIntoTimestamp || !isInsertedIntoDownloadEvent || !isInsertedIntoOrderTable) {
			if(!isInsertedIntoTimestamp) {
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
	    		pw.println("toastr.error('Something went, while downloading image, Please try again');");
	    		pw.println("setTimeout(function() {");
	    		pw.println("window.location.href='greetings.jsp';");
	    		pw.println("},2000);"); // Redirect after 2 seconds
	    		pw.println("});");
	    		pw.println("</script>");
	    		
			}else if(!isInsertedIntoDownloadEvent) {
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
	    		pw.println("toastr.error('Something went, while downloading image, Please try again');");
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
	    		pw.println("toastr.error('Something went, while downloading image, Please try again');");
	    		pw.println("setTimeout(function() {");
	    		pw.println("window.location.href='login.jsp';");
	    		pw.println("},2000);"); // Redirect after 2 seconds
	    		pw.println("});");
	    		pw.println("</script>");
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
 		pw.println("toastr.success('User order created successfully...');");
 		pw.println("setTimeout(function() {");
 		pw.println("window.location.href='greetings.jsp';");
 		pw.println("},2000);"); // Redirect after 2 seconds
 		pw.println("});");
 		pw.println("</script>");
		  
		}	
	}
	
	private String read_renew_info(PreparedStatement ps, Connection con, int user_id) {
		String renew_title = null;
		try {
			ps = con.prepareStatement("select renew_type from flyinginvite_renew_table where user_id = ?;");
			ps.setInt(1, user_id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				renew_title = rs.getString("renew_title");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return renew_title;
	}
	
	private int read_limit_count(PreparedStatement ps, Connection con, int user_id) {
		int limit_count = 0;
		try {
			ps = con.prepareStatement("select limit_count, renew_type from flyinginvite_limit_count Inner Join flyinginvite_renew_table using(limit_count_id) where user_id = ?;");
			ps.setInt(1, user_id);
			ResultSet rs= ps.executeQuery();
			if(rs.next()) {
				limit_count = rs.getInt("limit_count");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return limit_count;
	}
	
	private int read_total_download_count(PreparedStatement ps, Connection con, int user_id) {
		int total_download_count = 0;
		try {
			ps = con.prepareStatement("select count(download_event_id) as total_download from flyinginvite_download_event where user_id = ?;");
			ps.setInt(1, user_id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				total_download_count = rs.getInt("total_download");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return total_download_count;
	}
	
	private boolean insertIntoOrderTable(PreparedStatement ps, Connection con, String order_title, int template_id, int target_id, int type_id, int access_type_id, int price_id, int image_id, int user_id, int timestamp_id, int renew_id) {
		boolean flag = false;
		try {
			ps = con.prepareStatement("insert into flyinginvite_order(order_title,template_id,target_id,type_id,access_type_id,price_id,image_id,user_id,timestamp_id,renew_id)values(?,?,?,?,?,?,?,?,?,?);");
		    ps.setString(1,order_title);
		    ps.setInt(2, template_id);
		    ps.setInt(3, target_id);
		    ps.setInt(4, type_id);
		    ps.setInt(5, access_type_id);
		    ps.setInt(6, price_id);
		    ps.setInt(7, image_id);
		    ps.setInt(8, user_id);
		    ps.setInt(9, timestamp_id);
		    ps.setInt(10, renew_id);
		    ps.executeUpdate();
		    flag = true;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	
	private void read_image_id(PreparedStatement ps, Connection con, int template_id) {
		try {
			ps = con.prepareStatement("select imageId from template_image where template_id = ?;");
			ps.setInt(1, template_id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				this.image_id = rs.getInt("imageId");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private int read_renew_id(PreparedStatement ps, Connection con, int user_id) {
		int renew_id = -1;
		try {
			ps = con.prepareStatement("select renew_id from flyinginvite_renew_table where user_id = ?;");
			ps.setInt(1, user_id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				renew_id = rs.getInt("renew_id");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return renew_id;
	}
	
	private boolean insertIntoDownloadEvent(PreparedStatement ps, Connection con, int timestamp_id, int template_id, int user_id) {
		boolean flag = false;
		try {
			ps = con.prepareStatement("insert into flyinginvite_download_event(timestamp_id, template_id, user_id)values(?,?,?);");
			ps.setInt(1, timestamp_id);
			ps.setInt(2, template_id);
			ps.setInt(3, user_id);
			ps.executeUpdate();
			flag = true;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	
	private int read_time_stamp_id(PreparedStatement ps, Connection con, int user_id) {
	   int timestampid = -1;
	   try {
		   ps = con.prepareStatement("select max(timestamp_id) as max_count from flyinginvite_timestamp where user_id = ?;");
		   ps.setInt(1,user_id);
		   ResultSet rs = ps.executeQuery();
		   if(rs.next()) {
			   timestampid = rs.getInt("max_count");
		   }
	   }
	   catch(Exception e) {
		   e.printStackTrace();
	   }
	   return timestampid;
	}
	
	private int read_user_id(PreparedStatement ps, Connection con, String session_name) {
		int user_id = -1;
		try {
			ps = con.prepareStatement("select user_id from flyinginvite_user_info_details Inner Join flyinginvite_user_session_details using(user_id) where session_name = ?;");
			ps.setString(1, session_name);
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
	
	private boolean insert_into_timestamp(PreparedStatement ps, Connection con, String timestamp, int user_id) {
		boolean flag = false;
		try {
			ps = con.prepareStatement("insert into flyinginvite_timestamp(timestamp, user_id)values(?, ?);");
			ps.setString(1, timestamp);		
			ps.setInt(2, user_id);
			ps.executeUpdate();
			flag = true;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	private int read_template_id(PreparedStatement ps, Connection con, String template_title, String target_title) {
		int template_id = -1;
		try {
			ps = con.prepareStatement("select template_id, template_title from flyinginvite_template Inner Join flyinginvite_target using(template_id) where template_title = ? and target_title = ?;");
			ps.setString(1, template_title);
			ps.setString(2, target_title);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				template_id = rs.getInt("template_id");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return template_id;
	}
	
	
	private void read_price_id(PreparedStatement ps, Connection con, int template_id) {
	   
		try {
			ps = con.prepareStatement("select price_id from flyinginvite_template_price where template_id = ?;");
			ps.setInt(1, template_id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				this.price_id = rs.getInt("price_id");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private void read_access_type_id(PreparedStatement ps, Connection con, int template_id) {
	  try {
		  ps = con.prepareStatement("select access_type_id from flyinginvite_access_type where template_id = ?;");
		  ps.setInt(1, template_id);
		  ResultSet rs = ps.executeQuery();
		  if(rs.next()) {
			  this.access_type_id = rs.getInt("access_type_id");
		  }
	  }
	  catch(Exception e) {
		  e.printStackTrace();
	  }
	}
	
	
	private void read_type_id(PreparedStatement ps, Connection con, int template_id) {
		try {
			ps = con.prepareStatement("select type_id from flyinginvite_template_type where template_id = ?");
			ps.setInt(1, template_id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				this.type_id = rs.getInt("type_id");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private void read_target_id(PreparedStatement ps, Connection con, int template_id) {
		try {
			ps = con.prepareStatement("select target_id from flyinginvite_target where template_id = ?;");
			ps.setInt(1, template_id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				this.target_id = rs.getInt("target_id");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private boolean download_image(HttpServletRequest request, HttpServletResponse response, String template_heading, String target_title) throws IOException {
        boolean flag = false;
		
		try  {
            String sql = "select image, template_title, target_title from template_image Inner Join flyinginvite_template using(template_id) Inner Join flyinginvite_target using(template_id) where template_title = ? and target_title = ?";
               ps = con.prepareStatement(sql);
               ps.setString(1,template_heading);
               ps.setString(2, target_title);
               rs = ps.executeQuery();

            if (rs.next()) {
                    
                    byte[] imageBytes = rs.getBytes("image");
                    response.setContentType("image/png");
                    response.setHeader("Content-Disposition", "attachment; filename=\"download.png\"");

                    try {
                        response.getOutputStream().write(imageBytes);
                        response.getOutputStream().flush();
                        response.getOutputStream().close();	
                        flag = true;
                    }
                    catch(Exception e) {
                    	e.printStackTrace();
                    	flag = false;
                    }
                    
            } else {
                response.sendError(HttpServletResponse.SC_NOT_FOUND, "File not found");
            }
            
        }catch (Exception e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error: " + e.getMessage());
        }
		
		return flag;
      }
 }
