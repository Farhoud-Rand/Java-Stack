package com.example.BurgerTracker.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.BurgerTracker.Models.Burger;
import com.example.BurgerTracker.Services.BurgerService;

import jakarta.validation.Valid;

@Controller
public class MainController {
	// Attribute and constructor
	@Autowired
	BurgerService burgerService;

	// ******************** R (Read all) from CRUD ******************
	// Get all burgers from our database
	@GetMapping("/")
	public String index(Model model,@ModelAttribute("burger") Burger burger) {
		List<Burger> burgers = burgerService.allBurgers();
		model.addAttribute("burgers",burgers);
		return "index.jsp";
	}

	// ******************** C (Create) from CRUD ********************
	// Function to add new burger to the table
	@PostMapping("/add")
	public String create(@Valid @ModelAttribute("burger") Burger burger, BindingResult result, Model model) {
		if(result.hasErrors()){
			model.addAttribute("burger",burger);
			List<Burger> burgers = burgerService.allBurgers();
			model.addAttribute("burgers",burgers);
			return "index.jsp";
		} else {
			burgerService.add(burger);
			return "redirect:/";
		}
	}



}
