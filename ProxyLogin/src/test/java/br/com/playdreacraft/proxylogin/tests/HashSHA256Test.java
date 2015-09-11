package br.com.playdreacraft.proxylogin.tests;

import java.security.NoSuchAlgorithmException;

import br.com.playdreamcraft.proxylogin.security.HashSHA256;

public class HashSHA256Test
{

	public static boolean estaCerto(String hash, String senha)
	{
		try
		{
			return HashSHA256.getInstance().senhaCorreta(hash, senha);
		}catch (NoSuchAlgorithmException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}return false;
	}

}
