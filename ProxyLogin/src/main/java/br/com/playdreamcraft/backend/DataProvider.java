package br.com.playdreamcraft.backend;

import br.com.playdreamcraft.account.Conta;

public interface DataProvider
{
	public void atualizarTodoCache();
	public void atualizarUmaConta(Conta conta);	
	public Conta carregarConta(String nome);
}
