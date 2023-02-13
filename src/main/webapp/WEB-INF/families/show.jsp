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
	    <title>${fam.getFamilyName()}</title>
	    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
		<link rel="stylesheet" href="/css/style.css">
	    <script src="/webjars/jquery/jquery.min.js"></script>
	    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
	</head>
	<body>
		<div class="container">	
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
				<h2>${fam.getFamilyName()}</h2>
			</div>
			
			<c:if test="${addableMembers.size() != 0}">
				<div>
					<form:form action="/families/${fam.getId()}/add" method="POST" modelAttribute="family">
						<input type="hidden" name="_method" value="put">
						<div class="row mb-3">
							<form:errors path="users" class="text-danger"/>
						</div>
						<div class="row mb-3">
							<form:label class="col-sm-2 col-form-label" path="users">Users:</form:label>
							<div class="col-sm-10">
								<c:forEach var="user" items="${addableMembers}">
									<form:checkbox path="users" value="${user}"/>
									${user.getUsername()}
								</c:forEach>
							</div>
							<form:input type="hidden" path="familyName" value="${fam.getFamilyName()}"/>
						</div>
						
						<div class="d-flex flex-row my-4 justify-content-end">
							<button type="submit" class="btn accentSplash">Add Family Member(s)</button>
						</div>
					</form:form>
				</div>
			</c:if>
			
			<c:if test="${removableMembers.size() != 0}">
				<div>
					<form:form action="/families/${fam.getId()}/remove" method="POST" modelAttribute="family2">
						<input type="hidden" name="_method" value="put">
						<div class="row mb-3">
							<form:label class="col-sm-2 col-form-label" path="users">Users:</form:label>
							<div class="col-sm-10">
								<c:forEach var="user" items="${removableMembers}">
									<form:checkbox path="users" value="${user}"/>
									${user.getUsername()}
								</c:forEach>
							</div>
							<form:input type="hidden" path="familyName" value="${fam.getFamilyName()}"/>
						</div>
						
						<div class="d-flex flex-row my-4 justify-content-end">
							<button type="submit" class="btn accentSplash">Remove Family Member(s)</button>
						</div>
					</form:form>
				</div>
			</c:if>
		</div>
	</body>
</html>