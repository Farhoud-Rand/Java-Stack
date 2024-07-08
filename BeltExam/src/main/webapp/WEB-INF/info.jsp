<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

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
		<h3>
			<strong>Time: </strong>
			<c:out value="${b.formattedTime}" />
		</h3>
		<h6>
			<c:out value="${b.description}" />
		</h6>
		<hr>
		<h2>Course Students</h2>
		<c:forEach var="student" items="${students}">
					<option value="${student.id}">${student.name}-
						${student.email}</option>
				</c:forEach>
		<hr>
		<h1>New Student</h1>
		<form:form action="/students/new" method="post"
			modelAttribute="student">
			<div class="mb-3">
				<form:label path="name">Name</form:label>
				<form:input class="form-control" path="name" />
				<small class="text-danger"> <form:errors path="name" /></small>
			</div>
			<div class="mb-3">
				<form:label path="email">Email</form:label>
				<form:input class="form-control" path="email" />
				<small class="text-danger"> <form:errors path="email" /></small>
			</div>

			<input type="submit" value="Add Student" class="btn btn-primary">
		</form:form>

		<h1>Add Student</h1>
		<form action="/courses/${b.id}/addStudent" method="post">
			<select class="form-control" name="studentId" required>
				<c:forEach var="student" items="${otherStudents}">
					<option value="${student.id}">${student.name}-
						${student.email}</option>
				</c:forEach>
			</select> <input type="submit" value="Add" class="btn btn-primary mt-3" />
		</form>
	</div>
</body>
</html>