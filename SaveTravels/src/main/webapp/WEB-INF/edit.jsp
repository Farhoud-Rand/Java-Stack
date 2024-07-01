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
      <title>Update Expenses' information</title>
   </head>
   <body>
      <div class="container mt-5">
         <div class="row mt-2 mb-2">
            <h2 class="col-8">Edit expense information</h2>
            <div class="col-2"></div>
            <a class="col-2" href="/expenses">Go Back</a>
         </div>
         <form:form action="/expenses/${expense.id}" method="post" modelAttribute="expense">
            <input type="hidden" name="_method" value="put">
            <div class="form-group mt-2">
               <form:label path="name" class="form-label"> Expense Name </form:label>
               <form:input class="form-control" path="name"/>
               <small>
                  <form:errors class="text-danger" path="name"/>
               </small>
            </div>
            <div class="form-group mt-2">
               <form:label path="vendor" class="form-label"> Vendor </form:label>
               <form:input class="form-control" path="vendor"/>
               <small>
                  <form:errors class="text-danger" path="vendor"/>
               </small>
            </div>
            <div class="form-group mt-2">
               <form:label path="amount" class="form-label"> Amount </form:label>
               <form:input class="form-control" path="amount"/>
               <small>
                  <form:errors class="text-danger" path="amount"/>
               </small>
            </div>
            <div class="form-group mt-2">
               <form:label path="description" class="form-label"> Description </form:label>
               <form:input class="form-control" path="description"/>
               <small>
                  <form:errors class="text-danger" path="description"/>
               </small>
            </div>
            <input type="submit" value="Submit" class="btn btn-primary mt-3" />
         </form:form>
      </div>
   </body>
</html>