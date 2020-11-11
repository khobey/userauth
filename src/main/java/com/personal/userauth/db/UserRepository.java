package com.personal.userauth.db;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.personal.userauth.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>
{
	List<User> findByEmailAddress(String emailAddress);
}
