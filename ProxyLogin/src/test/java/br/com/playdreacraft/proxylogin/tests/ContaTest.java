package br.com.playdreacraft.proxylogin.tests;

import br.com.playdreamcraft.proxylogin.account.Conta;

public class ContaTest
{
	public static void main(String[] args)
	{
		Conta conta = new Conta("192.168.25.1");		
		Conta conta2 = conta.getClone();
		System.out.println(conta+" -(1) "+ conta.getIp());
		System.out.println(conta2+" -(2) "+ conta2.getIp());
	}
}
