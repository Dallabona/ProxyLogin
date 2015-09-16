package br.com.playdreamcraft.proxylogin.security.passwords.hash;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

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
	 * Retorna a hash passando um salt e a string
	 */
	public String generateHash(String senha, String salt)
			throws NoSuchAlgorithmException
	{
		return "$SHA$"
				+ salt
				+ "$"
				+ digerirSHA256(new StringBuilder(
						String.valueOf(digerirSHA256(senha))).append(salt)
						.toString());
	}

	/**
	 * Testa se a senha está correta
	 */
	public boolean senhaCorreta(String hash, String senha)
			throws NoSuchAlgorithmException
	{
		String[] partes = hash.split("\\$");
		return hash.equals(generateHash(senha, partes[2]));
	}

	/**
	 * Digest and string
	 * 
	 * @param message string to be digested
	 *            
	 * @return the hash
	 * @throws NoSuchAlgorithmException
	 */
	private static String digerirSHA256(String message)
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
