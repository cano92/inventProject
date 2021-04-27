package dao.impl;

import org.springframework.stereotype.Repository;

import dao.IRoleDAO;
import entities.Role;

@Repository
public class RoleDAO extends GenericDAO<Role> implements IRoleDAO{

	public RoleDAO() {
		super(Role.class);
	}
	
	//consultas hql o criteria

	//agregar un permiso al Rol
	
	
	
}
