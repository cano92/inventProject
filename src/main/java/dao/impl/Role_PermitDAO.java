package dao.impl;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import dao.IRole_PermitDAO;
import entities.Permit;
import entities.Role;
import entities.Role_Permit;
import util.exception.PersistenceException;

@Repository
@Transactional
public class Role_PermitDAO extends GenericDAO<Role_Permit> implements IRole_PermitDAO {

	public Role_PermitDAO() {
		super(Role_Permit.class);
	}

//	methods
	@Override
	public void removeAllPermit(Role role) throws PersistenceException {
		
//		String hql="DELETE FROM Role_Permit as rp WHERE rp.role_id = :role_id";
		String hql="DELETE FROM Role_Permit as rp WHERE rp.role = :role";
		
		this.getEntityManager().createQuery(hql)
		.setParameter("role", role)
		.executeUpdate();
	}

	@Override
	public void removeAllRole(Permit permit) throws PersistenceException {
		String hql="DELETE FROM Role_Permit as rp WHERE rp.permit = :permit";
		
		this.getEntityManager().createQuery(hql)
		.setParameter("permit", permit)
		.executeUpdate();
	}


}
