package main.resources;

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
import javax.servlet.http.HttpSession;

@WebServlet("/Auth")
public class Auth extends HttpServlet {
	
	Connection con;
	PreparedStatement ps;
	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://88.222.214.58:3306/flyinginvite_invitation";
	private String username = "root";
	private String password = "13Viraj@2507";
	
	public void init() {
		try {
           Class.forName(driver);
		   con = DriverManager.getConnection(url, username, password);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		boolean success = false;
		if(username != null && password != null) {
			try {
				ps = con.prepareStatement("select * from userInfo where email = ? and password = ?");
				ps.setString(1,username);
				ps.setString(2, password);
				ResultSet rs  = ps.executeQuery();
				if(rs.next()) {
				     success = true;	
				}else {
					success = false;
				}
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}else {
		      success = false;
		}
		
		if(success) {
		  HttpSession session = request.getSession(true);
		  session.setAttribute("username", username);     
		  response.sendRedirect("dashboard.jsp");	
		  
		}else {
		    request.getSession(false); 
		    pw.println("<script type=\"text/javascript\">"); 
		    pw.println("alert('Invalid Credentials');"); 
		    pw.println("location='administrator.jsp';"); 
		    pw.println("</script>"); 
		}
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	public void destroy() {
		try {
			ps.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

