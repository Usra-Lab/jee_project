<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


    
    
<!DOCTYPE html>


<html lang="en">
		<head>
		<title>StudentsMarksList</title>
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.3.0/font/bootstrap-icons.css">
		
	</head>
	<body>
		<style><%@include file="/WEB-INF/Assets/CSS/HomeStyle.css"%></style>
		<style><%@include file="/WEB-INF/Assets/CSS/style.css"%></style>
		
			
       
       <div class="main-container d-flex">
             <%@ include file="SideBare.jsp" %>
	       <div class="content">
	       
	            <nav class="navbar  bg-dark">
					  <div class="container-fluid ">
					    <a href="/insert" class="text-decoration-none px-3 py-2 d-block add" data-bs-toggle="modal" data-bs-target="#AddStudent"><i class="bi bi-plus mx-2"></i>Add</a>
					    <form class="d-flex" method="get" action="search">
					      <input type="text" class="form-control me-2" name="firstName" placeholder="Search"  />
					      <button class="btn btn-outline-primary" type="submit">Search</button>
					    </form>
					  </div>
				  </nav>
				  
				  <div class="container mt-5">
					 <div id="AddStudent" class="modal fade">
					
						<div class="modal-dialog modal-dialog-centered">
							<div class="modal-content">
									<div class="modal-body">
									<button type="button" class="btn-close btn-close-white" data-bs-dismiss="modal"></button>
									<div class="  bg-dark p-5 ">
									<h1 class="text-start mb-5">AddStudent</h1>
									<form class="loginForm " method="post" action="insert">
										<input type="text" class="form-control mt-3" name="number" placeholder="number" required />
										<input type="text" class="form-control mt-3" name="firstName" placeholder="firstName" required />
										<input type="text" class="form-control mt-3" name="lastName" placeholder="lastName" required />
										<input type="text" class="form-control mt-3" name="mark" placeholder="mark" required />
										<button type="submit" class="btn btn-light mt-3">Add</button>
									</form>
									</div>
								</div>
							</div>
						</div>
		            </div>
		           
		           
		
		
					<table class="table table-striped">
					  <thead>
					    <tr>
					      <th scope="col">Apogee</th>
					      <th scope="col">FirstName</th>
					      <th scope="col">LastName</th>
					      <th scope="col">Email</th>
					      <th scope="col">Mark</th>
                          <th scope="col">Actions</th>
					    </tr>
					    
					  </thead>
					  <tbody>
			               
			               <c:forEach items="${students}" var="student">
				               <tr>
					               <td>${student.apogee }</td>
					               <td>${student.firstName }</td>
					               <td>${student.lastName }</td>
					               <td>${student.email }</td>
					               
					               <c:if test="${code=='jee_code'}">
					               <td>${student.jee_mark }</td>
					               </c:if>
					               <c:if test="${code=='framworks_code'}">
					               <td>${student.frameworks_mark }</td>
					               </c:if>
					               <c:if test="${code=='maths_code'}">
					               <td>${student.maths_mark}</td>
					               </c:if>
					               <c:if test="${code=='dev_mobile_code'}">
					               <td>${student.mobile_dev_mark}</td>
					               </c:if>
					               <c:if test="${code=='cs_code'}">
					               <td>${student.cs_mark}</td>
					               </c:if>
					               <c:if test="${code=='administration_system_code'}">
					               <td>${student.administration_system_mark}</td>
					               </c:if>
					               <td>
					                    <a href="edit?apogee=<c:out value='${student.apogee}'/>"><i class="bi bi-pencil-square"></i></a>				                    
					               </td>
				               </tr>
			               </c:forEach>
			               
					      
					  </tbody>
					</table>
 
				</div>

	       </div>
       </div>
       

		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>

	</body>
</html>