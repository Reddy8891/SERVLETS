<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page errorPage="myerrorpage.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>**Please enter product name and product desc**</h2>
<% System.out.println("hello"); 
out.print(session.getId());%>
<%= 100/0 %>
</body>
</html>