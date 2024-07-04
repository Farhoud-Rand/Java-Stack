<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
	crossorigin="anonymous"></script>
<meta charset="ISO-8859-1">
<title>Category Information</title>
</head>
<body>
	<div class="container p-4">
		<h1>${category.name}</h1>
		<h3>Products:</h3>
		<ol>
			<c:forEach var="product" items="${products}">
				<li><c:out value="${product.name}" /></li>
			</c:forEach>
		</ol>
		<hr class="mb-3 mt-5 border-5">
		<h3 class="mt-3 mb-3">Add Product:</h3>
		<form action="/categories/${category.id}/add" method="post">
			<select class="form-control" name="productId" required>
				<c:forEach var="product" items="${otherProducts}">
					<option value="${product.id}">${product.name}</option>
				</c:forEach>
			</select>

			<input type="submit" value="Add" class="btn btn-primary mt-3" />
		</form>


	</div>
</body>
</html>