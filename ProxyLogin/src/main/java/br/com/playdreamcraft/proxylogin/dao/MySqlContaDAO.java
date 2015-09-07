package br.com.playdreamcraft.proxylogin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import javax.security.auth.login.AccountNotFoundException;

import net.md_5.bungee.api.connection.ProxiedPlayer;
import br.com.playdreamcraft.proxylogin.account.Conta;
import br.com.playdreamcraft.proxylogin.backend.DataProviderException;
import br.com.playdreamcraft.proxylogin.utils.MySqlPoolSettings;

public class MySqlContaDAO implements ContaDAO
{

	private static final String	DELETAR		= "DELETE FROM accounts WHERE name = ?";
	private static final String	SELECIONAR	= "SELECT * FROM accounts where name = ?";
	private static final String INSERIR = "INSERT into accounts (name, password, email, lastip, lastseen) VALUES (?,?,?)";
	private static final String ATUALIZAR_PASSWORD = "UPDATE accounts SET password = ? WHERE name = ? ";
	private static final String ATUALIZAR_PASSWORD = "UPDATE accounts SET password = ?, email = ?, lastip = ?, lastseen = ? WHERE name = ? ";
	private static final String ATUALIZAR_PASSWORD = "UPDATE accounts SET password = ?, email = ?, lastip = ?, lastseen = ? WHERE name = ? ";
	private static final String ATUALIZAR_PASSWORD = "UPDATE accounts SET password = ?, email = ?, lastip = ?, lastseen = ? WHERE name = ? ";
	
	private static final String NAME = "name";
	private static final String PASSWORD = "password";
	private static final String EMAIL = "email";
	private static final String LAST_IP = "lastip";
	private static final String LAST_SEEN = "lastseen";
	private static final String SEPARATOR = ",";

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
				String password = rs.getString(PASSWORD);
				String email = rs.getString(EMAIL);
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
				String password = rs.getString(PASSWORD);
				String email = rs.getString(EMAIL);
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
		boolean passwordUpdate = false;
		boolean emailUpdate = false;
		boolean lastIpUpdate = false;
		boolean lastSeenUpdate = false;
		

		try
		{
			con = MySqlPoolSettings.getMYSQL().getPool().getConnection();

			ps = con.prepareStatement(SELECIONAR);
			ps.setString(1, nome.toLowerCase());
			rs = ps.executeQuery();

			if(rs.next())
			{
				Set<String> update = new HashSet<>();
				
				String password = rs.getString(PASSWORD);
				String email = rs.getString(EMAIL);
				String lastip = rs.getString(LAST_IP);
				Long lastSeen = rs.getLong(LAST_SEEN);
				
				if(!(conta.getPassword().equals(password)))
				{
					passwordUpdate = true; //password need to update ?	
					update.add(PASSWORD);
				}
				if(!(conta.getEmail().equals(email)))
				{
					emailUpdate = true;//email need to update ?
					update.add(EMAIL);
				}
				if(!(conta.getProxiedPlayer().getAddress().getHostName().equals(lastip)))
				{
					lastIpUpdate = true; //ip need to update ?
					update.add(LAST_IP);
				}
				if(!(conta.getLastSeen() == lastSeen ))
				{
					lastSeenUpdate = true; //last seen need to update ?
					update.add(LAST_SEEN);
				}
				
				if(update.size() == 1)
				{
					for(String string : update)
					{
						
					}
				}
				if(update.size() > 1)
				{
					for(String string : update)
					{
						
					}
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
