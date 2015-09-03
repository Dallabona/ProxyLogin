package br.com.playdreamcraft.proxylogin.cache;

import java.util.Collections;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import javax.security.auth.login.AccountNotFoundException;

import net.md_5.bungee.api.connection.ProxiedPlayer;
import br.com.playdreamcraft.proxylogin.account.Conta;
import br.com.playdreamcraft.proxylogin.backend.DataProviderException;
import br.com.playdreamcraft.proxylogin.dao.ContaDAO;

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
		if(!contas.contains(conta))
			contas.add(conta);
	}

	@Override
	public Conta getContaPorNome(String nome) // se nao existir retornar null
	{
		Conta conta = null;

		if(contas.contains(conta))
		{
			for(Conta contas : contas)
			{
				if(contas.getName().equalsIgnoreCase(nome))
				{
					conta = contas;
					break;
				}					
			}
		}
		
		return conta;
	}
	
	@Override
	public Conta getContaPorProxiedPlayer(ProxiedPlayer pp)
			throws AccountNotFoundException, DataProviderException
	{		
		return getContaPorNome(pp.getName());
	}

	@Override
	public void deletarConta(Conta conta) throws AccountNotFoundException
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
	public void atualizarConta(Conta conta)
	{
		Conta contaAntiga = getContaPorNome(conta.getName());
		if(contaAntiga != null)
			contas.remove(contaAntiga);
		contas.add(conta);
	}

	@Override
	public void removerUmaConta(Conta conta)
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
