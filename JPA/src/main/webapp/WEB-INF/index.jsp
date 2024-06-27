<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>

<meta charset="ISO-8859-1">
<title>Book API - all books</title>
</head>
<body>
<div class="container mt-4">
        <h1 class="mb-5">All Books</h1>
        <table class="table table-hover table-bordered text-center mb-4">
            <thead>
                <tr class="table-primary">
                    <th class="col-1">ID</th>
                    <th class="col-3">Title</th>
                    <th class="col-2">Language</th>
                    <th class="col-2"># Pages</th>
                </tr>
            </thead>
            <tbody>
            <c:forEach var="b" items="${books}">
            <tr>
                    <td><c:out value="${b.id}"/></td>
                    <td><a href="books/<c:out value="${b.id}"/>"><c:out value="${b.title}"/></a></td>
                    <td><c:out value="${b.language}"/></td>
                    <td><c:out value="${b.numberOfPages}"/></td>
                </tr>
	</c:forEach>
            </tbody>
        </table>
        <a href="books/new">Add a new Book</a>
    </div>

</body>
</html>