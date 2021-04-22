package entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Role {

	@Id @GeneratedValue
	long id;
	String name;
	
	@OneToMany()
	List<Role_Permit> permits;
	
	//Construct
	public Role() { }

	public Role(String name) {
		this.name = name;
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

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Role_Permit> getPermits() {
		return permits;
	}

	public void setPermits(List<Role_Permit> permits) {
		this.permits = permits;
	}



}
