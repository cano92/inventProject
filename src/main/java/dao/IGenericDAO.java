package dao;

import java.util.List;

import util.exception.PersistenceException;

public interface IGenericDAO<T> {

	List<T> getAll() throws PersistenceException;
	
	T getByID(int id) throws PersistenceException;
	
	T save(T entidad) throws PersistenceException;
	
	T update(T entidad) throws PersistenceException;
	
	boolean delete( int id ) throws PersistenceException;
	
	boolean delete( T entidad ) throws PersistenceException;
	
	/**
	 *  extra..
	 *  */
	boolean isExistFieldName(String fieldName, String findName) throws PersistenceException;

	T getFirstFieldName(String fieldName, String findName) throws PersistenceException;
	
	List<T> getAllFieldName(String fieldName, String findName) throws PersistenceException;

}
