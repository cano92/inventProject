package controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String showHome(Model model) {

		return "home";
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
