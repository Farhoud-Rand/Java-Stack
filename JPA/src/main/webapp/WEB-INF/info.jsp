<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
<meta charset="ISO-8859-1">
<title>Book Information</title>
</head>
<body>
<div class="container p-4">
        <div class="row mt-2 mb-2">
            <h1 class="col-8">Book <c:out value="${b.id}"/></h1>
            <div class="col-2"></div>
            <a class="col-2" href="/books">Go Back</a>
        </div>
        <h6><strong>Title:</strong> <c:out value="${b.title}"/></h6>
        <h6><strong>Language:</strong> <c:out value="${b.language}"/></h6>
        <h6><strong>Number of pages:</strong> <c:out value="${b.numberOfPages}"/></h6>
        <h6 class="mb-5"><strong>Description:</strong> <c:out value="${b.description}"/></h6>
        <h6>Created At : <c:out value="${b.createdAt}"/> <br> Last Updated: <c:out value="${b.updatedAt}"/></h6>
        <h6><a href="/books/<c:out value="${b.id}"/>/edit" class="col-1">Edit</a>  |  <a href="/books/<c:out value="${b.id}"/>/destroy"
                class="col-1">Delete</a></h6>
    </div>
</body>
</html>