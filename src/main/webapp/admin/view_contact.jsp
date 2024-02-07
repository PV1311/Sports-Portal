<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="sportsportal.dao.* , java.util.* , sportsportal.beans.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Contacts</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.9.0/css/all.min.css" integrity="sha512-q3eWabyZPc1XTCmF+8/LuE1ozpg5xxn7iO89yfSOd5/oKvyqLngoNGsx8jq92Y8eXJ/IRxQbEC+FGSYxtk2oiw==" crossorigin="anonymous" referrerpolicy="no-referrer" />

</head>
<body>

<%@include file="/headers/admin_header.html" %>

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

<div class="cintainer-fluid" style="background-color:#91cbe2;">
  <h2 style="text-align: center;">Hello <%= adId %> , you are <%= userRole %></h2>
</div>

<h2 style="text-align: center">Contacts</h2>

<!-- Method for fetching data form database table is written on AdminDao,java in viewContacts() Method -->

<%
  AdminDao dao = new AdminDao();
  ArrayList<ContactBean> contactList = dao.viewContacts();
  System.out.println("Total plans : "+contactList.size());
%>

<table class="table">
  <thead>
    <tr>
      <th scope="col">Name</th>
      <th scope="col">Email</th>
      <th scope="col">Phone</th>
      <th scope="col">Question</th>
      <th scope="col">Date</th>
    </tr>
  </thead>
  <tbody>
    <%
      for(ContactBean pb:contactList)
      {
    %>
    <tr>
      <th><%=pb.getName() %></th>
      <th><%=pb.getEmail() %></th>
      <th><%=pb.getPhone() %></th>
      <th><%=pb.getQuestion() %></th>
      <th><%=pb.getDate() %></th>
    </tr>
      <%} %>
  </tbody>
</table>
<%} %>


<!-- make member_feedback.jsp(show id , rating , date when showing on page)

tableheadings -> sno(PK , AI , int type) , memberid , feedback , ratings , date (data will be viewed on the basis of sno)

make extra view Member Feedback and view Members .jsp page and complete remaining view pages -->

<!-- Cookie always have positive age , if age is negative , it gets destroyed as soon as it is created -->
<!-- Cookie is a text file created on server side and added in client machine , cookie reside on client machine and session resides on server -->

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz" crossorigin="anonymous"></script>

</body>
</html>