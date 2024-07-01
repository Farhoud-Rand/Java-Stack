<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
   <head>
      <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
      <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
      <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
      <meta charset="ISO-8859-1">
      <title>Expense Information</title>
   </head>
   <body>
      <div class="container p-4">
         <div class="row mt-2 mb-2">
            <h1 class="col-8">
               Expense 
               <c:out value="${expense.id}"/>
            </h1>
            <div class="col-2"></div>
            <a class="col-2" href="/expenses">Go Back</a>
         </div>
         <h6>
            <strong>Name:</strong> 
            <c:out value="${expense.name}"/>
         </h6>
         <h6>
            <strong>Vendor:</strong> 
            <c:out value="${expense.vendor}"/>
         </h6>
         <h6>
            <strong>Amount:</strong> 
            <c:out value="${expense.amount}"/>
         </h6>
         <h6 class="mb-5">
            <strong>Description:</strong> 
            <c:out value="${expense.description}"/>
         </h6>
         <h6>
            Created At : 
            <c:out value="${expense.createdAt}"/>
            <br> Last Updated: 
            <c:out value="${expense.updatedAt}"/>
         </h6>
         <h6>
            <a href="/expenses/
            <c:out value="${expense.id}"/>
            /edit" class="col-1">Edit</a>  |  <a href="/expenses/
            <c:out value="${expense.id}"/>
            /destroy" class="col-1">Delete</a>
         </h6>
      </div>
   </body>
</html>