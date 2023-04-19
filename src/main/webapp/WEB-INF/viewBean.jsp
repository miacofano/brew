<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isErrorPage="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
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
			<h1>${bean.name}</h1>
		</div>
		<div class="col-sm">
			<a href="/beans">Home</a>
		</div>
	</div>
	<div class="container">
		<div class="col-sm">
			<p>Brand: <c:out value="${bean.brand}"/></p>
			<p>Region: <c:out value="${bean.region}"/></p>
			<p>Roast: <c:out value="${bean.roast}"/></p>
			<p>Price: $<c:out value="${bean.price}"/></p>
		</div>
		<div class="col-sm">
			<p>Brew: <c:out value="${bean.brew}"/></p>
			<p>Rating: <c:out value="${bean.rating}"/></p>
			<p>Flavor: <c:out value="${bean.flavor}"/></p>
		</div>
		<div class="row align-items-center">
			<div class="col-sm">
				<a class="btn btn-secondary" href="/beans/${bean.id}/edit" role="button">Edit</a>
			</div>
			<div class="col-sm">
				<a class="btn btn-danger" href="/beans/${bean.id}/delete" role="button">Delete</a>
			</div>
		</div>
	</div>
</div>
</body>
</html>