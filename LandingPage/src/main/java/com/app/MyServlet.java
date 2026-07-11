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
import java.util.Base64;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;


@WebServlet("/MyServlet")
public class MyServlet extends HttpServlet {

	String driver = "com.mysql.cj.jdbc.Driver";
    String url = "jdbc:mysql://88.222.214.58:3306/flyinginvite_invitation";
    String username = "root";
    String password = "13Viraj@6937";
    ResultSet rs = null;
    Connection con = null;
    PreparedStatement ps = null;
    
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
        response.setContentType("text/html");
        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String heading = request.getParameter("template_heading");
        int price = Integer.parseInt(request.getParameter("template_price"));
        String category = request.getParameter("template_category");
        String downloadType = request.getParameter("download_type");

        
        
        boolean flag = false;
		try {
			
			    //Read user email
			    boolean email_exists = is_email_exist(email,phone);

		        // Store in DB (example)
		        if(downloadType.equals("Free") || email_exists) {

			         System.out.println("connection established");	
	                 flag = insert_into_user_order_details(firstname,lastname,email,phone,heading,price,category,downloadType);  	
		        }   		        	

		    } catch (Exception e) {
		        e.printStackTrace();
		    }
		
		System.out.println(flag);
		
		if(flag == true) {
 
			download_image(request,response,heading);
			
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	private boolean insert_into_user_order_details(String firstname, String lastname, String email, String phone, String heading, int price, String category, String downloadType) {
		boolean flag = false;
		try {
		    Class.forName(driver);
		    con = DriverManager.getConnection(url, username, password);
		    ps = con.prepareStatement("insert into user_order_info(order_user_firstname, order_user_lastname, order_user_email, order_user_phone, order_user_template_title, order_user_template_price, order_user_template_type, order_user_download_type)values(?,?,?,?,?,?,?,?)");
		    ps.setString(1,firstname);
		    ps.setString(2,lastname);
		    ps.setString(3,email);
		    ps.setString(4,phone);
		    ps.setString(5,heading);
		    ps.setInt(6,price);
		    ps.setString(7,category);
		    ps.setString(8,downloadType);
		    ps.executeUpdate();
		    flag = true;
		    
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	
	
	private void download_image(HttpServletRequest request, HttpServletResponse response, String template_heading) throws IOException {
        try  {
            String sql = "select image, template_heading from template_image Inner Join template using(templateId) where template_heading = ?";
               ps = con.prepareStatement(sql);
               ps.setString(1,template_heading);
               rs = ps.executeQuery();

            if (rs.next()) {
                    
                    byte[] imageBytes = rs.getBytes("image");

                    // ✅ Convert to Base64 String
                    String base64Image = Base64.getEncoder().encodeToString(imageBytes);

                    // ✅ Prefix with PNG MIME type if needed
                    String pngString = "data:image/png;base64," + base64Image;
                    
                    // ✅ Remove the prefix if present
                    String base64Image02 = pngString.split(",")[1];

                    response.setContentType("image/png");
                    response.setHeader("Content-Disposition", "attachment; filename=\"download.png\"");

                    byte[] imageBytes02 = Base64.getDecoder().decode(base64Image02);

                    response.getOutputStream().write(imageBytes02);
                    response.getOutputStream().flush();
                    response.getOutputStream().close();

                    
            } else {
                response.sendError(HttpServletResponse.SC_NOT_FOUND, "File not found");
            }
            
        }catch (Exception e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error: " + e.getMessage());
        }

   }

	
	private boolean is_email_exist(String email, String phone) {
		boolean flag = false;
		try {
			
			Class.forName(driver);
			con = DriverManager.getConnection(url,username,password);
			ps = con.prepareStatement("select email fro user_order_info where order_user_phone = ?");
			ps.setString(1,phone);
			rs = ps.executeQuery();
			if(rs.next()) {
				flag = true;
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return flag;
	}

 }
