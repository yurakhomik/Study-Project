<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
	<style type="text/css">
		.tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
		.tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
		.tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
		.tg .tg-4eph{background-color:#f9f9f9}
	</style>
	
</head>
<body background="http://howdoyousaythatword.com/wp-content/uploads/2012/01/fruit.jpg">

<h1 align="center">
	 Fruit shop
</h1>

<p align="right" style="text-indent:100px">
 <input type="button" value ="Login"onClick='location.href="./login"'>
 <input type="button" value ="Registration"onClick='location.href="./register"'>
 </p>
 
<p align="right" width="30%">
<input type="button" value ="Add goods"onClick='location.href="/SpringMVCHibernate/persons"'>
<p>

<br>
<h3 align="center">Goods List</h3>
<c:if  test="${!empty listPersons}">
	<table class="tg" align="center">
	<tr>
		<!--  <th width="80">Good ID</th>  -->
		<th width="120">Name</th>
		<th width="120">Category</th>
		<th width="120">In stock(kg)</th>
		<th width="120">Price($)</th>
		  <!-- <th width="60">Edit</th> -->
		<!-- <th width="60">Delete</th> -->
	</tr>
	<c:forEach items="${listPersons}" var="person">
		<tr>
			<!--  <td>${person.id}</td>  -->
			<td>${person.name}</td>
			<td>${person.country}</td>
			<td>${person.weigth}</td>
			<td>${person.price}</td>
			<!-- <td><a href="<c:url value='/edit/${person.id}' />" >Edit</a></td> -->
			<!-- <td><a href="<c:url value='/remove/${person.id}' />" >Delete</a></td> -->
		</tr>
	</c:forEach>
	</table>
</c:if>
 
 
 
</body>
</html>
