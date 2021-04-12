package services.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.IUserDAO;
import dao.impl.GenericDAO;
import entities.User;
import services.IUserService;
import util.exception.PersistenceException;
import util.exception.ServiceException;


@Service
public class UserService extends GenericService<User> implements IUserService {

	@Autowired
	private IUserDAO userDAO;
	
	@Override
	@SuppressWarnings("unchecked")
	public GenericDAO<User> getDaoRepository() {	
		return (GenericDAO<User>) this.userDAO;
	}
	
	//>>>> add servicios no genericos
	
	@Override
	public List<User> findByUserName(String name) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User findByUser(String user)throws ServiceException {
		try {
			return this.userDAO.findByUser(user);
		} catch (PersistenceException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public List<User> getUsers(int ini, int fin)throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User save(User entidad) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}
	

}
