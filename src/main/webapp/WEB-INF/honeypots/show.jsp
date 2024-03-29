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
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
	    <title>${honeypot.occasion}</title>
	    <link rel="preconnect" href="https://fonts.googleapis.com">
		<link rel="preconnect" href="https://fonts.gstatic.com">
		<link href="https://fonts.googleapis.com/css2?family=Rubik&display=swap" rel="stylesheet">
	    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
		<link rel="stylesheet" href="/css/style.css">
	    <script src="/webjars/jquery/jquery.min.js"></script>
	    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
	    <script src="/js/script.js"></script>
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
          						<a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button" data-bs-toggle="dropdown" aria-expanded="false">
            						Families
          						</a>
          						<ul class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
            						<li><a class="dropdown-item" href="/families">My Families</a></li>
            						<li><a class="dropdown-item" href="/families/new">New Family</a></li>
          						</ul>
        					</li>
    						<li class="nav-item dropdown">
          						<a class="nav-link active dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button" data-bs-toggle="dropdown" aria-expanded="false" aria-current="page">
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
			<div class="row my-4 d-flex flex-column justify-content-around align-items-center h-75">
				<h1 class="d-flex justify-content-center">${honeypot.occasion}</h1>
				
				<div class="h-85 d-flex flex-column justify-content-between">
					<div class="d-flex">
						<div class="w-50">
							<p class="fw-bold fs-4">Creator: ${honeypot.creator.getUsername()}</p>
							<p class="fw-bold fs-4">Family: ${honeypot.honeyFamily.getFamilyName()}</p>
						</div>
						<div class="w-50">
							<a href="/honeypots/${honeypot.id}/contributions/new" class="d-flex justify-content-end noLink">
								<button class="btn accentSplash">Add Contribution?</button>
							</a>
						</div>
					</div>
					
					<div class="circle align-self-center">
						<div id="progress">
							<input type="hidden" id="amountSaved" value="${honeypot.getAmountSaved()}"/>
							<input type="hidden" id="goalAmount" value="${honeypot.getGoalAmount()}"/>
						</div>
					</div>
					<div>
						<p class="d-flex justify-content-center">Goal Progress: ${honeypot.amountSaved} / ${honeypot.goalAmount}</p>
					</div>
				</div>
			</div>
			
			
			
			
		</div>
	</body>
</html>