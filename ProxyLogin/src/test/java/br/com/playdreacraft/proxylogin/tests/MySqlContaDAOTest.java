package br.com.playdreacraft.proxylogin.tests;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.concurrent.TimeUnit;

import javax.security.auth.login.AccountNotFoundException;

import br.com.playdreamcraft.proxylogin.account.Conta;
import br.com.playdreamcraft.proxylogin.backend.DataProviderException;
import br.com.playdreamcraft.proxylogin.dao.MySqlContaDAO;
import br.com.playdreamcraft.proxylogin.utils.MySqlPoolSettings;

public class MySqlContaDAOTest
{

	public static void main(String[] args) throws AccountNotFoundException, DataProviderException
	{
		
		
	MySqlPoolSettings.setupMysql("192.168.25.229", 3306, "authme", "root", "teste123");
		MySqlContaDAO mysql = MySqlContaDAO.getInstance() ;		
		
		
		
		
		for(int i = 101 ; i < 1010 ; i++)
		{
			mysql.atualizarConta(new Conta("lalala"+i, "das@hotmail.com", "123322144"));
		}
		
		//mysql.deletarConta(conta);
		
		/* mysql.inserirConta(conta);
		Conta conta = mysql.getContaPorNome("ClovisAuth");
		
		System.out.println(conta.getHash());
		System.out.println(conta.getEmail());
		System.out.println(HashSHA256Test.estaCerto(conta.getHash(), "123321"));*/
		try
		{
			MySqlPoolSettings.getMYSQL().getPool().close();
		}catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
