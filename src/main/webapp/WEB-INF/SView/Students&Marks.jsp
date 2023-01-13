<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%String code=(String) request.getAttribute("code"); %>

<!DOCTYPE html>


<html lang="en">
		<head>
		<title>StudentsList</title>
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.3.0/font/bootstrap-icons.css">
		
	</head>
	<body>
		<style><%@include file="/WEB-INF/Assets/CSS/HomeStyle.css"%></style>
		<style><%@include file="/WEB-INF/Assets/CSS/style.css"%></style>
		
			
       
       <div class="main-container d-flex">
	       <div class="content">
	       
				  <div class="container mt-5">
					 <div id="AddStudent" class="modal fade">

		            </div>

					<table class="table table-striped">
					  <thead>
					    <tr>
					      <th scope="col">Apogee</th>
					      <th scope="col">FirstName</th>
					      <th scope="col">LastName</th>
					      <th scope="col">Email</th>
					      
					       <c:if test="${code=='jee_code'}">
					      <th scope="col">JeeMark</th>
				               </c:if>
				               <c:if test="${code=='framworks_code'}">
					      <th scope="col">FrameworksMark</th>
				               
				               </c:if>
				               <c:if test="${code=='maths_code'}">
					      <th scope="col">Maths_Mark</th>
				               
				               </c:if>
				               <c:if test="${code=='dev_mobile_code'}">
					      <th scope="col">DevMobileMark</th>
				               
				               </c:if>
				               <c:if test="${code=='cs_code'}">
					      <th scope="col">CsMark</th>
				               
				               </c:if>
				               <c:if test="${code=='administration_system_code'}">
					      <th scope="col">AdministrationSystemMark</th>
				               </c:if>
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
					               
				               </tr>
			               </c:forEach>
			               
					      
					  </tbody>
					</table>
						<a href="Logout" class="text-decoration-none px-3 py-5 d-block"><i class="bi bi-box-arrow-left mx-2"></i>Logout</a>
				</div>

	       </div>
       </div>
       
       
       
       

		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>

	</body>
</html>