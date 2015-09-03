package br.com.playdreamcraft.account;

import net.md_5.bungee.api.connection.ProxiedPlayer;

public class Conta
{	
	
	private String password;
	private String name;
	private String email;
	private String ip;
	public String getIp()
	{
		return ip;
	}

	private ProxiedPlayer proxyPlayer;
	private boolean logged;
	
	public Conta(String ip)
	{
		this.ip = ip;
	}
	
	public String getPassword()
	{
		return password;
	}

	public String getName()
	{
		return name;
	}
	
	public boolean isLogged() 
	{
		return logged;
	}

	public void setLogged(boolean logged) 
	{
		this.logged = logged;
	}

	public String getEmail() 
	{
		return email;
	}

	public ProxiedPlayer getProxyPlayer() 
	{
		return proxyPlayer;
	}	

}
