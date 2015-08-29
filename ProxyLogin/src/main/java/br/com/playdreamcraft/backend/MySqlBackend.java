package br.com.playdreamcraft.backend;

import javax.security.auth.login.AccountNotFoundException;

import br.com.playdreamcraft.account.Conta;

public class MySqlBackend implements DataBackend, PercistenciaBackend
{
	
	
	@Override
	public Conta getContaPorNome(String nome) throws AccountNotFoundException 
	{
		
		return null;
	}

	@Override
	public void gravarConta(Conta conta)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public PercistenciaBackend getPercistenciaBackend()
	{
		// TODO Auto-generated method stub
		return null;
	}

}
