package services;

import entities.Permit;
import entities.Role;
import util.exception.ServiceException;

public interface IRoleService extends IGenericService<Role>{
	
	public Role addPermit(Role role,Permit permit ) throws ServiceException;

	public Role removePermit(Role role, Permit permit) throws ServiceException;
	
	public Role removeAllPermit( Role role )throws ServiceException;
	
}
