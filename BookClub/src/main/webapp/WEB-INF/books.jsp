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
<title>Home Page</title>
</head>
<body>
	<div class="container p-4">
		<div class="row mt-2 mb-2">
			<h1 class="col-8">
				Welcome,
				<c:out value="${user.userName}" />
			</h1>
			<div class="col-4 text-end">
				<form:form action="/users/logout" method="post">
					<input type="submit" value="logout" class="btn btn-link" />
				</form:form>
			</div>
		</div>
		<div class="row mt-2 mb-2">
			<p class="col-8">This is your home page. Nothing to see yet.</p>
			<div class="col-4 text-end">
				<form:form action="/books/new" method="get">
					<input type="submit" value="+ Add a book to my shelf!"
						class="btn btn-link" />
				</form:form>
			</div>
		</div>
		<table class="table table-hover table-bordered text-center mb-4">
			<thead>
				<tr class="table-primary">
					<th class="col-1">ID</th>
					<th class="col-3">Title</th>
					<th class="col-2">Author Name</th>
					<th class="col-2">Posted By</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="b" items="${books}">
					<tr>
						<td><c:out value="${b.id}" /></td>
						<td><a href="books/<c:out value="${b.id}"/>"><c:out
									value="${b.title}" /></a></td>
						<td><c:out value="${b.author}" /></td>
						<td><c:out value="${b.user.userName}" /></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>