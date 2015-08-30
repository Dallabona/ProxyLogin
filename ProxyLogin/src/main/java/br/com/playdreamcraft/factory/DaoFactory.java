package br.com.playdreamcraft.factory;

import br.com.playdreamcraft.backend.CacheBackendType;
import br.com.playdreamcraft.backend.PersistenceBackendType;
import br.com.playdreamcraft.dao.ContaDAO;
import br.com.playdreamcraft.dao.MySqlContaDAO;

public class DaoFactory
{
	public static ContaDAO getPersistenceContaDAO(PersistenceBackendType pBack)
	{
		if(pBack == PersistenceBackendType.MYSQL)
			return new MySqlContaDAO();
		
		return null;
	}
	
	public static ContaDAO getCacheContaDAO(CacheBackendType cBack)
	{
		if(cBack == CacheBackendType.GENUINE)
			return new ContaCache();
		
		return null;
	}
}
