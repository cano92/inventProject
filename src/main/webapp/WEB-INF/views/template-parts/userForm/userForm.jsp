<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 


<form:form action="registerUser" modelAttribute="userForm" method="post">
	<div class="row">
		<div class="form-group col-md">
	    	<label for="formGroupExampleInput">Nombre</label>
			<form:input path="firtsName" class="form-control" id="formGroupExampleInput" placeholder="juan" /> 
			<form:errors path="firtsName" cssClass="errorFormText" />
	  	</div>
	
		<div class="form-group col-md">
	    	<label for="formGroupExampleInput2">Apellido</label>
	  		<form:input path="lastName" placeholder="Perez" class="form-control" id="formGroupExampleInput2" />
	  		<form:errors path="lastName" cssClass="errorFormText" />
	  	</div>	
	</div>
	
	<div class="row">
		<div class="form-group col-md">
	    	<label for="formGroupExampleInput3">User</label>
			<form:input path="user" placeholder="user" class="form-control" id="formGroupExampleInput3" />
	  		<form:errors path="user" cssClass="errorFormText" />
	  	</div>
		<div class="form-group col-md">
	    	<label for="formGroupExampleInput4">DNI</label>
			<form:input path="dni" type="number" min="0" class="form-control" id="formGroupExampleInput4" />
	  		<form:errors path="dni" cssClass="errorFormText" />
	  	</div>	
	</div>
  
  
	<div class="form-group">
	  	<label for="exampleInputEmail1">Email address</label> 
		<form:input path="mail" type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="email" />
	  	<small id="emailHelp" class="form-text text-muted">example@domain.com.</small>
	  	<form:errors path="mail" cssClass="errorFormText" />
	</div>
	<div class="form-group">
	  	<label for="exampleInputPassword1">Password</label>
		<form:input path="password"  type="password" class="form-control" id="exampleInputPassword1" placeholder="Password" />
	 	<form:errors path="password" cssClass="errorFormText" />
	</div>
	
	<div class="row">
		<div class="form-group col-md">
	    	<label for="inputState">Sexo</label>
		    <form:errors path="genderId" cssClass="errorFormText" />
			<form:select path="genderId" id="inputState" class="form-control">
				<form:option value="0" label="" />	
				<form:option value="58" label="masculino" />	
				<form:option value="59" label="femenino" /> 
			</form:select>
		     
	  	</div>

		<div class="form-group col-md">
	    	<label for="example-date-input">FechaNac</label>
			<form:input path="dateOfBirth" class="form-control" type="date" value="1900-05-19" id="example-date-input" /> 
	    	<form:errors path="dateOfBirth" cssClass="errorFormText" />
	  	</div>	
	</div>
	
	<div class="form-group">
	    <label for="formGroupExampleInput3">Direccion</label>	    
		<form:input path="direction" class="form-control" id="formGroupExampleInput3" placeholder="calle 123" /> 
		<form:errors path="direction" cssClass="errorFormText" />
	</div>
	
	
	<div class="form-check">
	  <input type="checkbox" class="form-check-input" id="exampleCheck1">
	  <label class="form-check-label" for="exampleCheck1">confirmar datos</label>
	</div>
	
	<button type="submit" class="btn btn-primary">Enviar</button>
</form:form> 
