package br.com.playdreamcraft.proxylogin.cache;

import br.com.playdreamcraft.proxylogin.account.Account;
import br.com.playdreamcraft.proxylogin.backend.DataProvider;

public interface ContaCache extends DataProvider
{
	
	public void atualizarTodasContas();
	public void atualizarConta(Account conta);
	public void inserirConta(Account conta);	
	public void removerUmaConta(Account conta);
	public void removerTodasContas();
}
