package br.com.playdreamcraft.proxylogin.security.passwords;

public class PasswordHandler
{
	private static PasswordHandler	instance;

	private PasswordHandler()
	{
	}

	public static PasswordHandler getInstance()
	{
		if(null == instance)
		{
			instance = new PasswordHandler();
		}
		return instance;
	}
	
	
}
