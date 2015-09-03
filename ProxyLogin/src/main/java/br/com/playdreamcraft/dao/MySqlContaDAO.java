package br.com.playdreamcraft.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.security.auth.login.AccountNotFoundException;

import br.com.playdreamcraft.account.Conta;
import br.com.playdreamcraft.backend.DataProviderException;
import br.com.playdreamcraft.utils.MySqlPoolSettings;

public class MySqlContaDAO implements ContaDAO
{

	public static final String DELETAR = "DELETE FROM accounts where name = ?";

	private static MySqlContaDAO instance;

	private MySqlContaDAO()
	{
	}

	public static MySqlContaDAO getInstance()
	{
		if(null == instance)
			instance = new MySqlContaDAO();

		return instance;
	}

	@Override
	public void inserirConta(Conta conta)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public Conta getContaPorNome(String nome) throws AccountNotFoundException, DataProviderException
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deletarConta(Conta conta) throws DataProviderException
	{		
		Connection con = null;
		PreparedStatement ps = null;
			try
			{
				con = MySqlPoolSettings.getMYSQL().getPool().getConnection();
				
				ps = con.prepareStatement(DELETAR);
				ps.setString(1, conta.getName());
				ps.executeUpdate();
				
			}catch (Exception ex)
			{
				throw new DataProviderException("Mysql problem "+ex.getMessage());				
			}finally
			{
				fecharPreparedStatement(ps);
				fecharConnexao(con);
			}			
	}

	@Override
	public void atualizarConta(Conta conta) throws AccountNotFoundException
	{
		
		
	}


	private void fecharPreparedStatement(PreparedStatement ps)
	{
		if(ps != null)
			try
			{
				ps.close();
			}catch (SQLException e)
			{				
				e.printStackTrace();
			}
	}
	
	private void fecharResultset(ResultSet rs)
	{
		if(rs != null)
			try
			{
				rs.close();
			}catch (SQLException e)
			{				
				e.printStackTrace();
			}
	}
	
	private void fecharConnexao(Connection con)
	{
		if(con != null)
			try
			{
				con.close();
			}catch (SQLException e)
			{				
				e.printStackTrace();
			}
	}
}
