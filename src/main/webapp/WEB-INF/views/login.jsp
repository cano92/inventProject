
<!-- include head ( contiene librerias css y encabezados ) -->
<%@ include file="head.jsp"%>

<%@ include file="header.jsp"%>

<%@ include file="navBar.jsp"%>

<!-- contenido -->


<!--  indicador de en que parte del menu estamos-->
<div class="container px-lg-5">
	<div class="row mx-lg-n5">
		<div class="col py-3 px-lg-5">
			<h4>login</h4>
		</div>
	</div>
</div>

<!-- ***************** CONTENIDO	**************************--->
<div class="container">
	<section class="row justify-content-center">

		<article class="col-4">
			
			<form action="" method="post">
				<div class="form-group">
					<label for="exampleInputEmail1">Name</label> <input required
						type="text" name="name" class="form-control"
						placeholder="Enter User Name">
				</div>
				<div class="form-group">
					<label for="exampleInputPassword1">Password</label> <input required
						type="text" name="password" class="form-control"
						placeholder="Password">
				</div>
				<div class="text-center">
					<button type="submit" class="btn btn-primary">Submit</button>
				</div>

			</form>

		</article>

	</section>
</div>





<!-- include footer jsp (incluye librerias js) -->
<%@ include file="footer.jsp"%>

