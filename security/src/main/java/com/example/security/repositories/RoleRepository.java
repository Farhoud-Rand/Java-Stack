package com.example.security.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.security.models.Role;

//imports removed for brevity
@Repository
public interface RoleRepository extends CrudRepository<Role, Long> {
	@Override
	List<Role> findAll();

	List<Role> findByName(String name);
}