package com.java.brew.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.java.brew.models.LoginUser;
import com.java.brew.models.User;
import com.java.brew.repositories.UserRepository;


@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepo;
	
	//REGISTRATION METHOD
	public User register(User newUser, BindingResult result) {
		//REJECT IF DUPLICATE EMAIL
		Optional<User> potentialUser = userRepo.findByEmail(newUser.getEmail());
		if(potentialUser.isPresent()) {
			result.rejectValue("email", "Matches", "An account with that email already exists!");
		}
		//REJECT IF PASSWORD CONFIRMATION DOESNT MATCH 
		if(!newUser.getPassword().equals(newUser.getConfirm())) {
			result.rejectValue("confirm", "Matches", "The Confirm Password must match Password!");
		}
		//REJECT IF ENTRY ERRORS
		if(result.hasErrors()) {
			return null;
		}
		//HASH PASSWORD AND CREATE NEW USER
		String hashed=BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
		newUser.setPassword(hashed);
		return userRepo.save(newUser);
	}
	
	//LOGIN METHOD
	public User login(LoginUser newLoginUser, BindingResult result) {
		//REJECT IF EMAIL IS NOT FOUND IN DATABASE
		Optional<User> potentialUser = userRepo.findByEmail(newLoginUser.getEmail());
		if(!potentialUser.isPresent()) {
			result.rejectValue("email", "Matches", "User not found!");
			return null;
		}
		//RETRIEVE EXISTING USER
		User user = potentialUser.get();
		//REJECT IF PASSWORD DOES NOT MATCH
		if(!BCrypt.checkpw(newLoginUser.getPassword(), user.getPassword())) {
			result.rejectValue("password", "Matches", "Invalid Password!");
		}
		//REJECT IF ENTRY ERRORS
		if(result.hasErrors()) {
			return null;
		}
		//RETURN USER OBJECT
		return user;
	}
	
	//GET USER BY ID
	public User findById(Long id) {
    	Optional<User> potentialUser = userRepo.findById(id);
    	if(potentialUser.isPresent()) {
    		return potentialUser.get();
    	}
    	return null;
    }
	
	//GET USER BY EMAIL
	public User findByEmail(String email) {
		Optional<User> result = userRepo.findByEmail(email);
		if(result.isPresent()) {
			return result.get();
		}
		return null;
	}
}
