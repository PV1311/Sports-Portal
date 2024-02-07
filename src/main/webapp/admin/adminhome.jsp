<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Home</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.9.0/css/all.min.css" integrity="sha512-q3eWabyZPc1XTCmF+8/LuE1ozpg5xxn7iO89yfSOd5/oKvyqLngoNGsx8jq92Y8eXJ/IRxQbEC+FGSYxtk2oiw==" crossorigin="anonymous" referrerpolicy="no-referrer" />

</head>
<body>


<% 
  String adId = (String)session.getAttribute("session_adminId");
  String userRole = (String)session.getAttribute("role");
  
  if(adId == null)
  {
	  request.setAttribute("msg" , "Unauthorised Access , Please Log in again");
	    RequestDispatcher rd = request.getRequestDispatcher("/admin/adminlogin.jsp");
	    rd.forward(request , response);
%>

<%
  }
  else
  {
%>

<%@include file="/headers/admin_header.html" %>


<div class="cintainer-fluid" style="background-color:#91cbe2;">
  <h2 style="text-align: center;">Hello <%= adId %> , you are <%= userRole %></h2>
</div>
<% } %>






<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz" crossorigin="anonymous"></script>

</body>
</html>