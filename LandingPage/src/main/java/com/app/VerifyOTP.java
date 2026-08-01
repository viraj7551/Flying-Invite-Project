package com.app;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/verifyOTP")
public class VerifyOTP extends HttpServlet {
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
	    response.setContentType("text/html");	
	    
	    String num1 = request.getParameter("num1");
	    String num2 = request.getParameter("num2");
	    String num3 = request.getParameter("num3");
	    String num4 = request.getParameter("num4");
	    String num5 = request.getParameter("num5");
	    String num6 = request.getParameter("num6");
	    
	    if(num1 == null || num2 == null || num3 == null || num4 == null || num5 == null || num6 == null) {
	    	
	    	if(num1 == null) {
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
         		pw.println("toastr.error('You can confirm otp with empty value.');");
         		pw.println("setTimeout(function() {");
         		pw.println("window.location.href='verify_otp.jsp';");
         		pw.println("},2000);"); // Redirect after 2 seconds
         		pw.println("});");
         		pw.println("</script>");
	    	}else if(num2 == null) {
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
         		pw.println("toastr.error('You can confirm otp with empty value.');");
         		pw.println("setTimeout(function() {");
         		pw.println("window.location.href='verify_otp.jsp';");
         		pw.println("},2000);"); // Redirect after 2 seconds
         		pw.println("});");
         		pw.println("</script>");
	    	}else if(num3 == null) {
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
         		pw.println("toastr.error('You can confirm otp with empty value.');");
         		pw.println("setTimeout(function() {");
         		pw.println("window.location.href='verify_otp.jsp';");
         		pw.println("},2000);"); // Redirect after 2 seconds
         		pw.println("});");
         		pw.println("</script>");
	    	}else if(num4 == null) {
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
         		pw.println("toastr.error('You can confirm otp with empty value.');");
         		pw.println("setTimeout(function() {");
         		pw.println("window.location.href='verify_otp.jsp';");
         		pw.println("},2000);"); // Redirect after 2 seconds
         		pw.println("});");
         		pw.println("</script>");
	    	}else if(num5 == null) {
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
         		pw.println("toastr.error('You can confirm otp with empty value.');");
         		pw.println("setTimeout(function() {");
         		pw.println("window.location.href='verify_otp.jsp';");
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
         		pw.println("toastr.error('You can confirm otp with empty value.');");
         		pw.println("setTimeout(function() {");
         		pw.println("window.location.href='verify_otp.jsp';");
         		pw.println("},2000);"); // Redirect after 2 seconds
         		pw.println("});");
         		pw.println("</script>");
	    	}
	    	
	    }else {
		    
		    String total_value =  num1+""+num2+""+num3+""+num4+""+num5+""+num6;
		    int converted_value = Integer.parseInt(total_value);

		    // Retrieve the OTP from the session
	        Integer generatedOTP = (Integer)request.getSession().getAttribute("generatedOTP");	
	        
	        if(converted_value < 1) {
	        	
	        	if(converted_value < 1) {
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
     	    		pw.println("toastr.error('You cannot confirm OTP with incorrect value.');");
     	    		pw.println("setTimeout(function() {");
     	    		pw.println("window.location.href='reset_password.jsp';");
     	    		pw.println("},2000);"); // Redirect after 2 seconds
     	    		pw.println("});");
     	    		pw.println("</script>");
	        	}
	        	
	        }else {
	        	
	       		 if (generatedOTP == converted_value) {
                     request.getSession(true);  // Make sure the session is created or exists
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
     	    		pw.println("toastr.success('You are validated successfully.');");
     	    		pw.println("setTimeout(function() {");
     	    		pw.println("window.location.href='reset_password.jsp';");
     	    		pw.println("},2000);"); // Redirect after 2 seconds
     	    		pw.println("});");
     	    		pw.println("</script>"); 
             }
             
             else {
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
         		pw.println("toastr.error('Please try again.');");
         		pw.println("setTimeout(function() {");
         		pw.println("window.location.href='verify_otp.jsp';");
         		pw.println("},2000);"); // Redirect after 2 seconds
         		pw.println("});");
         		pw.println("</script>");
                 
                }
	        }
	        
	    }

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
