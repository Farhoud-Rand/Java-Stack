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
<title>Products and Categories</title>
</head>
<body>
	<div class="container p-4">
		<h1>Welcome to home page</h1>
		<div class="row mt-4 d-flex align-items-center justify-content-center">
			<a href="/products" class="btn btn-primary col-4">New Product</a> <span
				class="col-1"></span> <a href="/categories"
				class="btn btn-primary col-4">New Category</a>
			<hr class="mb-3 mt-5 border-5">
			<div class="row d-flex align-items-start justify-content-center">
				<div class="col-5 mt-3 p-3">
					<table class="table table-hover table-bordered text-center mb-4">
						<thead>
							<tr class="table-primary">
								<th class="col-1">Products</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="product" items="${products}">
								<tr>
									<td><a href="/products/<c:out value="${product.id}"/>">${product.name}</a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
				<div class="col-1"></div>
				<div class="col-5 mt-3 p-3">
					<table class="table table-hover table-bordered text-center mb-4">
						<thead>
							<tr class="table-primary">
								<th class="col-1">Categories</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="category" items="${categories}">
								<tr>
									<td><a href="/categories/<c:out value="${category.id}"/>">${category.name}</a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
</body>
</html>