<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 

<link rel="stylesheet"	href="loginForm.css">

<section class="row justify-content-center">
	<article class="col-5 loginForm">
	
		<header class="row">
			<div class="col">
				<h3>Login.!</h3>
			</div>
		</header>
		<section class="row">
			<div class="col">
				<form:form action="login" modelAttribute="loginForm" method="post">
					<div class="form-group">
						<label for="exampleInputEmail1">Name</label> 
						<form:errors path="user" />
						<form:input path="user" class="form-control" placeholder="Enter User Name" /> 
					</div>
					<div class="form-group">
						<label for="exampleInputPassword1">Password</label> 
						<form:input path="pass" class="form-control" placeholder="Enter User Password" /> 
					</div>
				
					<p class="text-primary">*Ingrese usuario y contraseña </p>	
					<footer class="row">
						<div class="col text-center">
							<button type="submit" class="btn btn-primary">Submit</button>
						</div>
					</footer>
				</form:form> 
			</div>
		</section>
	
	</article>
</section>
	