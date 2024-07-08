package com.example.BeltExample.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.BeltExample.models.Course;
import com.example.BeltExample.models.Instructor;
import com.example.BeltExample.repositories.CourseRepository;

@Service
public class CourseService {
	@Autowired
	CourseRepository courseRepository;

	@Autowired
	InstructorService instructorService;

	// Function to create a new course
	public void createCourse(Course course, long instructorId) {
		Instructor instructor = instructorService.getInstructorByID(instructorId);
		course.setTeacher(instructor);
		courseRepository.save(course);
		//		joinCourse(course, instructor);
	}

	//	// Function to add new instructor as a team member for a specific team
	//	public void joinCourse(Course course, Instructor instructor) {
	//		course.getTeam().add(instructor);
	//		courseRepository.save(course);
	//	}

	// Function to get all courses
	public List<Course> getAllCourses() {
		return courseRepository.findAll();
	}

	// Function to find the course by its ID
	public Optional<Course> findCourseById(long id) {
		return courseRepository.findById(id);
	}

	//	// Function to add instructor as a team member for a course
	//	public void addTeam(long courseId, long instructorId) {
	//		Course course = findCourseById(courseId);
	//		Instructor instructor = instructorService.getInstructorByID(instructorId);
	//		course.getTeam().add(instructor);
	//		courseRepository.save(course);
	//	}
	//
	//	// Function to add instructor as a team member for a course
	//	public void removeTeam(Course course, Instructor instructor) {
	//		course.getTeam().remove(instructor);
	//		courseRepository.save(course);
	//	}

	//	Function to update a course
	public void updateCourse (long id,Course course) {
		Optional<Course> optionalCourse = findCourseById(id);
		if (optionalCourse.isPresent()) {
			Course oLdCourse = optionalCourse.get();
			oLdCourse.setName(course.getName());
			oLdCourse.setDay(course.getDay());
			oLdCourse.setPrice(course.getPrice());
			oLdCourse.setDescription(course.getDescription());
			courseRepository.save(oLdCourse);
		}
	}

	//	Function to delete course by its ID
	public void deleteCourseById(long id) {
		courseRepository.deleteById(id);
	}
}
