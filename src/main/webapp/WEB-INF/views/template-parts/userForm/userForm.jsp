<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 


<form >
	<div class="row">
		<div class="form-group col-md">
	    	<label for="formGroupExampleInput">Nombre</label>
	    	<input type="text" class="form-control" id="formGroupExampleInput" placeholder="Example input">
	  	</div>
	
		<div class="form-group col-md">
	    	<label for="formGroupExampleInput2">Apellido</label>
	    	<input type="text" class="form-control" id="formGroupExampleInput2" placeholder="Example input">
	  	</div>	
	</div>
	
	<div class="row">
		<div class="form-group col-md">
	    	<label for="formGroupExampleInput3">User</label>
	    	<input type="text" class="form-control" id="formGroupExampleInput3" placeholder="Example input" required >
	  	</div>
		<div class="form-group col-md">
	    	<label for="formGroupExampleInput4">DNI</label>
	    	<input type="number" min="0" class="form-control" id="formGroupExampleInput4" placeholder="Example input" required >
	  	</div>	
	</div>
  
  
	<div class="form-group">
	  <label for="exampleInputEmail1">Email address</label>
	  <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter email">
	  <small id="emailHelp" class="form-text text-muted">example@domain.com.</small>
	</div>
	<div class="form-group">
	  <label for="exampleInputPassword1">Password</label>
	  <input type="password" class="form-control" id="exampleInputPassword1" placeholder="Password">
	</div>
	
	<div class="row">
		<div class="form-group col-md">
	    	<label for="inputState">Genero</label>
		     <select id="inputState" class="form-control">
		       <option selected>..</option>
		       <option value="1">masculino</option>
		       <option value="2">femenino</option>
		     </select>
	  	</div>

		<div class="form-group col-md">
	    	<label for="example-date-input">FechaNac</label>
	    	<input class="form-control" type="date" value="1900-05-19" id="example-date-input">
	  	</div>	
	</div>
	
	<div class="form-group">
	    <label for="formGroupExampleInput3">Direccion</label>
	    <input type="text" class="form-control" id="formGroupExampleInput3" placeholder="Example input" required >
	</div>
	
	<div class="form-check">
	  <input type="checkbox" class="form-check-input" id="exampleCheck1">
	  <label class="form-check-label" for="exampleCheck1">Check me out</label>
	</div>
	
	<button type="submit" class="btn btn-primary">Submit</button>
</form>
