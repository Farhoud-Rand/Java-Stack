package com.example.security.services;

import java.util.List;
import java.util.Optional;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.security.models.User;
import com.example.security.repositories.RoleRepository;
import com.example.security.repositories.UserRepository;

@Service
public class UserService {
	private UserRepository userRepository;
	private RoleRepository roleRepository;
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	public UserService(UserRepository userRepositorysitory, RoleRepository roleRepositorysitory, BCryptPasswordEncoder bCryptPasswordEncoder)     {
		this.userRepository = userRepositorysitory;
		this.roleRepository = roleRepositorysitory;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}


	//	// 1
	//	public void saveWithUserRole(User user) {
	//		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
	//		user.setRoles(roleRepositorysitory.findByName("ROLE_USER"));
	//		userRepositorysitory.save(user);
	//	}
	//
	//	// 2
	//	public void saveUserWithAdminRole(User user) {
	//		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
	//		user.setRoles(roleRepositorysitory.findByName("ROLE_ADMIN"));
	//		userRepositorysitory.save(user);
	//	}
	//
	//	// 3
	//	public User findByUsername(String username) {
	//		return userRepositorysitory.findByUsername(username);
	//	}



	public void newUser(User user, String role) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		user.setRoles(roleRepository.findByName(role));
		userRepository.save(user);
	}

	public void updateUser(User user) {
		userRepository.save(user);
	}

	public User findByUsername(String username) {
		return userRepository.findByUsername(username);
	}

	public List<User> allUsers(){
		return userRepository.findAll();
	}

	public User upgradeUser(User user) {
		user.setRoles(roleRepository.findByName("ROLE_ADMIN"));
		return userRepository.save(user);
	}

	public void deleteUser(User user) {
		userRepository.delete(user);
	}

	public User findById(Long id) {
		Optional<User> potentialUser = userRepository.findById(id);
		if(potentialUser.isPresent()) {
			return potentialUser.get();
		}
		return null;
	}
}

