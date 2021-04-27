package controllers;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import entities.Permit;
import entities.Role;
import entities.User;
import services.IPermitService;
import services.IRoleService;
import services.IUserService;
import util.exception.ServiceException;

@Controller
@RequestMapping(value = "/user")
public class UserController {

	@Autowired
	private IUserService userService;
	@Autowired
	private IRoleService roleService;
	@Autowired
	private IPermitService permitService;

	@RequestMapping(value = "/ini", method = RequestMethod.GET)
	public String showHome(Model model) {
		try {
//new Permit			 no debe repetir el mismo Permiso
			Permit show = permitService.save(new Permit("product_show"));
			permitService.save(new Permit("product_show"));
			
			Permit nuevo = permitService.save(new Permit("product_new"));
			Permit delete = permitService.save(new Permit("product_delete"));
			Permit update = permitService.save(new Permit("product_update"));
			Permit buy = permitService.save(new Permit("product_buy"));
			Permit sale = permitService.save(new Permit("product_sale"));

//new Roles			 no debe repetirse el mismo Rol
			Role dueño = this.roleService.save(new Role("dueño"));
			this.roleService.save(new Role("dueño"));
			Role empleado = this.roleService.save(new Role("empleado"));
			Role invitado = this.roleService.save(new Role("invitado"));
			
//add role Permit			no debe repetirse el mismo permiso
			//los Id de role permit son compuestos. ya los tienen antes de realizar el persist
			this.roleService.addPermit(dueño, show);
			this.roleService.addPermit(dueño, nuevo);
			this.roleService.addPermit(dueño, delete);
			this.roleService.addPermit(dueño, update);
			this.roleService.addPermit(dueño, buy);
			this.roleService.addPermit(dueño, sale);
			
			invitado.addPermit(show);
			this.roleService.update(invitado);
			
			empleado.addPermit(show);
			empleado.addPermit(show);
			empleado.addPermit(sale);
			empleado.addPermit(delete);
			this.roleService.update(empleado);
			
			this.roleService.removePermit(empleado, delete);
			
// User
		User pepe = userService.save(new User("pep","pep","pepe","pepe", 1234, "pepe@mail.com", LocalDate.of(1990, 1, 12)) );
		User userInvitado = userService.save(new User("inv","inv","pepe","pepe", 2345, "invitado@mail.com", LocalDate.of(1991, 2, 12)) );
		User userEmpleado = userService.save(new User("emp","emp","empleado","empleadp", 3456, "empleado@mail.com", LocalDate.of(1992, 3, 12)) );
		User userDueño = userService.save(new User("due","due","dueño","dueño",4567, "dueño@mail.com", LocalDate.of(1993, 4, 12)) );
		
// Add user roles		
		pepe.addRole(empleado);
		pepe.addRole(empleado);
		pepe.addRole(invitado);
		User pepeAct = this.userService.update(pepe);
		
		//el Id de user es simple... no los tienen hasta despues de realizar el persist..
		//por eso se usa una entitdad actualizada para eliminar un rol
		this.userService.removeRole(pepeAct, empleado);
		
		userInvitado.addRole(invitado);
		this.userService.update(userInvitado);
		
		userEmpleado.addRole(invitado);
		userEmpleado.addRole(empleado);
		this.userService.update(userEmpleado);
		
		userDueño.addRole(invitado);
		userDueño.addRole(empleado);
		userDueño.addRole(dueño);
		this.userService.update(userDueño);
		
		} catch (ServiceException e) {
			System.out.println("algo salio mal");
		}
		return "home";
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String showList() {
		List<User> list;
		try {
			list = this.userService.findByUsersFirtsName("pepe");
			list.forEach(System.out::println);

		} catch (ServiceException e) {
			e.printStackTrace();
		}
		return "home";
	}

	@RequestMapping(value = "/us", method = RequestMethod.GET)
	public String showUser() {
		try {
			User pepe = this.userService.findByUser("due");
			
			if( pepe.isExistRole("invitado") )
				System.out.println("el usuario tiene rol invitado");
			if( pepe.isExistRole("dueño") )
				System.out.println("el usuario tiene rol dueño");
			
			if( pepe.isExistPermit("product_show") )
				System.out.println("el usuario tiene permiso product_show");
			
			if( pepe.isExistPermit("product_delete")  )
				System.out.println("el usuario tiene permiso product_delete");
			
			
			System.out.println(pepe);
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		return "home";
	}
	
	@RequestMapping(value = "/us2", method = RequestMethod.GET)
	public String testUser() {
		try {
			userService.save(new User("pep","pep","pepe","pepe", 1234, "pepe@mail.com", LocalDate.of(1990, 1, 12)) );
			System.out.println("pasa");
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		return "home";
	}

}
