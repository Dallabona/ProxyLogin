package br.com.playdreamcraft.dao;


import javax.security.auth.login.AccountNotFoundException;

import br.com.playdreamcraft.account.Conta;
import br.com.playdreamcraft.backend.Cache;
import br.com.playdreamcraft.backend.DataBackend;
import br.com.playdreamcraft.backend.PersistenceBackend;


public class MySqlContaDAO implements ContaDAO
{
	
	public static final String INSERIR = "INSERT INTO accounts VALUES";

	@Override
	public void inserirConta(Conta conta)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deletarConta(Conta conta) throws AccountNotFoundException
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void alterarSenha(Conta conta) throws AccountNotFoundException
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void atualizarTodoCache()
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void atualizarUmaConta(Conta conta)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public Conta carregarConta(String nome)
	{
		// TODO Auto-generated method stub
		return null;
	}



	
	


}
