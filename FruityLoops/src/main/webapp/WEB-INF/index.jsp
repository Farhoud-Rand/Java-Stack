<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
<div>
<h1>Fruit Store</h1>
<table>
<tr>
<td><strong>Name</strong></td>
<td><strong>Price</strong></td>
</tr>
<c:forEach var="i" items="${fruits}">
        <tr><td><c:out value="${i.name}"/></td>
        <td><c:out value="${i.price}"/></td>
        </tr>
    </c:forEach>
</table>
</div>
</body>
</html>