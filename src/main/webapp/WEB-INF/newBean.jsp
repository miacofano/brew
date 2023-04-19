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
<title>Brew Reviews</title>
</head>
<body>
<div class="container">
	<h1>New Bean</h1>
	<form:form action="/beans/new" method="post" modelAttribute="bean" class="form">
		<form:hidden value="${user.id}" path="user"/>
			<div class="row">
				<div class="col">
					<div class="form-row">
						<form:label class="form-label" path="name">Name:</form:label>
				        <form:errors class="text-danger" path="name"/>
				        <form:input class="form-control" path="name"/>
					</div>
					<div class="form-row">
						<form:label class="form-label" path="brand">Brand:</form:label>
				        <form:errors class="text-danger" path="brand"/>
				        <form:input class="form-control" path="brand"/>
					</div>
					<div class="form-row">
						<form:label class="form-label" path="region">Region:</form:label>
				        <form:errors class="text-danger" path="region"/>     
				        <form:input class="form-control" path="region"/>
					</div> 
					<div class="form-row">
						<form:label class="form-label" path="roast">Roast:</form:label>
				        <form:errors class="text-danger" path="roast"/>     
				        <form:input class="form-control" path="roast"/>
					</div>
					<div class="form-row">
						<form:label class="form-label" path="price">Price: $</form:label>
				        <form:errors path="price"/>     
				        <form:input class="form-control" type="number" path="price"/>
					</div> 
				</div>
				<div class="col">
					<div class="center">
						<form:label class="form-label" path="brew">Brew Method:</form:label>
				        <form:errors class="text-danger" path="brew"/>
				        <form:input class="form-control" path="brew"/>
					</div>
					<div class="center">
						<form:label class="form-label" path="rating">Rating:</form:label>
				        <form:errors class="text-danger" path="rating"/>
				        <form:input class="form-control" type="number" path="rating"/>
					</div>
					<div class="center">
						<form:label class="form-label" path="flavor">Flavor Profile:</form:label>
				        <form:errors class="text-danger" path="flavor"/>
				        <form:textarea class="form-control" path="flavor"/>
					</div>
				</div>  
			</div>
			<div class="row align-items-center">
				<div class="col-sm">
					<button class="btn btn-primary">Create</button>
				</div>
				<div class="col-sm">
					<a class="btn btn-warning" href="/beans" role="button">Cancel</a>
				</div>
			</div>  
	</form:form>
</div>
</body>
</html>

