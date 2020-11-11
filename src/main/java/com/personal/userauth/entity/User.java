package com.personal.userauth.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "users")
public class User implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -280385090886660177L;

	public String getFirstName()
	{
		return firstName;
	}
	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}
	public String getLastName()
	{
		return lastName;
	}
	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}
	public String getEmailAddress()
	{
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress)
	{
		this.emailAddress = emailAddress;
	}
	public String getPassword()
	{
		return password;
	}
	public void setPassword(String password)
	{
		this.password = password;
	}
	
	public String getPasswordConfirm()
	{
		return passwordConfirm;
	}
	public void setPasswordConfirm(String passwordConfirm)
	{
		this.passwordConfirm = passwordConfirm;
	}
	
	public String toString()
	{
		return "First Name: " + this.firstName + "\nLast Name: " + this.lastName + "\nEmail Address: " + this.emailAddress + "\nPassword: " +  this.password;
	}

	public PasswordHashAlgo getPasswordAlgo()
	{
		return passwordAlgo;
	}
	public void setPasswordAlgo(PasswordHashAlgo passwordAlgo)
	{
		this.passwordAlgo = passwordAlgo;
	}
	public long getId()
	{
		return id;
	}
	public void setId(long id)
	{
		this.id = id;
	}

	@NotBlank(message = "First name is mandatory")
	@Column(name = "first_name")
	private String firstName;
	
	@NotBlank(message = "Last name is mandatory")
	@Column(name = "last_name")
	private String lastName;
	
	@NotBlank(message = "Email address is mandatory")
	@Column(name = "email_address")
	private String emailAddress;
	
	@NotBlank(message = "Password is mandatory")
	@Column(name = "password")
	private String password;
	
	@NotBlank(message = "Password is mandatory")
	@Transient
	private String passwordConfirm;
	
	@OneToOne(targetEntity = PasswordHashAlgo.class, cascade = CascadeType.ALL)
	private PasswordHashAlgo passwordAlgo;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
}
