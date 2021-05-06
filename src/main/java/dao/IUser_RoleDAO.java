package dao;

import entities.Role;
import entities.User;
import entities.User_Role;
import util.exception.PersistenceException;

public interface IUser_RoleDAO extends IGenericDAO<User_Role> {

	//cuando se elimina un usuario se eliminan los referencias a roles
	//o cuando se quiere elmininar todos los roles de un usuario
	void removeAllRoles(User user)throws PersistenceException;
	
	//cuando se elimina un rol se eliminan las referencias de usuarios
	void removeAllUser(Role role)throws PersistenceException;
}
