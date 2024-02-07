<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="sportsportal.dao.* , java.util.* , sportsportal.beans.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Our Plans</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.9.0/css/all.min.css" integrity="sha512-q3eWabyZPc1XTCmF+8/LuE1ozpg5xxn7iO89yfSOd5/oKvyqLngoNGsx8jq92Y8eXJ/IRxQbEC+FGSYxtk2oiw==" crossorigin="anonymous" referrerpolicy="no-referrer" />

</head>
<body>

<%@include file="/headers/commonheader.html" %>



<h2 style="text-align: center">Our Plans</h2>

<!-- Method for fetching data form database table is written on UserDao,java in viewPlans() Method -->

<%
  UserDao dao = new UserDao();
  ArrayList<Plan_Bean> planList = dao.viewPlans();
	
%>
<%
System.out.println("hello");	
 System.out.println("Total plans : "+planList.size()); 
%>

<table class="table">
  <thead>
    <tr>
      <th scope="col">Name</th>
      <th scope="col">Charges</th>
      <th scope="col">Services</th>
    </tr>
  </thead>
  <tbody>
    <%
      for(Plan_Bean pb:planList)
      {
    %>
    <tr>
      <th><%=pb.getName() %></th>
      <th><%=pb.getCharges() %></th>
      <th><%=pb.getServices() %></th>
    </tr>
      <%} %>
  </tbody>
</table>





<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz" crossorigin="anonymous"></script>

</body>
</html>