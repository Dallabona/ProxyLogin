package br.com.playdreamcraft.proxylogin.account;

import java.util.concurrent.TimeUnit;

import br.com.playdreamcraft.proxylogin.ProxyLogin;
import net.md_5.bungee.api.connection.ProxiedPlayer;

public class Conta
{	
	
	public long getLastSeen()
	{
		return lastSeen;
	}

	private String name;
	private String hash;
	private String email;
	
	private long lastSeen; // in minutes

	private ProxiedPlayer proxiedPlayer;
	private boolean logged;
	
	public Conta(String name, String email, String password)
	{
		//TODO DISABLED JUST FOR TEST
		//this.proxiedPlayer = ProxyLogin.getInstance().getProxy().getPlayer(name);			
		this.email = email;
		this.hash = password;
		this.name = name;		
		lastSeen = TimeUnit.MILLISECONDS.toMinutes(System.currentTimeMillis());
	}
	
	public Conta(ProxiedPlayer pp, String email, String password)
	{
		name = pp.getName().toLowerCase();		
		this.email = email;
		proxiedPlayer = pp;
		lastSeen = TimeUnit.MILLISECONDS.toMinutes(System.currentTimeMillis());
	}
	
	public String getHash()
	{
		return hash;
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

	public ProxiedPlayer getProxiedPlayer() 
	{
		return proxiedPlayer;
	}	
		
}
