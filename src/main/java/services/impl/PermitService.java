package services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.IPermitDAO;
import dao.IRole_PermitDAO;
import dao.impl.GenericDAO;
import entities.Permit;
import services.IPermitService;
import util.exception.PersistenceException;
import util.exception.ServiceException;

@Service
public class PermitService extends GenericService<Permit> implements IPermitService{

	@Autowired
	private IPermitDAO permitDao;
	@Autowired
	private IRole_PermitDAO role_permitDao;

	@SuppressWarnings("unchecked")
	@Override
	public GenericDAO<Permit> getDaoRepository() {
		return (GenericDAO<Permit>) this.permitDao;
	}

	@Override
	public Permit save(Permit entidad) throws ServiceException {
		//no debe haber dos permisos con el mismo nombre
		try { //busca si ya existe algun objeto con el nombre
			boolean exitName=this.permitDao.isExistFieldName("name", entidad.getName());
			if( !exitName)
				return this.permitDao.save(entidad);
			return null;
		} catch (PersistenceException e) {
			throw new ServiceException(e);
		}
	}
	
	@Override
	public boolean delete(Permit permit) throws ServiceException{
		
		try { //elimina el permit y todas las referencias al permits
			this.role_permitDao.removeAllRole(permit);
			super.delete(permit);
		} catch (PersistenceException e) {
			throw new ServiceException(e);
		}
		return true;
	}
	
}
