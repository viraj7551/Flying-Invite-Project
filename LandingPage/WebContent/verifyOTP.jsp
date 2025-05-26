<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ page import = "java.util.*"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta property="og:title" content="FlyingInvite | OTP Verification">
<meta property="og:description" content="India's Interative Invitation">
<meta property="og:url" content="https://flyinginvite.in/">
<meta property="og:type" content="website">
<meta property="og:site_name" content="FlyingInvite">
<meta property="og:image" content="https://red-katalin-50.tiiny.site/">
<meta property="og:image:type" content="image/jpeg">
<meta property="og:image:width" content="1200">
<meta property="og:image:height" content="630">
<link rel="icon" href="/favicon.ico" type="image/x-icon">
<link rel="icon" href=" ./assets/images/FlyingInvite.png" type="image/png">
    <title>FlyingInvite | OTP Verification</title>
    	<link rel="stylesheet" 
	      href=
"https://cdn.jsdelivr.net/npm/bootstrap-icons@1.3.0/font/bootstrap-icons.css" />
	<link rel="stylesheet" 
	      href=
"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
		integrity=
"sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" 
        crossorigin="anonymous">
        
    <link rel="stylesheet" href="./assets/css/style02.css">
</head>
<body>

 <%
 
    if(session.getAttribute("generatedOTP") == null){
	   response.sendRedirect("verifyEmail.jsp");
    }

 
 %>

    <div id="form-container">
        <h4>OTP Verification</h4> <br>
        <form id="signup-form" method="POST" action="/LandingPage/OTPAuth" onsubmit="return validateOTP();">
            <label for="email">Please Enter OTP:</label>
            <input type="password" id="validate_otp" name="otp_field" required><br>
            <button type="submit">Verify OTP</button>
        </form>
         <a id="navigateBack" href="verifyEmail.jsp">Back</a>
    </div>

    <script src="./assets/js/script.js"></script>
</body>

</html>