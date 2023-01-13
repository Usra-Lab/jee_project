<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%int StudentCounter=(int) request.getAttribute("StudentCounter"); %>
<%int TeacherCounter=(int) request.getAttribute("TeacherCounter"); %>
<%double jeeFisrtMark=(double) request.getAttribute("jeeFisrtMark"); %>
<%double jeeLastMark=(double) request.getAttribute("jeeLastMark"); %>
<%double frameworksFirstMark=(double) request.getAttribute("frameworksFirstMark"); %>
<%double frameworksLastMark=(double) request.getAttribute("frameworksLastMark"); %>
<%double csFirstMark=(double) request.getAttribute("csFirstMark"); %>
<%double csLastMark=(double) request.getAttribute("csLastMark"); %>

<!DOCTYPE html>
<html lang="en">
		<head>
		<title>Login</title>
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.3.0/font/bootstrap-icons.css">
		
	</head>
	<body >
		<style><%@include file="/WEB-INF/Assets/CSS/HomeStyle.css"%></style>
			
       
       <div class="main-container d-flex">
             <%@ include file="SideBare.jsp" %>
	        <div class="content bg-light">

				<div class="container mt-5 " >
				
					<h1>Welcome admin</h1>
					
					<div class="row g-3 my-2">
						<div class="col-md-4">
							<div class="p-3 bg-white shadow-sm d-flex justify-content-around align-items-center rounded">
								<div >
									<h3 class="fs-2"><%= StudentCounter %></h3>
									<p class="fs-5">All Students <a href="SMStudentsList"><i class="bi bi-eye-fill"></i></a></p>
								</div>
						  </div>
					    </div>
				   
						<div class="col-md-4">
							<div class="p-3 bg-white shadow-sm d-flex justify-content-around align-items-center rounded">
								<div >
									<h3 class="fs-2"><%= TeacherCounter %></h3>
									<p class="fs-5">All Teachers <a href="SMTeacherData"><i class="bi bi-eye-fill"></i></a> </p>
								</div>
						  </div>
					    </div>
				   
						<div class="col-md-4">
							<div class="p-3 bg-white shadow-sm d-flex justify-content-around align-items-center rounded">
								<div >
									<h3 class="fs-2">6</h3>
									<p class="fs-5">All Subjects</p>
								</div>
						  </div>
						   
				   </div>
	          </div>
	       
	       
	       <div class="d-sm-flex m-4">
	       		       <div class="row g-3 my-2  ">	    
	       		          <div class=" d-sm-flex p-4 shadow-sm">   
					       <h4 style= "color:#A0A0A0" class="mx-4">Jee</h4>
							<div class="col-md-5">
								<div class="p-3 bg-white shadow-sm d-flex justify-content-around align-items-center rounded  mx-4">
									<div >
										<h3 class="fs-2"><%= jeeFisrtMark %></h3>
										<p class="fs-5">First Mark</p>
									</div>
							  </div>
						    </div>
					   
							<div class="col-md-5">
								<div class="p-3 bg-white shadow-sm d-flex justify-content-around align-items-center rounded">
									<div >
									
									
										<h3 class="fs-2"><%= jeeLastMark %></h3>
										<p class="fs-5">Last Mark </p>
										
									</div>
							  </div>
						    </div>	
						 </div>
						 
					<div class=" d-sm-flex p-4 shadow-sm">   
		                 <h4 style= "color:#A0A0A0" class="mx-4">Frameworks</h4>
							<div class="col-md-5">
								<div class="p-3 bg-white shadow-sm d-flex justify-content-around align-items-center rounded mx-4">

									<div >
										<h3 class="fs-2"><%= frameworksFirstMark %></h3>
										<p class="fs-5">First Mark</p>
									</div>
							  </div>
						    </div>		   
							<div class="col-md-5">
								<div class="p-3 bg-white shadow-sm d-flex justify-content-around align-items-center rounded ">
									<div >
										<h3 class="fs-2"><%= frameworksLastMark %></h3>
										<p class="fs-5">Last Mark</p>
									</div>
							     </div>
					   
		                    </div>
		              </div>
		              
		            <div class=" d-sm-flex p-4 shadow-sm">   
		              
		                   <h4 style= "color:#A0A0A0" class="mx-4">Cs</h4>
							<div class="col-md-5">
								<div class="p-3 bg-white shadow-sm d-flex justify-content-around align-items-center rounded mx-4">
									<div >
										<h3 class="fs-2"><%= csFirstMark %></h3>
										<p class="fs-5">First Mark</p>
									</div>
							  </div>
						    </div>
					   
							<div class="col-md-5">
								<div class="p-3 bg-white shadow-sm d-flex justify-content-around align-items-center rounded">
									<div >
										<h3 class="fs-2"><%= csLastMark %></h3>
										<p class="fs-5">Last Mark</p>
									</div>
							  </div>
						    </div>
					   
	                  </div>
							
				</div>
					   
	         </div>
	       </div>	       
   
	   </div>
	       
     </div>
       

		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>

	</body>
</html>