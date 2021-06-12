<%@ taglib prefix="rapid" uri="http://www.rapid-framework.org.cn/rapid" %>



<rapid:override name="page-content">
	<section class="row justify-content-center">
		<article class="col-11 loginForm">
			
			<h4 class="headerHome">formulario Usuario</h4>
		
			<%@ include file="template-parts/userForm/userForm.jsp"%>
	
		</article>
	</section>
</rapid:override>

<%@ include file="template/homeTemplate.jsp"%>