package br.com.playdreamcraft.proxylogin.cache;

import br.com.playdreamcraft.proxylogin.account.Conta;
import br.com.playdreamcraft.proxylogin.backend.DataProvider;

public interface ContaCache extends DataProvider
{
	
	public void atualizarTodasContas();
	public void atualizarConta(Conta conta);
	public void inserirConta(Conta conta);	
	public void removerUmaConta(Conta conta);
	public void removerTodasContas();
}
