package com.personal.userauth.security;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.bouncycastle.util.encoders.Hex;

public class PasswordHash
{
	public static String hashPassword(String password) throws NoSuchAlgorithmException
	{
		MessageDigest digest = MessageDigest.getInstance("SHA-256");
		byte[] hash = digest.digest(
				password.getBytes(StandardCharsets.UTF_8));
		String hashedPassword = new String(Hex.encode(hash));
		
		return hashedPassword;
	}
}
