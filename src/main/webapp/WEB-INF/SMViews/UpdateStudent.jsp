<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<title>UpdateStuent</title>
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.3.0/font/bootstrap-icons.css">
	</head>
	
	<body>
	
		<div class="container d-flex h-100 bg-dark p-5 w-25 mt-5">
			<form class="row align-self-center" method="post" action="updateData">
			<h1 class="text-start mb-5" style="color:white">EditStudent</h1>
					  <input type="text" class="form-control mt-3" name="firstName" placeholder="firstName" required value='${student.firstName}' />       
					  <input type="text" class="form-control mt-3" name="lastName" placeholder="lastName" required value='${student.lastName}' />
					  <input type="text" class="form-control mt-3" name="email" placeholder="email" required value='${student.email}' /> 
				<button type="submit" class="btn btn-light mt-3">Edit</button>
			</form>
		</div>									
	</body>
	
	
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
</html>