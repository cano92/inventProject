package entities;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class Role_Permit {
	
	//indica que clase compuesta es tomada como Id
	@EmbeddedId
	Role_PermitPK rolePermitPK;

	//constructores
	public Role_Permit() { }
	
	public Role_Permit(Role_PermitPK role_PermitPK) {
		this.rolePermitPK= role_PermitPK;
	}
	
	public Role_Permit(Role role, Permit permit) {
		this.rolePermitPK= new Role_PermitPK(role,permit);
	}

	//Getters Setters
	
	public Role_PermitPK getRolePermitPK() {
		return rolePermitPK;
	}

	public void setRolePermitPK(Role_PermitPK rolePermitPK) {
		this.rolePermitPK = rolePermitPK;
	}
	
}
