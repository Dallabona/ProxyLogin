package br.com.playdreamcraft.cache;

import java.util.HashSet;
import java.util.Set;

import javax.security.auth.login.AccountNotFoundException;

import br.com.playdreamcraft.account.Conta;
import br.com.playdreamcraft.dao.ContaDAO;

/**
 * Cache de contas
 * 
 * @author _LucasD
 *
 */
public class GenuineContaCache implements ContaCache, ContaDAO
{
	private ContaDAO contaDAO;
	private static Set<Conta> contas = new HashSet<>();
	private static GenuineContaCache contaCache;

	private static GenuineContaCache instance;

	private GenuineContaCache()
	{
	}

	public static GenuineContaCache getInstance()
	{
		if(null == instance)
			instance = new GenuineContaCache();

		return instance;
	}


	@Override
	public void inserirConta(Conta conta)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public Conta getContaPorNome(String nome) throws AccountNotFoundException
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deletarConta(Conta conta) throws AccountNotFoundException
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void atualizarTodasContas()
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void atualizarConta(Conta conta)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void carregarConta(Conta conta)
	{
		// TODO Auto-generated method stub
		
	}



	



}
