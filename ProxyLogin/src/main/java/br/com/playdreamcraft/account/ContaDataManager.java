package br.com.playdreamcraft.account;

import javax.security.auth.login.AccountNotFoundException;

import br.com.playdreamcraft.backend.DataProviderException;
import br.com.playdreamcraft.backend.PersistenceBackend;
import br.com.playdreamcraft.cache.ContaCache;
import br.com.playdreamcraft.dao.ContaDAO;
import br.com.playdreamcraft.factory.DAOFactory;

public class ContaDataManager implements ContaDAO
{

	ContaDAO contaDAOcache;
	ContaDAO contaDAOpersistence;
	private static ContaDataManager singleton;
	
	private ContaDataManager(ContaDAO contaDAOcache, ContaDAO contaDAOpersistence)
	{
		if(!(contaDAOcache instanceof ContaCache) || !(contaDAOpersistence instanceof PersistenceBackend))
			throw new RuntimeException("Algum problema ocorreu, provavelmente com o cache ou com a persistencia de dados");
		
		this.contaDAOcache = contaDAOcache;
		this.contaDAOpersistence = contaDAOpersistence;
	}
	
	public static ContaDataManager getInstance()
	{
		if(singleton == null)
			singleton = new ContaDataManager(DAOFactory.getCacheContaDAO(), DAOFactory.getPersistenceContaDAO());
		
		return singleton;
	}
	
	@Override
	public void inserirConta(Conta conta) throws DataProviderException 
	{		
		contaDAOpersistence.inserirConta(conta);		
		contaDAOcache.inserirConta(conta);		
	}

	@Override
	public Conta getContaPorNome(String nome) throws AccountNotFoundException, DataProviderException
	{
		Conta conta;
		
		conta = contaDAOcache.getContaPorNome(nome);
		if(conta != null)
			return conta;
	
		conta = contaDAOpersistence.getContaPorNome(nome);		
		contaDAOcache.inserirConta(conta);
		
		return conta;
	}

	@Override
	public void deletarConta(Conta conta) throws AccountNotFoundException, DataProviderException
	{				
		 contaDAOpersistence.deletarConta(conta);		
		 contaDAOcache.deletarConta(conta);
	}

	@Override
	public void atualizarConta(Conta conta) throws AccountNotFoundException, DataProviderException
	{		
		String nomeConta = conta.getName();
		Conta contaRollback = null; 
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
