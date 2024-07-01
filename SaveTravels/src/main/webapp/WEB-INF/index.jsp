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
      <title>Save Travels</title>
      <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
      <link rel="stylesheet" href="/css/main.css">
      <!-- change to match your file/naming structure -->
      <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
      <script type="text/javascript" src="/js/app.js"></script><!-- change to match your file/naming structure -->
   </head>
   <body>
      <div class="container mt-4">
         <h1 class="mb-5">Save Travels</h1>
         <table class="table table-hover table-bordered text-center mb-4">
            <thead>
               <tr class="table-primary">
                  <th>Expense</th>
                  <th>Vendor</th>
                  <th>Amount</th>
                  <th>Actions</th>
               </tr>
            </thead>
            <tbody>
               <c:forEach var="expense" items="${expenses}">
                  <tr>
                     <td>
                        <a href="expenses/${expense.id}">
                           <c:out value="${expense.name}"/>
                        </a>
                     </td>
                     <td>
                        <c:out value="${expense.vendor}"/>
                     </td>
                     <td>
                        <c:out value="${expense.amount}"/>
                     </td>
                     <td>
                        <a href="expenses/${expense.id}/edit">Edit</a> <a class="btn btn-primary" href="/expenses/
                        <c:out value="${expense.id}"/>
                        /destroy" role="button">Delete</a>
                     </td>
                  </tr>
               </c:forEach>
            </tbody>
         </table>
         <br>
         <h2 class="mb-2">Add an expense</h2>
         <form:form action="/add" method="post" modelAttribute="expense">
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
            <input type="submit" value="Submit" class="btn btn-primary mt-3"/> 
         </form:form>
      </div>
   </body>
</html>