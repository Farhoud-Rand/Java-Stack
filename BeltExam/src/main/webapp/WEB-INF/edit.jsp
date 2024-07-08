<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<title>Update Course</title>
</head>
<body>
	<div class="container mt-5">
		<h2>
			<c:out value="${course.name}" />
		</h2>
		<form:form action="/courses/edit/${course.id}" method="post"
			modelAttribute="course">
			<input type="hidden" name="_method" value="patch">
			<div class="mb-3">
				<form:label path="name">Name</form:label>
				<form:textarea class="form-control" path="name" />
				<small class="text-danger"><form:errors path="name" /></small>
			</div>
			<div class="mb-3">
				<form:label path="day">Day of Week:</form:label>
				<form:input class="form-control" path="day" />
				<small class="text-danger"><form:errors path="day" /></small>
			</div>
			<div class="mb-3">
				<form:label path="price">Drop-in Price:</form:label>
				<form:input type="number" class="form-control" path="price" />
				<small class="text-danger"><form:errors path="price" /></small>
			</div>
			<div class="mb-3">
				<form:label path="description">Course Description:</form:label>
				<form:textarea class="form-control" path="description" />
				<small class="text-danger"><form:errors path="description" /></small>
			</div>

			<div class="row">
				<div class="col-8">
					<a class="col-2 btn btn-danger" href="/courses/delete/${course.id}">Delete</a>
				</div>

				<a class="col-2 btn btn-danger col-2" href="/courses">Cancel</a> <input
					type="submit" value="Update" class="btn btn-success col-2" />
			</div>
		</form:form>
	</div>
</body>
</html>