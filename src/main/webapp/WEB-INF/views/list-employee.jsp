<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Employee List</title>
	</head>
	<body>
		<div align="center">
	        <h1>Employee List</h1>
	        <h4><a href="/employee">New Employee</a></h4>
	        <div>
	        	<form action="/search" method="get">
	        		<input type="text" name="keyword" id="keyword" value="${not empty keyword ? keyword : param.keyword}"/>
	        		<input type="submit" value="Search"/>
	        	</form>
	        </div>
	        <c:choose>
	        	<c:when test="${fn:length(employeeList) gt 0}">
	        		<table border="1" cellspacing="5" cellpadding="5">
			        	<tr>
				        	<th>No</th>
				        	<th>Name</th>
				        	<th>Email</th>
				        	<th>Address</th>
				        	<th>Telephone</th>
				        	<th>Action</th>
			        	</tr>
						<c:forEach var="employee" items="${employeeList}">
				        	<tr>
				        		<td>${employee.id}</td>
								<td>${employee.name}</td>
								<td>${employee.email}</td>
								<td>${employee.address}</td>
								<td>${employee.telephone}</td>
								<td>
									<a href="employee?id=${employee.id}">Edit</a>&nbsp;
									<a href="delete?id=${employee.id}">Delete</a>
								</td>
				        	</tr>
						</c:forEach>	        	
					</table>
	        	</c:when>
	        	<c:otherwise>
	        		<p>No record exists!</p>
	        	</c:otherwise>
	        </c:choose>
    	</div>
	</body>
</html>