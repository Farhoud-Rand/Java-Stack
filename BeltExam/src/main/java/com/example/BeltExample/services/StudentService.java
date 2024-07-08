package com.example.BeltExample.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.BeltExample.models.Student;
import com.example.BeltExample.repositories.CourseRepository;
import com.example.BeltExample.repositories.StudentRepository;

@Service
public class StudentService {
	@Autowired
	StudentRepository studentRepository;

	@Autowired
	CourseRepository courseRepository;

	// Function to create new student
	public void createStudent(Student student) {
		studentRepository.save(student);
	}
	// Function to find the course by its ID
	public Student findStudentById(long id) {
		return studentRepository.findById(id);
	}


}
