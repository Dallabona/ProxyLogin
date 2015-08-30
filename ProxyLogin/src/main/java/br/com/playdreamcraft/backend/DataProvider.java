package br.com.playdreamcraft.backend;

import javax.security.auth.login.AccountNotFoundException;

import br.com.playdreamcraft.account.Conta;

public interface DataProvider
{
	public void atualizarTodoCache();
	public void atualizarUmaConta(Conta conta);	
	public Conta carregarConta(String nome) throws AccountNotFoundException;
}
