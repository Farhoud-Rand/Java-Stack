<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
	crossorigin="anonymous"></script>
<%@ page isErrorPage="true"%>
<meta charset="ISO-8859-1">
<title>Product Form</title>
</head>
<body>
	<div class="container mt-5">
		<h3 class="text-center">New Product</h3>
		<form:form action="/products/new" method="post" modelAttribute="product">
			<div class="mb-3">
				<form:label path="name">Name</form:label>
				<form:input class="form-control" path="name" />
				<small class="text-danger"><form:errors path="name" /></small>
			</div>
			<div class="mb-3">
				<form:label path="price">Price</form:label>
				<form:input class="form-control"  path="price" />
				<small class="text-danger"> <form:errors path="price" /></small>
			</div>
			<div class="mb-3">
				<form:label path="description">Description</form:label>
				<form:textarea class="form-control" path="description" />
				<small class="text-danger"> <form:errors path="description" /></small>
			</div>
			
			<input type="submit" value="Submit" class="btn btn-primary" />
		</form:form>
	</div>
</body>
</html>