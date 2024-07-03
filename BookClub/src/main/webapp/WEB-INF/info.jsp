<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">

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
<title>Book Information</title>
</head>
<body>
	<div class="container p-4">
		<div class="row mt-2 mb-2">
			<h1 class="col-8">
				<c:out value="${b.title}" />
			</h1>
			<div class="col-2"></div>
			<a class="col-2" href="/books">Back to the shelves</a>
		</div>
		<h4 class="pt-1">
			<strong><span class="text-danger">
			<c:choose>
			    <c:when test="${readed==true}">
					You 
			    </c:when>    
			    <c:otherwise>
			        <c:out value="${b.user.userName}" />
		    </c:otherwise>
			</c:choose>
			</span> read <span class="text-primary"><c:out
						value="${b.title}" /></span> by <span class="text-success"><c:out
						value="${b.author}" /></span>.</strong>
		</h4>
		<h5 class="pt-2">Here are
		<c:choose>
			    <c:when test="${readed==true}">
					your 
			    </c:when>    
			    <c:otherwise>
			        <c:out value="${b.user.userName}"/>'s
		    </c:otherwise>
			</c:choose>
		  thoughts:</h5>	
		<h6 class="border p-3 mt-4">
			<c:out value="${b.thoughts}" />
		</h6>
		<h6 class="mt-4 text-end">
		<c:choose>
			    <c:when test="${readed==true}">
					<a href="/books/<c:out value="${b.id}"/>/edit" class="col-1 btn btn-success">Edit</a>
					<a href="/books/<c:out value="${b.id}"/>/destroy" class="col-1 btn btn-danger">Delete</a>		 
			    </c:when>    
			    <c:otherwise>
			        <a href="/books/<c:out value="${b.id}"/>/edit" class="col-1 disabled btn btn-secondary" tabindex="-1">Edit</a>
					<a href="/books/<c:out value="${b.id}"/>/destroy" class="col-1 disabled btn btn-secondary" tabindex="-1" >Delete</a>
		    </c:otherwise>
			</c:choose>
			
		</h6>
	</div>
</body>
</html>