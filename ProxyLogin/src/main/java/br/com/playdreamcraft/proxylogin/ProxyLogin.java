package br.com.playdreamcraft.proxylogin;

import net.md_5.bungee.api.plugin.Plugin;

/**
 * Classe principal do plugin ProxyLogin. Um sistema de autenticação baseado no proxy Bungeecord
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
	 * Retorna a instância da classe main
	 * @return Instância da classe main
	 */
	public static ProxyLogin getInstance()
	{
		return plugin;
	}
}
