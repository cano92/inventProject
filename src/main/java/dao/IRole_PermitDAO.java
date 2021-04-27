package dao;

import entities.Role_Permit;
import util.exception.PersistenceException;

public interface IRole_PermitDAO extends IGenericDAO<Role_Permit> {

	
//	boolean findNewRolePermitExist(Role role,Permit permit) throws PersistenceException;
	boolean removeAllPermit(int roleId) throws PersistenceException;
}
