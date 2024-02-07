<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Login</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.9.0/css/all.min.css" integrity="sha512-q3eWabyZPc1XTCmF+8/LuE1ozpg5xxn7iO89yfSOd5/oKvyqLngoNGsx8jq92Y8eXJ/IRxQbEC+FGSYxtk2oiw==" crossorigin="anonymous" referrerpolicy="no-referrer" />

</head>
<body>

<%
//reading data from cookie created in MemberLogin Servlet
  Cookie[] ck = request.getCookies(); //returns array
  String userData = "";
  String userId = "";
  String userPass = "";
		
	if(ck!=null) 
	{
		if(ck.length>1)
		{
	    for(Cookie c : ck)
		 {
		    if(c.getName().equalsIgnoreCase("userdetails")) //getName() will get name of cookie and check if the cookie referred to by the name inside "" exists or not
		    {
		    	userData = c.getValue();
		    	break;
		    }
		  }
		  System.out.println(userData);
		  String[] data = userData.split("#"); //we should already know what is stored first
		    
		  userId = data[0];
		  userPass = data[1];
	}
	}
%>


<%@include file="/headers/commonheader.html" %>


<%-- <%
  String message1 = (String)request.getAttribute("registration");
  
  if(message != null)
  {
%>

<div class="alert alert-warning alert-dismissible fade show" role="alert">
  <strong><%= message %></strong> 
  <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
</div>

<%}%>
                                               ->message to be displayed has same hey here , i.e.


<%
  String message2 = (String)request.getAttribute("msg");
  
  if(message != null)
  {
%>

<div class="alert alert-warning alert-dismissible fade show" role="alert">
  <strong><%= message %></strong> 
  <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
</div>

<%}%> --%>



<%
  String message = (String)request.getAttribute("msg");
  
  if(message != null)
  {
%>

<div class="alert alert-warning alert-dismissible fade show" role="alert">
  <strong><%= message %></strong> 
  <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
</div>

<%}%>






<form method="post" action="/SportsPortal/MemberLogin" class="needs-validation" novalidate>
   <section class="vh-100" style="background-color: #508bfc;">
  <div class="container py-5 h-100">
    <div class="row d-flex justify-content-center align-items-center h-100">
      <div class="col-12 col-md-8 col-lg-6 col-xl-5">
        <div class="card shadow-2-strong" style="border-radius: 1rem;">
          <div class="card-body p-5 text-center">

            <h3 class="mb-5">Log in</h3>

            <div class="form-outline mb-4">
              <label class="form-label" for="typeEmailX-2">ID</label>
              <input type="text" name="txtid" id="typeEmailX-2" class="form-control form-control-lg" required="required" value="<%=userId %>" />
              
              <div class="invalid-feedback">
                 Please provide your id.
              </div>
              
            </div>

            <div class="form-outline mb-4">
              <label class="form-label" for="typePasswordX-2">Password</label>
              <input type="password" name="txtpass" id="typePasswordX-2" class="form-control form-control-lg" required="required" value="<%=userPass %>" />
              
              <div class="invalid-feedback">
                 Please provide your password.
              </div>
              
            </div>

            <!-- Checkbox -->
            <div class="form-check d-flex justify-content-start mb-4">
              <input class="form-check-input" name="chkcookie" type="checkbox" value="checked" id="form1Example3" />
              <label class="form-check-label" for="form1Example3"> Remember password </label>
            </div>

            <button class="btn btn-primary btn-lg btn-block" type="submit">Login</button>

            <hr class="my-4">

            <button class="btn btn-lg btn-block btn-primary" style="background-color: #dd4b39;"
              type="submit"><i class="fab fa-google me-2"></i> Sign in with google</button>
            <button class="btn btn-lg btn-block btn-primary mb-2" style="background-color: #3b5998;"
              type="submit"><i class="fab fa-facebook-f me-2"></i>Sign in with facebook</button>

          </div>
        </div>
      </div>
    </div>
  </div>
</section>
</form>


<%@include file="/footer/footer.html" %>


<script src="/SportsPortal/javascript/validation.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz" crossorigin="anonymous"></script>

</body>
</html>