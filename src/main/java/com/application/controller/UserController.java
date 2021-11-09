package com.application.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.application.model.UserDetails;
import com.application.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/")
	@ResponseBody
	public String page() {
		return "hello";
	}
	
	@PostMapping("/newUser")
	public ResponseEntity<UserDetails> addNewUser(@RequestBody UserDetails userDetails) {
		
		return new ResponseEntity<UserDetails>(userService.addNewUser(userDetails), HttpStatus.OK);
	}
	
	@RequestMapping("/updateUser")
	public ResponseEntity<UserDetails> updateUser(@RequestBody UserDetails userDetails) {
		
		return new ResponseEntity<UserDetails>(userService.updateUser(userDetails), HttpStatus.OK);
	}
	
	@GetMapping("/findUserById/{userId}")
	public ResponseEntity<UserDetails> findUserById(@PathVariable int userId) {
		
		return new ResponseEntity<UserDetails>(userService.findUserById(userId), HttpStatus.OK);
	}
	
	@GetMapping("/findUserByName/{userName}")
	public ResponseEntity<UserDetails> findUserByUserName(@PathVariable String userName) {
		
		return new ResponseEntity<UserDetails>(userService.findUserByName(userName), HttpStatus.OK);
	}
	
	@GetMapping("/findUserByEmail/{email}")
	public ResponseEntity<UserDetails> findUserByEmail(@PathVariable String email) {
		
		return new ResponseEntity<UserDetails>(userService.findUserByEmail(email), HttpStatus.OK);
	}
	
	@GetMapping("/findUserByMobile/{mobile}")
	public ResponseEntity<UserDetails> findUserByMobile(@PathVariable long mobile) {
		
		return new ResponseEntity<UserDetails>(userService.findUserByMobile(mobile), HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteUserById/{userid}")
	public ResponseEntity<String> deleteUserById(@PathVariable int userId) {
		
		userService.deleteUserById(userId);
		return new ResponseEntity<String>("user deleted with ID : " + userId, HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteUserByName/{userName}")
	public ResponseEntity<String> deleteUserByName(@PathVariable String userName) {
		
		userService.deleteUserByName(userName);
		return new ResponseEntity<String>("user deleted with Name : " + userName, HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteUserByEmail/{email}")
	public ResponseEntity<String> deleteUserByEmail(@PathVariable String email) {
		
		userService.deleteUserByEmail(email);
		return new ResponseEntity<String>("user deleted with email : " + email, HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteUserByMobile/{mobile}")
	public ResponseEntity<String> deleteUserByMobile(@PathVariable long mobile) {
		
		userService.deleteUserByMobile(mobile);
		return new ResponseEntity<String>("user deleted with mobile number : " + mobile, HttpStatus.OK);
	}
	
	@GetMapping("/getAllUser")
	public ResponseEntity<List<UserDetails>> getAllUsers() {
		
		return new ResponseEntity<List<UserDetails>>(userService.getAllUser(), HttpStatus.OK);
	}
}
