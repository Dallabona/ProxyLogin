package br.com.playdreamcraft.backend;

import br.com.playdreamcraft.account.Conta;

public interface PercistenciaBackend 
{	
	public void gravarConta(Conta conta);
	public PercistenciaBackend getPercistenciaBackend();
}
