package br.com.ufg.inf.dsc.cliente;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketException;

public class EnviarMensagem implements Runnable{

	private Socket servidor;
	private InetAddress addr;
	private int port;
	
	public EnviarMensagem(Socket servidor, InetAddress addr, int port) {
		this.servidor = servidor;
		this.addr = addr;
		this.port = port;
	}
	
	
	@Override
	public void run() {

		try {
			
			String mensagem = "Testando mensagens enviadas via datagrama IP";
			byte[] msg = mensagem.getBytes();
		
			DatagramPacket pacote = new DatagramPacket(msg, msg.length, addr, port);
		
			DatagramSocket ds = new DatagramSocket();
			
			ds.send(pacote);
			
			System.out.println("Mensagem enviada para: " + addr.getHostAddress() + "\n"
					+ "Porta: " + port + "\n" + "Mensagem: " + new String(msg));
			
			ds.close();
		
		
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
