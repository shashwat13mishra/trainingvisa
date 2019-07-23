<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@taglib uri ="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Calculator output</title>
</head>
<body>
<form action="calculator" method=get>

Number 1 <input name=n1> <br>

Number 2 <input name=n2> <br>

<input name=op value="+" type=submit> 
<input name=op value="-" type=submit> 
<input name=op value="*" type=submit> 
<input name=op value="/" type=submit> 
</form>

<c:if test="${not(empty(result))}">
<br>
<br>
<h3>Result is : </h3>
<blink>${result}</blink>

</c:if>
</body>
</html>