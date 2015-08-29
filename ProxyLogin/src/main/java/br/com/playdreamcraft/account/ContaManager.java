package br.com.playdreamcraft.account;

import javax.security.auth.login.AccountNotFoundException;

import br.com.playdreamcraft.backend.DataBackend;

public class ContaManager 
{
	private DataBackend backend;
	
	public void registrarConta(Conta conta)
	{
		
	}
	
	public Conta pegarContaPorNome(String conta) throws AccountNotFoundException
	{
		return backend.getContaPorNome(conta);		
	}	
	
}
