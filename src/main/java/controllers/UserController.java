package controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;


import services.IUserService;
import util.model.UserForm;

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
	public String userFormShow( Model model) {
		UserForm userForm = new UserForm();
		model.addAttribute("userForm",userForm);
		return "userForm-show";
	}
	
	@RequestMapping(value = "/registerUser", method = RequestMethod.POST)
	public String registerUser(@Valid @ModelAttribute("userForm") UserForm userForm, 
			BindingResult validationResult ) {
		if(validationResult.hasErrors() ) {
			return "userForm-show";
		}//paso la validadion
		//agregar el nuevo usuario 
		
		//ir a pagina de confirmacion de que se agrego el nuevo usuario
		return "userForm-show";
	}
}
