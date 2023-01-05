<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Formatting (dates) --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
	    <title>New Family</title>
	    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
		<link rel="stylesheet" href="/css/style.css">
	    <script src="/webjars/jquery/jquery.min.js"></script>
	    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
	</head>
	<body>
		<div class="container vh-100">	
			<nav class="navbar navbar-dark navbar-expand-lg">
				<div class="container-fluid">
					<a href="/home" class="navbar-brand">Honey Pot</a>
					<button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarBasic" aria-controls="navbarBasic" aria-expanded="false" aria-label="Toggle navigation">
      					<span class="navbar-toggler-icon"></span>
    				</button>
    				<div class="collapse navbar-collapse" id="navbarBasic">
    					<ul class="navbar-nav">
    						<li class="nav-item">
    							<a href="/home" class="nav-link">Home</a>
    						</li>
    						<li class="nav-item dropdown">
          						<a class="nav-link active dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button" data-bs-toggle="dropdown" aria-expanded="false" aria-current="page">
            						Families
          						</a>
          						<ul class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
            						<li><a class="dropdown-item" href="/families">My Families</a></li>
            						<li><a class="dropdown-item" href="/families/new">New Family</a></li>
          						</ul>
        					</li>
    						<li class="nav-item dropdown">
          						<a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button" data-bs-toggle="dropdown" aria-expanded="false">
            						Honey Pots
          						</a>
          						<ul class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
            						<li><a class="dropdown-item" href="/honeypots">My Honey Pots</a></li>
            						<li><a class="dropdown-item" href="/honeypots/new">New Honey Pot</a></li>
          						</ul>
        					</li>
        					<li class="nav-item">
    							<a href="/logout" class="nav-link">Logout</a>
    						</li>
    					</ul>
    				</div>
				</div>
			</nav>
			
			<div class="row my-4">
				<h1>New Family</h1>
			</div>
			
			<div class="d-flex h-50 align-items-center mx-2">
				<div class="w-75 h-75 mainSplash d-flex flex-column justify-content-evenly row">
					<form:form action="/families/new" method="POST" modelAttribute="family">
						<div class="row mb-3">
							<form:label class="col-sm-6 col-form-label" path="familyName">Family Name:</form:label>
							<div class="col-sm-6">
								<form:input type="text" path="familyName" class="form-control"/>
								<form:errors path="familyName" class="accent text-center"/>
							</div>
						</div>
						
						<div class="row mb-3">
							<form:label class="col-sm-6 col-form-label" path="users">Users:</form:label>
							<div class="col-sm-6">
								<c:forEach var="user" items="${users}">
									<form:checkbox path="users" value="${user}"/>
									${user.getUsername()}
								</c:forEach>
							</div>
						</div>
						
						<div class="d-flex flex-row justify-content-center">
							<div class="col-4">
								<button class="btn accentSplash w-100" type="submit">Create Family</button>
							</div>
						</div>
						
					</form:form>
				</div>
			</div>
		</div>
	</body>
</html>