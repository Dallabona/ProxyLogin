package br.com.playdreamcraft.proxylogin.security.passwords.hash;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * An implementation of a PasswordHash
 * @see PasswordHash
 * @author PalitoDeDente
 *
 */
public class HashSHA256 implements PasswordHash
{

	private static HashSHA256	instance;

	private HashSHA256()
	{
	}

	public static HashSHA256 getInstance()
	{
		if(null == instance)
			instance = new HashSHA256();

		return instance;
	}

	/**
	 * @see PasswordHash
	 */
	public String generateHash(String senha, String salt)
			throws NoSuchAlgorithmException
	{
		return "$SHA$"
				+ salt
				+ "$"
				+ digestSHA256(new StringBuilder(
						String.valueOf(digestSHA256(senha))).append(salt)
						.toString());
	}

	/**
	 * @see PasswordHash
	 */
	public boolean isCorrect(String hash, String password)
			throws NoSuchAlgorithmException
	{
		String[] parts = hash.split("\\$");
		return hash.equals(generateHash(password, parts[2]));
	}

	/**
	 * Digest and string
	 * 
	 * @param message string to be digested
	 *            
	 * @return the hash
	 * @throws NoSuchAlgorithmException
	 */
	private static String digestSHA256(String message)
			throws NoSuchAlgorithmException
	{
		MessageDigest sha256 = MessageDigest.getInstance("SHA-256");
		sha256.reset();
		sha256.update(message.getBytes());
		byte[] digest = sha256.digest();
		return String.format("%0" + (digest.length << 1) + "x",
				new Object[] { new BigInteger(1, digest) });
	}
}
