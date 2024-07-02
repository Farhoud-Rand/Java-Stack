package com.example.services;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.example.models.LoginUser;
import com.example.models.User;
import com.example.repositories.UserRepository;

@Service
public class UserService {
	@Autowired
	UserRepository userRepository;

	// Function to create new user
	public User register(User newUser, BindingResult result) {

		// Reject values or register if no errors:
		// Reject if email is taken (present in database)
		User potentialUser = userRepository.findByEmail(newUser.getEmail());
		if (potentialUser != null) {
			result.rejectValue("email", "Founds", "The Email is used!");
		}

		// Reject if password doesn't match confirmation
		if(!newUser.getPassword().equals(newUser.getConfirm())) {
			result.rejectValue("confirm", "Matches", "The Confirm Password must match Password!");
		}
		// Return null if result has errors
		if(result.hasErrors()) {
			// Exit the method and go back to the controller
			// to handle the response
			return null;
		}
		// Hash and set password, save user to database
		String hashed = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
		newUser.setPassword(hashed);
		userRepository.save(newUser);
		return newUser;
	}

	//	Function to login the user
	public User login(LoginUser newLoginObject, BindingResult result) {
		// Reject values:

		// Find user in the DB by email
		User potentialUser = userRepository.findByEmail(newLoginObject.getEmail());

		// Reject if NOT present
		if (potentialUser == null) {
			result.rejectValue("email", "Founds", "The Email is not found!");
		} else {
			// Reject if BCrypt password match fails
			if(!BCrypt.checkpw(newLoginObject.getPassword(), potentialUser.getPassword())) {
				result.rejectValue("password", "Matches", "Invalid Password!");
			}
		}

		// Return null if result has errors
		// Otherwise, return the user object
		if(result.hasErrors()) {
			// Exit the method and go back to the controller
			// to handle the response
			return null;
		}

		return potentialUser;
	}

	//	Function to find a specific user by its ID
	public User getUserByID(long id) {
		return userRepository.findById(id);
	}
}
