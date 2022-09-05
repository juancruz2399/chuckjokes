package com.example.demo.app.Controllers;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
@RequestMapping
public class LoginController {

	@GetMapping("/signin")
	public String login(@RequestParam(value="error",required=false)String error,
						@RequestParam(value="logout",required=false)String logout,
						Model model, Principal principal, RedirectAttributes flash) {
		if(principal!=null) {
			flash.addFlashAttribute("info","Ya ha iniciado sesión");
			return "redirect:/index";
		}
		if(error!=null) {
			model.addAttribute("error","Usuario o contraseña incorrecta");
		}
		if(logout!=null) {
			model.addAttribute("success","Ha cerrado sesión con exito");
		}
		return "signin";
	}
	@GetMapping({"","/"})
	public String index(Model model) {
		model.addAttribute("bienvenido","hola");
		return "signin";
	}
	
	@GetMapping("/forbidden")
	public String error403(Model model) {
		return "forbidden";
	}
}
