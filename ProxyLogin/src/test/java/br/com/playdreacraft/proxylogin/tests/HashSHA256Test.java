package br.com.playdreacraft.proxylogin.tests;

import java.security.NoSuchAlgorithmException;

import br.com.playdreamcraft.proxylogin.security.HashSHA256;

public class HashSHA256Test
{

	public static void main(String[] args) throws NoSuchAlgorithmException
	{
		HashSHA256 hash = new HashSHA256();
		
		// System.out.println(hash.gerarHash("aa", "123"));
System.out.println(hash.senhaCorreta("$SHA$123$23596a0cc989b4625c10782450a511eafdd026a14a67a942667d8c4a83c80c32"
, "aa"));
	}

}
