package br.com.playdreamcraft.account;

import javax.security.auth.login.AccountNotFoundException;

import br.com.playdreamcraft.backend.DataBackend;
import br.com.playdreamcraft.dao.ContaDAO;

public class ContaManager implements ContaDAO
{
	private DataBackend backend;
	
	public void registrarConta(Conta conta)
	{
		
	}

	@Override
	public void inserirConta(Conta conta)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public Conta contaPorNome(String nome)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deletarConta(Conta conta)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void alterarSenha(Conta conta)
	{
		// TODO Auto-generated method stub
		
	}
	
		
	
}
