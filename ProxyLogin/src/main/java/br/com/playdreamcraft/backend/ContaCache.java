package br.com.playdreamcraft.backend;

import java.util.HashSet;
import java.util.Set;

import javax.security.auth.login.AccountNotFoundException;

import br.com.playdreamcraft.account.Conta;

/**
 * Cache de contas
 * @author _LucasD
 *
 */
public class ContaCache implements DataBackend,Cache
{
	private PersistenceBackend persistenceBackend;
	private static Set<Conta> contas = new HashSet<>();
	private static ContaCache contaCache;
	
	private ContaCache()
	{
		
	}
	
	/**
	 * Recuperar instância de ContaCache
	 * @return Instância unitária da classe ContaCache
	 */
	@Override
	public static Cache getCache()
	{
		if(contaCache == null)
			contaCache = new ContaCache();
		
		return contaCache;
	}
	
	/**
	 * Recupera objeto conta por um nome
	 * @return Instância da conta
	 * @exception Conta nao encontrada
	 */
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

	@Override
	public void atualizarTodoCache() 
	{		
		
	}

	/**
	 * Atualiza uma conta que esta no cache
	 */
	@Override
	public void atualizarUmaConta(Conta conta) throws AccountNotFoundException 
	{
		DataBackend db = (DataBackend) persistenceBackend;
		db.getContaPorNome(conta.getName());
	}
}
