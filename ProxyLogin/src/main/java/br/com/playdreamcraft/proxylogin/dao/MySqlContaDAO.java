package br.com.playdreamcraft.proxylogin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.security.auth.login.AccountNotFoundException;

import net.md_5.bungee.api.connection.ProxiedPlayer;
import br.com.playdreamcraft.proxylogin.account.Account;
import br.com.playdreamcraft.proxylogin.backend.DataProviderException;
import br.com.playdreamcraft.proxylogin.utils.MySqlPoolSettings;

public class MySqlContaDAO implements AccountDAO
{
	private static final String TABLE = "authme";
	
	private static final String		DELETAR				= "DELETE FROM "+TABLE+" WHERE username = ?";
	private static final String		SELECIONAR			= "SELECT * FROM "+TABLE+" where username = ?";
	private static final String		INSERIR				= "INSERT into "+TABLE+" (username, password, email, ip, lastlogin) VALUES (?,?,?,?,?)";

	private static final String		ATUALIZAR_PASSWORD	= "UPDATE "+TABLE+" SET password = ? WHERE username = ?";
	private static final String		ATUALIZAR_EMAIL		= "UPDATE "+TABLE+" SET email = ? WHERE username = ?";
	private static final String		ATUALIZAR_LASTSEEN	= "UPDATE "+TABLE+" SET lastlogin = ? WHERE username = ?";
	private static final String		ATUALIZAR_LASTIP	= "UPDATE "+TABLE+" SET ip = ? WHERE username = ?";

	@SuppressWarnings("unused")
	private static final String		NAME				= "username";
	private static final String		PASSWORD			= "password";
	private static final String		EMAIL				= "email";
	private static final String		LAST_IP				= "ip";
	private static final String		LAST_SEEN			= "lastlogin";	


	private static final String		NAME_CONDITION		= " WHERE username = ?";
	private static final char		SEPARADOR			= ',';
	private static final String		INTERROGACAO		= " = ?";
	private static final char		SPACE				= ' ';

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
	public void inserirConta(Account conta) throws DataProviderException
	{
		Connection con = null;
		PreparedStatement ps = null;

		try
		{
			con = MySqlPoolSettings.getMYSQL().getPool().getConnection();

			ps = con.prepareStatement(INSERIR);
			ps.setString(1, conta.getName().toLowerCase());
			ps.setString(2, conta.getHash());
			ps.setString(3, conta.getEmail());
			ps.setString(4, "192.168.1.1");//ps.setString(4, conta.getProxiedPlayer().getAddress().getHostName());//TODO ARRUMAR QUANDO TIVER PRONTO
			ps.setLong(5, conta.getLastSeen());
			ps.executeUpdate();
		}catch (SQLException sqle)
		{
			throw new DataProviderException("Mysql problem "
					+ sqle.getMessage());
		}
		finally
		{
			fecharConnexao(con);
			fecharPreparedStatement(ps);
		}

	}

	@Override
	public Account getContaPorNome(String nome) throws AccountNotFoundException,
			DataProviderException
	{
		Account contaRetorno = null;
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
				contaRetorno = new Account(nome, email, password);			
			}else
				throw new AccountNotFoundException();
		}catch (SQLException sqle)
		{
			throw new DataProviderException("Mysql problem "
					+ sqle.getMessage());
		}
		finally
		{
			fecharConnexao(con);
			fecharPreparedStatement(ps);
			fecharResultset(rs);
		}

		return contaRetorno;
	}

	@Override
	public Account getContaPorProxiedPlayer(ProxiedPlayer pp)
			throws AccountNotFoundException, DataProviderException
	{
		Account contaRetorno = null;
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
				contaRetorno = new Account(pp, email, password);
			}else
				throw new AccountNotFoundException();
		}catch (SQLException sqle)
		{
			throw new DataProviderException("Mysql problem "
					+ sqle.getMessage());
		}
		finally
		{
			fecharConnexao(con);
			fecharPreparedStatement(ps);
			fecharResultset(rs);
		}

		return contaRetorno;
	}

	@Override
	public void deletarConta(Account conta) throws DataProviderException
	{
		Connection con = null;
		PreparedStatement ps = null;
		try
		{
			con = MySqlPoolSettings.getMYSQL().getPool().getConnection();

			ps = con.prepareStatement(DELETAR);
			ps.setString(1, conta.getName().toLowerCase());
			ps.executeUpdate();

		}catch (SQLException sqle)
		{			throw new DataProviderException("Mysql problem "
					+ sqle.getMessage());
		}
		finally
		{
			fecharPreparedStatement(ps);
			fecharConnexao(con);
		}
	}

	@Override
	public void atualizarConta(Account conta) throws AccountNotFoundException,
			DataProviderException
	{
		String nome = conta.getName();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String query = null;
		ArrayList<String> update;
		
		try (Connection con = MySqlPoolSettings.getMYSQL().getPool()
				.getConnection())
		{
			try
			{

				ps = con.prepareStatement(SELECIONAR);
				ps.setString(1, nome.toLowerCase());
				rs = ps.executeQuery();

				if(rs.next())
				{
					update = new ArrayList<>();

					String password = rs.getString(PASSWORD);
					String email = rs.getString(EMAIL);
					String lastip = rs.getString(LAST_IP);
					Long lastSeen = rs.getLong(LAST_SEEN);

					if(!(conta.getHash().equals(password)))
						update.add(PASSWORD);// password need to update ?

					if(!(conta.getEmail().equals(email)))
						update.add(EMAIL);// email need to update ?

				/*	if(!(conta.getProxiedPlayer().getAddress().getHostName() 
							.equals(lastip)))
						update.add(LAST_IP);// ip need to update ?*/

					if(!(conta.getLastSeen() == lastSeen))
						update.add(LAST_SEEN);// last seen need to update ?

					if(update.size() == 1)
					{
						for(String string : update)
						{
							switch (string)
							{
								case PASSWORD:{
									query = ATUALIZAR_PASSWORD;
									break;
								}

								case EMAIL:{
									query = ATUALIZAR_EMAIL;
									break;
								}

								case LAST_IP:{
									query = ATUALIZAR_LASTIP;
									break;
								}

								case LAST_SEEN:{
									query = ATUALIZAR_LASTSEEN;
									break;
								}
							}
							break;
						}
					}
					if(update.size() > 1)
					{
						StringBuilder sb = new StringBuilder(
								"UPDATE "+TABLE+" SET ");
						boolean first = true;
						for(String string : update)
						{							
							if(first)
							{
								sb.append(string);
								sb.append(INTERROGACAO); // UPDATE accounts SET
															// name = ?, email =
															// ?
								first = false;
							}else
							{
								sb.append(SEPARADOR);
								sb.append(SPACE);
								sb.append(string);
								sb.append(INTERROGACAO);
							}
						}
						sb.append(NAME_CONDITION);						
						query = sb.toString();								
					}

				}else
					throw new AccountNotFoundException();
			}catch (SQLException sqle)
			{
				throw new DataProviderException("Mysql problem "
						+ sqle.getMessage());
			}
			finally
			{
				fecharPreparedStatement(ps);
				fecharResultset(rs);
			}

			try
			{
				if(query != null && update != null )
				{					
					ps = con.prepareStatement(query);
		
					for(int i = 0 ; i < update.size() ; i++)
					{
						switch (update.get(i))
						{
							case NAME:
							{
								ps.setString(i+1, conta.getName());
								break;
							}							
							case PASSWORD:
							{
								ps.setString(i+1, conta.getHash());
								break;
							}	
							
							case EMAIL:
							{
								ps.setString(i+1, conta.getEmail());
								break;
							}
							
							case LAST_SEEN:
							{
								ps.setLong(i+1, conta.getLastSeen());
								break;
							}
							case LAST_IP:
							{
								ps.setString(i+1, conta.getHash()); //TODO
								break;
							}
							default:
								break;
						}						
					}	
					
					ps.setString(update.size()+1, conta.getName());
					ps.executeUpdate();

				}
			}catch (SQLException sqle)
			{
				throw new DataProviderException("Mysql problem "
						+ sqle.getMessage());
			}
			finally
			{
				update.clear();
				fecharResultset(rs);
			}

		}catch (SQLException sqle)
		{
			throw new DataProviderException("Mysql problem "
					+ sqle.getMessage());
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
