package com.personal.userauth.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "passwordhashalgo")
public class PasswordHashAlgo
{
	public String getHashAlgo()
	{
		return hashAlgo;
	}
	public void setHashAlgo(String hashAlgo)
	{
		this.hashAlgo = hashAlgo;
	}
	
	public long getAlgoId()
	{
		return algoId;
	}
	public void setAlgoId(long algoId)
	{
		this.algoId = algoId;
	}
	public String getAlgoName()
	{
		return algoName;
	}
	public void setAlgoName(String algoName)
	{
		this.algoName = algoName;
	}

	@Column(name= "hashAlgo")
	private String hashAlgo;
	
	@Column(name= "algoName")
	private String algoName;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long algoId;
}
