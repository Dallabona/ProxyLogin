package br.com.playdreamcraft.backend;

import br.com.playdreamcraft.account.Conta;

public interface PercistenciaBackend extends DataBackend
{	
	public void gravarConta(Conta conta);
	public PercistenciaBackend getPercistenciaBackend();
}
