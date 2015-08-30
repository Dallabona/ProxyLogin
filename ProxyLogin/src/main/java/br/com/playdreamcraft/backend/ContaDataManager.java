package br.com.playdreamcraft.backend;

import javax.security.auth.login.AccountNotFoundException;

import br.com.playdreamcraft.account.Conta;
import br.com.playdreamcraft.dao.ContaDAO;

public class ContaDataManager implements ContaDAO
{

	ContaDAO contaDAOcache;
	ContaDAO contaDAOpersistence;
	private static ContaDataManager singleton;
	
	private ContaDataManager(ContaDAO contaDAOcache, ContaDAO contaDAOpersistence)
	{
		this.contaDAOcache = contaDAOcache;
		this.contaDAOpersistence = contaDAOpersistence;
	}
	@Override
	public void inserirConta(Conta conta)
	{
		contaDAOcache.inserirConta(conta);
		contaDAOpersistence.inserirConta(conta);
	}

	@Override
	public Conta getContaPorNome(String nome) throws AccountNotFoundException
	{
		Conta conta;
		
		conta = contaDAOcache.getContaPorNome(nome);
		if(conta != null)
			return conta;
	
		conta = contaDAOpersistence.getContaPorNome(nome);
		
		return conta;
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
	
	
}
