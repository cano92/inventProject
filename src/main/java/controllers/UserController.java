package controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

import entities.User;
import services.IUserService;
import util.exception.ServiceException;

@Controller
@RequestMapping(value = "/user")
public class UserController {

	@Autowired
	private IUserService userService;
	
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String homeShow(ModelMap model,HttpSession session) {

		return "home-show";
	};

	
	@RequestMapping(value = "/info", method = RequestMethod.GET)
	public String infoShow() {
		return "info-show";
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public RedirectView logout( HttpSession session) {
		session.removeAttribute("user");
		
		RedirectView redirectView = new RedirectView();
	    redirectView.setUrl("http://localhost:8080/citrino/home");
	    return redirectView;
	}

	@RequestMapping(value = "/registerUser", method = RequestMethod.GET)
	public String userFormShow( ) {
		
		return "userForm-show";
	}
	
	@RequestMapping(value = "/registerUser", method = RequestMethod.POST)
	public String registerUser( ) {
		
		return "userForm-show";
	}
}
