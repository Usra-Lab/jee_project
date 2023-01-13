<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
    
    
<!DOCTYPE html>


<html lang="en">
		<head>
		<title>Login</title>
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
	</head>
	<body style="	background-image: linear-gradient(to right top, #d3d3d3, #b7b7b7, #9c9c9c, #828282, #696969);
	">
		<style><%@include file="/WEB-INF/Assets/CSS/style.css"%></style>
		<div class="center">
		
		        <button class="teacher" data-bs-toggle="modal" data-bs-target="#TeacherLogin">Teacher's Field</button>
				<button class="student" data-bs-toggle="modal" data-bs-target="#StudentLogin">Student's Field</button>
	  </div>
		
		
		<div id="TeacherLogin" class="modal fade">
		
			<div class="modal-dialog modal-dialog-centered">
				<div class="modal-content">
						<div class="modal-body">
						<button type="button" class="btn-close btn-close-white" data-bs-dismiss="modal"></button>
						<div class="  bg-dark p-5 ">
						<h1 class="text-start mb-5">Login</h1>
						<form class="loginForm " method="post" action="Login">
							<input type="email" class="form-control mt-3" name="username" placeholder="Username" required />
							<input type="password" class="form-control mt-3" name="password" placeholder="Password" required />
							<button type="submit" class="btn btn-light mt-3">SignIn</button>
							<p class=" text-end  mt-3 " >Don't have an account ? <a href="Register"> Create One</a></p>
						</form>
						</div>
					</div>
				</div>
			</div>
		</div>
		
		<div id="StudentLogin" class="modal fade">
		
			<div class="modal-dialog modal-dialog-centered">
				<div class="modal-content">
						<div class="modal-body">
						<button type="button" class="btn-close btn-close-white" data-bs-dismiss="modal"></button>
						<div class="  bg-dark p-5 ">
						<form class="loginForm " method="get" action="StudentSpace">
							<select class="form-control mt-3 col-md-10" name="code" >
							 		<option value="" >SubjectCode</option>
							 		<option value="jee_code">jee_code</option>
							 		<option value="framworks_code">frameworks_code</option>
							 		<option value="maths_code">maths_code</option>
							 		<option value="dev_mobile_code">dev_mobile_code</option>
							 		<option value="administration_system_code">Administration_System_code</option>
							 		<option value="cs_code">cs_code</option>
						 		</select>
							<button type="submit" class="btn btn-light mt-3">Join</button>
						</form>
						</div>
					</div>
				</div>
			</div>
		</div>
		
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
	</body>
</html>