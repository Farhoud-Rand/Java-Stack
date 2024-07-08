package com.example.BeltExample.services;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.example.BeltExample.models.Instructor;
import com.example.BeltExample.models.LoginInstructor;
import com.example.BeltExample.repositories.InstructorRepository;

@Service
public class InstructorService {
	@Autowired
	InstructorRepository instructorRepository;

	// Function to create new instructor
	public Instructor register(Instructor newInstructor, BindingResult result) {

		// Reject values or register if no errors:
		// Reject if email is taken (present in database)
		Instructor potentialInstructor = instructorRepository.findByEmail(newInstructor.getEmail());
		if (potentialInstructor != null) {
			result.rejectValue("email", "Founds", "The Email is used!");
		}

		// Reject if password doesn't match confirmation
		if(!newInstructor.getPassword().equals(newInstructor.getConfirm())) {
			result.rejectValue("confirm", "Matches", "The Confirm Password must match Password!");
		}
		// Return null if result has errors
		if(result.hasErrors()) {
			// Exit the method and go back to the controller
			// to handle the response
			return null;
		}
		// Hash and set password, save instructor to database
		String hashed = BCrypt.hashpw(newInstructor.getPassword(), BCrypt.gensalt());
		newInstructor.setPassword(hashed);
		instructorRepository.save(newInstructor);
		return newInstructor;
	}

	//	Function to login the instructor
	public Instructor login(LoginInstructor newLoginObject, BindingResult result) {
		// Reject values:

		// Find instructor in the DB by email
		Instructor potentialInstructor = instructorRepository.findByEmail(newLoginObject.getEmail());

		// Reject if NOT present
		if (potentialInstructor == null) {
			result.rejectValue("email", "Founds", "The Email is not found!");
		} else {
			// Reject if BCrypt password match fails
			if(!BCrypt.checkpw(newLoginObject.getPassword(), potentialInstructor.getPassword())) {
				result.rejectValue("password", "Matches", "Invalid Password!");
			}
		}

		// Return null if result has errors
		// Otherwise, return the instructor object
		if(result.hasErrors()) {
			// Exit the method and go back to the controller
			// to handle the response
			return null;
		}

		return potentialInstructor;
	}

	//	Function to find a specific instructor by its ID
	public Instructor getInstructorByID(long id) {
		return instructorRepository.findById(id);
	}
}
