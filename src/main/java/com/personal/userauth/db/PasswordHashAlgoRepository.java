package com.personal.userauth.db;

import org.springframework.data.jpa.repository.JpaRepository;

import com.personal.userauth.entity.PasswordHashAlgo;

public interface PasswordHashAlgoRepository extends JpaRepository<PasswordHashAlgo, Long>
{
	PasswordHashAlgo findTopByOrderByAlgoIdDesc();
}
