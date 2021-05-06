package dao;

import entities.Permit;
import entities.Role;
import entities.Role_Permit;
import util.exception.PersistenceException;

public interface IRole_PermitDAO extends IGenericDAO<Role_Permit> {

	//elimina todas las referecias a permisos del rol
	void removeAllPermit(Role role) throws PersistenceException;
	
	//elimina todas las referencias a Role del permit
	void removeAllRole(Permit permit) throws PersistenceException;

}
