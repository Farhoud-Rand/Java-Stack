<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
<%@ page isErrorPage="true" %>
<meta charset="ISO-8859-1">
<title>Update Project information</title>
</head>
<body>
<div class="container mt-5">
	<h2>Edit project information</h2>
<form:form action="/projects/edit/${project.id}" method="post" modelAttribute="project">
	<input type="hidden" name="_method" value="patch">
	 <div class="mb-3">
        <form:label path="title">Title</form:label>
        <form:textarea class="form-control" path="title"/>
        <small class="text-danger"><form:errors path="title"/></small>
    </div>
    <div class="mb-3">
        <form:label path="description">Description</form:label>
        <form:textarea class="form-control" path="description"/>
        <small class="text-danger"><form:errors path="description"/></small>
    </div>
    <div class="mb-3">
        <form:label path="dueDate">dueDate</form:label>
        <form:input type="date" class="form-control" path="dueDate"/>
        <small class="text-danger"> <form:errors path="dueDate"/></small>
    </div>
    <input type="submit" value="Submit" class="btn btn-success" />
</form:form>
</div>
</body>
</html>