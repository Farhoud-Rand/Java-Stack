<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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
<title>Home Page</title>
</head>
<body>
	<div class="container p-4">
		<div class="row mt-2 mb-2">
			<h1 class="col-4">
				Welcome,
				<c:out value="${user.userName}" />
			</h1>
			<div class="col-2">
				<form:form action="/users/logout" method="post">
					<input type="submit" value="logout" class="btn btn-primary" />
				</form:form>
			</div>
			<div class="row mt-2 mb-2">
				<p class="col-10">This is your home page. Nothing to see yet.</p>
				<a class="btn btn-primary col-2" href="/add">+ Add Project</a>
			</div>

			<h1>All Projects</h1>
			<table class="table table-hover table-bordered text-center mb-4">
				<thead>
					<tr class="table-primary">
						<th class="col-1">Project</th>
						<th class="col-3">Team Lead</th>
						<th class="col-2">Due Date</th>
						<th class="col-2">Actions</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="b" items="${allProjects}">
						<tr>
							<td><a href="/projects/<c:out value="${b.id}"/>"><c:out
										value="${b.title}" /></a></td>
							<td><c:out value="${b.lead.userName}" /></td>
							<td><fmt:formatDate value="${b.dueDate}" pattern="MMM-dd" /></td>
							<td><a href="/addTeam/<c:out value="${b.id}"/>">Join
									team</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>

			<h1>Your Projects</h1>
			<table class="table table-hover table-bordered text-center mb-4">
				<thead>
					<tr class="table-primary">
						<th class="col-1">Project</th>
						<th class="col-3">Team Lead</th>
						<th class="col-2">Due Date</th>
						<th class="col-2">Actions</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="b" items="${userProjects}">
						<tr>
							<td><a href="projects/<c:out value="${b.id}"/>"><c:out
										value="${b.title}" /></a></td>
							<td><c:out value="${b.lead.userName}" /></td>
							<td><fmt:formatDate value="${b.dueDate}" pattern="MMM-dd" /></td>
							<td><c:if test="${ b.lead.id == user.id}">
									<a href="/projects/edit/${b.id}">Edit</a>
									<a href="/projects/delete/${b.id}" class="text-danger">Delete</a>
								</c:if> <c:if test="${ b.lead.id != user.id}">
									<a href="/leaveteam/${b.id}">Leave Team</a>
								</c:if></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>


		</div>
	</div>
</body>
</html>