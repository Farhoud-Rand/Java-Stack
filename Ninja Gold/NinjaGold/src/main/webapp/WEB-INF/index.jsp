<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Ninja Golds</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<link rel="stylesheet" type="text/css" href="/css/style.css">
	<script type="text/javascript" src="/js/app.js"></script>
</head>
<body class="custom-body">
<div class="container">
	<!-- First Flex box to show total golds -->
    <div class="my_container d-flex p-2 flex-md-row align-items-center">
        <h5 class="flex-item mx-2">Your Gold: </h5>
        <h5 class="flex-item mx-2 result"><c:out value="${total_golds}"></c:out></h5>
        <!-- We will have the total number in session -->
    </div>
    
    <!-- Second flex box to show places -->
    <div class="my_container_1 d-flex flex-md-row align-items-center justify-content-between">
    <!-- Each place will be in a separate div in order to contain a video and form for this place -->
    <div class="video-background">
        <!-- Farm Form -->
        <form action="/process_money" method="post">
            <h4 class="my_magin">Farm</h4>
            <h6 class="my_magin">(earns 10-20 golds)</h6>
            <!-- Add hidden input to indicate which form the user submit -->
            <input type="hidden" name="form" value="farm">
            <!-- Add another hidden inputs in order to specify the min and max values -->
            <input type="hidden" name="min" value="10">
            <input type="hidden" name="max" value="20">
            <button type="submit" class="btn btn-info m-3">Find Gold!</button>
        </form>
    </div>
    <div class="video-background">
         <!-- Cave Form -->
         <form action="/process_money" method="post">
             <h4 class="my_magin">Cave</h4>
             <h6 class="my_magin">(earns 5-10 golds)</h6>
             <!-- Add hidden input to indicate which form the user submit -->
             <input type="hidden" name="form" value="cave">
             <!-- Add another hidden inputs in order to specify the min and max values -->
             <input type="hidden" name="min" value="5">
             <input type="hidden" name="max" value="10">
             <button type="submit" class="btn btn-info m-3">Find Gold!</button>
         </form>
     </div>

     <div class="video-background">
        <!-- House Form -->
        <form action="/process_money" method="post">
            <h4 class="my_magin">House</h4>
            <h6 class="my_magin">(earns 2-5 golds)</h6>
            <!-- Add hidden input to indicate which form the user submit -->
            <input type="hidden" name="form" value="house">
            <!-- Add another hidden inputs in order to specify the min and max values -->
            <input type="hidden" name="min" value="2">
            <input type="hidden" name="max" value="5">
            <button type="submit" class="btn btn-info m-3">Find Gold!</button>
        </form>
    </div>
        <div class="video-background">
        <!-- Casino Form -->
         <form action="/process_money" method="post">
             <h4 class="my_magin">Casino</h4>
             <h6 class="my_magin">(earns/takes 0-50 golds)</h6>
             <!-- Add hidden input to indicate which form the user submit -->
             <input type="hidden" name="form" value="casino">
             <!-- Add another hidden inputs in order to specify the min and max values -->
             <input type="hidden" name="min" value="-50">
             <input type="hidden" name="max" value="50">
             <button type="submit" class="btn btn-info m-3">Find Gold!</button>
         </form>
     </div>    
</div>
<h5 class="m-4">Activities:</h5>
<div id="activities">
	<c:forEach var="a" items="${activities}">
	<p class="<c:out value="${a.color}"/>"><c:out value="${a.output}"/></p>
	</c:forEach>
</div>
<!-- Reset button -->
    <a href="/destroy_session"><button class="btn btn-info m-3 px-16">Reset</button></a>

  
</div>

</body>
</html>