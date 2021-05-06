package dao.impl;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import dao.IGenderDAO;
import entities.Gender;

@Repository
@Transactional
public class GenderDAO extends GenericDAO<Gender> implements IGenderDAO{

	public GenderDAO() {
		super(Gender.class);
	}
	
}
