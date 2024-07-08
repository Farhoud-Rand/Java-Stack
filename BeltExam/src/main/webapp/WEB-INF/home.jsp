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
<title>Dashboard</title>
</head>
<body>
	<div class="container p-4">
		<div class="row mt-2 mb-2">
			<h1 class="col-10">
				Namaste,
				<c:out value="${instructor.instructorName}" />
				.
			</h1>
			<div class="col-2">
				<form:form action="/instructors/logout" method="post">
					<input type="submit" value="logout" class="btn btn-primary" />
				</form:form>
			</div>
		</div>

		<p>Course Schedule</p>
		<table class="table table-hover table-bordered text-center mb-4">
			<thead>
				<tr class="table-primary">
					<th class="col-1">Class Name</th>
					<th class="col-3">Instructor</th>
					<th class="col-2">Weekday</th>
					<th class="col-2">Price</th>
					<th class="col-2">Time</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="b" items="${allCourses}">
					<tr>
						<td><a href="/courses/<c:out value="${b.id}"/>"><c:out
									value="${b.name}" /></a> <c:if
								test="${ b.teacher.id == instructor.id}">
								<a href="/courses/edit/${b.id}">Edit</a>
							</c:if></td>
						<td><c:out value="${b.teacher.instructorName}" /></td>
						<td><c:out value="${b.day}" /></td>
						<td><c:out value="${b.price}" /></td>
						<td><c:out value="${b.formattedTime}" /></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

		<a class="btn btn-primary col-2" href="/add">+ Add Course</a>
	</div>
</body>
</html>