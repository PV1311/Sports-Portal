<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Member Registration Form</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.9.0/css/all.min.css" integrity="sha512-q3eWabyZPc1XTCmF+8/LuE1ozpg5xxn7iO89yfSOd5/oKvyqLngoNGsx8jq92Y8eXJ/IRxQbEC+FGSYxtk2oiw==" crossorigin="anonymous" referrerpolicy="no-referrer" />

</head>
<body>

<%@include file="/headers/commonheader.html" %>



<form method="post" action="/SportsPortal/MemberRegistration" style="background-image: linear-gradient(to right, blue , white);">
<section class="vh-100 gradient-custom">
  <div class="container py-5 h-100">
    <div class="row justify-content-center align-items-center h-100">
      <div class="col-12 col-lg-9 col-xl-7">
        <div class="card shadow-2-strong card-registration" style="border-radius: 15px;">
          <div class="card-body p-4 p-md-5">
            <h3 class="mb-4 pb-2 pb-md-0 mb-md-5">Registration Form</h3>

            
              <div class="input-group mb-3">
                   <span class="input-group-text" id="basic-addon1"><i class='fas fa-user-alt'></i></span>
                   <input type="text" name="txtid" class="form-control" placeholder="ID" aria-label="Username" aria-describedby="basic-addon1">
                 </div>
                  
              <div class="input-group mb-3">
                   <span class="input-group-text" id="basic-addon1"><i class='fas fa-eye-slash'></i></span>
                   <input type="text" name="txtpass" class="form-control" placeholder="Password" aria-label="Username" aria-describedby="basic-addon1">
                 </div>
                  
               <div class="form-outline">
                    <label class="form-label" for="name">Name</label>
                    <input type="text" name="txtname" id="name" class="form-control form-control-lg" />
                  </div>
            

              <div class="row">
                <div class="col-md-6 mb-4">

                  <h6 class="mb-2 pb-1">Gender: </h6>

                  <div class="form-check form-check-inline">
                    <label class="form-check-label" for="femaleGender">Female</label>
                    <input class="form-check-input" type="radio" name="inlineRadioOptions" id="femaleGender"
                      value="Female" checked />
                  </div>

                  <div class="form-check form-check-inline">
                    <label class="form-check-label" for="maleGender">Male</label>
                    <input class="form-check-input" type="radio" name="inlineRadioOptions" id="maleGender"
                      value="Male" />
                  </div>

                  <div class="form-check form-check-inline">
                    <label class="form-check-label" for="otherGender">Other</label>
                    <input class="form-check-input" type="radio" name="inlineRadioOptions" id="otherGender"
                      value="Other" />
                  </div>

                </div>
              </div>

              <div class="row">
                <div class="col-md-6 mb-4 pb-2">

                  <div class="form-outline">
                    <label class="form-label" for="emailAddress">Email</label>
                    <input type="email" name="txtmail" id="emailAddress" class="form-control form-control-lg" />
                  </div>

                </div>
                <div class="col-md-6 mb-4 pb-2">

                  <div class="form-outline">
                    <label class="form-label" for="phoneNumber">Phone Number</label>
                    <input type="tel" name="txtphone" id="phoneNumber" class="form-control form-control-lg" />
                  </div>

                </div>
              </div>

              <div class="row">
                <div class="col-12">

                  <label class="form-label select-label">Select City</label>
                  <select name="cmbcity" class="select form-control-lg">
                    <option value="1" disabled>Choose option</option>
                    <option value="Lucknow">Lucknow</option>
                    <option value="Kanpur">Kanpur</option>
                  </select>

                </div>
              </div>
              
              <div class="form-outline">
                    <label class="form-label" for="planName">Plan Name</label>
                    <input type="text" name="txtplan" id="planName" class="form-control form-control-lg" />
                  </div>
                  
               <div class="mb-3">
                    <label for="exampleFormControlTextarea1" class="form-label">Address</label>
                    <textarea class="form-control" name="txtaddress" id="exampleFormControlTextarea1" rows="auto"></textarea>
                  </div>
              
              <div class="row">
                <div class="col-md-6 mb-4 pb-2">

                 <div class="mt-4 pt-2">
                <input class="btn btn-primary btn-lg" type="submit" value="Submit" />
              </div>

                </div>
                <div class="col-md-6 mb-4 pb-2">

                  <div class="mt-4 pt-2">
                <input class="btn btn-primary btn-lg" type="reset" value="reset" />
              </div>

                </div>
              </div>

            
          </div>
        </div>
      </div>
    </div>
  </div>
</section>
</form>




<div class="container-fluid gx-0">
<%@include file="/footer/footer.html" %>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz" crossorigin="anonymous"></script>

</body>
</html>