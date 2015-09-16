package br.com.playdreamcraft.proxylogin.dao;

import javax.security.auth.login.AccountNotFoundException;

import net.md_5.bungee.api.connection.ProxiedPlayer;
import br.com.playdreamcraft.proxylogin.account.Account;
import br.com.playdreamcraft.proxylogin.backend.DataProviderException;

public interface AccountDAO
{
	/**
	 * Persiste uma conta
	 * @param conta Conta a ser persistida
	 */
	public void inserirConta(Account conta) throws DataProviderException;
	
	/**
	 * Recupera uma conta já persistida pelo nome
	 * @param nome Nome da conta
	 * @return Retorna a conta
	 * @throws AccountNotFoundException A conta pode nao existir
	 */
	public Account getContaPorNome(String nome) throws AccountNotFoundException,DataProviderException;
	
	/**
	 * Recupera uma conta já persistida pelo proxied player
	 * @param nome Nome da conta
	 * @return Retorna a conta
	 * @throws AccountNotFoundException A conta pode nao existir
	 */
	public Account getContaPorProxiedPlayer(ProxiedPlayer pp) throws AccountNotFoundException,DataProviderException;	
	
	/**
	 * Deleta uma conta dos registros
	 * @param conta Conta a ser deletada
	 * @throws AccountNotFoundException A conta pode nao existir
	 */
	public void deletarConta(Account conta)throws AccountNotFoundException,DataProviderException;	
	
	
	/**
	 * Atualizar conta
	 * @param conta Conta em questão
	 * @throws AccountNotFoundException A conta pode não existir
	 */
	public void atualizarConta(Account conta) throws AccountNotFoundException,DataProviderException;
}
