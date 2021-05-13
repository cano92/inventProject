package controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import entities.User;
import services.IUserService;
import util.exception.ServiceException;

@Controller
@RequestMapping(value = "/user")
public class UserController {

	@Autowired
	private IUserService userService;
	
	//si el logueo es exitoso va home
	public String login() {
		//login a BD para recuperar al usuario
	
		return this.showHome();
	}
	
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String showHome() {
		//validacion de datos imput
		//consulta BD User pass
		
		//rn caso de que falle la autenticacion show erroLogin 

		if( this.isAdmin() )
			return "homeAdmin"; //redirect AdminController en caso de path diferente
		if(this.isUser()) //si solo tiene un solo rol y solo uno role:user es 
			return "homeUser";
		if( this.isCustomizer() )	//si tiene mas de un rol es customizado
			return "homeCustomizer";
		return "errorRole"; //se logueo con exito pero no tiene ningun rol asignado
	};

	//estos deben ser servicios de Rol o de la entity
	private boolean isAdmin() {
		return true;
	}
	private boolean isUser() {
		return false;
	}
	private boolean isCustomizer() {
		return false;
	}




	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String showList() {
		List<User> list;
		try {
			list = this.userService.findByFirtsName("pepe");
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
			
			this.userService.removeAllRoles(pepe);
			
			System.out.println(pepe);
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		return "home";
	}
	
	@RequestMapping(value = "/us2", method = RequestMethod.GET)
	public String testUser() {
	
		return "home";
	}

}
