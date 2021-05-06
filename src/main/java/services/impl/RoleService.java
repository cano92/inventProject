package services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.IRoleDAO;
import dao.IRole_PermitDAO;
import dao.IUser_RoleDAO;
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
	private IRole_PermitDAO role_permitDao;
	@Autowired
	private IUser_RoleDAO user_roleDao;
	
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
				return null;
		} catch (PersistenceException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public Role addPermit(Role role, Permit permit)  throws ServiceException{
		try { // nose duplican por la clave primary compuesta.. pero produce error usar save porque intenta insertar una nuevo registro duplicando el id
			role.addPermit(permit);
			return this.roleDao.update(role); 
			
		} catch (PersistenceException e) {
			throw new ServiceException(e); 
		}
	}	
	
	@Override
	public Role removePermit(Role role, Permit permit) throws ServiceException{
		try { //buscar permit porque si se crea un nuevo obj se duplica y hibernate rompe
			Role_Permit rolePermit = role.removePermit(permit);
			 this.role_permitDao.delete(rolePermit);
			 
			return this.roleDao.getByID(role.getId()); //actualiza la ref de la entity
		} catch (PersistenceException e) {
			throw new ServiceException(e);
		}
	}
	
	
	public boolean removePermit(Role_Permit rp) throws ServiceException{
		try { //Tener en cuenta que Role ya no debe tener en su collecion de "permits" el parametro o se actuliza
			this.role_permitDao.delete(rp);
			return true;
		} catch (PersistenceException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public Role removeAllPermit(Role role) throws ServiceException {
		// en vez de eliminar una por una toda lista llamar a un hql que elimine todo
		try {
			this.role_permitDao.removeAllPermit(role);
			
			return this.roleDao.getByID(role.getId());
		} catch (PersistenceException e) {
			throw new ServiceException(e);
		}
	}

	//remove role
	@Override
	public boolean delete(Role role) throws ServiceException{
		try {//eliminar referencias de user a rol
			this.user_roleDao.removeAllUser(role);
			super.delete(role);
			return true;
		} catch (PersistenceException e) {
			throw new ServiceException(e);
		}
	}
	
}
