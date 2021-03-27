package dmacc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import dmacc.beans.Console;
import dmacc.repository.ConsoleRepository;

@Controller
public class WebController {

	@Autowired
	ConsoleRepository repo;
	
	@GetMapping({"/", "/viewAll"})
	public String viewAllConsoles(Model model) {
		
		if(repo.findAll().isEmpty()) {
			return addNewConsole(model);
		}
		
		model.addAttribute("consoles", repo.findAll());
		return "results";
	}
	
	@GetMapping("/inputConsole")
		public String addNewConsole(Model model) {
			Console c = new Console();
			model.addAttribute("newConsole", c);
			return "input";
		}

	@PostMapping("/inputConsole")
	public String addNewConsole(@ModelAttribute Console c, Model model){
		repo.save(c);
		return viewAllConsoles(model);
	}
	
	@GetMapping("/edit/{id}")
	public String showUpdateConsole(@PathVariable("id") long id, Model model) {
		Console c = repo.findById(id).orElse(null);
		model.addAttribute("newConsole", c);
		return "input";
	}
	
	@PostMapping("/update/{id}")
	public String reviseConsole(Console c, Model model) {	
		repo.save(c);
		return viewAllConsoles(model);
	}
	
	@GetMapping("/delete/{id}")
	public String deleteConsole(@PathVariable("id") long id, Model model) {
		Console c = repo.findById(id).orElse(null);
		repo.delete(c);
		return viewAllConsoles(model);
	}
}

	
