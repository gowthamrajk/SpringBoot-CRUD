package com.application.repository;

import org.springframework.data.repository.CrudRepository;
import com.application.exception.EmailNotFoundException;
import com.application.exception.UserNotFoundException;
import com.application.model.UserDetails;

public interface UserRepository extends CrudRepository<UserDetails, Integer>  {
	
	public UserDetails findByUserName(String userName);
	
	public UserDetails findByEmail(String email);
	
	public UserDetails findByMobile(long mobile);

}
