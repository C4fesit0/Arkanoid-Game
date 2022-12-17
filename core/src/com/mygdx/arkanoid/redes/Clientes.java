package com.mygdx.arkanoid.redes;

import java.net.InetAddress;

public class Clientes {
	
	private int numCliente;
	private InetAddress ip;
	private int puerto;

	
	public Clientes(int numCliente,int puerto,InetAddress ip){
		
		this.numCliente=numCliente;
		this.ip=ip;
		this.puerto=puerto;
		
	}
	
	public int getNum()
	{
		return this.numCliente;
	}
	
	public InetAddress getIp()
	{
		return this.ip;
	}
	
	public int getPuerto()
	{
		return this.puerto;
	}
	
}
