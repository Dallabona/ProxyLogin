package br.com.playdreamcraft.backend;

import javax.security.auth.login.AccountNotFoundException;

import br.com.playdreamcraft.account.Conta;

public interface DataBackend 
{
	public Conta getContaPorNome(String nome) throws AccountNotFoundException;	
}
