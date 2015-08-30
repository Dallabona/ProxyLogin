package br.com.playdreamcraft.cache;

import java.util.HashSet;
import java.util.Set;

import javax.security.auth.login.AccountNotFoundException;

import br.com.playdreamcraft.account.Conta;
import br.com.playdreamcraft.dao.ContaDAO;

/**
 * Cache de contas
 * @author _LucasD
 *
 */
public class ContaCache implements Cache, ContaDAO
{
	private ContaDAO contaDAO;
	private static Set<Conta> contas = new HashSet<>();
	private static ContaCache contaCache;
	
	private ContaCache()
	{
		
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
	public Conta carregarConta(String nome) throws AccountNotFoundException
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void inserirConta(Conta conta)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public Conta getContaPorNome(String nome) 
	{
		
		return null;
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
	public void atualizarConta(Conta conta) throws AccountNotFoundException
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void atualizarTudo()
	{
		// TODO Auto-generated method stub
		
	}

	
	
	



}
