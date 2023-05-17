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
	    <title>New Honey Pot</title>
		<link rel="preconnect" href="https://fonts.googleapis.com">
		<link rel="preconnect" href="https://fonts.gstatic.com">
		<link href="https://fonts.googleapis.com/css2?family=Rubik&display=swap" rel="stylesheet">
	    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
		<link rel="stylesheet" href="/css/style.css">
	    <script src="/webjars/jquery/jquery.min.js"></script>
	    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
	</head>
	<body>
		<div class="wrapper">	
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
			<div class="center-text">
				<h1>New Honey Pot</h1>
			</div>
			
			<div class="container__content">
				<div class="mainSplash form__box">
					<form:form action="/honeypots/new" method="POST" modelAttribute="honeyPot">
						<div class="form-section">
							<form:label path="occasion">Whatcha saving up for?</form:label>
							<form:input type="text" path="occasion" class="form-section-input"/>
						</div>
						<div class="form-section">
							<form:errors path="occasion" class="form-section-error warning-text"/>
						</div>
						
						<div class="form-section">
							<form:label path="honeyFamily">Which Family?</form:label>
							<form:select path="honeyFamily" class="form-section-input">
								<c:forEach var="family" items="${userFamilies}">
									<form:option value="${family}" label="${family.familyName}"/>
								</c:forEach>
							</form:select>
						</div>
						
						<div class="form-section">
							<form:label path="goalAmount">Goal Amount:</form:label>
							<form:input type="number" min="0.01" step="0.01" max="9999.99" path="goalAmount" class="form-section-input"/>
						</div>
						<div class="form-section">
							<form:errors path="goalAmount" class="form-section-error warning-text"/>
						</div>
						
						<div class="form-section">
							<form:label path="goalDate">Goal Date:</form:label>
							<form:input path="goalDate" class="date form-section-input"/>
						</div>
						<div class="form-section">
							<form:errors path="goalDate" class="form-section-error warning-text"/>
						</div>
						
						<div class="d-flex flex-row justify-content-center">
							<div class="col-4">
								<button class="btn accentSplash w-100" type="submit">Create</button>
							</div>
						</div>
						
					</form:form>
				</div>
			</div>
		</div>
	</body>
</html>