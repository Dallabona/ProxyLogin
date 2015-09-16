package br.com.playdreacraft.proxylogin.tests;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.concurrent.TimeUnit;

import javax.security.auth.login.AccountNotFoundException;

import br.com.playdreamcraft.proxylogin.account.Account;
import br.com.playdreamcraft.proxylogin.backend.DataProviderException;
import br.com.playdreamcraft.proxylogin.dao.MySqlContaDAO;
import br.com.playdreamcraft.proxylogin.utils.MySqlPoolSettings;

public class MySqlContaDAOTest
{
	public static MySqlContaDAO mysql =null;
	public static void main(String[] args) throws AccountNotFoundException, DataProviderException
	{
	
		
		MySqlContaDAOTest teste = new MySqlContaDAOTest();
	
		MySqlPoolSettings.setupMysql("192.168.25.229", 3306, "authme", "root", "Kvmdks3bmg");
		 mysql = MySqlContaDAO.getInstance() ;		
		//mysql.deletarConta(conta);
		
		/* mysql.inserirConta(conta);
		Conta conta = mysql.getContaPorNome("ClovisAuth");
		
		System.out.println(conta.getHash());
		System.out.println(conta.getEmail());
		System.out.println(HashSHA256Test.estaCerto(conta.getHash(), "123321"));*/
		teste.testeMysql();
		
		try
		{
			System.out.println("Esperando");
			Thread.sleep(500000);
		}catch (InterruptedException e1)
		{
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println("Saiu do esperar");
		
		try
		{
			MySqlPoolSettings.getMYSQL().getPool().close();
			System.out.println("Fechou pool");
		}catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void testeMysql()
	{
		new Thread() 
		{
	@Override
	public void run()
		{
			
			
			
			System.out.println("Iniciou");
			
			for(int i = 101 ; i < 5100 ; i++)
			{
				try
				{					
					mysql.deletarConta(new Account("lalala"+i, "das@hotmail.com", "123322144"));
				}catch (DataProviderException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			System.out.println("Acabou");
		
		}
		}.start();
	}
	
}//classe
