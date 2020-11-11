package com.personal.userauth.manager;

import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import com.personal.userauth.db.UserRepository;
import com.personal.userauth.entity.User;
import com.personal.userauth.security.PasswordHash;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Component
public class UserRegistrationManager
{
	@Autowired
	UserRepository repository;
	
	@Lazy
	Logger logger = LogManager.getLogger(UserRegistrationManager.class);
	
	public void registerUser(@Valid User user)
	{
		if(!validateUniqueUser(user))
		{
			logger.warn("Duplicate registration for user: " + user.getEmailAddress());
			return;
		}
		try
		{
			String password = PasswordHash.hashPassword(user.getPassword());
			user.setPassword(password);
		} catch (NoSuchAlgorithmException e)
		{
			logger.error("Error during hashing of password", e);
		}
		repository.save(user);
	}
	
	public boolean validateUniqueUser(User user)
	{
		List<User> users = repository.findByEmailAddress(user.getEmailAddress());
		return users.isEmpty();
	}

}
