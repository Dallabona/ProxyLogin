package br.com.playdreacraft.proxylogin.tests;

import br.com.playdreamcraft.proxylogin.backend.DataProviderException;

public class TryTest
{

	public static void main(String[] args)
	{
		try
		{
			try
			{
				throw new DataProviderException("pum");
				
				
			}catch(DataProviderException exp)
			{
				System.out.println("Fora"+exp.getMessage());
			}
			
			throw new DataProviderException("tutstus");
			
		}catch(DataProviderException exp)
		{
			System.out.println("LucasD"+exp.getMessage());
		}
	}
	
	
	
	
	
}
