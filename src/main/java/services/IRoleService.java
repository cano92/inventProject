package services;

import entities.Permit;
import entities.Role;
import util.exception.ServiceException;

public interface IRoleService extends IGenericService<Role>{
	
	public boolean addPermit(Role role,Permit permit ) throws ServiceException;

	public boolean removePermit(Role role, Permit permit) throws ServiceException;
	
	public boolean removePermitAll( Role role )throws ServiceException;
	
}
