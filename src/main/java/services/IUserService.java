package services;

import java.util.List;

import entities.Role;
import entities.User;
import util.exception.ServiceException;

public interface IUserService extends IGenericService<User>{
	//las funciones de GenericDao se heredan
	
	public User login(String user, String pass) throws ServiceException;
	
	public List<User> findByFirtsName(String name) throws ServiceException;

	public User findByUser(String user) throws ServiceException;
	
	public List<User> getUsers(int ini,int fin) throws ServiceException;

	public void removeRole(User user, Role role) throws ServiceException;
	
	public void removeAllRoles(User user) throws ServiceException;
	
	public boolean isExistMail(String mail)throws ServiceException;
	
	public boolean isExistUser(String user)throws ServiceException;
	
}
