package services;

import java.util.List;

import entities.Permit;

//import java.util.List;

import entities.Role;
import util.exception.ServiceException;

public interface IRoleService extends IGenericService<Role>{
	
	public boolean addPermit(Role role,Permit permit ) throws ServiceException;

	public boolean removePermit(Role role, Permit permit) throws ServiceException;
	
	public boolean removePermitAll( Role role )throws ServiceException;
	
	public List<Permit> getPermitAll(Role role)throws ServiceException;
	
	public boolean findPermit(Role role,Permit permit )throws ServiceException;
	
	public boolean findPermit(Role role, String permitName )throws ServiceException;
	
}
