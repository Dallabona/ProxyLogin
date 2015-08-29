package br.com.playdreamcraft.backend;

import br.com.playdreamcraft.Registravel;


public class BackendManager implements Registravel, Autenticavel
{
	private Cache cache;
	private PercistenciaBackend pBackend;
	
	public BackendManager()
	{
		cache = ContaCache.getCache();
		pBackend = 
	}

}