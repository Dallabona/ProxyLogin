package br.com.playdreamcraft.backend;

public enum PersistenceBackendType
{	
	
	MYSQL;
	
	private final static PersistenceBackendType persistenciaSelecionada = PersistenceBackendType.MYSQL;
	
	public static PersistenceBackendType getPersistenciaselecionada()
	{
		return persistenciaSelecionada;
	}	
	
}
