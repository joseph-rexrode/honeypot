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
		<div class="wrapper">	
			<div class="navPane">
				<h1>Honey Pot Vacation Planner</h1>
			</div>
			
			<!-- Maybe make register block by itself in center with like honey pot graphic -->	
			<!-- And include a "returning user?" button that switches to the login block -->
			
			<!-- Eventually add mobile friendly and small screen friendly view transitions -->
			
			<div class="container-login">
				<div class="container-login-register mainSplash">
					<form:form action="/register" method="POST" modelAttribute="newUser">
						<div>
							<div>
								<h2 class="accent">Register</h2>
								<div class="form-section">
									<form:label path="username">Username: </form:label>
									<form:input path="username" class="form-section-input"/>
									<form:errors path="username" class="text-warning"/>
								</div>
								<div class="form-section">
									<form:label path="email">Email: </form:label>
									<form:input path="email" type="email" class="form-section-input"/>
									<form:errors path="email" class="text-warning"/>
								</div>
								<div class="form-section">
									<form:label path="password">Password: </form:label>
									<form:input path="password" type="password" class="form-section-input"/>
									<form:errors path="password" class="text-warning"/>
								</div>
								<div class="form-section">
									<form:label path="confirm">Confirm Password: </form:label>
									<form:input path="confirm" type="password" class="form-section-input"/>
									<form:errors path="password" class="text-warning"/>
								</div>		
							</div>
							<div class="w-50">
								<input type="submit" value="Register" class="btn btn-primary accentSplash">
							</div>
						</div>
					</form:form>
				</div>
				
				<div class="container-login-register mainSplash">
					<form:form action="/login" method="POST" modelAttribute="newLogin">
						<div>
							<div>
								<h2 class="accent">Login</h2>
								<div class="form-section">
									<form:label path="email" class="col-6">Email: </form:label>
									<form:input path="email" type="email" class="form-section-input"/>
									<form:errors path="email" class="text-warning"/>
								</div>
								<div class="form-section">
									<form:label path="password">Password: </form:label>
									<form:input path="password" type="password" class="form-section-input"/>
									<form:errors path="password" class="text-warning"/>
								</div>
							</div>
							<div class="w-50">
								<input type="submit" value="Login" class="btn btn-primary accentSplash">
							</div>
						</div>
					</form:form>
				</div>
			</div>
		</div>
	</body>
</html>
