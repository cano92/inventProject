package entities.app;

public class Topic {

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
