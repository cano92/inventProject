package entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Role {

	@Id @GeneratedValue
	long id;
	String name;
	
	// en las entities usar Set para evitar repetidos
	// Eager cuando alguien pide el rol vuelve con todos los permisos
	//@OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
//	@OneToMany(cascade={CascadeType.ALL},fetch = FetchType.EAGER)
//	List<Permit> permits=new LinkedList<Permit>();
	
	//Construct
	public Role() { }

	public Role(String name) {
		this.name = name;
	}

//	public boolean addPermit(Permit permit) {
//		//crea un nuevo objeto Role_Permit con el oermiso parametro
//		// si se crea un nuevo permit cada vez que se agrega se repiten muchos
//		
//		
//		return this.permits.add(permit);
//	}
//	
//	public boolean removePermit(Permit permit) {
//		return this.permits.remove(permit);
//	}
//	
//	public boolean findPermit(Permit per) {
//		return this.getPermits().stream().anyMatch(permit->permit.equals(per));
//	}
//	
//	public boolean findPermit(String permitName) {
//		return this.getPermits().stream().anyMatch( permit->permit.getName().equalsIgnoreCase(permitName) );
//	}
//	public List<Permit> getPermits() {
//		return permits;
//	}
//
//	public void setPermits(List<Permit> permits) {
//		this.permits = permits;
//	}
//	
	
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
}
