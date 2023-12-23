<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="EmployeeSevlet" method="post">

Name:<input type="text" name="name"></input>
</br>
Password:<input type="password" name="password"></input>
</br>
Email:<input type="email" name="email"></input>
</br>
<br>
Country:
<select name="country">

<option>India</option>
<option>Australia</option>
<option>Afganisthan</option>



</select>
<br>


<input type="submit">Submit</input>
<a href="viewData.jsp">ViewData</a>





</form>
</body>
</html>