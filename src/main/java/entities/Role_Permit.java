package entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Role_Permit {
	
	@Id @GeneratedValue
	int id;
	
	//config si un rol se borra todas sus referencias tambien y lo mismo si un permit se borra
	@OneToOne
	public Role role;
	@OneToOne
	public Permit permit;
	
	public Role_Permit() { }
	
	public Role_Permit(Role role,Permit permit) {
		this.permit=permit;
		this.role=role;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Permit getPermit() {
		return permit;
	}

	public void setPermit(Permit permit) {
		this.permit = permit;
	}
	
	
}
