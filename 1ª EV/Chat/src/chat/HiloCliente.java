package chat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;

public class HiloCliente extends Thread {

	private Socket socket;
	private ArrayList<HiloCliente> listaHilos;

	public HiloCliente(Socket socket, ArrayList<HiloCliente> listaHilos) {
		this.socket = socket;
		this.listaHilos = listaHilos;
	}
	
	

	public Socket getSocket() {
		return socket;
	}



	public void run() {
		
		String[] mensaje;
		String m;

		try {
				DataInputStream dis = new DataInputStream(socket.getInputStream());
				
			do {
				

				m = dis.readUTF();
				mensaje = m.split(" ");
				m = m.substring(m.indexOf(" ") + 1);
				

				
				for (HiloCliente cliente : listaHilos) {
					
					if (cliente.getSocket().getInetAddress().getHostName().equals(mensaje[0])) {
						
						cliente.enviar(m);
					}
				}

			} while (!m.equalsIgnoreCase("exit"));

			dis.close();
			socket.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void enviar(String mensaje) {
		
		try {
			
			DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
			dos.writeUTF(mensaje);
			
		} catch (IOException e) {

			e.printStackTrace();
			
		}
		
	}

}
