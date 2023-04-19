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
	<div class="row align-items-center">
		<div class="col-sm">
			<h1>Brew Review</h1>
		</div>
		<div class="col-sm">
			<p>${user.userName}</p>
			<a href="/logout">logout</a>
		</div>
	</div>
	<p>Beans</p>
	<table class="table">
	    <thead>
	        <tr>
	            <th>Name</th>
	            <th>Brand</th>
	            <th>Region</th>
	        </tr>
	    </thead>
	    <tbody>
	    	<c:forEach var="bean" items="${beans}">
				<tr>
					<td><a href="/beans/${bean.id}">${bean.name}</a></td>
					<td>${bean.brand}</td>
					<td>${bean.region}</td>
				</tr>
			</c:forEach>
	    </tbody>
	</table>
	<a class="btn btn-success" href="/beans/new" role="button">Add Beans</a>
</div>
</body>
</html>