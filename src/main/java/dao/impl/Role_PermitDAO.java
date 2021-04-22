package dao.impl;


import org.springframework.stereotype.Repository;

import dao.IRole_PermitDAO;
import entities.Role_Permit;

@Repository
public class Role_PermitDAO extends GenericDAO<Role_Permit> implements IRole_PermitDAO {

	public Role_PermitDAO() {
		super(Role_Permit.class);
	}

//	@Override
//	public boolean findNewRolePermitExist(Role role,Permit permit) throws PersistenceException {
//
//		String hql="from Role_Permit as rp where rp.role=:fRole and rp.permit=:fPermit";
//		List<Role_Permit> result= this.getEntityManager().createQuery(hql, Role_Permit.class)
//				.setParameter("fRole",role)
//				.setParameter("fPermit",permit)
//				.setMaxResults(1) //busca solo uno porque si hay uno, no hace falta seguir buscando
//				.getResultList();
//		if(result.size() == 0) return false;
//		return true;
//	}
	
	
	
	
}
