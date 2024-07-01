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
      <title>Person Information</title>
      <link rel="stylesheet" href="/webjars/boots 	trap/css/bootstrap.min.css">
      <link rel="stylesheet" href="/css/main.css">
      <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
      <script type="text/javascript" src="/js/app.js"></script>
   </head>
   <body>
      <div class="container mt-4">
         <h1 class="mb-5">Person Details</h1>
         <table class="table table-hover table-bordered text-center mb-4">
            <thead>
               <tr class="table-primary">
                  <th>Name</th>
                  <th>License Number</th>
                  <th>State</th>
                  <th>Exp Date</th>
               </tr>
            </thead>
            <tbody>
                  <tr>
                     <td>
                        <c:out value="${person.firstName} ${person.lastName}"/>
                     </td>
                     <td>
                        <c:out value="${person.license.number}"/>
                     </td>
                     <td>
                        <c:out value="${person.license.state}"/>
                     </td>
                     <td>
                        <c:out value="${newDate}"/>
                     </td>
                  </tr>
            </tbody>
         </table>
      </div>
   </body>
</html>