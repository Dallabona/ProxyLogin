package br.com.playdreamcraft.proxylogin.config;


public class ConfigManager
{
	private static ConfigManager instance;

	private ConfigManager()
	{
	}

	public static ConfigManager getInstance()
	{
		if(null == instance)
			instance = new ConfigManager();

		return instance;
	}
	
	public String getPersistence()
	{
		//TODO
		return null;
	}

	public String getCache()
	{
		// TODO Auto-generated method stub
		return null;
	}
}
