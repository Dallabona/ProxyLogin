package br.com.playdreacraft.proxylogin.tests;

import br.com.playdreamcraft.backend.DataProviderException;

public class DataProviderExceptionTest
{

	public static void main(String[] args) throws DataProviderException
	{
		int a =2;
		int b =1;
		if(a+b==3)
		throw new DataProviderException("Teste");
		System.out.println("aa executou");

	}

}
