package com.personal.userauth.manager;

import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.personal.userauth.db.PasswordHashAlgoRepository;
import com.personal.userauth.db.UserRepository;
import com.personal.userauth.entity.PasswordHashAlgo;
import com.personal.userauth.entity.User;
import com.personal.userauth.response.ResponseDetail;
import com.personal.userauth.security.PasswordHash;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Component
public class UserRegistrationManager
{
	@Autowired
	UserRepository repository;
	
	@Autowired
	PasswordHashAlgoRepository pwRepository;
	
	@Lazy
	Logger logger = LogManager.getLogger(UserRegistrationManager.class);
	
	public ResponseDetail registerUser(@Valid User user)
	{
		if(!validateUniqueUser(user))
		{
			logger.warn("Duplicate registration for user: " + user.getEmailAddress());
			return new ResponseDetail(HttpStatus.BAD_REQUEST, "Duplicate registration for user" );
		}
		try
		{
			PasswordHashAlgo algo = getHashAlgo();
			String password = PasswordHash.hashPassword(user.getPassword(), algo.getHashAlgo());
			user.setPassword(password);
			user.setPasswordAlgo(algo);
		} catch (NoSuchAlgorithmException e)
		{
			logger.error("Error during hashing of password", e);
		}
		repository.save(user);
		return new ResponseDetail(HttpStatus.OK, "Registration done  for: " + user.getEmailAddress() );
	}
	
	public boolean validateUniqueUser(User user)
	{
		List<User> users = repository.findByEmailAddress(user.getEmailAddress());
		return users.isEmpty();
	}
	
	private PasswordHashAlgo getHashAlgo()
	{
		return pwRepository.findTopByOrderByAlgoIdDesc();
	}
}
