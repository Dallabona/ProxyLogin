package br.com.playdreamcraft.backend;

import br.com.playdreamcraft.config.ConfigManager;

public enum PersistenceBackendType
{	
	
	MYSQL, SQLLITE;	
	
	private final static PersistenceBackendType persistenciaSelecionada ;//= PersistenceBackendType.MYSQL;
	
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