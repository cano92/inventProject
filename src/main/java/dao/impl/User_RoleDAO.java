package dao.impl;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import dao.IUser_RoleDAO;
import entities.User_Role;

@Repository
@Transactional
public class User_RoleDAO extends GenericDAO<User_Role> implements IUser_RoleDAO {

	public User_RoleDAO() {
		super(User_Role.class);
	}
	
}
