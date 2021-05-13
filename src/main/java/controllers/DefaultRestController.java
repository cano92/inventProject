package controllers;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import entities.Gender;
import entities.Permit;
import entities.Role;
import entities.User;
import entities.app.Post;
import entities.app.Topic;
import services.IGenderService;
import services.IPermitService;
import services.IPostService;
import services.IRoleService;
import services.ITopicService;
import services.IUserService;
import util.exception.ServiceException;

@RestController
public class DefaultRestController {
	
	@Autowired
	private IUserService userService;
	@Autowired
	private IRoleService roleService;
	@Autowired
	private IPermitService permitService;
	@Autowired
	private IGenderService genderService;
	@Autowired
	private IPostService postService;
	@Autowired
	private ITopicService topicservice;

	@RequestMapping(value = "/ini", method = RequestMethod.GET)
	public String showIni(Model model) {
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
			//ojo no usar un objeto no actualizado
			dueño=this.roleService.addPermit(dueño, show);
			dueño=this.roleService.addPermit(dueño, nuevo);
			dueño=this.roleService.addPermit(dueño, delete);
			dueño=this.roleService.addPermit(dueño, update);
			dueño=this.roleService.addPermit(dueño, buy);
			dueño=this.roleService.addPermit(dueño, sale);
			
			invitado.addPermit(show);
			invitado=this.roleService.update(invitado);
			
			empleado.addPermit(show);
			empleado.addPermit(show);
			empleado.addPermit(sale);
			empleado.addPermit(delete);
			empleado = this.roleService.update(empleado);
			
			empleado=this.roleService.removePermit(empleado, delete);
			//hay un problema al eliminar  el permit.. en BD se elimina pero despues lo busca como si el objeto quedara viejo
//			empleado = this.roleService.update(empleado);

			
//			removes
			//empleado=this.roleService.removeAllPermit(dueño);
			//this.permitService.delete(show);
			//this.roleService.delete(dueño);
//	Gender
		Gender masculino = this.genderService.save(new Gender("Masculino"));
		Gender femenino = this.genderService.save(new Gender("Femenino"));
			
// User
		User pepe = userService.save(new User("pep","pep","pepe","pepe", 1234, "pepe@mail.com", LocalDate.of(1990, 1, 12), masculino));
		User userInvitado = userService.save(new User("inv","inv","pepe","pepe", 2345, "invitado@mail.com", LocalDate.of(1991, 2, 12), masculino));
		User userEmpleado = userService.save(new User("emp","emp","empleado","empleadp", 3456, "empleado@mail.com", LocalDate.of(1992, 3, 12), femenino));
		User userDueño = userService.save(new User("due","due","dueño","dueño",4567, "dueño@mail.com", LocalDate.of(1993, 4, 12), masculino));
		
// Add user roles		
//		empleado=this.roleService.getByID(8);
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
		
		//this.roleService.delete(dueño);
		
		} catch (ServiceException e) {
			System.out.println("algo salio mal");
		}
		return "<h3>Carga Inicial Completa</h3>";
	}
	
	@RequestMapping(value = "/app", method = RequestMethod.GET)
	public String testApp() {
		try {
			Topic topicA = this.topicservice.save(new Topic("topicA"));
			Topic topicB = this.topicservice.save(new Topic("topicB"));
			Topic topicC = this.topicservice.save(new Topic("topicC"));
			
			this.postService.save(new Post(null, "primer post","descripcion de postA con topicA", topicA));
			this.postService.save(new Post(null, "primer post","descripcion de postA con topicA", topicB));
			this.postService.save(new Post(null, "primer post","descripcion de postA con topicA", topicC));
			
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		return "home";
	}
	
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String test() {
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
			
			this.userService.removeAllRoles(pepe);
			
			System.out.println(pepe);
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		return "<h3>Test Concluido </h3>";
	}
	
	
	
}
