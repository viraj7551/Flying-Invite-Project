package com.flyinginvite;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/pageInfo")
public class PageInfo extends HttpServlet {
	Connection con;
	
	public void init() {
		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://88.222.214.58:3306/flyinginvite_custom";
		String username = "root";
		String password = "13Viraj@2507";
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, username, password);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  String title = request.getParameter("title");
	  String heading1 = request.getParameter("heading1");
	  String heading2 = request.getParameter("heading2");
	  int userId = Integer.parseInt(request.getParameter("user_id"));
	  PrintWriter pw = response.getWriter();
	  response.setContentType("text/html");
	  boolean flag = false;
	  
	  if(title!= null && heading1 != null && heading2 != null) {
		  boolean success = isTitleExist(title);
		  if(!success) {
			  try {
				  PreparedStatement ps = con.prepareStatement("insert into page_info(page_title, page_heading1, page_heading2, userId)values(?,?,?,?)");
				  ps.setString(1,title);
				  ps.setString(2,heading1);
				  ps.setString(3, heading2);
				  ps.setInt(4, userId);
				  ps.executeUpdate();
				  flag = true;
			  }
			  catch(Exception e) {
				  e.printStackTrace();
			  }
		  }else {
	  	        request.getSession(true);
			    pw.println("<script type=\"text/javascript\">"); 
			    pw.println("alert('page information you are trying to add, already exists.');"); 
			    pw.println("location='page_info.jsp';"); 
			    pw.println("</script>");   
		  }
	  }
	  
	  if(flag) {
	        request.getSession(true);
		    pw.println("<script type=\"text/javascript\">"); 
		    pw.println("alert('page information is added successfully.');"); 
		    pw.println("location='dashboard.jsp';"); 
		    pw.println("</script>"); 
	  }else {
	        request.getSession(true);
		    pw.println("<script type=\"text/javascript\">"); 
		    pw.println("alert('something went wrong! please try again.');"); 
		    pw.println("location='page_info.jsp';"); 
		    pw.println("</script>"); 
	  }
	}
	
	public boolean isTitleExist(String title) {
		boolean success = false;
		try {
		   PreparedStatement ps = con.prepareStatement("select * from page_info where page_title = ?");
		   ps.setString(1, title);
		   ResultSet rs = ps.executeQuery();
		   if(rs.next()) {
			   success = true;
		   }
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return success;
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	public void close() {
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
