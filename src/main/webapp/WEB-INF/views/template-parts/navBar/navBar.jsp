<!-- nav bar es un componente con su logica propia asi se puede cambiar en cualquier comento  -->

<!-- logica para el nav-Bar o la customizacion del mismo -->
	<% if( session.getAttribute("user") == null){  %>
	
		<%@ include file="navBar-default.jsp"%>
	<%}else{ %>
		<%@ include file="navBar-user.jsp"%>
	<%} %>