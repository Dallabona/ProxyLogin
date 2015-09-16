package br.com.playdreamcraft.proxylogin.cache;

import java.util.Collections;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import javax.security.auth.login.AccountNotFoundException;

import net.md_5.bungee.api.connection.ProxiedPlayer;
import br.com.playdreamcraft.proxylogin.account.Account;
import br.com.playdreamcraft.proxylogin.backend.DataProviderException;
import br.com.playdreamcraft.proxylogin.dao.AccountDAO;

/**
 * Cache de contas
 * 
 * @author _LucasD
 *
 */
public class GenuineContaCache implements ContaCache, AccountDAO
{
	private AccountDAO contaDAO;
	private static Set<Account> contas = Collections.newSetFromMap(new ConcurrentHashMap<Account,Boolean>());
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
	public void inserirConta(Account conta)
	{
		if(!contas.contains(conta))
			contas.add(conta);
	}

	@Override
	public Account getContaPorNome(String nome) // se nao existir retornar null
	{
		Account conta = null;

		if(contas.contains(conta))
		{
			for(Account contaLoop : contas)
			{
				if(contaLoop.getName().equalsIgnoreCase(nome))
				{
					conta = contaLoop;
					break;
				}					
			}
		}
		
		return conta;
	}
	
	@Override
	public Account getContaPorProxiedPlayer(ProxiedPlayer pp)
			throws AccountNotFoundException, DataProviderException
	{		
		return getContaPorNome(pp.getName());
	}

	@Override
	public void deletarConta(Account conta) throws AccountNotFoundException
	{
		if(contas.contains(conta))
			contas.remove(conta);
	}

	@Override
	public void atualizarTodasContas()
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void atualizarConta(Account conta)
	{
		Account contaAntiga = getContaPorNome(conta.getName());
		if(contaAntiga != null)
			contas.remove(contaAntiga);
		contas.add(conta);
	}

	@Override
	public void removerUmaConta(Account conta)
	{
		if(contas.contains(conta))
			contas.remove(conta);
	}

	@Override
	public void removerTodasContas()
	{
		contas.clear();
	}	

}
