package br.com.playdreamcraft.proxylogin.security;

import java.security.NoSuchAlgorithmException;

public interface PasswordHash
{

	public String gerarHash(String senha, String salt) throws NoSuchAlgorithmException;
	public boolean senhaCorreta(String hash, String senha) throws NoSuchAlgorithmException;
	
}
