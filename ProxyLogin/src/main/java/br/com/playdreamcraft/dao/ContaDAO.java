package br.com.playdreamcraft.dao;

import javax.security.auth.login.AccountNotFoundException;

import br.com.playdreamcraft.account.Conta;
import br.com.playdreamcraft.backend.PersistenceBackend;

public interface ContaDAO extends PersistenceBackend 
{
	public void inserirConta(Conta conta);
	public Conta getContaPorNome(String nome); //retorna null caso não existir
	public void deletarConta(Conta conta)throws AccountNotFoundException;
	public void alterarSenha(Conta conta) throws AccountNotFoundException;
}
