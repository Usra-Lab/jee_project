<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%String code=(String) request.getAttribute("code"); %>

<%String subject=(String) request.getAttribute("subject"); %>



    
    
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
             <%@ include file="SideBare.jsp" %>
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
					      <th scope="col">CsMark</th>
					      <th scope="col">JeeMark</th>
					      <th scope="col">MobileDevMark</th>
					      <th scope="col">FrameworksMark</th>
					      <th scope="col">MathsMark</th>
					      <th scope="col">AdmSystemMark</th>
					    </tr>
					    
					  </thead>
					  
					  <tbody>
						    <c:forEach items="${students}" var="student">
				             <tr>
					               <td>${student.apogee }</td>
					               <td>${student.firstName }</td>
					               <td>${student.lastName }</td>
					               <td>${student.cs_mark}</td>
					               <td>${student.jee_mark }</td>
					               <td>${student.mobile_dev_mark}</td>
					               <td>${student.frameworks_mark }</td>
					               <td>${student.maths_mark}</td>
					               <td>${student.administration_system_mark}</td>
					               
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