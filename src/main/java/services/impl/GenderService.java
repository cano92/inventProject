package services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.IGenderDAO;
import dao.impl.GenericDAO;
import entities.Gender;
import services.IGenderService;
import util.exception.PersistenceException;
import util.exception.ServiceException;

@Service
public class GenderService extends GenericService<Gender> implements IGenderService{

	@Autowired
	private IGenderDAO genderDao;
	
	@SuppressWarnings("unchecked")
	@Override
	public GenericDAO<Gender> getDaoRepository() {
		return (GenericDAO<Gender>) this.genderDao;
	}

	@Override
	public Gender save(Gender gender)throws ServiceException {
		try {
			boolean exitName=this.genderDao.isExistFieldName("name", gender.getName());
			if( !exitName)
				return this.genderDao.save(gender);
			return null;
		} catch (PersistenceException e) {
			throw new ServiceException(e);
		}
	}
	
	
}
