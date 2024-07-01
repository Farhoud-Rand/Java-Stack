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
      <title>New License</title>
      <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
      <link rel="stylesheet" href="/css/main.css">
      <!-- change to match your file/naming structure -->
      <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
      <script type="text/javascript" src="/js/app.js"></script><!-- change to match your file/naming structure -->
   </head>
   <body>
      <div class="container mt-4">
         <h1 class="mb-5">New License</h1>
         <form:form action="/licenses/add" method="post" modelAttribute="license">
            <div class="form-group mt-2">
               <form:label path="person" class="form-label"> Person </form:label>
                <!--- Drop down select menu --->
			   <form:select path="person">
			       <c:forEach var="onePerson" items="${persons}">
			           <form:option value="${onePerson.id}" path="person">
			               <c:out value="${onePerson.firstName}"/>
			               <c:out value="${onePerson.lastName}"/>
			           </form:option>
			       </c:forEach>
			   </form:select>
               <small>
                  <form:errors class="text-danger" path="person"/>
               </small>
            </div>
            <div class="form-group mt-2">
               <form:label path="state" class="form-label"> State </form:label>
               <form:input class="form-control" path="state"/>
               <small>
                  <form:errors class="text-danger" path="state"/>
               </small>
            </div>
            <div class="form-group mt-2">
               <form:label path="number" class="form-label"> Number </form:label>
               <form:input class="form-control" path="number"/>
               <small>
                  <form:errors class="text-danger" path="number"/>
               </small>
            </div>
            <div class="form-group mt-2">
               <form:label path="expirationDate" class="form-label"> Exp date </form:label>
               <form:input class="form-control" type="date" path="expirationDate"/>
               <small>
                  <form:errors class="text-danger" path="expirationDate"/>
               </small>
            </div>
            <input type="submit" value="Create" class="btn btn-primary mt-3"/> 
         </form:form>
      </div>
   </body>
</html>