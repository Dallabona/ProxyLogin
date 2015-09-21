package br.com.playdreamcraft.proxylogin;

import net.md_5.bungee.api.plugin.Plugin;

/**
 * Classe principal do plugin ProxyLogin. Um sistema de autentica��o baseado no proxy Bungeecord
 * @author PiLogic
 *
 */
public class ProxyLogin extends Plugin 
{

	private static ProxyLogin plugin;
	
	@Override	public void onEnable() 
	{
		plugin = this;
		//Mysql.setupMysql(mysqlIp, mysqlPort, mysqlDatabase, mysqlUsername, mysqlPassword);
	}

	@Override
	public void onDisable() 
	{
		
	}

	/**
	 * Retorna a inst�ncia da classe main
	 * @return Inst�ncia da classe main
	 */
	public static ProxyLogin getInstance()
	{
		return plugin;
	}
}
