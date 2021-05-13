package dao.app.impl;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import dao.app.IPostDAO;
import dao.impl.GenericDAO;
import entities.app.Post;

@Repository
@Transactional
public class PostDAO extends GenericDAO<Post> implements IPostDAO {

	public PostDAO() {
		super(Post.class);
	}

}
