package com.application.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "userdetails")
public class UserDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "userid")
	private int userId;
	
	@Column(name = "username")
	private String userName;
	
	private String email;
	private long mobile;
	private String password;
	
	public UserDetails() { }

	public UserDetails(int userId, String userName, String email, long mobile, String password) {
		this.userId = userId;
		this.userName = userName;
		this.email = email;
		this.mobile = mobile;
		this.password = password;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getMobile() {
		return mobile;
	}

	public void setMobile(long mobile) {
		this.mobile = mobile;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		
		return "User Details => ID : " + userId + ", Name : " + userName + ", Email : " + email + ", Mobile : " 
		       + mobile + ", Password : " + password;
	}
}
