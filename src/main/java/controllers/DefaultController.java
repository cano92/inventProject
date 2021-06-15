package controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

import entities.User;
import services.IUserService;
import util.exception.ServiceException;
import util.model.LoginForm;

@Controller
public class DefaultController {
	
	String urlPage ="http://localhost:8080/citrino";
	
	@Autowired
	private IUserService userService;
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String LoginShow(HttpServletRequest request, Model model) {
		
		LoginForm loginForm = new LoginForm();
		model.addAttribute("loginForm",loginForm);
		return "login-show";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)	//debe ser la clave del model form
	public RedirectView login(@Valid @ModelAttribute("loginForm") LoginForm login,
							BindingResult validationResult, Model model, HttpSession session) {
		RedirectView redirectView = new RedirectView();	
		try {
			if(validationResult.hasErrors() ) 
				redirectView.setUrl(this.urlPage+"/loginError");
			else {		
				User user = this.userService.login(login.getUser(), login.getPass());
				if(user == null)  
					redirectView.setUrl(this.urlPage+"/loginError");
				else {
					session.setAttribute("user", user);
					redirectView.setUrl(this.urlPage+"/user/home");
				}
			}
		}catch (ServiceException e) {
			e.printStackTrace();
			redirectView.setUrl(this.urlPage+"/errorPage");
		}
	    return redirectView;
	}
	
	@RequestMapping(value = "/loginError", method = RequestMethod.GET)
	public String LoginErrorShow(HttpServletRequest request, Model model) {
		
		LoginForm loginForm = new LoginForm();
		model.addAttribute("loginForm",loginForm);
		return "loginError-show";
	}

	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String Show(HttpSession session ) {
		return "home-show";
	}
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String homeShow() {
		return "home-show";
	}
	
	@RequestMapping(value = "/info", method = RequestMethod.GET)
	public String infoShow() {
		return "info-show";
	}
	
	@RequestMapping(value = "/errorPage", method = RequestMethod.GET)
	public String errorPage() {
		return "error-page";
	}
	
}
