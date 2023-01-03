<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Registration page</h1>
<form action="<%= request.getContextPath() %>/WelcomServlet1" method="post">
Enter Product name: <input type="text" name="prod_name" placeholder="Enter Product name here"><br>
Enter Product Description: <input type="text" name="prod_desc" placeholder="Enter Product Description here"><br>

<button type="submit">Submit</button>
</form>




<a href="<%= request.getContextPath() %>/home">click here</a><br>

<a href="<%= request.getContextPath() %>/about">about servlet</a>
</body>
</html>