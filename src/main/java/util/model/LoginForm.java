package util.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class LoginForm {

	@NotNull(message = "Name cannot be null")
	@NotEmpty(message = "Name cannot be null")
	@Size(min=2, message = "campo requerido")
	String user;
	
	@NotNull(message = "pass cannot be null")
	@NotEmpty(message = "Name cannot be null")
	@Size(min=2, message = "campo requerido")
	String pass;

	public LoginForm() { }
	
	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	
	
}
