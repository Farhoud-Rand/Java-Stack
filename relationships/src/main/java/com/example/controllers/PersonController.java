package com.example.controllers;

import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.models.Person;
import com.example.services.PersonService;

import jakarta.validation.Valid;

@Controller
public class PersonController {
	// Attribute and constructor
	@Autowired
	PersonService personService;

	// ******************** C (Create) from CRUD ********************
	//	Function to render the add new person form page
	@GetMapping("/persons/new")
	public String personForm(@ModelAttribute("person") Person person) {
		return"newPerson.jsp";
	}

	// Function to add new person to the table
	@PostMapping("/persons/add")
	public String create(@Valid @ModelAttribute("person") Person person, BindingResult result, Model model) {
		if(result.hasErrors()){
			model.addAttribute("person",person);
			return "newPerson.jsp";
		} else {
			personService.add(person);
			return "redirect:/persons/"+person.getId();
		}
	}

	// ******************** R (Read one) from CRUD ********************
	//Method to show the person informations
	@GetMapping("/persons/{person_id}")
	public String showPerson(@PathVariable Long person_id, Model model) {
		Person someAwesomePerson = personService.findPerson(person_id);
		SimpleDateFormat test = new SimpleDateFormat("MMM dd, yyyy");
		//		System.out.println());
		String newDate = test.format(someAwesomePerson.getLicense().getExpirationDate());
		//		SimpleDateFormat newDate = test.format(someAwesomePerson.getLicense().getExpirationDate());
		model.addAttribute("person", someAwesomePerson);
		model.addAttribute("newDate", newDate);
		return "showPerson.jsp";
	}

}
