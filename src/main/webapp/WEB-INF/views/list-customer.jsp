<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List Customers</title>
</head>
<style>
	table, th, td , tr{
		border: 2px solid red;
		padding:10px;
	}
</style>
<body>
	<jsp:include page="../../index.jsp"></jsp:include>

	<h1>List of all Customers</h1>
	<table>
		<thead>
			<tr>
				<th>Customer Id</th>
				<th>Customer Name</th>
				<th>Customer Age</th>
				<th>Registered Date</th>
			</tr>
		</thead>
		<tbody>
			<core:forEach var="customer" items="${list}">
				<tr>
					<td>${customer.getId()}</td>
					<td>${customer.getName()}</td>
					<td>${customer.getAge()}</td>
					<td>${customer.getCreatedAt()}</td>
				</tr>
			</core:forEach>

		</tbody>
	</table>

</body>
</html>