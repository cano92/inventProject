<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="rapid" uri="http://www.rapid-framework.org.cn/rapid"%>



<rapid:override name="page-content">
	<!-- ***************** CONTENIDO	**************************--->
	<!-- 	la primer seccion es el row para ocupar todo el espacio -->
	<section class="row justify-content-center">

		<article class="col-5 loginForm">
			<header class="row">
				<div class="col">
					<h3>Login.!</h3>
				</div>
			</header>
			<section class="row">
				<div class="col">
					<form action="" method="post">
						<div class="form-group">
							<label for="exampleInputEmail1">Name</label> <input required
								type="text" name="name" class="form-control"
								placeholder="Enter User Name">
						</div>
						<div class="form-group">
							<label for="exampleInputPassword1">Password</label> <input
								required type="text" name="password" class="form-control"
								placeholder="Password">
						</div>
					</form>
				</div>
			</section>
			<footer class="row">
				<div class="col text-center">
					<button type="submit" class="btn btn-primary">Submit</button>
				</div>
			</footer>
		</article>

	</section>
</rapid:override>



<%@ include file="template/clearTemplate.jsp"%>




