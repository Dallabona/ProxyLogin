package br.com.playdreamcraft.cache;

import java.util.Collections;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

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
	private static Set<Conta> contas = Collections.newSetFromMap(new ConcurrentHashMap<Conta,Boolean>());
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

	@Override
	public void removerUmaConta(Conta conta)
	{
		// TODO Auto-generated method stub
		
	}



	



}
