package controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	
	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String adminRoles(ModelMap model,HttpSession session) {
		// model map es para enviar atributos al jsp..
		model.addAttribute("mensaje","Hola mundo");
		
		return "adminRoles";
	}
}
