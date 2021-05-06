package entities.app;

import entities.User;

public class Post {

	int id;

	User author;

	String title;
	String description;

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
