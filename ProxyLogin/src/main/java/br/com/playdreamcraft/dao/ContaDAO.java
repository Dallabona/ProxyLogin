package br.com.playdreamcraft.dao;

import javax.security.auth.login.AccountNotFoundException;

import br.com.playdreamcraft.account.Conta;
import br.com.playdreamcraft.backend.Cache;
import br.com.playdreamcraft.backend.PersistenceBackend;

public interface ContaDAO
{
	/**
	 * Persiste uma conta
	 * @param conta Conta a ser persistida
	 */
	public void inserirConta(Conta conta);
	
	/**
	 * Recupera uma conta já persistida pelo nome
	 * @param nome Nome da conta
	 * @return Retorna a conta
	 * @throws AccountNotFoundException A conta pode nao existir
	 */
	public Conta getContaPorNome(String nome) throws AccountNotFoundException;	
	
	
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
	
	/**
	 * Atualizar conta
	 * @param conta Conta em questão
	 * @throws AccountNotFoundException A conta pode não existir
	 */
	public void atualizarConta(Conta conta) throws AccountNotFoundException;
}
