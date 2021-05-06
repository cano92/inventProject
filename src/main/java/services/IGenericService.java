package services;

import java.util.List;

import dao.impl.GenericDAO;
import util.exception.ServiceException;

public interface IGenericService<T> {

	List<T> getAll() throws ServiceException ;
	
	T getByID(int id) throws ServiceException;
	
	T save(T entidad) throws ServiceException;
	
	T update(T entidad) throws ServiceException;
	
	boolean delete( int id ) throws ServiceException;
	
	boolean delete( T entidad ) throws ServiceException;
	
	//debe retornar el dao reposutorio Actual
	GenericDAO<T> getDaoRepository();
	
}
