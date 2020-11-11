package com.personal.userauth.manager;

import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.personal.userauth.db.PasswordHashAlgoRepository;
import com.personal.userauth.db.UserRepository;
import com.personal.userauth.entity.User;
import com.personal.userauth.entity.UserLoginCred;
import com.personal.userauth.response.ResponseDetail;
import com.personal.userauth.security.PasswordHash;

@Component
public class UserLoginManager
{
	@Autowired
	UserRepository repository;

	@Autowired
	PasswordHashAlgoRepository pwRepository;
	
	Logger logger = LogManager.getLogger(UserLoginManager.class);

	public ResponseDetail challengeLogin(@Valid UserLoginCred cred) throws NoSuchAlgorithmException
	{
		List<User> users = getUserFromDB(cred.getUsername());
		if(users == null || users.isEmpty())
		{
			logger.warn("Invalid login for: " + cred.getUsername());
			return new ResponseDetail(HttpStatus.UNAUTHORIZED, "User not found");
		}
		
		User user = users.get(0);
		if( isPasswordCorrect(user, cred))
			return new ResponseDetail(HttpStatus.OK, "Login successful");
		else
			return new ResponseDetail(HttpStatus.UNAUTHORIZED, "Invalid username and/or passwords");
	}
	
	private boolean isPasswordCorrect(User user, UserLoginCred cred) throws NoSuchAlgorithmException
	{
		String hashToChallenge = PasswordHash.hashPassword(cred.getPassword(), user.getPasswordAlgo().getHashAlgo());
		return user.getPassword().equals(hashToChallenge);
	}
	
	private List<User> getUserFromDB(String emailAddress)
	{
		return repository.findByEmailAddress(emailAddress);
	}

}
