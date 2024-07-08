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
<title>Add new project</title>
</head>
<body>
	<div class="container mt-5">
		<div class="row justify-content-between">
			<h2 class="col-3">Add new Project</h2>
			<a class="col-2" href="/home">Back to the dashboard</a>
		</div>
		<form:form action="/projects/new" method="post" modelAttribute="project">
			<div class="mb-3">
				<form:label path="title">Project Title:</form:label>
				<form:input class="form-control" path="title" />
				<small class="text-danger"><form:errors path="title" /></small>
			</div>
			<div class="mb-3">
				<form:label path="description">Project Description:</form:label>
				<form:textarea class="form-control" path="description" />
				<small class="text-danger"><form:errors path="description" /></small>
			</div>
			<div class="mb-3">
				<form:label path="dueDate">Due Date:</form:label>
				<form:input class="form-control" type="date" path="dueDate" />
				<small class="text-danger"><form:errors path="dueDate" /></small>
			</div>

			<input type="submit" value="Submit" class="btn btn-primary">
		</form:form>
	</div>

</body>
</html>