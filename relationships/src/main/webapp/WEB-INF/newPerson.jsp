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
      <title>Relationships</title>
      <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
      <link rel="stylesheet" href="/css/main.css">
      <!-- change to match your file/naming structure -->
      <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
      <script type="text/javascript" src="/js/app.js"></script><!-- change to match your file/naming structure -->
   </head>
   <body>
      <div class="container mt-4">
         <h1 class="mb-5">New Person</h1>
         <form:form action="/persons/add" method="post" modelAttribute="person">
            <div class="form-group mt-2">
               <form:label path="firstName" class="form-label"> First Name </form:label>
               <form:input class="form-control" path="firstName"/>
               <small>
                  <form:errors class="text-danger" path="firstName"/>
               </small>
            </div>
            <div class="form-group mt-2">
               <form:label path="lastName" class="form-label"> last Name </form:label>
               <form:input class="form-control" path="lastName"/>
               <small>
                  <form:errors class="text-danger" path="lastName"/>
               </small>
            </div>
            <input type="submit" value="Create" class="btn btn-primary mt-3"/> 
         </form:form>
      </div>
   </body>
</html>