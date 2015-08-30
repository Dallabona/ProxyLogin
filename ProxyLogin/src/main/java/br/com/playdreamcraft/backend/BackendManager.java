package br.com.playdreamcraft.backend;

import br.com.playdreamcraft.Autenticavel;
import br.com.playdreamcraft.Registravel;
import br.com.playdreamcraft.dao.MySqlBackend;


public class BackendManager implements Registravel, Autenticavel
{
	private Cache cache;
	private PersistenceBackend pBackend;
	
	public BackendManager()
	{
		cache = ContaCache.getCache();
		
	}

	public enum BackendPersistenceType
	{
		MYSQL;
	}
	
	private PersistenceBackend getBackendPersistence(BackendPersistenceType bp)
	{
		if(bp == BackendPersistenceType.MYSQL)
			return new MySqlBackend();
			
		return null;
	}
	
}