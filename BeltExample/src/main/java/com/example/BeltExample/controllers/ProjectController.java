package com.example.BeltExample.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.BeltExample.models.Project;
import com.example.BeltExample.models.User;
import com.example.BeltExample.services.ProjectService;
import com.example.BeltExample.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class ProjectController {
	@Autowired
	ProjectService projectService;

	@Autowired
	UserService userService;

	// Function to render the home page
	@GetMapping("/home")
	public String homePage(Model model, HttpSession session) {
		if (session.getAttribute("user") != null) {
			User user = userService.getUserByID((long) session.getAttribute("user"));
			model.addAttribute("user", user);
			List<Project> allProjects = projectService.getAllProjects(user);
			List<Project> userProjects = projectService.getUserProjects(user);
			model.addAttribute("allProjects", allProjects);
			model.addAttribute("userProjects", userProjects);
			return "home.jsp";
		}
		return "notLogin.jsp";
	}

	// Function to render a new project to database
	@GetMapping("/add")
	public String addForm(@ModelAttribute("project") Project project, HttpSession session) {
		// Check if the user is already login or not
		if (session.getAttribute("user") != null) {
			return "add.jsp";
		}
		return "notLogin.jsp";
	}

	// Function to add create new project
	@PostMapping("/projects/new")
	public String create(@Valid @ModelAttribute("project") Project project, BindingResult result, Model model,
			HttpSession session) {
		// Check if the user is already login or not
		if (session.getAttribute("user") != null) {
			if (result.hasErrors()) {
				return "add.jsp";
			} else {
				projectService.createProject(project, (long) session.getAttribute("user"));
				return "redirect:/home";
			}
		}
		return "notLogin.jsp";
	}

	// Function to add project to the user as a team member
	@GetMapping("/addTeam/{id}")
	public String addTeam(@PathVariable long id, HttpSession session) {
		// Check if the user is already login or not
		if (session.getAttribute("user") != null) {
			projectService.addTeam(id, (long) session.getAttribute("user"));
			return "redirect:/home";
		}
		return "notLogin.jsp";
	}

	// Function to add project to the user as a team member
	@GetMapping("/leaveteam/{id}")
	public String removeTeam(@PathVariable long id, HttpSession session) {
		// Check if the user is already login or not
		if (session.getAttribute("user") != null) {
			Project project = projectService.findProjectById(id);
			User user = userService.getUserByID((long) session.getAttribute("user"));
			projectService.removeTeam(project, user);
			return "redirect:/home";
		}
		return "notLogin.jsp";
	}

	// Function to render edit page
	@GetMapping("/projects/edit/{id}")
	public String edit(@PathVariable long id, HttpSession session, Model model) {
		if (session.getAttribute("user") != null) {
			Project project = projectService.findProjectById(id);
			model.addAttribute("project",project);
			return "edit.jsp";
		}
		return "notLogin.jsp";
	}

	// Function to update project information
	@PatchMapping("/projects/edit/{id}")
	public String update(@Valid @ModelAttribute("project") Project project, BindingResult result, @PathVariable long id,
			HttpSession session) {
		if (session.getAttribute("user") == null) {
			return "notLogin.jsp";
		}
		if (result.hasErrors()) {
			return "edit.jsp";
		} else {
			projectService.updateProject(id, project);
			return "redirect:/home";
		}
	}

	// Function to delete a project
	@GetMapping("/projects/delete/{id}")
	public String deleteProject(@PathVariable("id")Long id,HttpSession session) {
		if (session.getAttribute("user") == null) {
			return "notLogin.jsp";
		}
		projectService.deleteProjectById(id);
		return "redirect:/home";
	}
}
