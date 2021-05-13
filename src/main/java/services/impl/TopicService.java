package services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.app.ITopicDAO;
import dao.impl.GenericDAO;
import entities.app.Topic;
import services.ITopicService;

@Service
public class TopicService  extends GenericService<Topic> implements ITopicService{

	@Autowired
	private ITopicDAO topicDao;
	
	@SuppressWarnings("unchecked")
	@Override
	public GenericDAO<Topic> getDaoRepository() {
		return (GenericDAO<Topic>) this.topicDao;
	}



}
