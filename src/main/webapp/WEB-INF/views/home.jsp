
<!-- include head ( contiene librerias css y encabezados ) -->
<%@ include file="head.jsp"%>

<%@ include file="header.jsp"%>

<%@ include file="navBar.jsp"%>

<!-- contenido -->


<!--  indicador de en que parte del menu estamos-->
<div class="container px-lg-5">
	<div class="row mx-lg-n5">
		<div class="col py-3 px-lg-5">
			<h4>Home citrino</h4>
		</div>
	</div>
</div>

<!-- ***************** CONTENIDO	**************************--->
<!-- siempre debe estar en una fila (row) y en almenos una columna ( col)  -->
<div class="container">

	<section class="row justify-content-center ">
		<article class="col-8">

			<div id="carouselExampleControls" class="carousel slide"
				data-ride="carousel">
				<div class="carousel-inner">
					<div class="carousel-item active">
						<img
							src="/webReuJov/resources/img/fondos/Los-10-deportes-mas-practicados-en-todo-el-mundo.jpg"
							class="d-block w-100 figure-img img-thumbnail img-fluid" alt="..">
					</div>
					<div class="carousel-item">
						<img src="/webReuJov/resources/img/fondos/pelotas-deportes.jpg" class="d-block w-100"
							alt="..">
					</div>
					<div class="carousel-item">
						<img src="/webReuJov/resources/img/fondos/images.jpeg" class="d-block w-100" alt="...">
					</div>
				</div>
				<a class="carousel-control-prev" href="#carouselExampleControls"
					role="button" data-slide="prev"> <span
					class="carousel-control-prev-icon" aria-hidden="true"></span> <span
					class="sr-only">Previous</span>
				</a> <a class="carousel-control-next" href="#carouselExampleControls"
					role="button" data-slide="next"> <span
					class="carousel-control-next-icon" aria-hidden="true"></span> <span
					class="sr-only">Next</span>
				</a>
			</div>

			<!-- es como un <br> salto de linea-->
			<div class="w-100"></div>
			<h4 class="text-center">Titulo del evento</h4>

			<div class="w-100"></div>
			<p>contenido encabezado dasiodmaskimddasm iasdnmiasnd
				aoisdnnmiasnm aisjdnas ioasind aisdi iasdn aisdno aiosdn</p>

			<p>Descripcion del evento asdfghbjnkmasduhabsdasd dasjnd ajsdn
				aksdn dasdjknml,dagysbhhhhhsaubdiusadui9nas adionas diasnd aisdn
				aojsnd oasn d asdkpamlsÃ±dnmklasdnaskod ashdjiak dasjk dasjk
				oajskdnn ajs d ajsd asdnjkmlÃ±askmd aisdn oasdn oajsd oiasnnd oaisnd
				on das oda so</p>
			<div class="w-100"></div>


			<p class="text-right">algun lugar 00/00/00.</p>

		</article>
	</section>
</div>





<!-- include footer jsp (incluye librerias js) -->
<%@ include file="footer.jsp"%>

