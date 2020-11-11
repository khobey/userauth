package com.personal.userauth.rest;

import java.security.NoSuchAlgorithmException;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.personal.userauth.entity.UserLoginCred;
import com.personal.userauth.manager.UserLoginManager;
import com.personal.userauth.response.ResponseDetail;

@RestController
public class UserLoginRest
{
	@Autowired
	UserLoginManager mgr;
	
	@PostMapping("/login")
	public ResponseEntity<String> login(@Valid @RequestBody UserLoginCred cred)
	{
		try
		{
			ResponseDetail  res = mgr.challengeLogin(cred);
			return ResponseEntity.status(res.getCode()).body(res.getDetail());
			
		} catch (NoSuchAlgorithmException e)
		{
			Logger logger = LogManager.getLogger(UserLoginRest.class);
			logger.fatal("Unable to login due to system error" , e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Unable to login due to system error. Contact your administrator");
		}
	}
	
}
