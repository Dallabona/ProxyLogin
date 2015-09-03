package br.com.playdreamcraft.proxylogin.backend;

import br.com.playdreamcraft.proxylogin.config.ConfigManager;

public enum PersistenceBackendType
{	
	
	MYSQL;	
	
	private final static PersistenceBackendType persistenciaSelecionada ;;
	
	static
	{
		persistenciaSelecionada = getTypePerString(ConfigManager.getInstance().getPersistence());		
	}
	
	public static PersistenceBackendType getPersistenciaselecionada()
	{
		return persistenciaSelecionada;
	}	
	
	private static PersistenceBackendType getTypePerString(String persistenceType)
	{		
		for(PersistenceBackendType pTipo : PersistenceBackendType.values())
		{
			if(pTipo.toString().equalsIgnoreCase(persistenceType))
			{
				return pTipo;
			}
		} 
		return MYSQL;
	}
}