package br.com.ufg.inf.dsc.servidor;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.Socket;
import java.net.SocketException;

public class ReceberMensagemDoCliente implements Runnable{

	private Socket cliente;
	private int port;

	public ReceberMensagemDoCliente(int port,Socket cliente) {
		this.cliente = cliente;
		this.port = port;
	}

	@Override
	public void run() {

		do{

			try {
				DatagramSocket ds = new DatagramSocket(port);
				System.out.println("Ouvindo porta: " + port);

				byte[] msg = new byte[256];

				DatagramPacket pacote = new DatagramPacket(msg, msg.length);
				ds.receive(pacote);

				System.out.println(new String(pacote.getData()).trim());
				ds.close();
				
				//enviando mensagem de volta
				String texto = new String(pacote.getData());
				String palavraBuscada = "mensagens enviadas";
				
				if (texto.toLowerCase().contains(palavraBuscada.toLowerCase())){
					PrintWriter pw = new PrintWriter(cliente.getOutputStream(),true);
					pw.println(palavraBuscada + " : Existe!!!");
				}
				
			} catch (SocketException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}while(true);

	}

}
