package main.resources;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet("/uploadFile")
@MultipartConfig
public class FileUploader extends HttpServlet {
	 protected void doPost(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {

	        Part filePart = request.getPart("file");
	        String fileName = filePart.getSubmittedFileName();

	        String uploadPath = getServletContext().getRealPath("/uploads");

	        File uploadDir = new File(uploadPath);
	        if (!uploadDir.exists()) {
	            uploadDir.mkdirs();
	        }

	        String filePath = uploadPath + File.separator + fileName;

	        filePart.write(filePath);

	        String fileUrl = request.getContextPath() + "/uploads/" + fileName;

	        response.setContentType("text/html");

	        response.getWriter().println("<h3>File Uploaded Successfully</h3>");
	        response.getWriter().println("<a href='"+fileUrl+"' target='_blank'>"+fileUrl+"</a>");
	    }

}
