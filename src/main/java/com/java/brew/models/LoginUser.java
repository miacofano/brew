package com.java.brew.models;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

public class LoginUser {
    
	//TABLES & VALIDATORS
    @NotEmpty(message="Email is required!")
    @Email(message="Please enter a valid email!")
    private String email;
    
    @NotEmpty(message="Password is required!")
    private String password;
    
    //OBJECT
    public LoginUser() {}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
    
}
