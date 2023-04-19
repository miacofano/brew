<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css">
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<title>Brew Review</title>
</head>
<body>
<div class="container">
	<h1>Brew Review Database</h1>
	<div class="row align-items-center">
		<div class="col-sm">
			<h3>Register</h3>
			<div class="container">
				<form:form action="/register" method="post" modelAttribute="newUser" class="form">
				    <div class="form-row">
				        <form:label class="form-label" path="userName">Name:</form:label>
				        <form:errors path="userName" class="text-danger"/>
				        <form:input class="form-control" path="userName"/>
				    </div>
				    <div class="form-row">
				        <form:label class="form-label" path="email">Email:</form:label>
				        <form:errors path="email" class="text-danger"/>
				        <form:input class="form-control" path="email"/>
				    </div>
				    <div class="form-row">
				        <form:label class="form-label" path="password">Password:</form:label>
				        <form:errors path="password" class="text-danger"/>
				        <form:input class="form-control" path="password"/>
				    </div>
				    <div class="form-row">
				        <form:label class="form-label" path="confirm">Confirm Password:</form:label>
				        <form:errors path="confirm" class="text-danger"/>
				        <form:input class="form-control" path="confirm"/>
				    </div>
					<button class="btn btn-primary">Register</button>
				</form:form>
			</div>
		</div>
		<div class="col-sm">
			<h3>Login</h3>
			<div class="container">
				<form:form action="/login" method="post" modelAttribute="newLogin" class="form">
				    <div class="form-row">
				        <form:label class="form-label" path="email">Email:</form:label>
				        <form:errors path="email" class="text-danger"/>
				        <form:input class="form-control" path="email"/>
				    </div>
				    <div class="form-row">
				        <form:label class="form-label" path="password">Password:</form:label>
				        <form:errors path="password" class="text-danger"/>
				        <form:input class="form-control" path="password"/>
				    </div>
					<button class="btn btn-primary">Login</button>
				</form:form>
			</div>
		</div>
	</div>
</div>
</body>
</html>