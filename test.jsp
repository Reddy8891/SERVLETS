
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3>hello jsp</h3>
<%@ page errorPage="myerrorpage.jsp" %>  
  
 <%= 100/0 %>  
</body>
</html>