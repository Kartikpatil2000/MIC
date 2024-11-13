package com.cdac.Project.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cdac.Project.entities.User;

import com.cdac.Project.resources.UserService;


@RestController
@RequestMapping("/api/User")
@CrossOrigin("*")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/addUser")
	public ResponseEntity <User> addUser(@RequestBody User user) {
	
		
		try {
			userService.addUser(user);
			System.out.println(user);
			return ResponseEntity.status(HttpStatus.CREATED).body(user);
		}
		catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	
	@GetMapping("/getUsers")
	public ResponseEntity<List<User>> getAllUsers(){
		List <User> list= userService.getAllUsers();
		if(list.size()<=0)
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		
		return ResponseEntity.status(HttpStatus.CREATED).body(list);
	}
	
	@GetMapping("/getUser/{userId}")
	public ResponseEntity <User> getUser(@PathVariable("userId") int id) {
		User user=userService.getUserById(id);
		if(user==null)
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		return ResponseEntity.status(HttpStatus.CREATED).body(user); 
	}
	
	@GetMapping("/getUserByLocation")
	public ResponseEntity<List<User>> getUserByLocation(@PathVariable("location") String location){
		List <User> list= userService.getUsersByLocation(location);
		if(list.size()<=0)
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		
		return ResponseEntity.status(HttpStatus.CREATED).body(list);
	}
	
	@GetMapping("/getUserByEmailAndPassword")
	public ResponseEntity <User> getUser(@PathVariable("email, password") String email, String password) {
		User user=userService.getUserByEmailIdAndPassword(email, password);
		if(user.getEmailId()==email && user.getPassword()==password)
			return ResponseEntity.status(HttpStatus.FOUND).build();
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); 
	}
	
	
	@DeleteMapping("/deleteUser/{userId}")
	public ResponseEntity <Void> deleteUserById(@PathVariable("userId") int id) {
		try {
			userService.deleteUser(id);
			return ResponseEntity.status(HttpStatus.OK).build();
		}
		catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
		
	@DeleteMapping("/deleteUsers")
	public ResponseEntity <Void> deleteUser() {
		try {
				userService.deleteAllUser();
				return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
			}
			catch (Exception e) {
				e.printStackTrace();
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
			}
	}		
		
		
		
		
}
