package br.com.playdreamcraft.dao;

import javax.security.auth.login.AccountNotFoundException;

import br.com.playdreamcraft.account.Conta;
import br.com.playdreamcraft.backend.Cache;
import br.com.playdreamcraft.backend.PersistenceBackend;

public interface ContaDAO extends PersistenceBackend
{
	/**
	 * Persiste uma conta
	 * @param conta Conta a ser persistida
	 */
	public void inserirConta(Conta conta);	

	
	/**
	 * Deleta uma conta dos registros
	 * @param conta Conta a ser deletada
	 * @throws AccountNotFoundException A conta pode nao existir
	 */
	public void deletarConta(Conta conta)throws AccountNotFoundException;
	
	/**
	 * Aterar 
	 * @param conta 
	 * @throws AccountNotFoundException A conta pode nao existir
	 */
	public void alterarSenha(Conta conta) throws AccountNotFoundException;
}
