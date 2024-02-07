<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Feedback</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.9.0/css/all.min.css" integrity="sha512-q3eWabyZPc1XTCmF+8/LuE1ozpg5xxn7iO89yfSOd5/oKvyqLngoNGsx8jq92Y8eXJ/IRxQbEC+FGSYxtk2oiw==" crossorigin="anonymous" referrerpolicy="no-referrer" />

</head>
<body>

<%@include file="/headers/commonheader.html" %>


<!--Jumbotron


<div
  class="bg-image p-5 text-center shadow-1-strong rounded mb-5 text-white"
  style="background-image: url('https://mdbcdn.b-cdn.net/img/new/slides/003.webp');"
>
  <h1 class="mb-3 h2">Jumbotron</h1>

  <p>
    Lorem ipsum dolor, sit amet consectetur adipisicing elit. Repellendus praesentium
    labore accusamus sequi, voluptate debitis tenetur in deleniti possimus modi voluptatum
    neque maiores dolorem unde? Aut dolorum quod excepturi fugit.
  </p>
</div>


Jumbotron -->


<!-- Jumbotron -->

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



<form method="post" action="/SportsPortal/Feedback" class="needs-validation" novalidate>
<div class="bg-image p-5 text-center shadow-1-strong  mb-0 text-white" style="background-image: url('/SportsPortal/images/2.jpg');">
  <h1 class="mb-3 h2" style="text-align: center;margin-top: 2%;font-family: cursive;color: blue;">Please give your feedback below</h1>

<p>


<div class="row justify-content-center">
<div class="col-6 justify-content-center">

   <div class="container ml-5 mr-5 mb-3">
      <label for="name" class="form-label">Your Name</label>
      <input type="text" class="form-control" name="txtname" placeholder="your name please" required="required">
   
      <div class="invalid-feedback">
        Please provide your name.
      </div>
   
   </div>
         
   <div class="container ml-5 mr-5 mb-3">
      <label for="email" class="form-label">Your Email</label>
      <input type="email" class="form-control" name="txtemail" placeholder="your email please" required="required">
   
      <div class="invalid-feedback">
        Please provide your Email.
      </div>
   
   </div>
   
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
   
   <div class="container ml-5 mr-5 mb-3 form-check">
      <label class="form-check-label" for="flexCheckChecked">I agree</label>
      <input class="form-check-input" name="chkagree" type="checkbox" required="required" value="agrees" id="flexCheckChecked" checked>
   
       <div class="invalid-feedback">
         Please check this checkbox.
       </div>
   
   </div>
         
   <div class="text-center">
      <button class="btn btn-success">Submit</button>
   </div>

</div>
</div>

</p>
</div>
</form>



<%@include file="/footer/footer.html" %>

<script src="/SportsPortal/javascript/validation.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz" crossorigin="anonymous"></script>


</body>
</html>