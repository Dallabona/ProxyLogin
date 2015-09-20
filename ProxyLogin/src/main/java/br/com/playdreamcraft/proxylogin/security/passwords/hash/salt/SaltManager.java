package br.com.playdreamcraft.proxylogin.security.passwords.hash.salt;

import java.security.NoSuchAlgorithmException;

/**
 * Class to manage Salt
 * 
 * @author PalitoDeDente
 *
 */
public class SaltManager implements Salt
{
	Salt						salt;

	private static SaltManager	instance;

	private SaltManager()
	{
	}

	public static SaltManager getInstance()
	{
		if(null == instance)
			instance = new SaltManager();

		return instance;
	}

	@Override
	public String generateSalt(int lengh) throws NoSuchAlgorithmException
	{
		return salt.generateSalt(lengh);		
	}

}
