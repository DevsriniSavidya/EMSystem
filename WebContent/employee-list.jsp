<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<style><%@include file="/WEB-INF/css/list.css"%></style>
<title>Employee Management Application</title>
<link rel="stylesheet"
	  href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	  integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	  crossorigin="anonymous">
	  <link rel="stylesheet"
	  href="/WEB-INF/css/list.css" type="text/css">
</head>
<body>

	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: DeepPink">
			<div>
				<a href="#" class="navbar-brand"> <b>Employee Management App </b></a>
			</div>
            <ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/list"
					class="nav-link" >Employees</a></li>
			</ul>
		</nav>
	</header>
	<br>

	<div class="row">
	      <div class="container">
			<h3 class="text-center">List of Employees</h3>
			<hr>
			<div class="container text-left">

				<a href="<%=request.getContextPath()%>/new" class="btn btn-success">Add
					New Employee</a>
		    </div>
			<br>
			<table class="table table-striped">
				<thead class="thead-dark">
					<tr>
						<th>ID</th>
						<th>Name</th>
						<th>Type</th>
						<th>Department</th>
						<th>Address</th>
						<th>Gender</th>
						<th>Age</th>
						<th>Actions</th>
					</tr>
				</thead>
				
				<tbody >
					<c:forEach var="employee" items="${listEmployee}">

						<tr>
							<td><c:out value="${employee.id}" /></td>
							<td><c:out value="${employee.name}" /></td>
							<td><c:out value="${employee.type}" /></td>
							<td><c:out value="${employee.department}" /></td>
							<td><c:out value="${employee.address}" /></td>
							<td><c:out value="${employee.gender}" /></td>
							<td><c:out value="${employee.age}" /></td>
							
							
							<td>
					        <a class="btn btn-warning"  role="button" href="edit?id=<c:out value='${employee.id}' />">Update</a></button>
							    &nbsp;&nbsp;&nbsp;&nbsp;
							<a class="btn btn-danger"  role="button" href="delete?id=<c:out value='${employee.id}' />">Delete</a></button>
							</td>
						</tr>
					</c:forEach>
				</tbody>

			</table>
		</div>
	</div>
</body>
</html>
