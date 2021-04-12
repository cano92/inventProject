package services;

import entities.Permit;

//import java.util.List;

import entities.Role;
import util.exception.ServiceException;

public interface IRoleService extends IGenericService<Role>{
	
	public boolean addPermit(Role role,Permit permit ) throws ServiceException;

}
