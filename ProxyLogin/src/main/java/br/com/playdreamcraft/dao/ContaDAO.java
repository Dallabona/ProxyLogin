package br.com.playdreamcraft.dao;

import br.com.playdreamcraft.account.Conta;

public interface ContaDAO 
{
	public void inserirConta(Conta conta);
	public Conta pegarConta(Conta conta);
	public void deletarConta(Conta conta);
	public void alterarSenha(Conta conta);
}
