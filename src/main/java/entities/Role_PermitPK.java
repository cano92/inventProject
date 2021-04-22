package entities;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

@Embeddable
public class Role_PermitPK implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ManyToOne
	public Role roleFK;
	@ManyToOne
	public Permit permitFK;
	
	
	public Role_PermitPK() { }
	
	public Role_PermitPK(Role role, Permit permit) {
		super();
		this.roleFK = role;
		this.permitFK = permit;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((permitFK == null) ? 0 : permitFK.hashCode());
		result = prime * result + ((roleFK == null) ? 0 : roleFK.hashCode());
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
		if (permitFK == null) {
			if (other.permitFK != null)
				return false;
		} else if (!permitFK.equals(other.permitFK))
			return false;
		if (roleFK == null) {
			if (other.roleFK != null)
				return false;
		} else if (!roleFK.equals(other.roleFK))
			return false;
		return true;
	}

	public Role getRole() {
		return roleFK;
	}

	public void setRole(Role role) {
		this.roleFK = role;
	}

	public Permit getPermit() {
		return permitFK;
	}

	public void setPermit(Permit permit) {
		this.permitFK = permit;
	}

	@Override
	public String toString() {
		return "Role_PermitPK [role=" + roleFK + ", permit=" + permitFK + "]";
	}
	
	
}
