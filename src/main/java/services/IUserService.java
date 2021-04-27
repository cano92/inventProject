package services;

import java.util.List;

import entities.Role;
import entities.User;
import util.exception.ServiceException;

public interface IUserService extends IGenericService<User>{
	//las funciones de GenericDao se heredan
	
	public List<User> findByUsersFirtsName(String name) throws ServiceException;

	public User findByUser(String user) throws ServiceException;
	
	public List<User> getUsers(int ini,int fin) throws ServiceException;

	public void removeRole(User user, Role role) throws ServiceException;
}
