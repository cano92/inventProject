package dao.impl;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import dao.IRoleDAO;
import entities.Role;

@Repository
@Transactional
public class RoleDAO extends GenericDAO<Role> implements IRoleDAO{

	public RoleDAO() {
		super(Role.class);
	}
	
	//consultas hql o criteria

	//agregar un permiso al Rol
	
	
	
}
