package br.com.playdreamcraft.proxylogin.security.passwords.hash.salt;

import java.security.NoSuchAlgorithmException;

public interface Salt
{
	
	public String generateSalt(int lengh) throws NoSuchAlgorithmException;
	
}
