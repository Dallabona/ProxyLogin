package br.com.playdreamcraft.dao;

import javax.security.auth.login.AccountNotFoundException;

import br.com.playdreamcraft.account.Conta;
import br.com.playdreamcraft.backend.DataProviderException;

public interface ContaDAO
{
	/**
	 * Persiste uma conta
	 * @param conta Conta a ser persistida
	 */
	public void inserirConta(Conta conta) throws DataProviderException;
	
	/**
	 * Recupera uma conta j� persistida pelo nome
	 * @param nome Nome da conta
	 * @return Retorna a conta
	 * @throws AccountNotFoundException A conta pode nao existir
	 */
	public Conta getContaPorNome(String nome) throws AccountNotFoundException,DataProviderException;	
	
	
	/**
	 * Deleta uma conta dos registros
	 * @param conta Conta a ser deletada
	 * @throws AccountNotFoundException A conta pode nao existir
	 */
	public void deletarConta(Conta conta)throws AccountNotFoundException,DataProviderException;	
	
	
	/**
	 * Atualizar conta
	 * @param conta Conta em quest�o
	 * @throws AccountNotFoundException A conta pode n�o existir
	 */
	public void atualizarConta(Conta conta) throws AccountNotFoundException,DataProviderException;
}
