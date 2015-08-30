package br.com.playdreamcraft.utils;

import java.sql.SQLException;

import br.com.playdreamcraft.ProxyLogin;
import br.com.playdreamcraft.backend.PersistenceBackendSetup;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

/**
 * Classe do tipo Singleton destinada para setup da Pool de conex�es
 * 
 * @author _LucasD
 * @see ProxyLogin
 */
public class MySqlPoolSettings 
{

	private static MySqlPoolSettings mysql;
	
	private String mysqlIp;
	private int mysqlPort;
	private String mysqlDatabase;
	private String mysqlUsername;
	private String mysqlPassword;
	private static HikariDataSource hikari;
	
	/**
	 * Construtor da classe Mysql, passando as informa��es de setup do banco	
	 * 
	 * @param mysqlIp Ip do banco de dados
	 * @param mysqlPort Porta do banco de dados
	 * @param mysqlDatabase Banco em quest�o
	 * @param mysqlUsername Usu�rio do banco de dados
	 * @param mysqlPassword Senha do banco de dados
	 */
	private MySqlPoolSettings(String mysqlIp, int mysqlPort, String mysqlDatabase, String mysqlUsername, String mysqlPassword)
	{
		this.mysqlIp = mysqlIp;
		this.mysqlPort = mysqlPort;
		this.mysqlDatabase = mysqlDatabase;
		this.mysqlUsername = mysqlUsername;
		this.mysqlPassword = mysqlPassword;
	}
	
	/**
	 * M�todo respons�vel pelo setup do banco	
	 * @param mysqlIp Ip do banco de dados
	 * @param mysqlPort Porta do banco de dados
	 * @param mysqlDatabase Banco em quest�o
	 * @param mysqlUsername Usu�rio do banco de dados
	 * @param mysqlPassword Senha do banco de dados
	 */
	public static void setupMysql(String mysqlIp, int mysqlPort, String mysqlDatabase, String mysqlUsername, String mysqlPassword)
	{
		if(mysql == null)
		{
			mysql = new MySqlPoolSettings(mysqlIp, mysqlPort, mysqlDatabase, mysqlUsername, mysqlPassword);
		}
	}	
	
	/**
	 * M�todo para fazer setup do HikariCP
	 */
	public void setupHikari()
	{
		HikariConfig config = new HikariConfig();
		
		config.setJdbcUrl("jdbc:mysql://"+mysqlIp+":"+mysqlPort+"/"+mysqlDatabase);
		config.setUsername(mysqlUsername);
		config.setPassword(mysqlPassword);
		config.setAutoCommit(true);
		config.setConnectionTimeout(10000);
		config.setIdleTimeout(1800000);
		config.setMaximumPoolSize(17);
		config.addDataSourceProperty("cachePrepStmts", "true");
		config.addDataSourceProperty("prepStmtCacheSize", "250");
		config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
		MySqlPoolSettings.hikari = new  HikariDataSource(config);
	}
	
	/**
	 * M�todo para recuperar uma instancia da classe Mysql
	 * @return Retorna uma instancia da classe Mysql
	 * @throws SQLException Lan�a essa exce��o quando 
	 */
	public static MySqlPoolSettings getMYSQL() throws Exception
	{
		if(mysql == null)
		{
			throw new SQLException("Mysql nao foi iniciado");			
		}		
			return mysql;				
	}
	
	/**
	 * M�todo para pegar a pool de conex�o
	 * @return Retorna a pool de conex�o
	 */
	public HikariDataSource getPool()
	{
		return hikari;
	}

	/**
	 * Faz setup do backend
	 */
	@Override
	public void setupBackend()
	{
				
	}
	
}
