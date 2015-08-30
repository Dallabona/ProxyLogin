package br.com.playdreamcraft.backend;

import br.com.playdreamcraft.account.Conta;

public interface Cache extends DataBackend
{
	public void atualizarTodoCache();
	public void atualizarUmaConta(Conta conta) ;	
}
