package br.com.playdreamcraft.proxylogin.account;

import net.md_5.bungee.api.connection.ProxiedPlayer;

public class Conta
{	
	
	private String name;
	private String password;
	private String email;
	private String ip;	

	private ProxiedPlayer proxyPlayer;
	private boolean logged;
	
	public Conta(String name, String email, String password)
	{
		this.ip = ip;
		this.email = email;
		this.password = password;
		this.name = name;
		
	}
	
	public Conta(ProxiedPlayer pp, String email, String password)
	{
		name = pp.getName().toLowerCase();
		ip = pp.getAddress().getHostName();
		this.email = email;
		proxyPlayer = pp;
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
	
	public String getIp()
	{
		return ip;
	}

}
