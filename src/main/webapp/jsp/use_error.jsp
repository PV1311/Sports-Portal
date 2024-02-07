<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" errorPage="/jsp/custom_error_page.jsp"%>
    
    
<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" errorPage="/jsp/custom_error_page.jsp"%>       <!-- errorPage attribute is required to call error page if exception is raised --> --%>
                                                <!-- doing it like this is local calling , but we should call globally which is done in web.xml file-->
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%
  String name = null;
  out.print(name.length());
%>

</body>
</html>