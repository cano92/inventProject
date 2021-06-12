package dao;

import java.util.List;

import entities.User;
import util.exception.PersistenceException;

public interface IUserDAO extends IGenericDAO<User> {

	//agregar funciones adicionales que no se heredan
	
	public User login(String user, String pass) throws PersistenceException;
	
	List<User> findByName(String name) throws PersistenceException;
	
	User findByUser(String user) throws PersistenceException;
	
	//pagination
	List<User> getUsers(int ini,int fin) throws PersistenceException;
}
