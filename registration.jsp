<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page errorPage="myerrorpage.jsp" %>
<%@ include file="Header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Registration Page</h2>

<center><form action="<%=  request.getContextPath() %>/DataBase" method="post">  
<fieldset>
Enter user ID: <input type="text" name="uid" /><br><br>  
Enter User Name:<input type="text" name="name"><br><br>
Enter Mobile Number:<input type="number" name="num" /><br/>  
<input type="submit" value="register"/>  
</fieldset>
</form>  </center>
</body>
</html>