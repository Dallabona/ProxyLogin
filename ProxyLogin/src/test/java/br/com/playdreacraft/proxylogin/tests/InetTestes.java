package br.com.playdreacraft.proxylogin.tests;

import java.net.InetSocketAddress;

public class InetTestes
{

	public static void main(String[] args)
	{
		InetSocketAddress inet = new InetSocketAddress("192.168.1.5", 80);
		
		System.out.println(inet.getHostName());
	}

}
