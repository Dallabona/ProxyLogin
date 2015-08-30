package br.com.playdreamcraft.factory;

import br.com.playdreamcraft.backend.PersistenceBackends;
import br.com.playdreamcraft.dao.ContaDAO;
import br.com.playdreamcraft.dao.MySqlContaDAO;

public class DaoFactory
{
	public static ContaDAO getContaDAO(PersistenceBackends pBack)
	{
		if(pBack == PersistenceBackends.MYSQL)
			return new MySqlContaDAO();
		
		return null;
	}
}
