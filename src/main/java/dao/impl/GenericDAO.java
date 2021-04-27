package dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import dao.IGenericDAO;
import util.exception.PersistenceException;

@Transactional //Indica que todos los methods internos se realizan como transacciones a la BD (JPA)
public class GenericDAO<T> implements IGenericDAO<T> {
		
	//clase del objeto que esta herendando
	protected Class<T> persistentClass;
	
	private EntityManager entityManager;

	//constructor al instanciar la clase se guarda la clase que se instancia
	public GenericDAO(Class<T> persistentClass) {
		this.setPersistentClass(persistentClass);
	}
	
	
	//retorna en String el Nombre de la clase de la variable persistentClass
	private String getEntityName() {
		return this.getPersistentClass().getSimpleName();
	}
	
	/**
	 * Busca en TablaDB si existe alguna concidencia con "findName"
	 * 
	 * se le debe indicar el nombre del atributo a buscar where
	 * el campo de la tabla en la que busca es "fieldName"
	 * */
	@Override
	public boolean isExistFieldName(String fieldName, String findName) throws PersistenceException{
		try{ //example UserHql ="from User as us where us.firtsName=:UserName";
			
			String hql="from "+this.getEntityName()+" as Entity where Entity."+fieldName+"='"+findName+"'";
	
			List<T> list=this.getEntityManager().createQuery(hql,this.getPersistentClass())
					.setMaxResults(1)
					.getResultList();
			return list.isEmpty()? false: true;
			
		}catch(Exception e) {
			throw new PersistenceException(e);
		}
	}
	
	@Override
	public T getFirstFieldName(String fieldName, String findName) throws PersistenceException {
		try{ //example UserHql ="from User as us where us.firtsName=:UserName";
			
			String hql="from "+this.getEntityName()+" as Entity where Entity."+fieldName+"='"+findName+"'";
	
			List<T> list=this.getEntityManager().createQuery(hql,this.getPersistentClass())
					.setMaxResults(1)
					.getResultList();
			return list.isEmpty()? null: list.get(0);
			
		}catch(Exception e) {
			throw new PersistenceException(e);
		}
	}
	
	@Override
	public List<T> getAllFieldName(String fieldName, String findName) throws PersistenceException{
		try{	//example UserHql ="from User as us where us.firtsName=:UserName";
			String hql="from "+this.getEntityName()+" as Entity where Entity."+fieldName+"='"+findName+"'";
	
			return this.getEntityManager().createQuery(hql,this.getPersistentClass()).getResultList();
			
		}catch(Exception e) {
			throw new PersistenceException(e);
		}
	}
	
	@Override
	public List<T> getAll() throws PersistenceException{
		try{ //consulta HQL + string Nombre de la entity class
			String hql="from "+this.getEntityName();  //"from EntityClass"
			return this.getEntityManager().createQuery(hql,this.getPersistentClass()).getResultList();
		}catch(Exception e) {
			throw new PersistenceException(e);
		}
	}

	@Override
	public T getByID(long id) throws PersistenceException{
		try{ //retorna null si el ID no existe
			if(id > 0) //cuando Id es menor a cero falla
				return this.getEntityManager().find(this.getPersistentClass(), id);
			else
				return null;
		}catch(Exception e) {
			throw new PersistenceException(e);
		}
	}

	@Override
	public T save(T entidad) throws PersistenceException{
		try {			
			this.getEntityManager().persist(entidad);
			return entidad; // entidad retorna con ID generado tras el persist
		}catch(Exception e) {
			throw new PersistenceException(e);
		}
	}

	@Override
	public T update(T entidad) throws PersistenceException{
		try{
			return this.getEntityManager().merge(entidad);
		}catch(Exception e) {
			throw new PersistenceException(e);
		}
	}

	@Override
	public boolean delete(long id) throws PersistenceException{
		try{			
			T entidad = this.getByID(id);
			
			if (entidad != null) {
				return this.delete(entidad);
			}else { return false; }
		}catch(Exception e) {
			throw new PersistenceException(e);
		}
	}

	@Override
	public boolean delete(T entidad) throws PersistenceException{
		try {
			if(!this.getEntityManager().contains(entidad))
				this.getEntityManager().remove( this.update(entidad) );
			else
				this.getEntityManager().remove(entidad);
			return true;
		}catch(Exception e) {
			throw new PersistenceException(e);
		}
	}
	
	
	
	//****** GETTERS  AND SETTERS...
	
	@PersistenceContext //inyecta el EntityMAnager por set Definido en el archivo de confg
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	public EntityManager getEntityManager() {
		return entityManager;
	}

	public Class<T> getPersistentClass() {
		return persistentClass;
	}

	public void setPersistentClass(Class<T> persistentClass) {
		this.persistentClass = persistentClass;
	}

	
}
