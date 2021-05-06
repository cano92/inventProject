package services.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.IUserDAO;
import dao.IUser_RoleDAO;
import dao.impl.GenericDAO;
import entities.Role;
import entities.User;
import entities.User_Role;
import services.IUserService;
import util.exception.PersistenceException;
import util.exception.ServiceException;


@Service
public class UserService extends GenericService<User> implements IUserService {

	@Autowired
	private IUserDAO userDAO;
	
	@Autowired
	private IUser_RoleDAO userRoleDAO;
	
	@Override
	@SuppressWarnings("unchecked")
	public GenericDAO<User> getDaoRepository() {	
		return (GenericDAO<User>) this.userDAO;
	}
	
	//>>>> add servicios no genericos
	
	public User addRole(User user, Role role ) throws ServiceException{
		try { // si el Rol no existe lo crea por el cascade
			user.addRole(role);
			return this.userDAO.update(user);
		} catch (PersistenceException e) {
			throw new ServiceException(e);
		}
	}
	
	@Override
	public List<User> findByFirtsName(String name) throws ServiceException {
		try {
			return this.userDAO.getAllFieldName("firtsName", name);
		} catch (PersistenceException e) {
			throw new ServiceException(e);
		}
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
	public User save(User entidad) throws ServiceException {
		try {		//no se puede guardar usuarios repetidos 
			boolean exist = this.userDAO.isExistFieldName("user", entidad.getUser());
			if(!exist)
				return this.userDAO.save(entidad);
			return null;
		} catch (PersistenceException e) {
			throw new ServiceException(e);
		}
	}
	
	@Override
	public void removeRole(User user, Role role) throws ServiceException {
		try {	
			User_Role userRole = user.removeRole(role);
			
			this.userRoleDAO.delete( userRole );
		} catch (PersistenceException e) {
			throw new ServiceException(e);
		}
	}
	
	@Override
	public List<User> getUsers(int ini, int fin)throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	// remove all roles..  en una consulta hql para no borrar cada rol uno por uno
	@Override
	public void removeAllRoles(User user) throws ServiceException{
		try { //user remove roles
			user.removeAllRoles();
			this.userRoleDAO.removeAllRoles(user);
		} catch (PersistenceException e) {
			throw new ServiceException(e);
		}
	}

}
