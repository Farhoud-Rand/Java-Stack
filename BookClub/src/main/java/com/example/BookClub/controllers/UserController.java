package com.example.BookClub.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.BookClub.models.LoginUser;
import com.example.BookClub.models.User;
import com.example.BookClub.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class UserController {
	@Autowired
	UserService userService;

	// Function to render the page that contains forms
	@GetMapping("/")
	public String index(@ModelAttribute("user") User user, @ModelAttribute("newLogin") LoginUser newLogin,
			Model model) {
		return "index.jsp";
	}

	// Function to submit the Register form
	@PostMapping("/users/new")
	public String createUser(@Valid @ModelAttribute("user") User user, BindingResult result, Model model,
			HttpSession session) {
		User testUser = userService.register(user, result);
		if (result.hasErrors()) {
			model.addAttribute("newLogin", new LoginUser());
			return "index.jsp";
		} else {
			session.setAttribute("user", testUser.getId());
			return "redirect:/books";
		}
	}

	// Function to login user
	@PostMapping("/users/login")
	public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, BindingResult result, Model model,
			HttpSession session) {

		User testUser = userService.login(newLogin, result);
		if (result.hasErrors()) {
			model.addAttribute("user", new User());
			return "index.jsp";
		} else {
			session.setAttribute("user", testUser.getId());
			return "redirect:/books";
		}
	}

	// Function to logout user
	@PostMapping("/users/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("user");
		return "redirect:/";
	}
}