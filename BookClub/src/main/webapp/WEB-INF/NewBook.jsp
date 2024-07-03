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
<title>Add New Book</title>
</head>
<body>
<div class="container mt-5">
<div class="row justify-content-between">
	<h2 class="col-3">Add new book</h2>
<a class="col-2" href="/books">Back to the shelves</a>
</div>
	<form:form action="/books" method="post" modelAttribute="book">
    <div class="mb-3">
        <form:label path="title">Title</form:label>
        <form:input class="form-control" path="title"/>
        <small class="text-danger"><form:errors path="title"/></small>
    </div>
    <div class="mb-3">
        <form:label path="author">Author</form:label>
        <form:input class="form-control" path="author"/>
        <small class="text-danger"> <form:errors path="author"/></small>
    </div>
    <p>
        <form:label path="thoughts">My Thoughts</form:label>
        <form:textarea class="form-control" path="thoughts"/>
        <small class="text-danger"> <form:errors path="thoughts"/></small>
    </p>
    <input type="submit" value="Submit" class="btn btn-primary" />
</form:form>
</div>
</body>
</html>