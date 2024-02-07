<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="sportsportal.dao.* , java.util.* , sportsportal.beans.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Feedback</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.9.0/css/all.min.css" integrity="sha512-q3eWabyZPc1XTCmF+8/LuE1ozpg5xxn7iO89yfSOd5/oKvyqLngoNGsx8jq92Y8eXJ/IRxQbEC+FGSYxtk2oiw==" crossorigin="anonymous" referrerpolicy="no-referrer" />

</head>
<body>

<%@include file="/headers/member_header.html" %>

<% 
  String adId = (String)session.getAttribute("memberSessionKey");
 
  
  if(adId == null)
  {
	  request.setAttribute("msg" , "Unauthorised Access , Please Log in again");
	    RequestDispatcher rd = request.getRequestDispatcher("/member/userlogin.jsp");
	    rd.forward(request , response);
%>

<%
  }
  else
  {
%>

<div class="cintainer-fluid" style="background-color:#91cbe2;">
  <h2 style="text-align: center;">Hello <%=adId %></h2>
</div>

<%} %>


<%
  String message = (String)request.getAttribute("information");
  
  if(message != null)
  {
%>

<div class="alert alert-warning alert-dismissible fade show" role="alert">
  <strong><%= message %></strong> 
  <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
</div>
<%-- <h3><%= message %></h3> --%>
<%} %>


<div class="mt-4">
<h4 style="text-align: center">Please provide your feedback below</h4>
</div>


<form method="post" action="/SportsPortal/MemberFeedback">
  <div class="mt-5 row justify-content-center">
  <div class="col-6 justify-content-center">


   <div class="container ml-5 mr-5 mb-3">
   <label for="email" class="form-label">Rating</label>
   <select name="rating" class="container mt-2 ml-5 mr-5 mb-3 form-select" required="required">
      <option value="1">1</option>
      <option value="2">2</option>
      <option value="3">3</option>
      <option value="4">4</option>
      <option value="5">5</option>
   </select>
   
   <div class="invalid-feedback">
     Please provide a rating.
   </div>
   
   </div>
         
   <div class="container ml-5 mr-5 mb-3">
      <label for="feedback" class="form-label">Your Feedback</label>
      <textarea class="form-control" name="txtfeedback" required="required" placeholder="your feedback here"></textarea>
   
       <div class="invalid-feedback">
         Please provide your feedback.
       </div>
   
   </div>

   <div class="text-center">
      <button class="btn btn-success">Submit</button>
   </div>

</div>
</div>

</form>



<script src="/SportsPortal/javascript/validation.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz" crossorigin="anonymous"></script>



</body>
</html>