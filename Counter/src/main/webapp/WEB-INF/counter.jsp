<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<title>Insert title here</title>
</head>
<body>
<p> Your have visted a<a href="/">https://localhost:8080 :</a><c:out value="${count }"></c:out> </p>
<a href="/">test another visit?</a>
<br>
<a href="/counter2">you can visit counter that increment the count by two from here</a>


</body>
</html>