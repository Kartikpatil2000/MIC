package com.cdac.Project.resources;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdac.Project.dao.UserRepository;
import com.cdac.Project.entities.User;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;

	public User addUser(User user)
	{
		return userRepository.save(user);
	}
	
	public User updateUser(User user, int userId)
	{
		user.setUserId(userId);
		return userRepository.save(user);
	}
	
	public User getUserById(int id)
	{
		Optional<User> optional= userRepository.findById(11);
		User user=optional.get();
		return user;
	}
	
	public List<User> getAllUsers()
	{
		List <User> lists = (List<User>) userRepository.findAll();
		return  lists;
	}
	
	public List<User> getUsersByLocation(String location)
	{
		List <User> users = userRepository.findByLocation(location);
		return users;
	}
	
	
	public User getUserByEmailIdAndPassword1(String email, String password)
	{
		User user = userRepository.findByEmailIdAndPassword(email, password);
		return user;
	}
	public Optional<String> getEmail()
	{
		return getEmail();
	}
	public void deleteUser(int id)
	{
		userRepository.deleteById(id);
	}
	
	public void deleteAllUser()
	{
		userRepository.deleteAll();
	}

	public User getUserByEmailIdAndPassword(String email, String password) {
		// TODO Auto-generated method stub
		return null;
	}
			
}
