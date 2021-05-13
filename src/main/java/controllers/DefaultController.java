package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class DefaultController {
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String LoginShow() {
		
		return "login";
	}
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String showHome() {
		
		return "home";
	}
	
	
}
