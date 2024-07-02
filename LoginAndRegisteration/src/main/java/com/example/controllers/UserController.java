package com.example.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.models.LoginUser;
import com.example.models.User;
import com.example.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class UserController {
	@Autowired
	UserService userService;
	//	Function to render the page that contains forms
	@GetMapping("/")
	public String index(@ModelAttribute("user") User user, Model model) {
		model.addAttribute("user",user);
		model.addAttribute("newLogin",new LoginUser());
		return "index.jsp";
	}

	// Function to submit the Register form
	@PostMapping("/users/new")
	public String createUser(@Valid @ModelAttribute("user") User user, BindingResult result, Model model, HttpSession session) {
		if (result.hasErrors()) {
			model.addAttribute("user",user);
			model.addAttribute("newLogin", new LoginUser());
			return "index.jsp";
		} else {
			User testUser = userService.register(user, result);
			if (testUser != null) {
				session.setAttribute("user", user.getId());
				return "redirect:/home";
			} else {
				model.addAttribute("user",user);
				model.addAttribute("newLogin", new LoginUser());
				return "index.jsp";
			}
		}
	}

	//	Function to render the home page
	@GetMapping("/home")
	public String homePage(Model model, HttpSession session) {
		if (session.getAttribute("user") != null) {
			User user =userService.getUserByID((long)session.getAttribute("user"));
			model.addAttribute("user",user);
			return "home.jsp";
		}
		return "notLogin.jsp";
	}

	// Function to login user
	@PostMapping("/users/login")
	public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin,
			BindingResult result, Model model, HttpSession session) {

		if (result.hasErrors()) {
			model.addAttribute("newLogin",newLogin);
			model.addAttribute("user", new User());
			return "index.jsp";
		} else {
			User testUser = userService.login(newLogin, result);
			if (testUser != null) {
				session.setAttribute("user", testUser.getId());
				return "redirect:/home";
			} else {
				model.addAttribute("newLogin",newLogin);
				model.addAttribute("user", new User());
				return "index.jsp";
			}
		}
	}

	// Function to logout user
	@PostMapping("/users/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("user");
		return "redirect:/";
	}

}
