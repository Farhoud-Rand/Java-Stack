package com.example.BeltExample.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.BeltExample.models.User;

@Repository
public interface UserRepository extends CrudRepository <User, Long>{
	User findByEmail(String email);
	User findById(long id);

}
