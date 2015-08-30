package br.com.playdreamcraft.dao;

import br.com.playdreamcraft.account.Conta;
import br.com.playdreamcraft.backend.PersistenceBackend;

public interface ContaDAO extends PersistenceBackend 
{
	public void inserirConta(Conta conta);
	public Conta contaPorNome(String nome);
	public void deletarConta(Conta conta);
	public void alterarSenha(Conta conta);
}
