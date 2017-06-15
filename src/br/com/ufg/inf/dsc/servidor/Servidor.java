package br.com.ufg.inf.dsc.servidor;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor{
	public static void main (String [] args) throws IOException{
		
		int port = Integer.parseInt("12345");
		ServerSocket servidor = new ServerSocket(port);
		Socket cliente = servidor.accept();
		System.out.println("Servidor conectado");
		
		new Thread(new ReceberMensagemDoCliente(port,cliente)).start();
	}
	
}
