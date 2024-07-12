package com.example.security.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.security.models.User;

//imports removed for brevity
@Repository
public interface UserRepository extends CrudRepository<User, Long> {
	User findByUsername(String username);
	@Override
	List<User> findAll();
}
