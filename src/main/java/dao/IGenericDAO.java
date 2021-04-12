package dao;

import java.util.List;

import util.exception.PersistenceException;

public interface IGenericDAO<T> {

	List<T> getAll() throws PersistenceException;
	
	T getByID(long id) throws PersistenceException;
	
	T save(T entidad) throws PersistenceException;
	
	T update(T entidad) throws PersistenceException;
	
	boolean delete( long id ) throws PersistenceException;
	
	boolean delete( T entidad ) throws PersistenceException;
	
	/**
	 *  ajaja
	 *  */
	boolean isExistFieldName(String fieldName, String findName) throws PersistenceException;


}
