package br.com.playdreamcraft.proxylogin.security;

public interface PasswordHash
{

	public String gerarHash(String senha, String salt);
	public boolean senhaCorreta(String senha, String salt);
	
}
