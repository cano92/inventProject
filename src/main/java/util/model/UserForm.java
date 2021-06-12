package util.model;

import java.time.LocalDate;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import javax.validation.constraints.Positive;

public class UserForm {

	@NotBlank
	String user;
	
	@NotBlank
	String password;

	@NotBlank
	String firtsName;
	
	@NotBlank
	String lastName;
	
	@NotBlank
	@Positive
	int dni;
	
	@NotBlank
	@Email 
	String mail;
	
	@NotBlank
	@Past //valida que la fecha sea del pasado
	LocalDate dateOfBirth;
	
	@NotBlank
	int genderId; //id de genero registrado
	
	
	public UserForm(){ }
	
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirtsName() {
		return firtsName;
	}
	public void setFirtsName(String firtsName) {
		this.firtsName = firtsName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getDni() {
		return dni;
	}
	public void setDni(int dni) {
		this.dni = dni;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	
}
