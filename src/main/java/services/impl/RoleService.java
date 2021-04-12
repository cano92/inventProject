package services.impl;

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
	public boolean addPermit(Role role, Permit permit)  throws ServiceException{
		try {
			if(role != null && permit != null ) {
				//revisa que los dos ya existen en BD
				Permit fPermit=this.permitDao.getByID(permit.getId());
				Role fRole=this.roleDao.getByID(role.getId());
				if( fRole != null && fPermit != null ){
					//revisa que no exita en la BD para No repetir para insertarlos
					if(!this.role_permitDao.findNewRolePermitExist(role, permit))
						this.role_permitDao.save(new Role_Permit(role, permit));
					return true;
				}
			}
			return false;
		} catch (PersistenceException e) {
			throw new ServiceException(e); 
		}
	}

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
	
	

	
	
}
