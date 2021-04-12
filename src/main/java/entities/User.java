package entities;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class User {

	@Id @GeneratedValue
	long id;
	
	String user;
	String password;
	
	String firtsName;
	String lastName;
	int dni;
	String mail;
	//fecha de nacimiento
	LocalDate dateOfBirth;
	String gender;
	//por defeault en OneToOne es EAGER se usa LAZY porque no es necesario que el rol y la lista de permisos vengan siempre
	@OneToOne(fetch=FetchType.LAZY, cascade= {CascadeType.ALL})
	Role role;
	

	
	//constructor
	public User() { }

	public User(String user, String password, String firtsName, String lastName, int dni, String mail,
			LocalDate dateOfBirth, Role role) {
		super();
		this.user = user;
		this.password = password;
		this.firtsName = firtsName;
		this.lastName = lastName;
		this.dni = dni;
		this.mail = mail;
		this.dateOfBirth = dateOfBirth;
		this.role= role;
	}


	public User(String firtsName, String lastName, int dni, LocalDate dateOfBirth) {
		super();
		this.firtsName = firtsName;
		this.lastName = lastName;
		this.dni = dni;
		this.dateOfBirth = dateOfBirth;
	}


	@Override
	public String toString() {
		return "User [id=" + id + ", user=" + user + ", password=" + password + ", firtsName=" + firtsName
				+ ", lastName=" + lastName + ", dateOfBirth=" + dateOfBirth + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (id != other.id)
			return false;
		return true;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

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

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Role getRole() {
		return role;
	}
	
	public void setRole(Role role) {
		this.role = role;
	}
	
}
