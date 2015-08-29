package br.com.playdreamcraft.account;

import net.md_5.bungee.api.connection.ProxiedPlayer;

public class Conta 
{	
	
	String password;
	String name;
	String email;
	ProxiedPlayer proxyPlayer;
	boolean logged;
	
	public Conta()
	{
		
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
