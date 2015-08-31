package br.com.playdreamcraft.backend;

import br.com.playdreamcraft.config.ConfigManager;

public enum CacheBackendType
{

	GENUINE;

	private final static CacheBackendType cacheSelecionado;
																			

	static
	{
		cacheSelecionado = getTypePerString(ConfigManager.getInstance()
				.getCache());
	}

	public static CacheBackendType getCacheSeleccionado()
	{
		return cacheSelecionado;
	}

	private static CacheBackendType getTypePerString(
			String cacheType)
	{
		for(CacheBackendType cTipo : CacheBackendType.values())
		{
			if(cTipo.toString().equalsIgnoreCase(cacheType))
			{
				return cTipo;
			}
		}
		return GENUINE;
	}
}
