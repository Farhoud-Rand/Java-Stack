package com.example.BeltExample.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.BeltExample.models.Student;
import com.example.BeltExample.services.StudentService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class StudentController {
	@Autowired
	StudentService studentService;

	// Function to add create new course
	@PostMapping("/students/new")
	public String create(@Valid @ModelAttribute("student") Student student, BindingResult result, Model model,
			HttpSession session) {
		// Check if the instructor is already login or not
		if (session.getAttribute("instructor") != null) {
			if (result.hasErrors()) {
				return "info.jsp";
			} else {
				studentService.createStudent(student);
				return "redirect:/courses";
			}
		}
		return "notLogin.jsp";
	}



}
