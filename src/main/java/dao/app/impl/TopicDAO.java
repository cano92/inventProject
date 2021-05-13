package dao.app.impl;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import dao.app.ITopicDAO;
import dao.impl.GenericDAO;
import entities.app.Topic;

@Repository
@Transactional
public class TopicDAO extends GenericDAO<Topic> implements ITopicDAO{

	public TopicDAO( ) {
		super(Topic.class);
	}

}
