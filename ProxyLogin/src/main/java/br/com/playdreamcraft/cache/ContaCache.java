package br.com.playdreamcraft.cache;

import br.com.playdreamcraft.account.Conta;
import br.com.playdreamcraft.backend.DataProvider;

public interface ContaCache extends DataProvider
{
	
	public void atualizarTodasContas();
	public void atualizarConta(Conta conta);
	public void inserirConta(Conta conta);	
	public void removerUmaConta(Conta conta);
	public void removerTodasContas();
}
