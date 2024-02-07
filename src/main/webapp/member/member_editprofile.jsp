<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="sportsportal.beans.Member" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Profile</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.9.0/css/all.min.css" integrity="sha512-q3eWabyZPc1XTCmF+8/LuE1ozpg5xxn7iO89yfSOd5/oKvyqLngoNGsx8jq92Y8eXJ/IRxQbEC+FGSYxtk2oiw==" crossorigin="anonymous" referrerpolicy="no-referrer" />

<style >

p
{
  font-family: cursive;
  color: #eee241; 
}

</style>

</head>
<body>


<%@include file="/headers/member_header.html" %>


<% 
  String memberId = (String)session.getAttribute("memberSessionKey");
  
  if(memberId == null)
  {
	  request.setAttribute("msg" , "Unauthorised Access , Please Log in again");
	    RequestDispatcher rd = request.getRequestDispatcher("/member/userlogin.jsp");
	    rd.forward(request , response);
%>

<%
  }
  else
  {
	  Member m = (Member)session.getAttribute("mem_details");
	  
%>
<!-- name, email, phone, city, planname, address -->


<div class="cintainer-fluid" style="background-color:#91cbe2;">
  <h2 style="text-align: center;">Hello <%= memberId %></h2>
</div>


<form method="post" action="/SportsPortal/MemberEditProfile">
<div class="row justify-content-center mt-5">
<div class="col-4 justify-content-center">
<div class="card text-center" style="background-color: #1f1faf">
  <div class="container">
    <div class="card-header"><h4 style="color: #eee241;">Edit Your Profile below</h4></div>
      <p>Name : <%=m.getName() %></p>
      <p>Plan Name : <%=m.getPlanName() %></p>
      <p>Email : <input type="email" name="email" class="form-control" value="<%=m.getEmail() %>"></p>
      <p>Phone : <input type="number" name="phone" class="form-control" value="<%=m.getPhone() %>"></p>
      <p>City : <input type="text" name="city" class="form-control" value="<%=m.getCity() %>"></p>
      <p>Address : <textarea name="address" class="form-control"><%=m.getAddress() %></textarea></p>
      <p><button class="btn btn-danger">Confirm</button></p>
  </div>
</div>              <!-- after changing the values , the changed values will be received on MemberEditProfile Servlet -->
</div>
</div>
</form>
<% } %>






<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz" crossorigin="anonymous"></script>



</body>
</html>