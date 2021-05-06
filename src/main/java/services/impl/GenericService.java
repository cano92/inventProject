package services.impl;

import java.util.List;

//import dao.impl.GenericDAO;
import services.IGenericService;
import util.exception.PersistenceException;
import util.exception.ServiceException;


public abstract class GenericService<T> implements IGenericService<T>{

	@Override
	public List<T> getAll() throws ServiceException{
		try {
			return this.getDaoRepository().getAll();
		} catch (PersistenceException e) {
			e.printStackTrace();
			throw new ServiceException(e);
		}
	}

	@Override
	public T getByID(int id) throws ServiceException{
		try {
			return this.getDaoRepository().getByID(id);
		} catch (PersistenceException e) {
			e.printStackTrace();
			throw new ServiceException(e);
		}
	}
	
	 //se debe sobre escribir con las reglas que se necesiten
	@Override 
	public T save(T entidad) throws ServiceException{
		try {
			return this.getDaoRepository().save(entidad);
		} catch (PersistenceException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public T update(T entidad) throws ServiceException{
		try {
			return this.getDaoRepository().update(entidad);
		} catch (PersistenceException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public boolean delete(int id) throws ServiceException{
		try {
			return this.getDaoRepository().delete(id);
		} catch (PersistenceException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public boolean delete(T entidad) throws ServiceException{
		try {
			return this.getDaoRepository().delete(entidad);
		} catch (PersistenceException e) {
			throw new ServiceException(e);
		}
	}

	
}
