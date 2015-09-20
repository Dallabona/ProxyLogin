package br.com.playdreamcraft.proxylogin.security.passwords.hash.salt;

/**
 * All salt types
 * @author PalitoDeDente
 *
 */
public enum SaltTypes
{

	GENUINE_SALT("GENUINE_SALT");
	
	String stringRepresetation;
	
	SaltTypes(String stringRepresentation)
	{
		this.stringRepresetation = stringRepresentation;
	}
	
}
