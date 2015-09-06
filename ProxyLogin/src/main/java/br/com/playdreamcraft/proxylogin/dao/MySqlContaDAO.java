package br.com.playdreamcraft.proxylogin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.security.auth.login.AccountNotFoundException;

import net.md_5.bungee.api.connection.ProxiedPlayer;
import br.com.playdreamcraft.proxylogin.account.Conta;
import br.com.playdreamcraft.proxylogin.backend.DataProviderException;
import br.com.playdreamcraft.proxylogin.utils.MySqlPoolSettings;

public class MySqlContaDAO implements ContaDAO
{

	public static final String	DELETAR		= "DELETE FROM accounts WHERE name = ?";
	public static final String	SELECIONAR	= "SELECT * FROM accounts where name = ?";
	public static final String INSERIR = "INSERT into accounts (name, password, email, lastip, lastseen) VALUES (?,?,?)";
	public static final String ATUALIZAR = "UPDATE accounts SET password = ?, email = ?, lastip = ?, lastseen = ? WHERE name = ? ";

	private static MySqlContaDAO	instance;

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
	public void inserirConta(Conta conta) throws DataProviderException
	{		
		Connection con = null;
		PreparedStatement ps = null;
		
		try
		{
			con = MySqlPoolSettings.getMYSQL().getPool().getConnection();

			ps = con.prepareStatement(INSERIR);
			ps.setString(1, conta.getName().toLowerCase());
			ps.setString(2, conta.getPassword());
			ps.setString(3, conta.getEmail());
			ps.setString(4, conta.getProxiedPlayer().getAddress().getHostName());
			ps.setLong(5, conta.getLastSeen());
						
		
		}catch (SQLException sqle)
		{
			throw new DataProviderException("Mysql problem "
					+ sqle.getMessage());
		}catch (Exception ex)
		{
			throw new DataProviderException("Mysql problem " + ex.getMessage());
		}finally
		{
			fecharConnexao(con);
			fecharPreparedStatement(ps);				
		}
		

	}

	@Override
	public Conta getContaPorNome(String nome) throws AccountNotFoundException,
			DataProviderException
	{
		Conta contaRetorno = null;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try
		{
			con = MySqlPoolSettings.getMYSQL().getPool().getConnection();

			ps = con.prepareStatement(SELECIONAR);
			ps.setString(1, nome.toLowerCase());
			rs = ps.executeQuery();

			if(rs.next())
			{
				String password = rs.getString("password");
				String email = rs.getString("email");
				contaRetorno = new Conta(nome, email, password);
			}else
				throw new AccountNotFoundException();
		}catch (SQLException sqle)
		{
			throw new DataProviderException("Mysql problem "
					+ sqle.getMessage());
		}catch (Exception ex)
		{
			throw new DataProviderException("Mysql problem " + ex.getMessage());
		}finally
		{
			fecharConnexao(con);
			fecharPreparedStatement(ps);
			fecharResultset(rs);	
		}
		
		

		return contaRetorno;
	}

	@Override
	public Conta getContaPorProxiedPlayer(ProxiedPlayer pp)
			throws AccountNotFoundException, DataProviderException
	{
		Conta contaRetorno = null;
		String nome = pp.getName();		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try
		{
			con = MySqlPoolSettings.getMYSQL().getPool().getConnection();

			ps = con.prepareStatement(SELECIONAR);
			ps.setString(1, nome.toLowerCase());
			rs = ps.executeQuery();

			if(rs.next())
			{
				String password = rs.getString("password");
				String email = rs.getString("email");
				contaRetorno = new Conta(pp, email, password);
			}else
				throw new AccountNotFoundException();
		}catch (SQLException sqle)
		{
			throw new DataProviderException("Mysql problem "
					+ sqle.getMessage());
		}catch (Exception ex)
		{
			throw new DataProviderException("Mysql problem " + ex.getMessage());
		}finally
		{
			fecharConnexao(con);
			fecharPreparedStatement(ps);
			fecharResultset(rs);	
		}

		return contaRetorno;
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
			ps.setString(1, conta.getName().toLowerCase());
			ps.executeUpdate();

		}catch (Exception ex)
		{
			throw new DataProviderException("Mysql problem " + ex.getMessage());
		}
		finally
		{
			fecharPreparedStatement(ps);
			fecharConnexao(con);
		}
	}

	@Override
	public void atualizarConta(Conta conta) throws AccountNotFoundException, DataProviderException
	{		
		String nome = conta.getName();		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try
		{
			con = MySqlPoolSettings.getMYSQL().getPool().getConnection();

			ps = con.prepareStatement(SELECIONAR);
			ps.setString(1, nome.toLowerCase());
			rs = ps.executeQuery();

			if(rs.next())
			{
				String password = rs.getString("password");
				String email = rs.getString("email");
				
				if(!(conta.getPassword().equals(password))) //password need to update
				{
					
				}
				
				if(!(conta.getEmail().equals(email))) //email need update
				{
					
				}
				
			}else
				throw new AccountNotFoundException();
		}catch (SQLException sqle)
		{
			throw new DataProviderException("Mysql problem "
					+ sqle.getMessage());
		}catch (Exception ex)
		{
			throw new DataProviderException("Mysql problem " + ex.getMessage());
		}finally
		{
			fecharConnexao(con);
			fecharPreparedStatement(ps);
			fecharResultset(rs);	
		}
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
