<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<title>Admin Dashboard</title>

<!-- Bootstrap CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">

<style>

body{
background:#f4f6f9;
}

/* Sidebar */
.sidebar{
height:100vh;
background:#343a40;
color:white;
position:fixed;
width:220px;
}

.sidebar a{
color:white;
text-decoration:none;
display:block;
padding:12px;
}

.sidebar a:hover{
background:#495057;
}

/* Content */
.content{
margin-left:220px;
padding:20px;
}

/* Cards */
.card-box{
border-radius:10px;
color:white;
padding:20px;
}

.bg-blue{background:#0d6efd;}
.bg-green{background:#198754;}
.bg-orange{background:#fd7e14;}
.bg-red{background:#dc3545;}

/* Mobile */
@media(max-width:768px){

.sidebar{
position:relative;
width:100%;
height:auto;
}

.content{
margin-left:0;
}

}

</style>

</head>

<body>
   <%
      session.invalidate(); 
   
      String userId = request.getParameter("userId");
   %>

<div class="sidebar">

<h4 class="text-center py-3">Admin Panel</h4>

<a href="#">Dashboard</a>
<a href="digital_invitation.jsp">Digital Invitations</a>
<a href="#">Interactive Invitations</a>
<a href="file_uploader.jsp">File Uploder</a>
<a href="administrator.jsp">Logout</a>

</div>


<div class="content">

<!-- Navbar -->

<nav class="navbar navbar-light bg-white shadow-sm mb-4">
<div class="container-fluid">

<span class="navbar-brand">Dashboard</span>

<a href="administrator.jsp" class="btn btn-outline-primary">Logout</a>

</div>
</nav>


<!-- Dashboard Cards -->

<div class="row g-3">

<div class="col-md-3">
<div class="card-box bg-blue">
<h5>Digital Invitations</h5>
<h3>0</h3>
</div>
</div>

<div class="col-md-3">
<div class="card-box bg-green">
<h5>Interactive Invitations</h5>
<h3>0</h3>
</div>
</div>

</div>


<!-- Table -->

<div class="card mt-4">

<div class="card-header">
Recent Orders
</div>

<div class="card-body table-responsive">

<table class="table table-striped">

<thead>
<tr>
<th>ID</th>
<th>Customer</th>
<th>Status</th>
<th>Amount</th>
</tr>
</thead>

<tbody>
<tr>
<td>#101</td>
<td>John</td>
<td><span class="badge bg-success">Completed</span></td>
<td>$120</td>
</tr>

<tr>
<td>#102</td>
<td>Sarah</td>
<td><span class="badge bg-warning">Pending</span></td>
<td>$80</td>
</tr>

<tr>
<td>#103</td>

<td>David</td>
<td><span class="badge bg-danger">Cancelled</span></td>
<td>$50</td>
</tr>

</tbody>

</table>

</div>

</div>

</div>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>