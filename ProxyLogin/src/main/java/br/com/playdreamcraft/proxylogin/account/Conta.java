package br.com.playdreamcraft.proxylogin.account;

import br.com.playdreamcraft.proxylogin.ProxyLogin;
import net.md_5.bungee.api.connection.ProxiedPlayer;

public class Conta
{	
	
	private String name;
	private String password;
	private String email;

	private ProxiedPlayer proxiedPlayer;
	private boolean logged;
	
	public Conta(String name, String email, String password)
	{
		this.proxiedPlayer = ProxyLogin.getInstance().getProxy().getPlayer(name);			
		this.email = email;
		this.password = password;
		this.name = name;		
	}
	
	public Conta(ProxiedPlayer pp, String email, String password)
	{
		name = pp.getName().toLowerCase();		
		this.email = email;
		proxiedPlayer = pp;
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
		return proxiedPlayer;
	}	
		
}
