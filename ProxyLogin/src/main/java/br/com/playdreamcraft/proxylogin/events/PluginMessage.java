package br.com.playdreamcraft.proxylogin.events;

import net.md_5.bungee.api.event.PluginMessageEvent;
import net.md_5.bungee.event.EventHandler;

public class PluginMessage
{
	private static String channel;
	
	public PluginMessage()
	{
		 channel = "proxylogin";
	}

	@EventHandler
	public void onPluginMessage(PluginMessageEvent event)
	{
		if(!event.getTag().equals(channel))
			return;
			
		byte[] data = event.getData();
		String string = new String(data);
		if()
		
	}
	
}
