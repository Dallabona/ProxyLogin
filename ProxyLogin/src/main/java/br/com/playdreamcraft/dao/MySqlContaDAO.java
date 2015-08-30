package br.com.playdreamcraft.dao;


import br.com.playdreamcraft.account.Conta;
import br.com.playdreamcraft.backend.DataBackend;
import br.com.playdreamcraft.backend.PersistenceBackend;


public class MySqlContaDAO implements ContaDAO, PersistenceBackend, DataBackend
{
	
	public static final String INSERIR = "INSERT INTO accounts VALUES";

	@Override
	public void inserirConta(Conta conta)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deletarConta(Conta conta)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void alterarSenha(Conta conta)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public Conta contaPorNome(String nome)
	{
		// TODO Auto-generated method stub
		return null;
	}
	
	


}
