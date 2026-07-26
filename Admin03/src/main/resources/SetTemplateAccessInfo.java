package main.resources;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/SetAccessInfo")
public class SetTemplateAccessInfo extends HttpServlet {
	Connection con;
	PreparedStatement ps;
	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://88.222.214.58:3306/flyinginvite_invitation";
	private String username = "root";
	private String password = "13Viraj@6937";
	PrintWriter pw;
	
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
        pw = response.getWriter();
        response.setContentType("text/html");
        String file_access_type = request.getParameter("template_access_type");
        int template_id = read_template_info();
        
        boolean isInsertedIntoTemplateAccess = insert_into_template_access_type(ps, con, file_access_type, template_id); 
        if(isInsertedIntoTemplateAccess) {
  		    pw.println("<script type=\"text/javascript\">"); 
  		    pw.println("alert('Access Type data is inserted successfully');"); 
  		    pw.println("location='digital_invitation.jsp';"); 
  		    pw.println("</script>");
        }else {
   		    pw.println("<script type=\"text/javascript\">"); 
   		    pw.println("alert('Something went wrong, while entering access type details');"); 
   		    pw.println("location='digital_invitation.jsp';"); 
   		    pw.println("</script>"); 
        }
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	private boolean insert_into_template_access_type(PreparedStatement ps, Connection con, String file_access_type, int template_id) {
		boolean flag = false;
		try {
			ps = con.prepareStatement("insert into flyinginvite_access_type(access_type_title, template_id)values(?,?);");
			ps.setString(1, file_access_type);
			ps.setInt(2, template_id);
			ps.executeUpdate();
			flag = true;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	
	private int read_template_info() {
		int template_id = 0;
		try {
			ps = con.prepareStatement("select max(template_id) as template_id from flyinginvite_template");
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
	
	public void destroy() {
		try {
			ps.close();
			con.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
