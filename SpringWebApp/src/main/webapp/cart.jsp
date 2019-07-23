<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cart</title>
</head>
<body bgcolor=pink>

	<h4>Selected Books</h4>
	<ul>
		<c:forEach var="aBook" items="${selectedBooks}">
			<li>${aBook}</li>
		</c:forEach>

	</ul>
	<h4>Selected Cars</h4>
	<ul>
		<c:forEach var="aCar" items="${selectedCars}">
			<li>${aCar}</li>
		</c:forEach>

	</ul>
	
	<h4>Selected Bikes</h4>
	<ul>
		<c:forEach var="aBike" items="${paramValues.Bikes}">
			<li>${aBike}</li>
		</c:forEach>

	</ul>

</body>
</html>