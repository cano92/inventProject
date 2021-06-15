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
			Permit pShow = permitService.save(new Permit("post_show","permite al usuario ver los post"));
			Permit pNuevo = permitService.save(new Permit("post_new","permite al usuario agregar nuevos los post"));
			Permit pDelete = permitService.save(new Permit("post_delete","permite al usuario borrar post"));
			Permit pUpdate = permitService.save(new Permit("post_update","permite al usuario editar post"));
			
			Permit tShow = permitService.save(new Permit("topic_show"));
			Permit tNuevo = permitService.save(new Permit("topic_new"));
			Permit tDelete = permitService.save(new Permit("topic_delete"));
			Permit tUpdate = permitService.save(new Permit("topic_update"));
			
			Permit uShow = permitService.save(new Permit("user_show"));
			Permit uNuevo = permitService.save(new Permit("user_new"));
			Permit uDelete =permitService.save(new Permit("user_delete"));
			Permit uUpdate =permitService.save(new Permit("user_update"));

			Permit rShow = permitService.save(new Permit("role_show"));
			Permit rNuevo = permitService.save(new Permit("role_new"));
			Permit rDelete =permitService.save(new Permit("role_delete"));
			Permit rUpdate =permitService.save(new Permit("role_update"));
			
			//opcionales 
			Permit peShow = permitService.save(new Permit("permit_show"));
			Permit peNuevo = permitService.save(new Permit("permit_new"));
			Permit peDelete =permitService.save(new Permit("permit_delete"));
			Permit peUpdate =permitService.save(new Permit("permit_update"));
			
			Permit geShow = permitService.save(new Permit("gender_show"));
			Permit geNuevo = permitService.save(new Permit("gender_new"));
			Permit geDelete =permitService.save(new Permit("gender_delete"));
			Permit geUpdate =permitService.save(new Permit("gender_update"));
			
//new Roles			 no debe repetirse el mismo Rol
			Role user = this.roleService.save(new Role("user","Rol user se encuentra limitado a las funciones basicas de la app "));
			this.roleService.save(new Role("user"));
			Role admin = this.roleService.save(new Role("admin","el Rol Administrador lleva todos los permisos y no tiene limite en las acciones"));
			
//add role Permit			no debe repetirse el mismo permiso
			//ojo no usar un objeto no actualizado
			user=this.roleService.addPermit(user, pShow);
			user=this.roleService.addPermit(user, pNuevo);
			user=this.roleService.addPermit(user, pDelete);
			user=this.roleService.addPermit(user, pUpdate);
			
			user=this.roleService.addPermit(user, uShow);
			user=this.roleService.addPermit(user, tShow);
			user=this.roleService.addPermit(user, rShow);
			
			admin.addPermit(pShow);
			admin.addPermit(pNuevo);
			admin.addPermit(pDelete);
			admin.addPermit(pUpdate);
			
			admin.addPermit(tShow);
			admin.addPermit(tNuevo);
			admin.addPermit(tDelete);
			admin.addPermit(tUpdate);
			
			admin.addPermit(uShow);
			admin.addPermit(uNuevo);
			admin.addPermit(uDelete);
			admin.addPermit(uUpdate);
			
			admin.addPermit(rShow);
			admin.addPermit(rNuevo);
			admin.addPermit(rDelete);
			admin.addPermit(rUpdate);
			
			admin.addPermit(peShow);
			admin.addPermit(peNuevo);
			admin.addPermit(peDelete);
			admin.addPermit(peUpdate);
			
			admin.addPermit(geShow);
			admin.addPermit(geNuevo);
			admin.addPermit(geDelete);
			admin.addPermit(geUpdate);
			admin = this.roleService.update(admin);
			
//	Gender
		Gender masculino = this.genderService.save(new Gender("Masculino"));
		Gender femenino = this.genderService.save(new Gender("Femenino"));
		
			
// User
		User pepe = userService.save(new User("pep","pep","pepe","pepe", 1234, "pepe@mail.com", LocalDate.of(1990, 1, 12), masculino));
		User userInvitado = userService.save(new User("inv","inv","alguien","alguien", 2345, "invitado@mail.com", LocalDate.of(1991, 2, 12), femenino));
		User userAdmin = userService.save(new User("admin","admin","admin","admin",4567, "admin@mail.com", LocalDate.of(1993, 4, 12), masculino));
		
// Add user Roles		

		userAdmin.addRole(admin);
		userAdmin.addRole(user);
		userAdmin = this.userService.update(userAdmin);
		
		pepe.addRole(user);
		pepe = this.userService.update(pepe);
		
		userInvitado.addRole(user);
		userInvitado = this.userService.update(userInvitado);
		
		
// App
		Topic topicA = this.topicservice.save(new Topic("topicA"));
		Topic topicB = this.topicservice.save(new Topic("topicB"));
		Topic topicC = this.topicservice.save(new Topic("topicC"));
		
		this.postService.save(new Post(pepe, "primer post","descripcion de postA con topicA", topicA));
		this.postService.save(new Post(pepe, "primer post","descripcion de postA con topicA", topicB));
		this.postService.save(new Post(userInvitado, "primer post","descripcion de postA con topicA", topicC));
		
		} catch (ServiceException e) {
			System.out.println("algo salio mal");
		}
		return "<h3>Carga Inicial Completa</h3>";
	}
	
	
	
	
}
