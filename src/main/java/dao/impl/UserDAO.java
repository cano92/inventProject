package dao.impl;

import java.util.List;

import javax.persistence.NoResultException;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import dao.IUserDAO;
import entities.User;
import util.exception.PersistenceException;

@Repository
@Transactional
public class UserDAO  extends GenericDAO<User> implements IUserDAO    {

	//el construcctor debe ir sin argumentos para que spring lo maneje
	public UserDAO() {
		super(User.class);
	}

	
//**** Consultas con HQL
	
	@Override
	public List<User> findByName(String name) throws PersistenceException{
		try{						
			String hql="from User as user where user.firtsName=:UserName";
			
			//paso a paso
//			Query query=this.getEntityManager().createQuery(hql);
//			query.setParameter("UserName",name);
//			return query.getResultList();
			return this.getEntityManager().createQuery(hql, User.class).setParameter("UserName",name).getResultList();
		
		}catch(Exception e) {
			throw new PersistenceException(e);
		}
	}

	@Override
	public User findByUser(String name) throws PersistenceException {
		try{
			String hql="from User as us where us.user=:UserName";
			return this.getEntityManager().createQuery(hql, User.class).setParameter("UserName",name).getSingleResult();
		}catch(NoResultException e) {
			System.out.println("el User Buscado no se encuentra registrado");
			return null;	 
		}catch(Exception e) {
			throw new PersistenceException(e);
		}
	}
	
	public User findByUser2(String name) throws PersistenceException {
		try{	//tambien se puede armar la consulta concatenando String
			String hql="from User as us where us.user='"+name+"'";
			//se le indica la User.class para que el objeto de la consulta sea casteada
			return this.getEntityManager().createQuery(hql, User.class).getSingleResult();
		}catch(Exception e) {
			throw new PersistenceException(e);
		}
	}
	
	@Override
	public List<User> getUsers(int ini,int fin) throws PersistenceException{
		try{
			String hql="from User";
			return this.getEntityManager().createQuery(hql, User.class).setFirstResult(ini).setMaxResults(fin).getResultList();
		}catch(Exception e) {
			throw new PersistenceException(e);
		}
	}
	
	//consultas Criteria
	

}
