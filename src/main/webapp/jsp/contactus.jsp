<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Contact Us</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.9.0/css/all.min.css" integrity="sha512-q3eWabyZPc1XTCmF+8/LuE1ozpg5xxn7iO89yfSOd5/oKvyqLngoNGsx8jq92Y8eXJ/IRxQbEC+FGSYxtk2oiw==" crossorigin="anonymous" referrerpolicy="no-referrer" />

<style>
.form-label
{
  color:red;
  
}
</style>

</head>
<body>

<%@include file="/headers/commonheader.html" %>


<%
  String message = (String)request.getAttribute("info");
  
  if(message != null)
  {
%>

<div class="alert alert-warning alert-dismissible fade show" role="alert">
  <strong><%= message %></strong> 
  <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
</div>
<%-- <h3><%= message %></h3> --%>
<%} %>



<form method="post" action="/SportsPortal/ContactUs">
<div class="container-fluid mt-1 gx-0;" style="background-color: cyan;">
   <h3 style="text-align:center;color:Red;">Feel Free To Contact Us</h3>
</div>

<div class="row">
   <div class="col-6">
      <img alt="" src="/SportsPortal/images/4.jpg" class="img-fluid">
   </div>
   
   <div class="col-4">
      <form>
         <div class="mb-3">
            <label for="name" class="form-label">Your Name</label>
            <input type="text" class="form-control" name="txtname" placeholder="your name please" required="required">
         </div>
         
         <div class="mb-3">
            <label for="email" class="form-label">Your Email</label>
            <input type="email" class="form-control" name="txtemail" placeholder="your email please" required="required">
         </div>
         
         <div class="mb-3">
            <label for="phone" class="form-label">Your Phone</label>
            <input type="number" class="form-control" name="txtphone" placeholder="your phone number please" required="required">
         </div>
         
         <div class="mb-3">
            <label for="question" class="form-label">Your Questio</label>
            <textarea class="form-control" name="txtquestion" placeholder="your question here"></textarea>
         </div>
         
         <div class="text-center">
            <button class="btn btn-success">Submit</button>
         </div>
      </form>
   </div>
</div>
</form>



<%@include file="/footer/footer.html" %>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz" crossorigin="anonymous"></script>


</body>
</html>