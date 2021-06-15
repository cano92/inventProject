package util.model;

import java.time.LocalDate;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import util.customValidation.MailNotRepeat;
import util.customValidation.UserNameNotRepeat;

public class UserForm {

	@NotBlank
	@Size(min=3, message = "*debe tener 3 o mas caracteres")
	@UserNameNotRepeat	//custom Validation
	String user;
	
	@NotBlank
	@Size(min=3, message = "*debe tener 3 o mas caracteres")
	String password;

	@NotBlank
	@Size(min=3, message = "*debe tener 3 o mas caracteres")
	String firtsName;
	
	@NotBlank
	@Size(min=3, message = "*debe tener 3 o mas caracteres")
	String lastName;
	
	@Positive
	int dni;
	
	@Email
	@MailNotRepeat //custom Validation
	String mail;
	
	String direction;
	
	//importante para que la fecha sea Parseada correctamente se debe usar la anotacion @DateTimeFormat
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Past //valida que la fecha sea del pasado
	LocalDate dateOfBirth;
	
	@Positive
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

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}
//	public Optional<@Past LocalDate> getDateOfBirth() {
//	    return Optional.of(dateOfBirth);
//	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public int getGenderId() {
		return genderId;
	}

	public void setGenderId(int genderId) {
		this.genderId = genderId;
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}
	
	
	
}
