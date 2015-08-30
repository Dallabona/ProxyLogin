package br.com.playdreamcraft.backend;

import br.com.playdreamcraft.account.Conta;

public interface PersistenceBackend extends DataBackend
{	
	public void gravarConta(Conta conta);
	public PersistenceBackend getPercistenciaBackend();
}
