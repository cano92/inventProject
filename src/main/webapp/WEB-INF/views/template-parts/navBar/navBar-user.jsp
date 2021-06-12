<%@ page import="entities.User" %>
<% User user = (User)session.getAttribute("user"); %>

<nav class="sticky-top" >
<div class="row">
<div class="col">
        <!--barra de navegacion-->

     	<nav class="navbar navbar-expand-md navbar-light bg-light">
			<a class="navbar-brand" href="home">Home</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>

			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav nav-tabs mr-auto">
        
        				nav nav-pills nav-justified
                 	<li class="nav-item dropdown">
						<a class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
						role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> Post </a>
						<div class="dropdown-menu" aria-labelledby="navbarDropdown">
							<a class="dropdown-item" href="recientes.html">Recientes</a> 
							<a class="dropdown-item" href="recientes.html">Topics</a>
							<div class="dropdown-divider"> </div>
							<a class="dropdown-item" href="#">Todos</a>
						</div>
					</li>
					
               
                <% if(user.isExistPermit("user_show")){  %>   
                   <li class="nav-item dropdown">
                       <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                         Usuarios
                       </a>
                       <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                        
                        <a class="dropdown-item" href="registerUser">Registrar</a>
                        
                         <a class="dropdown-item" href="programaProximo.html">Roles</a>
                        
                         <a class="dropdown-item" href="programaEstimaciones.html">Buscador</a>
                         
                         <div class="dropdown-divider"></div>
                     
                         	<a class="dropdown-item" href="programaTodos.html">Todos</a>
                     
                       </div>
                   </li>
             	<%} %>
             	
             	
             	<% if(user.isExistPermit("role_show")){  %>   
                   <li class="nav-item dropdown">
                       <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                         Rol
                       </a>
                       <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                        
                         <a class="dropdown-item" href="programaProximo.html">ver</a>
                        
                         <a class="dropdown-item" href="programaEstimaciones.html">Buscador</a>
                         
                         <div class="dropdown-divider"></div>
                     
                         <a class="dropdown-item" href="programaTodos.html">Todos</a>
                     
                       </div>
                   </li>
             	<%} %>


                   <li class="nav-item">
                     <a class="nav-link" href="info" tabindex="-1" aria-disabled="true">Info</a>
                   </li>
                   
                 </ul>
                 
                 
                <ul class="nav nav-tabs">	
           
                	<li class="nav-item dropdown ">
                       <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                       		<svg xmlns="http://www.w3.org/2000/svg" width="23" height="23" fill="currentColor" class="bi bi-person" viewBox="0 0 16 16">
  								<path d="M8 8a3 3 0 1 0 0-6 3 3 0 0 0 0 6zm2-3a2 2 0 1 1-4 0 2 2 0 0 1 4 0zm4 8c0 1-1 1-1 1H3s-1 0-1-1 1-4 6-4 6 3 6 4zm-1-.004c-.001-.246-.154-.986-.832-1.664C11.516 10.68 10.289 10 8 10c-2.29 0-3.516.68-4.168 1.332-.678.678-.83 1.418-.832 1.664h10z"/>
  							</svg>
<%--   							<%= userAct.getFirtsName() %> --%>
                   			${user.firtsName}                  		
                       </a>
                       <div class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdown">
                         <a class="dropdown-item" href="programaProximo.html">perfil</a>
                         <div class="dropdown-divider"></div>
                         <a class="dropdown-item" href="logout">salir</a>
                       </div>
                   </li>
   
				</ul>
               </div>
             </nav>
        
	</div>
</div>
</nav>