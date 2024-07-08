package com.example.BeltExample.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.BeltExample.models.Instructor;
import com.example.BeltExample.models.LoginInstructor;
import com.example.BeltExample.services.InstructorService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class InstructorController {
	@Autowired
	InstructorService instructorService;

	//	Function to render the page that contains forms
	@GetMapping("/")
	public String index(@ModelAttribute("instructor") Instructor instructor, Model model) {
		model.addAttribute("instructor",instructor);
		model.addAttribute("newLogin",new LoginInstructor());
		return "index.jsp";
	}

	// Function to submit the Register form
	@PostMapping("/instructors/new")
	public String createInstructor(@Valid @ModelAttribute("instructor") Instructor instructor, BindingResult result, Model model, HttpSession session) {
		if (result.hasErrors()) {
			model.addAttribute("instructor",instructor);
			model.addAttribute("newLogin", new LoginInstructor());
			return "index.jsp";
		} else {
			Instructor testInstructor = instructorService.register(instructor, result);
			if (testInstructor != null) {
				session.setAttribute("instructor", instructor.getId());
				return "redirect:/courses";
			} else {
				model.addAttribute("instructor",instructor);
				model.addAttribute("newLogin", new LoginInstructor());
				return "index.jsp";
			}
		}
	}

	// Function to login instructor
	@PostMapping("/instructors/login")
	public String login(@Valid @ModelAttribute("newLogin") LoginInstructor newLogin,
			BindingResult result, Model model, HttpSession session) {

		if (result.hasErrors()) {
			model.addAttribute("newLogin",newLogin);
			model.addAttribute("instructor", new Instructor());
			return "index.jsp";
		} else {
			Instructor testInstructor = instructorService.login(newLogin, result);
			if (testInstructor != null) {
				session.setAttribute("instructor", testInstructor.getId());
				return "redirect:/courses";
			} else {
				model.addAttribute("newLogin",newLogin);
				model.addAttribute("instructor", new Instructor());
				return "index.jsp";
			}
		}
	}

	// Function to logout instructor
	@PostMapping("/instructors/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("instructor");
		return "redirect:/";
	}
}
