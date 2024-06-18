package ar.edu.unju.fi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;




@Controller



/**
 * controlador principal
 */

public class MainController {

	@GetMapping("/inicio")
	public String getIndexPage(Model model) {
		model.addAttribute("titulo", "hola");
		return "index";
	}
	
	
}
