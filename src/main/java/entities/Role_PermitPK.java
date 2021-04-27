package entities;

import java.io.Serializable;

//import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Role_PermitPK implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public int roleFK;
	//@Column(name="PermitFK")
	public int permitFK;
	
	public Role_PermitPK() {}
	
	public Role_PermitPK(int roleFK, int permitFK) {
		super();
		this.roleFK = roleFK;
		this.permitFK = permitFK;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + permitFK;
		result = prime * result + roleFK;
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
		Role_PermitPK other = (Role_PermitPK) obj;
		if (permitFK != other.permitFK)
			return false;
		if (roleFK != other.roleFK)
			return false;
		return true;
	}
	
	public int getRoleFK() {
		return roleFK;
	}
	public void setRoleFK(int roleFK) {
		this.roleFK = roleFK;
	}
	public int getPermitFK() {
		return permitFK;
	}
	public void setPermitFK(int permitFK) {
		this.permitFK = permitFK;
	}
	@Override
	public String toString() {
		return "Role_PermitPK [roleFK=" + roleFK + ", permitFK=" + permitFK + "]";
	}
	

	
}
