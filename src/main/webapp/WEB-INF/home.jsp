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
	    <title>Home</title>
	    <link rel="preconnect" href="https://fonts.googleapis.com">
		<link rel="preconnect" href="https://fonts.gstatic.com">
		<link href="https://fonts.googleapis.com/css2?family=Rubik&display=swap" rel="stylesheet">
	    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
		<link rel="stylesheet" href="/css/style.css">
		<script src="https://kit.fontawesome.com/e9989f9ec4.js"></script>
	    <script src="/webjars/jquery/jquery.min.js"></script>
	    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
	    <script src="/js/script.js"></script>
	</head>
	<body>
		<div class="wrapper">	
			<nav class="navbar navbar-dark navbar-expand-lg">
				<div class="container-fluid">
					<a href="/home" class="navbar-brand">
						<i class="fa-solid fa-feather" style="color: #fdb833"></i>
					</a>
					<button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarBasic" aria-controls="navbarBasic" aria-expanded="false" aria-label="Toggle navigation">
      					<span class="navbar-toggler-icon"></span>
    				</button>
    				<div class="collapse navbar-collapse" id="navbarBasic">
    					<ul class="navbar-nav">
    						<li class="nav-item">
    							<a href="/home" class="nav-link active" aria-current="page">Home</a>
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
			
			<div class="home-grid">
				<div class="home-item1">
					<h1 class="fadeIn">Welcome, ${loggedUser.username}</h1>
				</div>
				
				<div class="home-item2 mainSplash">
					<h3>No new notifications</h3>
				</div>
				
				<div class="home-item3 mainSplash">
					<h3>Got a new goal in mind?</h3>
					<a href="/honeypots/new">
						<button class="form-button accentSplash">Create a new honey pot!</button>
					</a>
				</div>
				
				<div class="home-item4 rounded secondary-accent">
					<div class="center-text">
						<h2>
							Recent Contributions
						</h2>
					</div>
					<div class="contributions">
						<div class="cont-section">
							<div class="shape-icon rounded tertiary-accent"></div>
							<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit</p>
						</div>
						<div class="cont-section">
							<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit</p>
							<div class="shape-icon rounded tertiary-accent"></div>
						</div>
						<div class="cont-section">
							<div class="shape-icon rounded tertiary-accent"></div>
							<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit</p>
						</div>
					</div>
				</div>
			</div>
		</div>
	</body>
</html>