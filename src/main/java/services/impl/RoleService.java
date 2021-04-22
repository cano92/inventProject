package services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.IPermitDAO;
import dao.IRoleDAO;
import dao.IRole_PermitDAO;
import dao.impl.GenericDAO;
import entities.Permit;
import entities.Role;
import entities.Role_Permit;
import services.IRoleService;
import util.exception.PersistenceException;
import util.exception.ServiceException;

@Service
public class RoleService extends GenericService<Role> implements IRoleService {

	@Autowired
	private IRoleDAO roleDao;
	@Autowired
	private IPermitDAO permitDao;
	@Autowired
	private IRole_PermitDAO role_permitDao;
	
	@Override
	@SuppressWarnings("unchecked")
	public GenericDAO<Role> getDaoRepository() {	
		return (GenericDAO<Role>) this.roleDao;
	}
	
	//>>>> add servicios no genericos
	@Override
	public Role save(Role entidad) throws ServiceException {
		try {// no debe haber dos roles con el mismo nombre
			boolean existRole=this.roleDao.isExistFieldName("name", entidad.getName());
			if(!existRole )
				return this.roleDao.save(entidad);
			else
				return entidad;
		} catch (PersistenceException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public boolean addPermit(Role role, Permit permit)  throws ServiceException{
		try { // nose duplican por la clave primary compuesta.. pero produce error usar save porque intenta insertar una nuevo registro duplicando el id
			this.role_permitDao.update( new Role_Permit(role,permit) );
			return true;
		} catch (PersistenceException e) {
			throw new ServiceException(e); 
		}
	}	
	
	@Override
	public boolean removePermit(Role role, Permit permit) throws ServiceException{
		try {
			this.role_permitDao.delete(new Role_Permit(role,permit));
			return true;
		} catch (PersistenceException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public boolean removePermitAll(Role role) throws ServiceException {
		
		this.getPermitAll(role).forEach((perm)->{
			try {
				this.removePermit(role, perm);
			} catch (ServiceException e) {
				e.printStackTrace();
			}
		});
		return true;
	}

	@Override
	public List<Permit> getPermitAll(Role role) throws ServiceException {
		// TODO Auto-generated method stub
		
		return null;
	}

	@Override
	public boolean findPermit(Role role, Permit permit) throws ServiceException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean findPermit(Role role, String permitName) throws ServiceException {
		// TODO Auto-generated method stub
		return false;
	}
	
	
}
