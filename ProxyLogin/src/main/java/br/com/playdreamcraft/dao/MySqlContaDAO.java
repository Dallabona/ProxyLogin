package br.com.playdreamcraft.dao;

import javax.security.auth.login.AccountNotFoundException;

import br.com.playdreamcraft.account.Conta;
import br.com.playdreamcraft.backend.PersistenceBackend;
import br.com.playdreamcraft.cache.ContaCache;

public class MySqlContaDAO implements ContaDAO
{

	public static final String INSERIR = "INSERT INTO accounts VALUES";

	private static MySqlContaDAO instance;

	private MySqlContaDAO()
	{
	}

	public static MySqlContaDAO getInstance()
	{
		if(null == instance)
			instance = new MySqlContaDAO();

		return instance;
	}

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
	public Conta getContaPorNome(String nome) throws AccountNotFoundException
	{
		// TODO Auto-generated method stub
		return null;
	}

}
