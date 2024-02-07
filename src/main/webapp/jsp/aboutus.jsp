<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>About Us</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.9.0/css/all.min.css" integrity="sha512-q3eWabyZPc1XTCmF+8/LuE1ozpg5xxn7iO89yfSOd5/oKvyqLngoNGsx8jq92Y8eXJ/IRxQbEC+FGSYxtk2oiw==" crossorigin="anonymous" referrerpolicy="no-referrer" />

</head>
<body style="background-image: linear-gradient(to right, blue , orange);margin: 0px;">

<%@include file="/headers/commonheader.html" %>

<div style="width:100%;height:60px;background-color: #6f42c1">
   <h2 style="text-align: center;text-decoration: underline;">This is about us page</h2>
</div>

<div style="border-style:solid;border-color:#ae5656;border-radius:10px;margin: 30px;background-color: pink;">
   <p style="padding-top: 4px;padding-left: 8px;">Lorem ipsum dolor, sit amet consectetur adipisicing elit. Fugit soluta unde deserunt commodi omnis incidunt
        necessitatibus consequatur suscipit, ipsa molestias illo nesciunt tempore perferendis sed adipisci voluptatum
        quidem consectetur, repudiandae qui debitis atque laboriosam! Obcaecati consectetur expedita asperiores sint ea
        minima accusamus vero magni eveniet. Temporibus aut eaque a ullam?</p>
</div>

<div style="width:50%;height:420px;;float:left;">
   
      <img src="/SportsPortal/images/PV.jpg" style="width:50% ; height:100%; margin-left:130px;border: solid;">

</div>

<div style="width:50%;height:420px;float:left;">
   
      <img src="/SportsPortal/images/MSD.jpg" style="width:80% ; height:100%; margin-left:10px;border: solid;">
   
</div>

<div style="width:50%;height:180px;float:left">
     <p style="background-color: pink;margin-left: 180px;margin-top: 20px;margin-right: 300px;padding: 5px;padding-left: 8px;border-style: solid;border-color: #ae5656">
        Name : Pranjal Verma
        <br>
        Email : vermapranjal35@gmail.com
     </p>
</div>

<div style="width:50%;height:180px;float:left">
     <p style="background-color: pink;margin-left: 170px;margin-top: 20px;margin-right: 350px;padding: 5px;padding-left: 8px;border-style: solid;border-color: #ae5656">
        Name : Mahendra Singh Dhoni
        <br>
        Email : MSD@gmail.com
     </p>
</div>


<div class="container-fluid" style="clear: both">
<%@include file="/footer/footer.html" %>

</div>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz" crossorigin="anonymous"></script>

</body>
</html>