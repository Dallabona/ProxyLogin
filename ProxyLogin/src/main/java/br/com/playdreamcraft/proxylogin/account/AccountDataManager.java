package br.com.playdreamcraft.proxylogin.account;

import javax.security.auth.login.AccountNotFoundException;

import net.md_5.bungee.api.connection.ProxiedPlayer;
import br.com.playdreamcraft.proxylogin.backend.DataProviderException;
import br.com.playdreamcraft.proxylogin.backend.PersistenceBackend;
import br.com.playdreamcraft.proxylogin.cache.ContaCache;
import br.com.playdreamcraft.proxylogin.dao.AccountDAO;
import br.com.playdreamcraft.proxylogin.factory.DAOFactory;

public class AccountDataManager implements AccountDAO
{

	AccountDAO contaDAOcache;
	AccountDAO contaDAOpersistence;
	private static AccountDataManager singleton;
	
	private AccountDataManager(AccountDAO contaDAOcache, AccountDAO contaDAOpersistence)
	{
		if(!(contaDAOcache instanceof ContaCache) || !(contaDAOpersistence instanceof PersistenceBackend))
			throw new RuntimeException("Algum problema ocorreu, provavelmente com o cache ou com a persistencia de dados");
		
		this.contaDAOcache = contaDAOcache;
		this.contaDAOpersistence = contaDAOpersistence;
	}
	
	public static AccountDataManager getInstance()
	{
		if(singleton == null)
			singleton = new AccountDataManager(DAOFactory.getCacheContaDAO(), DAOFactory.getPersistenceContaDAO());
		
		return singleton;
	}
	
	@Override
	public void inserirConta(Account conta) throws DataProviderException 
	{		
		contaDAOpersistence.inserirConta(conta);		
		contaDAOcache.inserirConta(conta);		
	}

	@Override
	public Account getContaPorNome(String nome) throws AccountNotFoundException, DataProviderException
	{
		Account conta;
		
		conta = contaDAOcache.getContaPorNome(nome);
		if(conta != null)
			return conta;
	
		conta = contaDAOpersistence.getContaPorNome(nome);		
		contaDAOcache.inserirConta(conta);
		
		return conta;
	}
	
	@Override
	public Account getContaPorProxiedPlayer(ProxiedPlayer pp)
			throws AccountNotFoundException, DataProviderException
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deletarConta(Account conta) throws AccountNotFoundException, DataProviderException
	{				
		 contaDAOpersistence.deletarConta(conta);		
		 contaDAOcache.deletarConta(conta);
	}

	@Override
	public void atualizarConta(Account conta) throws AccountNotFoundException, DataProviderException
	{		
		String nomeConta = conta.getName();
		Account contaRollback = null; 
		try
		{
			contaDAOpersistence.atualizarConta(conta);
		}catch (DataProviderException e) //caso acontece algum erro em guardar uma conta
		{		
			contaRollback = contaDAOpersistence.getContaPorNome(nomeConta);
			e.printStackTrace();
		}	
		
		if(contaRollback != null)
		{
			contaDAOcache.deletarConta(conta);
			contaDAOcache.inserirConta(contaRollback);
		}
	}	
	
}
