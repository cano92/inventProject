package entities;

import javax.persistence.CascadeType;
//import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Role_Permit {

	@Id @GeneratedValue
	int id;
	
	@ManyToOne
	Permit permit;
	
//	@ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE})
	@ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE})
	Role role;

//	.. Construct
	public Role_Permit() { }
	
	public Role_Permit(Role role, Permit permit) {
		this.role=role;
		this.permit=permit;
	}

	
//	.. Getts and Setts
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Permit getPermit() {
		return permit;
	}

	public void setPermit(Permit permit) {
		this.permit = permit;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((permit == null) ? 0 : permit.hashCode());
		result = prime * result + ((role == null) ? 0 : role.hashCode());
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
		Role_Permit other = (Role_Permit) obj;
		if (permit == null) {
			if (other.permit != null)
				return false;
		} else if (!permit.equals(other.permit))
			return false;
		if (role == null) {
			if (other.role != null)
				return false;
		} else if (!role.equals(other.role))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Role_Permit [id=" + id + ", permit=" + permit + ", role=" + role + "]";
	}
	
}
