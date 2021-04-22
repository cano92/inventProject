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
		// Permits
		try {

			// no debe repetir el mismo Permiso
			Permit show = permitService.save(new Permit("product_show"));
			Permit show2 = permitService.save(new Permit("product_show"));
			Permit show3 = permitService.save(new Permit("product_show"));
			
			Permit nuevo = permitService.save(new Permit("product_new"));
			Permit delete = permitService.save(new Permit("product_delete"));
			Permit update = permitService.save(new Permit("product_update"));
			Permit buy = permitService.save(new Permit("product_buy"));
			Permit sale = permitService.save(new Permit("product_sale"));

			// no debe repetirse el mismo Rol
			Role dueño = this.roleService.save(new Role("dueño"));
			Role dueño2 = this.roleService.save(new Role("dueño"));
			Role dueño3 = this.roleService.save(new Role("dueño"));
			Role empleado = this.roleService.save(new Role("empleado"));
			Role invitado = this.roleService.save(new Role("invitado"));
			
			
			this.roleService.addPermit(dueño, sale);
			this.roleService.addPermit(dueño, sale);
			this.roleService.addPermit(dueño, sale);
			
			this.roleService.addPermit(dueño, nuevo);
			this.roleService.addPermit(dueño, delete);
			this.roleService.addPermit(dueño, update);
			this.roleService.addPermit(dueño, buy);
			this.roleService.addPermit(dueño, show);
			
			this.roleService.addPermit(empleado, sale);
			this.roleService.addPermit(empleado, show);
			
			this.roleService.removePermit(empleado, show);
			
			
			System.out.println("pasa");

			//no se debe agregar dos veces el "Role_Permit"
//			this.roleService.addPermit(dueño, show);
//			this.roleService.addPermit(dueño, show);
//			this.roleService.addPermit(dueño, show);
//			
//			this.roleService.addPermit(dueño, nuevo);
//			this.roleService.addPermit(dueño, delete);
//			this.roleService.addPermit(dueño, update);
//			this.roleService.addPermit(dueño, buy);
//			this.roleService.addPermit(dueño, sale);
//			
//			this.roleService.addPermit(empleado, show);
//			this.roleService.addPermit(empleado, sale);
//			this.roleService.addPermit(invitado, show);
			
			
			
			// User
//		userService.save(new User("pep","pep","pepe","pepe", 234, "pepe@mail.com", LocalDate.of(1992, 3, 12),null ));
//		userService.save(new User("ju","ju","juan","juan", 234, "juan@mail.com", LocalDate.of(1992, 3, 12),null ));
//		userService.save(new User("jo","jo","jose","jose", 234, "jose@mail.com", LocalDate.of(1992, 3, 12),empleado));	
//		userService.save(new User("em","em","ema","ema", 234, "ema@mail.com", LocalDate.of(1992, 3, 12),empleado));
//		userService.save(new User("mro","mro","mario","mario", 234, "mario@mail.com", LocalDate.of(1992, 3, 12),dueño));

		} catch (ServiceException e) {
			System.out.println("algo salio mal");
			// e.printStackTrace();
			// en caso de falla retorna a una pagina de error
		}
		return "home";
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String showList() {
		List<User> list;
		try {
			list = this.userService.findByUserName("juan");
			list.forEach(System.out::println);

		} catch (ServiceException e) {
			e.printStackTrace();
		}
		return "home";
	}

	@RequestMapping(value = "/us", method = RequestMethod.GET)
	public String showUser() {
		try {
			// registra user
			userService.update(
					new User("pep", "pep", "pepe", "pepe", 234, "pepe@mail.com", LocalDate.of(1992, 3, 12), null));
			// consulta por use
			User pepe = this.userService.findByUser("pepas");
			System.out.println(pepe);
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		return "home";
	}

}
