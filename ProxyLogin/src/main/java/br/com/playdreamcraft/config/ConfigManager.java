package br.com.playdreamcraft.config;

import java.lang.invoke.SwitchPoint;

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
}
