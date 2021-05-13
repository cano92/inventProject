package services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.app.IPostDAO;
import dao.impl.GenericDAO;
import entities.app.Post;
import services.IPostService;

@Service
public class PostService extends GenericService<Post> implements IPostService {

	@Autowired
	private IPostDAO postDao;
	
	@SuppressWarnings("unchecked")
	@Override
	public GenericDAO<Post> getDaoRepository() {
		return (GenericDAO<Post>) this.postDao;
	}

	
}
