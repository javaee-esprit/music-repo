<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>esprit</title>

</head>
<body>
<%!int visitCount = 0; %>
<%
String name = request.getParameter("name");
visitCount++;
%>
<h1>hello <%=name%>!</h1>
<h4>visits:<%=visitCount %></h4>
</body>
</html>