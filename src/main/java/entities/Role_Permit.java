package entities;

import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

@Entity
public class Role_Permit {
	
	//indica que clase compuesta es tomada como Id
	@EmbeddedId
	Role_PermitPK rolePermitPK;
	
	@ManyToOne
	@MapsId("permitFK")
	//@JoinColumn(name="PermitFK")
	Permit permit;
	
	//no lleva cascade remove para no eliminar el rol cuando se elimina un rol_permit
	@ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE})
	@MapsId("roleFK")
	Role role;

	//constructores
	public Role_Permit() { }
	
	public Role_Permit(Role_PermitPK role_PermitPK) {
		this.rolePermitPK= role_PermitPK;
	}
	
	public Role_Permit(Role role, Permit permit) {
		this.rolePermitPK= new Role_PermitPK(role.getId(), permit.getId());
		this.permit=permit;
		this.role=role;
	}

	//Getters Setters
	
	public Role_PermitPK getRolePermitPK() {
		return rolePermitPK;
	}

	public void setRolePermitPK(Role_PermitPK rolePermitPK) {
		this.rolePermitPK = rolePermitPK;
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
		result = prime * result + ((rolePermitPK == null) ? 0 : rolePermitPK.hashCode());
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
		if (rolePermitPK == null) {
			if (other.rolePermitPK != null)
				return false;
		} else if (!rolePermitPK.equals(other.rolePermitPK))
			return false;
		return true;
	}
	
}
