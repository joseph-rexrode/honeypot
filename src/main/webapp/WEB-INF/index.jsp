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
	    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
		<link rel="stylesheet" href="/css/style.css">
	    <script src="/webjars/jquery/jquery.min.js"></script>
	    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
	</head>
	<body>
		<div class="container">	
			<div class="navPane">
				<h1>Welcome to Honey Pot Vacation Planner!</h1>
			</div>
			
			<!-- Maybe make register block by itself in center with like honey pot graphic -->	
			<!-- And include a "returning user?" button that switches to the login block -->
			
			<div class="block">
				<h2>Register</h2>
				<form:form action="/register" method="POST" modelAttribute="newUser">
					<p>
						<form:label path="username">Username: </form:label>
						<form:input path="username"/>
						<form:errors path="username" class="text-danger"/>
					</p>
					<p>
						<form:label path="email">Email: </form:label>
						<form:input path="email" type="email"/>
						<form:errors path="email" class="text-danger"/>
					</p>
					<p>
						<form:label path="password">Password: </form:label>
						<form:input path="password" type="password"/>
						<form:errors path="password" class="text-danger"/>
					</p>
					<p>
						<form:label path="confirm">Confirm Password: </form:label>
						<form:input path="confirm" type="password"/>
						<form:errors path="password" class="text-danger"/>
					</p>
					
					<input type="submit" value="Register">
				</form:form>
			</div>
			
			<div class="block">
				<h2>Login</h2>
				<form:form action="/login" method="POST" modelAttribute="newLogin">
					<p>
						<form:label path="email">Email: </form:label>
						<form:input path="email" type="email"/>
						<form:errors path="email" class="text-danger"/>
					</p>
					<p>
						<form:label path="password">Password: </form:label>
						<form:input path="password" type="password"/>
						<form:errors path="password" class="text-danger"/>
					</p>
					
					<input type="submit" value="Login">
				</form:form>
			</div>
		</div>
		
	</body>
</html>
