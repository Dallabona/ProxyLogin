package br.com.playdreamcraft.proxylogin.security.passwords.hash;

import java.security.NoSuchAlgorithmException;

public interface PasswordHash
{

	/**
	 * 	Method to generate a hash from a password
	 * @param password pure password
	 * @param salt salt to hash
	 * @return
	 * @throws NoSuchAlgorithmException
	 */
	public String generateHash(String password, String salt) throws NoSuchAlgorithmException;
	
	
	/**
	 * Check if a password is correct
	 * @param hash password hash
	 * @param password pure password
	 * @return
	 * @throws NoSuchAlgorithmException
	 */
	public boolean isCorrect(String hash, String password) throws NoSuchAlgorithmException;
	
}
