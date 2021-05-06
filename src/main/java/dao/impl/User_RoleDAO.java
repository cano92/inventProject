package dao.impl;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import dao.IUser_RoleDAO;
import entities.Role;
import entities.User;
import entities.User_Role;
import util.exception.PersistenceException;

@Repository
@Transactional
public class User_RoleDAO extends GenericDAO<User_Role> implements IUser_RoleDAO {

	public User_RoleDAO() {
		super(User_Role.class);
	}

	@Override
	public void removeAllRoles(User user) throws PersistenceException {
		String hql="DELETE FROM User_Role as ur WHERE ur.user=:AUser";
		//los delets requieren un query simple, no necesitan indicar class
		this.getEntityManager().createQuery(hql) 
				.setParameter("AUser",user)
				.executeUpdate();
	}

	@Override
	public void removeAllUser(Role role) throws PersistenceException {
		String hql="DELETE FROM User_Role as ur WHERE ur.role=:role";
		this.getEntityManager().createQuery(hql)
		.setParameter("role",role)
		.executeUpdate();
	}
	
	
}
