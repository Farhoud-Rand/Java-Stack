<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
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
<title>View course</title>
</head>
<body>
	<div class="container p-4">
		<div class="row mt-2 mb-2">
			<h1 class="col-8">
				<c:out value="${b.name}" />
				with
				<c:out value="${b.teacher.instructorName}" />
			</h1>
			<div class="col-2"></div>
			<a class="col-2" href="/courses">Back to the dashboard</a>
		</div>
		<h3>
			<strong>Day: </strong>
			<c:out value="${b.day}" />
		</h3>
		<h3>
			<strong>Cost: </strong> $
			<c:out value="${b.price}" />
		</h3>
		<h6>
			<c:out value="${b.description}" />
			</h3>
	</div>
</body>
</html>