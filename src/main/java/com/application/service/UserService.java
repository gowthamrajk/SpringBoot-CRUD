package com.application.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.application.exception.EmailNotFoundException;
import com.application.exception.UserAlreadyExistException;
import com.application.exception.UserNotFoundException;
import com.application.model.UserDetails;
import com.application.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public UserDetails addNewUser(UserDetails userDetails) throws UserAlreadyExistException {
		
		if(userRepository.findById(userDetails.getUserId()) == null)
			throw new UserAlreadyExistException("User Already Exists with this email !!!");
		else {
		    userRepository.save(userDetails);
		    return userDetails;
		}			
	}
	
	public UserDetails updateUser(UserDetails userDetails) {
		
		userRepository.save(userDetails);
		return userDetails;
	}
	
	public UserDetails findUserById(int userId) {
		
		Optional<UserDetails> userDetail = userRepository.findById(userId);
		if(userDetail.isEmpty())
			throw new UserNotFoundException("User Not Available with this Id !!!");
		else
			return userDetail.get();
	}
	
    public UserDetails findUserByName(String userName) {
		
		UserDetails userObj = userRepository.findByUserName(userName);
		if(userObj == null)
			throw new UserNotFoundException("User Not Available with this Name !!!");
		else
			return userObj;
	}
    
    public UserDetails findUserByEmail(String email) {
		
		UserDetails userObj = userRepository.findByEmail(email);
		if(userObj == null)
			throw new UserNotFoundException("User Not Available with this email !!!");
		else
			return userObj;
	}
    
    public UserDetails findUserByMobile(long mobile) {
		
		UserDetails userObj = userRepository.findByMobile(mobile);
		if(userObj == null)
			throw new UserNotFoundException("User Not Available with this mobile number !!!");
		else
			return userObj;
	}
	
	public void deleteUserById(int userId) {
		
		if(userRepository.findById(userId).isEmpty())
			throw new UserNotFoundException("User Not Available with this Id !!!");
		else
			userRepository.deleteById(userId);
	}
	
	public void deleteUserByName(String userName) throws UserNotFoundException {
		
		UserDetails userObj = userRepository.findByUserName(userName);
		if(userObj == null)
			throw new UserNotFoundException("User Not Available with this Name !!!");
		else
			userRepository.deleteById(userObj.getUserId());
	}
	
    public void deleteUserByEmail(String email) throws EmailNotFoundException {
		
    	UserDetails userObj = userRepository.findByEmail(email);
		if(userObj == null)
			throw new EmailNotFoundException("User Not Available with this email !!!");
		else
			userRepository.deleteById(userObj.getUserId());
	}
    
    public void deleteUserByMobile(long mobile) throws UserNotFoundException {
		
    	UserDetails userObj = userRepository.findByMobile(mobile);
		if(userObj == null)
			throw new UserNotFoundException("User Not Available with this mobile Number !!!");
		else
			userRepository.deleteById(userObj.getUserId());
	}
    
    public List<UserDetails> getAllUser() {
    	
    	return (List<UserDetails>)userRepository.findAll();
    }
}