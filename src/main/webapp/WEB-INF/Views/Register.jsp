<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="tagslib.jsp" %>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>Register</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.3.0/font/bootstrap-icons.css">
	
	</head>
	<body>
			<style><%@include file="/WEB-INF/Assets/CSS/RegisterStyle.css"%></style>
			<style><%@include file="/WEB-INF/Assets/CSS/ToastStyle.css"%></style>
			
			
			
			<div class="container">
				<div class="row">
				
					<div class="col-md-7 text-left">
						<h1>Welcome !</h1>
						<p>Dear teacher in this space you can manage your students' grades well and share there marks with them.<br>The Stream Manager will also be aware of any changes and can give his own opinion on the students level.</p>
					</div>
					
					
					<div class="col-md-5 bg-dark p-5">
						 <div class="row">
							 <div class="col-md-10 ">
							     <h3 class="text-start">Register</h3>
							 </div>
						 </div>
						 
						 <form class="registerForm" method="post" action="Register">
						 
							 <div class="row">
							    <input type="text" class="form-control mt-3 col-md-10" name="firstName" placeholder="fisrtName" required />
							 </div>
							 
						 	 <div class="row">
						 		<input type="text" class="form-control mt-3 col-md-10" name="lastName" placeholder="lastName" required />
						 	 </div>
						 	 
						 	 <div class="row">
						 		<input type="email" class="form-control mt-3 col-md-10" name="email" placeholder="Email" required />
	                         </div>
						 	 
						 	 <div class="row">			   		 						   
						 	    <input type="password" class="form-control mt-3 col-md-10" name="password" placeholder="passWord" required />
						 	 </div>
						 	 
	                         <div class="row">			   
						 		<input type="password" class="form-control mt-3 col-md-10" name="re_password" placeholder="re_passWord" required />
						 	 </div>
						 						   
							<div class="row">
						 		<select class="form-control mt-3 col-md-10" name="subject" >
							 		<option value="" >Subject</option>
							 		<option value="jee">JEE</option>
							 		<option value="mobile_dev">Mobile_Dev</option>
							 		<option value="framworks">FramWorks</option>
							 		<option value="c#">C#</option>
							 		<option value="administration_system">Administration_System</option>
							 		<option value="maths">Maths</option>
						 		</select>
	                         </div>
	                         <div class="row">
	                         		<button type="submit" class="btn btn-light mt-3" style="border-radius:0;">SighUp</button>
	                         </div>
	                         
	                          <div class="row">	   
								<p class=" text-end  mt-3 col-md-10" >Having Account ? <a href="Login"> SignIn</a></p>
							 </div>
						</form>
						
					</div>					
					
				</div>
				
			</div>
			
			
		    <script type="text/javascript"><%@include file="/WEB-INF/Assets/JS/ToastStyle.js"%></script>
			<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
	</body>
</html>