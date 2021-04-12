package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class DefaultController {

	@RequestMapping(value="/home",method=RequestMethod.GET)
	public String showHome(Model model) {
		//inicio general de la pagina
		//traer articulo principal o novedad
		System.out.println("pasa");
		
		return "home";
	}
	
	
}
