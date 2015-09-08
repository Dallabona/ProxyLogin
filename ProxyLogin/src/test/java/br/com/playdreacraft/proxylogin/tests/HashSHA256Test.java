package br.com.playdreacraft.proxylogin.tests;

import java.security.NoSuchAlgorithmException;

import br.com.playdreamcraft.proxylogin.security.HashSHA256;

public class HashSHA256Test
{

	public static void main(String[] args) throws NoSuchAlgorithmException
	{
		HashSHA256 hash = new HashSHA256();
		
		// System.out.println(hash.gerarHash("aa", "123"));
		System.out.println(hash.senhaCorreta("as"
		, "aa"));
	}

}
