<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Product Page here</title>

<style>
{
  font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
  border-collapse: collapse;
  width: 100%;
}

td, th {
  border: 1px solid #ddd;
  padding: 8px;
}

tr:nth-child(even){background-color: #f2f2f2;}

tr:hover {background-color: #ddd;}

th {
  padding-top: 12px;
  padding-bottom: 12px;
  text-align: left;
  background-color: #4CAF50;
  color: white;
}
.error{
color : red;
}
</style>

</head>
<body>


<fieldset name="Add Product">

<form:form method="POST"  commandName="product" >
Name <form:input path="name" /> <form:errors path="*" cssClass="error"/> <br>
Price <form:input path="price"/> <br>
QoH <form:input path="qoh"/> <br>
<input type="submit" value="Add">
</form:form>


</fieldset>


<table>
<tr> <th> Id </th> <th> Name </th> <th> Price </th> <th> QoH </th> <th> Action </th> </tr>
<c:forEach var="p" items="${productList}">
<tr> <td> ${p.id} </td> <td> ${p.name} </td> <td> ${p.price} </td> <td> ${p.qoh} </td>
 <td><a href = removeProducts?id=${p.id}>Remove</a></td></tr>
</c:forEach>
</table>


</body>
</html>
