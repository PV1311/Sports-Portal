<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="sportsportal.dao.* , java.util.* , sportsportal.beans.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Member Feedback</title>

<%@include file="/common/common_css.html" %>


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

<h2 style="text-align: center">Member Feedbacks</h2>

<!-- Method for fetching data form database table is written on AdminDao,java in viewContacts() Method -->

<%
  AdminDao dao = new AdminDao();
  ArrayList<MemberFeedbackBean> feedbackList = dao.viewMemberFeedback();
  /* System.out.println("Total plans : "+planList.size()); */
%>

<form method="post" action="/SportsPortal/DeleteMemberFeedback">
<table class="table mt-5">
  <thead>
    <tr>
      <th scope="col">Select</th>
      <th scope="col">Member Id</th>
      <th scope="col">Rating</th>
      <th scope="col">Date</th>
    </tr>
  </thead>
  <tbody>
    <%
      for(MemberFeedbackBean pb: feedbackList)
      {
    	  int fid = pb.getSno();
    %>
   <tr>
     <th><input type="checkbox" name="chkdelete" value=<%=pb.getId() %> class="form-check-input"></th> <!-- name of all checkboxes area same because to delete feedbacks we take all id at once in DeleteFeedBack Servlet -->
     <th><a href="/SportsPortal/admin/view_memberfeedbackdata.jsp?feedbackSno=<%=fid %>"> <%=pb.getId() %> </a></th>   <!-- passing value using query string -->
                                                                                                   <!-- for passing multiple parameters , like feedbackSno , '&' is used , '?' is used only for the first time as written . Ex : as commented below-->
                                                                                                    
                                                                                              <%-- <th><a href="/SportsPortal/admin/view_memberfeedbackdata.jsp?feedbackSno=<%=fid %>&nm=scott&paaa=125"> <%=pb.getId() %> </a></th> --%>
                                                                                              
      <th><%=pb.getRating() %></th>
      <th><%=pb.getDate() %></th>
    </tr>
      <%} %>
      <tr><th colspan="7"><button type="Submit" class="btn btn-primary">Delete</button></th></tr>  <!-- colspan will merge the specified number of columns written in "" -->
  </tbody>
</table>
</form>
<%} %>





<%@include file="/common/common_js.html"%> 


</body>
</html>