package com.cdac.Project.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.cdac.Project.entities.User;

public interface UserRepository extends CrudRepository<User, Integer>{

	List<User> findByLocation(String location);

	User findByEmailIdAndPassword(String email, String password);
		
}
