package entities;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Role {

	@Id @GeneratedValue
	int id;
	String name;
	String description;
	
	//el dueño de la relacion es role_Permit
	@OneToMany(mappedBy="role", cascade= {CascadeType.ALL}, fetch=FetchType.EAGER )
	Set<Role_Permit> permits=new HashSet<Role_Permit>();
	
	//Construct
	public Role() { }

	public Role(String name) {
		this.name = name;
	}
	public Role(String name,String description) {
		this.name = name;
		this.description=description;
	}
	
//	.. methods
	
	public void addPermit(Permit permit) {
		this.permits.add(new Role_Permit(this,permit));
	}
	
	public void addPermit(Role_Permit rp) {
		this.permits.add(rp);
	}
	
	public Role_Permit removePermit(Permit permit) {
		Role_Permit rolePermit = this.getRolePermit(permit);
		this.permits.remove(rolePermit);
		return rolePermit;
	}
	
	public void removeAllPermit() {
		this.permits=new HashSet<Role_Permit>();
	}
	
	public Role_Permit getRolePermit(Permit permit) {
		Optional<Role_Permit> optRP = this.permits.stream()
				.filter( rp->rp.getPermit().equals(permit) )
				.findFirst();
		return optRP.isPresent()?optRP.get():null;
	}
	
	public boolean isExistPermit(String permitName) {
		return this.permits.stream().anyMatch(rolePermit->rolePermit.getPermit().getName().equals(permitName));
	}
	
	
	@Override
	public String toString() {
		return "Role [id=" + id + ", name=" + name + "]";
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
		Role other = (Role) obj;
		if (id != other.id)
			return false;
		return true;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Role_Permit> getPermits() {
		return permits;
	}

	public void setPermits(Set<Role_Permit> permits) {
		this.permits = permits;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}


}
