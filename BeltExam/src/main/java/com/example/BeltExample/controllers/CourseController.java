package com.example.BeltExample.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.BeltExample.models.Course;
import com.example.BeltExample.models.Instructor;
import com.example.BeltExample.services.CourseService;
import com.example.BeltExample.services.InstructorService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class CourseController {
	@Autowired
	CourseService courseService;

	@Autowired
	InstructorService instructorService;

	// Function to render the home page
	@GetMapping("/courses")
	public String homePage(Model model, HttpSession session) {
		if (session.getAttribute("instructor") != null) {
			Instructor instructor = instructorService.getInstructorByID((long) session.getAttribute("instructor"));
			model.addAttribute("instructor", instructor);
			List<Course> allCourses = courseService.getAllCourses();
			model.addAttribute("allCourses", allCourses);
			return "home.jsp";
		}
		return "notLogin.jsp";
	}

	// Function to render a new course to database
	@GetMapping("/add")
	public String addForm(@ModelAttribute("course") Course course, HttpSession session) {
		// Check if the instructor is already login or not
		if (session.getAttribute("instructor") != null) {
			return "add.jsp";
		}
		return "notLogin.jsp";
	}

	// Function to add create new course
	@PostMapping("/courses/new")
	public String create(@Valid @ModelAttribute("course") Course course, BindingResult result, Model model,
			HttpSession session) {
		// Check if the instructor is already login or not
		if (session.getAttribute("instructor") != null) {
			if (result.hasErrors()) {
				return "add.jsp";
			} else {
				courseService.createCourse(course, (long) session.getAttribute("instructor"));
				return "redirect:/courses";
			}
		}
		return "notLogin.jsp";
	}


	// Function to get course information by its ID
	@GetMapping("/courses/{id}")
	public String index(Model model, @PathVariable long id, HttpSession session) {
		if (session.getAttribute("instructor") != null) {
			Optional<Course> optionalCourse = courseService.findCourseById(id);
			if (optionalCourse.isPresent()) {
				Course course = optionalCourse.get();
				model.addAttribute("b", course);
			}
			return "info.jsp";
		}
		return "notLogin.jsp";
	}

	//	// Function to add course to the instructor as a team member
	//	@GetMapping("/addTeam/{id}")
	//	public String addTeam(@PathVariable long id, HttpSession session) {
	//		// Check if the instructor is already login or not
	//		if (session.getAttribute("instructor") != null) {
	//			courseService.addTeam(id, (long) session.getAttribute("instructor"));
	//			return "redirect:/courses";
	//		}
	//		return "notLogin.jsp";
	//	}
	//
	//	// Function to add course to the instructor as a team member
	//	@GetMapping("/leaveteam/{id}")
	//	public String removeTeam(@PathVariable long id, HttpSession session) {
	//		// Check if the instructor is already login or not
	//		if (session.getAttribute("instructor") != null) {
	//			Course course = courseService.findCourseById(id);
	//			Instructor instructor = instructorService.getInstructorByID((long) session.getAttribute("instructor"));
	//			courseService.removeTeam(course, instructor);
	//			return "redirect:/courses";
	//		}
	//		return "notLogin.jsp";
	//	}
	//
	// Function to render edit page
	@GetMapping("/courses/edit/{id}")
	public String edit(@PathVariable long id, HttpSession session, Model model) {
		if (session.getAttribute("instructor") != null) {
			Optional<Course> optionalCourse = courseService.findCourseById(id);
			if (optionalCourse.isPresent()) {
				Course course = optionalCourse.get();
				model.addAttribute("course",course);
				return "edit.jsp";
			}
		}
		return "notLogin.jsp";
	}

	// Function to update course information
	@PatchMapping("/courses/edit/{id}")
	public String update(@Valid @ModelAttribute("course") Course course, BindingResult result, @PathVariable long id,
			HttpSession session) {
		if (session.getAttribute("instructor") == null) {
			return "notLogin.jsp";
		}
		if (result.hasErrors()) {
			return "edit.jsp";
		} else {
			courseService.updateCourse(id, course);
			return "redirect:/courses";
		}
	}

	// Function to delete a course
	@GetMapping("/courses/delete/{id}")
	public String deleteCourse(@PathVariable("id")Long id,HttpSession session) {
		if (session.getAttribute("instructor") == null) {
			return "notLogin.jsp";
		}
		courseService.deleteCourseById(id);
		return "redirect:/courses";
	}
}
