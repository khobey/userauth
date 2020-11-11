package com.personal.userauth.rest;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.personal.userauth.entity.User;
import com.personal.userauth.manager.UserRegistrationManager;
import com.personal.userauth.response.ResponseDetail;

@RestController
public class UserRegistrationRest
{
	@Autowired
	UserRegistrationManager urm;
	
	@PostMapping("/register")
	public ResponseEntity<String> registerUser(@Valid @RequestBody User user)
	{
		if(!user.getPassword().equals(user.getPasswordConfirm()))
			return ResponseEntity.unprocessableEntity().body("Passwords do not match");
		
		ResponseDetail res = urm.registerUser(user);
		return ResponseEntity.status(res.getCode()).body(res.getDetail());
	}

}
