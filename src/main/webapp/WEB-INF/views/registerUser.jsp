
<!-- include head ( contiene librerias css y encabezados ) -->
<%@ include file="head.jsp"%>

<%@ include file="header.jsp"%>

<%@ include file="navBar.jsp"%>

<!-- contenido -->


<!--  indicador de en que parte del menu estamos-->
<div class="container px-lg-5">
	<div class="row mx-lg-n5">
		<div class="col py-3 px-lg-5">
			<h4>resgister</h4>
		</div>
	</div>
</div>

<!-- ***************** CONTENIDO	**************************--->
<div class="container">
	<section class="row justify-content-center">

		<article class="col-8">

			<form action="register" method="post">
				<div class="form-group">
					<label for="exampleInputEmail1">usuario</label> <input 
						type="text" name="user" class="form-control" placeholder="User">
				</div>
				<div class="form-group">
					<label for="exampleInputPassword1">Password</label> <input 
						type="text" name="password" class="form-control"
						placeholder="Password">
				</div>
				<div class="form-group">
					<label for="exampleInputPassword1">Nombre</label> <input 
						type="text" name="username" class="form-control" placeholder="username">
				</div>
				<div class="form-group">
					<label for="exampleInputPassword1">Apellido</label> <input 
						type="text" name="password" class="form-control"
						placeholder="apellido">
				</div>
				<div class="form-group">
					<label for="exampleInputPassword1">email</label> <input 
						type="text" name="password" class="form-control"
						placeholder="email">
				</div>
				<div class="form-group">
					<label for="exampleInputPassword1">cel</label> <input 
						type="text" name="password" class="form-control" placeholder="cel">
				</div>
				<div class="form-group">
					<label for="exampleInputPassword1">dni</label> <input 
						type="text" name="password" class="form-control" placeholder="dni">
				</div>
				<div class="form-group">
					<label for="exampleInputPassword1">fecha de Nacimiento</label> <input
						 type="text" name="password" class="form-control"
						placeholder="00/00/00">
				</div>

				<div class="form-group">
					<label for="exampleInputPassword1">sexo</label> <input 
						type="text" name="password" class="form-control" placeholder="x">
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

