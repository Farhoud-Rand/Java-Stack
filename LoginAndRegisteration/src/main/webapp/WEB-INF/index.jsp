<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
<%@ page isErrorPage="true" %>
<meta charset="ISO-8859-1">
<title>Login and Registration</title>
</head>
<body>
<div class="container mt-5">
	<h1>Welcome!</h1>
	<p>Join our growing community</p>
	<h3>Register</h3>
	<form:form action="/users/new" method="post" modelAttribute="user">
    <div class="mb-3">
        <form:label path="userName">User name</form:label>
        <form:input class="form-control" path="userName"/>
        <small class="text-danger"><form:errors path="userName"/></small>
    </div>
    <div class="mb-3">
        <form:label path="email">Email</form:label>
        <form:textarea class="form-control" path="email"/>
        <small class="text-danger"> <form:errors path="email"/></small>
    </div>
    <p>
        <form:label path="password">Password</form:label>
        <form:input class="form-control" path="password"/>
        <small class="text-danger"> <form:errors path="password"/></small>
    </p>
    <p>
        <form:label path="confirm">Confirm PW</form:label>
        <form:input class="form-control" path="confirm"/>
        <small class="text-danger"> <form:errors path="confirm"/></small>
    </p>
    <input type="submit" value="Submit" class="btn btn-primary" />
</form:form>

	<h3>Login</h3>
	<form:form action="/users/login" method="post" modelAttribute="newLogin">
    <div class="mb-3">
        <form:label path="email">Email</form:label>
        <form:textarea class="form-control" path="email"/>
        <small class="text-danger"> <form:errors path="email"/></small>
    </div>
    <p>
        <form:label path="password">Password</form:label>
        <form:input class="form-control" path="password"/>
        <small class="text-danger"> <form:errors path="password"/></small>
    </p>
    <input type="submit" value="Submit" class="btn btn-primary" />
</form:form>
</div>
</body>
</html>