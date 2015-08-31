package br.com.playdreamcraft.factory;

import br.com.playdreamcraft.backend.CacheBackendType;
import br.com.playdreamcraft.backend.PersistenceBackendType;
import br.com.playdreamcraft.cache.ContaCache;
import br.com.playdreamcraft.dao.ContaDAO;
import br.com.playdreamcraft.dao.MySqlContaDAO;

public class DAOFactory
{
	public static ContaDAO getPersistenceContaDAO()
	{
		if(PersistenceBackendType.getPersistenciaselecionada() == PersistenceBackendType.MYSQL)
			return MySqlContaDAO.getInstance();
		
		return null;
	}
	
	public static ContaDAO getCacheContaDAO()
	{
		if(CacheBackendType.getCacheSeleccionado() == CacheBackendType.GENUINE)
			return ContaCache.getInstance();
		
		return null;
	}
}
