package com.example.BookClub.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.BookClub.models.User;

@Repository
public interface UserRepository extends CrudRepository <User, Long>{
	User findByEmail(String email);
	User findById(long id);

}
