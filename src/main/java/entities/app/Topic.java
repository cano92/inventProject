package entities.app;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Topic {
	@Id @GeneratedValue
	int id;
	String name;
	
//	Contruct
	
	public Topic() {}
	
	public Topic(String name) {
		this.name=name;
	}

//	Getts and Setts
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
	
	
}
