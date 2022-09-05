package com.example.demo.app.Controllers;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.app.Entity.Jokes;
import com.example.demo.app.Entity.User;
import com.example.demo.app.Security.CustomUserDetails;
import com.example.demo.app.Services.ChuckNorrisJokeService;
import com.example.demo.app.Services.IJokesService;
import com.example.demo.app.Services.IUserService;




@Controller
@RequestMapping
public class JokeController {

	@Autowired
	private ChuckNorrisJokeService JokeService;
	
	@Autowired 
	private IJokesService JokesService;
	
	@Autowired
	private IUserService UserService;
	
	
	

	
	@GetMapping(value ="/index")
	public String generacion(Model model,
			RedirectAttributes flash) throws IOException, InterruptedException {		
		return "index";
	}
	@GetMapping("/favoritesjokes")
	public String favorites(Model model,
			RedirectAttributes flash){
		
		model.addAttribute("jokes",JokesService.listJokes());		
		return "joke";
	}
	@GetMapping(value ="/getjoke")
	public String generacionbroma(Model model,
			RedirectAttributes flash) throws IOException, InterruptedException {
		String joke = JokeService.getChuckNorrisJoke();
		model.addAttribute("joke",joke);
		
		return "index";
	}
	@PostMapping("/savejoke")
	public String savejoke(Model model, RedirectAttributes flash,
			@RequestParam(value = "joke")String jokefront) {
		
		Jokes jokes = new Jokes();
		jokes.setDate_save(Date.valueOf(LocalDate.now()));
		jokes.setJoke(jokefront);
		
		Authentication auth = SecurityContextHolder
	            .getContext()
	            .getAuthentication();
	    CustomUserDetails userDetail = (CustomUserDetails) auth.getPrincipal();
	    User user = UserService.findbyname(userDetail.getUsername());
	    System.out.println(user.getNombre());
		jokes.setUser(user);
		JokesService.save(jokes);
		
		return "redirect:/index";
	}
}
