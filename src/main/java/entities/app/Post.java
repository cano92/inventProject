package entities.app;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import entities.User;

@Entity
public class Post {
	@Id @GeneratedValue
	int id;

	@OneToOne
	User author;

	String title;
	String description;

	@OneToOne
	Topic topic;

//	Constructs
	public Post() {}
	
	public Post(User author, String title, String description, Topic topic) {
		super();
		this.author = author;
		this.title = title;
		this.description = description;
		this.topic = topic;
	}

//	Getts and Setts
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getAuthor() {
		return author;
	}

	public void setAuthor(User author) {
		this.author = author;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Topic getTopic() {
		return topic;
	}

	public void setTopic(Topic topic) {
		this.topic = topic;
	}

}
