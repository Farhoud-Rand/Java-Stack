<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
<meta charset="ISO-8859-1">
<title>Add new Book</title>
</head>
<body>
 <div class="container mt-5">
        <h2>Add New Book</h2>
        <form action="books/add" method="POST" class="mt-3">
            <div class="mb-3">
                <label for="title">Title</label>
                <input type="text" id="title" name="title" class="form-control" />
                <c:if test="${not empty details['title']}">
                    <div class="text-danger">${details['title']}</div>
                </c:if>
            </div>
            <div class="mb-3">
                <label for="language">Language</label>
                <input type="text" id="language" name="language" class="form-control" />
                <c:if test="${not empty details['language']}">
                    <div class="text-danger">${details['language']}</div>
                </c:if>
            </div>
            <div class="mb-3">
                <label for="numberOfPages">Number of Pages</label>
                <input type="number" id="numberOfPages" name="numberOfPages" class="form-control" />
                <c:if test="${not empty details['numberOfPages']}">
                    <div class="text-danger">${details['numberOfPages']}</div>
                </c:if>
            </div>
            <div class="mb-3">
                <label for="description">Description</label>
                <textarea id="description" name="description" class="form-control" ></textarea>
                <c:if test="${not empty details['description']}">
                    <div class="text-danger">${details['description']}</div>
                </c:if>
            </div>
            <div class="position-relative mt-5">
            	<button type="submit" class="btn btn-primary position-absolute bottom-0 end-0">Add Book</button>
            </div>
        </form>
    </div>

</body>
</html>