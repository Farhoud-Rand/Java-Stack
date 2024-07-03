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
<title>Read Share</title>
</head>
<body>
	<div class="container mt-5">
		<h1 class="d-flex align-items-center justify-content-center">Book
			Club</h1>
		<p class="d-flex align-items-center justify-content-center">A
			place for friends to share thoughts on books.</p>
		<div class="row">
			<div class="col-6">
				<h3>Register</h3>
				<form:form action="/users/new" method="post" modelAttribute="user">
					<div class="mb-3">
						<form:label path="userName">Name</form:label>
						<form:input class="form-control" path="userName" />
						<small class="text-danger"><form:errors path="userName" /></small>
					</div>
					<div class="mb-3">
						<form:label path="email">Email</form:label>
						<form:input class="form-control" path="email" />
						<small class="text-danger"> <form:errors path="email" /></small>
					</div>
					<p>
						<form:label path="password">Password</form:label>
						<form:input class="form-control" type="password" path="password" />
						<small class="text-danger"> <form:errors path="password" /></small>
					</p>
					<p>
						<form:label path="confirm">Confirm PW</form:label>
						<form:input class="form-control" type="password" path="confirm" />
						<small class="text-danger"> <form:errors path="confirm" /></small>
					</p>
					<input type="submit" value="Submit" class="btn btn-primary" />
				</form:form>
			</div>
			<div class="col-6">
				<h3>Log in</h3>
				<form:form action="/users/login" method="post"
					modelAttribute="newLogin">
					<div class="mb-3">
						<form:label path="email">Email</form:label>
						<form:input class="form-control" path="email" />
						<small class="text-danger"> <form:errors path="email" /></small>
					</div>
					<p>
						<form:label path="password">Password</form:label>
						<form:input class="form-control" type="password" path="password" />
						<small class="text-danger"> <form:errors path="password" /></small>
					</p>
					<input type="submit" value="Submit" class="btn btn-primary" />
				</form:form>
			</div>
		</div>
	</div>
</body>
</html>