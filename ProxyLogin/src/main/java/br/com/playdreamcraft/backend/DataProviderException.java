package br.com.playdreamcraft.backend;

public class DataProviderException extends Exception
{

	/**
	 * Exceção que pode ser lançada por um dataprovider
	 */
	private static final long	serialVersionUID	= -4515738808792207884L;
	public DataProviderException(String message)
	{
		super(message);
	}
}
