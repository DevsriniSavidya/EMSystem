<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<style><%@include file="/WEB-INF/css/index.css"%></style>
<title>Employee Management Application</title>
<link rel="stylesheet"
	  href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	  integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	  crossorigin="anonymous">
	
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
	

	    <div class="container col-md-5" style="background-color: Thistle">
		<div class="card" style="background-color: Thistle">
			<div class="card-body">
				<c:if test="${employee != null}">
					<form action="update" method="post">
				</c:if>
				<c:if test="${employee == null}">
					<form action="insert" method="post">
				</c:if>

				<caption>
					<h2>
						<c:if test="${employee != null}">
            			Edit Employee
            		</c:if>
						<c:if test="${employee == null}">
            			Add New Employee
            		</c:if>
					</h2>
				</caption>

				<c:if test="${employee != null}">
					<input type="hidden" name="id" value="<c:out value='${employee.id}' />" />
				</c:if>

				<fieldset class="form-group">
					<label> Name</label> <input type="text"
						value="<c:out value='${employee.name}' />" class="form-control"
						name="name" required="required">
				</fieldset>

				  
				<label> Type</label>
				<br>
				<div class="form-check form-check-inline">
                   <input class="form-check-input" type="radio" name="eType" value="Permanent" ${employee.type == 'Permanent' ? 'checked' : ''} >
                   <label class="form-check-label" for="Permanent">Permanent</label>
                </div>

                <div class="form-check form-check-inline">
                   <input class="form-check-input" type="radio" name="eType" value="Contract"  ${employee.type == 'Contract' ? 'checked' : ''} >
                   <label class="form-check-label" for="Contract">Contract</label>
                </div>
        <br><br>

            	<div class="form-group">
                   <label for="exampleFormControlSelect1">Department</label>
                     <select class="form-control" id="edept" name="edept">
                      <option value="IT"  ${employee.department == 'IT' ? 'selected="selected"' :  ''} >IT</option>
                      <option value="HR"  ${employee.department == 'HR' ? 'selected="selected"' :  ''} >HR</option>
                      <option value="Finance"  ${employee.department == 'Finance' ? 'selected="selected"' :  ''} >Finance</option>
                     </select>
                </div>

	
				<fieldset class="form-group">
					<label> Address</label> <input type="text"
						value="<c:out value='${employee.address}' />" class="form-control"
						name="address" required="required">
				</fieldset>
		
				<label>Gender</label>
				<br>
				<div class="form-check form-check-inline">
                   <input class="form-check-input" type="radio" name="gender" value="Female" ${employee.gender == 'Female' ? 'checked' : ''} >
                   <label class="form-check-label" for="Female">Female</label>
               </div>
               <div class="form-check form-check-inline">
                    <input class="form-check-input" type="radio" name="gender" value="Male"  ${employee.gender == 'Male' ? 'checked' : ''} >
                    <label class="form-check-label" for="Contract">Male</label>
               </div>
               <br><br>
				
				
				<fieldset class="form-group">
					<label> Age</label> <input type="number"
						value="<c:out value='${employee.age}' />" class="form-control"
						name="age">
				</fieldset>
				
                <button type="submit" class="btn btn-success">Save</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>
