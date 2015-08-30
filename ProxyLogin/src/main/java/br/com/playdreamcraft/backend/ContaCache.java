package br.com.playdreamcraft.backend;

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
public class ContaCache implements Cache, ContaDao
{
	private ContaDAO contaDAO;
	private static Set<Conta> contas = new HashSet<>();
	private static ContaCache contaCache;
	
	private ContaCache()
	{
		
	}	
/*	
	
	@Override
	public Conta getContaPorNome(String nome) throws AccountNotFoundException
	{
		Conta contaRetorno = null;
		for (Conta conta : contas) 
		{
			if(conta == null)
				contas.remove(conta);
			if(conta.getName().equalsIgnoreCase(nome))
				contaRetorno = conta;
		}
		if(contaRetorno == null)
			throw new AccountNotFoundException();
		return contaRetorno;
	}
*/
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
	public void atualizarTudo()
	{
		// TODO Auto-generated method stub
		
	}


}
