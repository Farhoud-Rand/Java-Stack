<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. --> 
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!-- Formatting (dates) --> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Burger Tracker</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/js/app.js"></script><!-- change to match your file/naming structure -->
</head>
<body>
<div class="container mt-4">
        <h1 class="mb-5">Burger Tracker</h1>
        <table class="table table-hover table-bordered text-center mb-4">
            <thead>
                <tr class="table-primary">
                    <th>Burger Name</th>
                    <th>Restaurant Name</th>
                    <th>Rating(out of 5)</th>
                </tr>
            </thead>
            <tbody>
            <c:forEach var="burger" items="${burgers}">
            <tr>
                    <td><c:out value="${burger.name}"/></td>
                    <td><c:out value="${burger.restaurant}"/></td>
                    <td><c:out value="${burger.rating}"/></td>
                </tr>
	</c:forEach>
            </tbody>
        </table>
        <br>
        <h1 class="mb-5">Add a Burger</h1>
        <form:form action="/add" method="post" modelAttribute="burger">
      	<div class="form-group mt-2">
      	<form:label path="name" class="form-label"> Burger Name </form:label>
      	<form:input class="form-control" path="name"/>
      	<small><form:errors class="text-danger" path="name"/></small>
      	</div>
      	
      	<div class="form-group mt-2">
      	<form:label path="restaurant" class="form-label"> Burger Restaurant </form:label>
      	<form:input class="form-control" path="restaurant"/>
      	<small><form:errors class="text-danger" path="restaurant"/></small>
      	</div>
      	
      	<div class="form-group mt-2">
      	<form:label path="rating" class="form-label"> Rating </form:label>
      	<form:input class="form-control" path="rating"/>
      	<small><form:errors class="text-danger" path="rating"/></small>
      	</div>
      	
      	<div class="form-group mt-2">
      	<form:label path="notes" class="form-label"> Notes </form:label>
      	<form:input class="form-control" path="notes"/>
      	<small><form:errors class="text-danger" path="notes"/></small>
      	</div>
      	
      	<input type="submit" value="Submit" class="btn btn-primary mt-3"/> 
        </form:form>
    </div>
</body>
</html>