package com.example.BeltExample.controllers;

import java.time.format.DateTimeFormatter;
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
import org.springframework.web.bind.annotation.RequestParam;

import com.example.BeltExample.models.Course;
import com.example.BeltExample.models.Instructor;
import com.example.BeltExample.models.Student;
import com.example.BeltExample.services.CourseService;
import com.example.BeltExample.services.InstructorService;
import com.example.BeltExample.services.StudentService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class CourseController {
	@Autowired
	CourseService courseService;

	@Autowired
	InstructorService instructorService;

	@Autowired
	StudentService studentService;

	// Function to render the home page
	@GetMapping("/courses")
	public String homePage(Model model, HttpSession session) {
		if (session.getAttribute("instructor") != null) {
			Instructor instructor = instructorService.getInstructorByID((long) session.getAttribute("instructor"));
			model.addAttribute("instructor", instructor);
			List<Course> allCourses = courseService.getAllCourses();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm a");
			allCourses.forEach(course -> {
				String formattedTime = course.getTime().format(formatter);
				course.setFormattedTime(formattedTime);
			});
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
	@GetMapping("/courses/{courseid}")
	public String index(Model model, @PathVariable long courseid, HttpSession session,
			@ModelAttribute("student") Student student) {
		if (session.getAttribute("instructor") != null) {
			Optional<Course> optionalCourse = courseService.findCourseById(courseid);
			if (optionalCourse.isPresent()) {
				Course course = optionalCourse.get();
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm a");
				String formattedTime = course.getTime().format(formatter);
				course.setFormattedTime(formattedTime);
				model.addAttribute("b", course);
				// Get all student not in this course
				List<Student> otherStudents = courseService.findStudentsNotInCourse(courseid);
				model.addAttribute("otherStudents", otherStudents);
				List <Student> Students = courseService.findAllStudentsInCourse(courseid);
				model.addAttribute("students", Students);

			}
			return "info.jsp";
		}
		return "notLogin.jsp";
	}

	// Function to add student to course
	@PostMapping("/courses/{courseid}/addStudent")
	public String addStudent(@PathVariable long courseid, HttpSession session, @RequestParam long studentId) {
		if (session.getAttribute("instructor") != null) {
			Optional<Course> optionalCourse = courseService.findCourseById(courseid);
			if (optionalCourse.isPresent()) {
				Course course = optionalCourse.get();
				Student student = studentService.findStudentById(studentId);
				courseService.addStudent(student, course);
				return "redirect:/courses";
			}
		}
		return "notLogin.jsp";
	}

	// // Function to add course to the instructor as a team member
	// @GetMapping("/addTeam/{id}")
	// public String addTeam(@PathVariable long id, HttpSession session) {
	// // Check if the instructor is already login or not
	// if (session.getAttribute("instructor") != null) {
	// courseService.addTeam(id, (long) session.getAttribute("instructor"));
	// return "redirect:/courses";
	// }
	// return "notLogin.jsp";
	// }
	//
	// // Function to add course to the instructor as a team member
	// @GetMapping("/leaveteam/{id}")
	// public String removeTeam(@PathVariable long id, HttpSession session) {
	// // Check if the instructor is already login or not
	// if (session.getAttribute("instructor") != null) {
	// Course course = courseService.findCourseById(id);
	// Instructor instructor = instructorService.getInstructorByID((long)
	// session.getAttribute("instructor"));
	// courseService.removeTeam(course, instructor);
	// return "redirect:/courses";
	// }
	// return "notLogin.jsp";
	// }
	//
	// Function to render edit page
	@GetMapping("/courses/edit/{id}")
	public String edit(@PathVariable long id, HttpSession session, Model model) {
		if (session.getAttribute("instructor") != null) {
			Instructor instructor = instructorService.getInstructorByID((long) session.getAttribute("instructor"));
			Optional<Course> Ocourse = courseService.findCourseById(id);
			if (Ocourse.isPresent()) {
				Course course = Ocourse.get();
				if (instructor.getId() == course.getTeacher().getId()) {
					Optional<Course> optionalCourse = courseService.findCourseById(id);
					if (optionalCourse.isPresent()) {
						Course courseX = optionalCourse.get();
						model.addAttribute("course", courseX);
						return "edit.jsp";
					}
				} else {
					return "notEdit.jsp";
				}
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
	public String deleteCourse(@PathVariable("id") Long id, HttpSession session) {
		if (session.getAttribute("instructor") == null) {
			return "notLogin.jsp";
		}
		courseService.deleteCourseById(id);
		return "redirect:/courses";
	}
}
