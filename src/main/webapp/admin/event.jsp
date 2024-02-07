<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Event</title>

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
<div class="cintainer-fluid gy-0" style="background-color:#91cbe2;">
  <h2 style="text-align: center;">Hello <%= adId %> , you are <%= userRole %></h2>
</div>
<% } %>


<%
  String message = (String)request.getAttribute("message");
  
  if(message != null)
  {
%>

<div class="alert alert-warning alert-dismissible fade show" role="alert">
  <strong><%= message %></strong> 
  <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
</div>
<%-- <h3><%= message %></h3> --%>
<%} %>


<form method="post" action="/SportsPortal/Event" style="background-color:#91cbe2;">
<section class="vh-100 gradient-custom">
  <div class="container py-5 h-100">
    <div class="row justify-content-center align-items-center h-100">
      <div class="col-12 col-lg-9 col-xl-7">
        <div class="card shadow-2-strong card-registration" style="border-radius: 15px;">
          <div class="card-body p-4 p-md-5">
           <h3 class="mb-4 pb-2 pb-md-0 mb-md-5">Event Form</h3>
            <form>
            
              <div class="form-outline">
                    <label class="form-label" for="eventName">Event Name</label>
                    <input type="text" name="eventname" id="eventName" class="form-control form-control-lg" />
                  </div>
                  
              <div class="form-outline">
                    <label class="form-label" for="venueName">Venue</label>
                    <input type="text" name="venue" id="venueName" class="form-control form-control-lg" />
                  </div>
                  
               <div calss="form-outline">
                    <label class="form-label" for="date">Date</label>
                    <input type="date" name="date" id="date" class="form-control form-control-lg" />
               </div>
               
               <div class="form-outline">
                    <label class="form-label" for="name">Organizer Name</label>
                    <input type="text" name="txtname" id="name" class="form-control form-control-lg" />
                  </div>
                  
              <div class="mb-3">
                    <label for="exampleFormControlTextarea1" class="form-label">Description</label>
                    <textarea class="form-control" name="txtdescription" id="exampleFormControlTextarea1" rows="auto"></textarea>
                  </div>
                  
              <div class="mt-4 pt-2">
                  <input class="btn btn-primary btn-lg" type="submit" value="Submit" />
                </div>
            
            </form>
          </div>
        </div>
      </div>
    </div>
  </div>
</section>
</form>






<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz" crossorigin="anonymous"></script>

</body>
</html>