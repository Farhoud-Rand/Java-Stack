package com.example.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.models.License;
import com.example.models.Person;
import com.example.services.LicenseService;
import com.example.services.PersonService;

import jakarta.validation.Valid;

@Controller
public class LicenseController {
	// Attributes and constructors
	@Autowired
	LicenseService licenseService;

	@Autowired
	PersonService personService;

	// ******************** C (Create) from CRUD ********************
	// Function to render the add new license form page
	@GetMapping("/licenses/new")
	public String licenseForm(@ModelAttribute("license") License license, Model model) {
		List<Person> persons = personService.allPersons();
		model.addAttribute("persons",persons);
		return"newLicense.jsp";
	}

	// Function to add new license to the table
	@PostMapping("/licenses/add")
	public String create(@Valid @ModelAttribute("license") License license, BindingResult result, Model model) {
		if(result.hasErrors()){
			model.addAttribute("license",license);
			List<Person> persons = personService.allPersons();
			model.addAttribute("persons",persons);
			return "newLicense.jsp";
		} else {
			licenseService.add(license);
			return "redirect:/persons/"+license.getPerson().getId();
		}
	}
}