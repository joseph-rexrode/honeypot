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
	    <title>Welcome</title>
	    <link rel="preconnect" href="https://fonts.googleapis.com">
		<link rel="preconnect" href="https://fonts.gstatic.com">
		<link href="https://fonts.googleapis.com/css2?family=Rubik&display=swap" rel="stylesheet">
	    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
		<link rel="stylesheet" href="/css/style.css">
	    <script src="/webjars/jquery/jquery.min.js"></script>
	    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
	</head>
	<body>
		<div class="container vh-100 vw-100">	
			<div class="navPane">
				<h1>Honey Pot Vacation Planner</h1>
			</div>
			
			<!-- Maybe make register block by itself in center with like honey pot graphic -->	
			<!-- And include a "returning user?" button that switches to the login block -->
			
			<!-- Eventually add mobile friendly and small screen friendly view transitions -->
			<div class="d-flex justify-content-around align-items-center h-75 overflow-auto row">
				<div class="block d-flex flex-column col-5 h-75 rounded-3 mainSplash">
					<form:form action="/register" method="POST" modelAttribute="newUser" class="h-100 my-3">
						<div class="d-flex flex-column justify-content-between align-items-center h-100">
							<div>
								<h2 class="accent">Register</h2>
								<p class="d-flex justify-content-between row">
									<form:label path="username" class="col-6">Username: </form:label>
									<form:input path="username" class="col-6"/>
									<form:errors path="username" class="text-danger"/>
								</p>
								<p class="d-flex justify-content-between row">
									<form:label path="email" class="col-6">Email: </form:label>
									<form:input path="email" type="email" class="col-6"/>
									<form:errors path="email" class="text-danger"/>
								</p>
								<p class="d-flex justify-content-between row">
									<form:label path="password" class="col-6">Password: </form:label>
									<form:input path="password" type="password" class="col-6"/>
									<form:errors path="password" class="text-danger"/>
								</p>
								<p class="d-flex justify-content-between row">
									<form:label path="confirm" class="col-6">Confirm Password: </form:label>
									<form:input path="confirm" type="password" class="col-6"/>
									<form:errors path="password" class="text-danger"/>
								</p>		
							</div>
							<div class="w-50">
								<input type="submit" value="Register" class="btn btn-primary w-100 accentSplash">
							</div>
						</div>
					</form:form>
				</div>
				
				<div class="block d-flex flex-column col-5 h-75 rounded-3 mainSplash">
					<form:form action="/login" method="POST" modelAttribute="newLogin" class="h-100 my-3">
						<div class="d-flex flex-column justify-content-between align-items-center h-100">
							<div>
								<h2 class="accent">Login</h2>
								<p class="d-flex justify-content-between row">
									<form:label path="email" class="col-6">Email: </form:label>
									<form:input path="email" type="email" class="col-6"/>
									<form:errors path="email" class="text-danger"/>
								</p>
								<p class="d-flex justify-content-between row">
									<form:label path="password" class="col-6">Password: </form:label>
									<form:input path="password" type="password" class="col-6"/>
									<form:errors path="password" class="text-danger"/>
								</p>
							</div>
							<div class="w-50">
								<input type="submit" value="Login" class="btn btn-primary w-100 accentSplash">
							</div>
						</div>
					</form:form>
				</div>
			</div>
		</div>
	</body>
</html>
