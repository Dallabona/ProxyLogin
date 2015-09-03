package br.com.playdreamcraft.proxylogin.factory;

import br.com.playdreamcraft.proxylogin.backend.CacheBackendType;
import br.com.playdreamcraft.proxylogin.backend.PersistenceBackendType;
import br.com.playdreamcraft.proxylogin.cache.GenuineContaCache;
import br.com.playdreamcraft.proxylogin.dao.ContaDAO;
import br.com.playdreamcraft.proxylogin.dao.MySqlContaDAO;

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
			return GenuineContaCache.getInstance();
		
		return null;
	}
}
