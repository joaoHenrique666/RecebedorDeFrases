package br.com.ufg.inf.dsc.cliente;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

public class Cliente {
	
	public static void main (String [] args) throws IOException{
		
		InetAddress addr = InetAddress.getByName("localhost");
		int port = Integer.parseInt("12345");
		
		Socket servidor = new Socket(addr, port);
		
		new Thread(new EnviarMensagem(servidor,addr,port)).start();
	}
	
	
}
