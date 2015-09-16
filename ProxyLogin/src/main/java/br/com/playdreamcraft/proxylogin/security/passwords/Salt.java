package br.com.playdreamcraft.proxylogin.security.passwords;

import java.security.NoSuchAlgorithmException;

public interface Salt
{
	
	public String generateSalt(int lengh) throws NoSuchAlgorithmException;
	
}
