package multiCadenaLarga;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.ArrayList;

public class HiloCliente extends Thread{
	
	Socket socket;
	ArrayList<String> cadenas;


	public HiloCliente(Socket socket, ArrayList<String> cadenas) {
		super();
		this.socket = socket;
		this.cadenas = cadenas;
	}

	public ArrayList<String> getCadenas() {
		return cadenas;
	}

	public void setCadenas(ArrayList<String> cadenas) {
		this.cadenas = cadenas;
	}

	public Socket getSocket() {
		return socket;
	}

	public void setSocket(Socket socket) {
		this.socket = socket;
	}
	
	public void run() {
		
		
		try {
			
			DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
			DataInputStream dis = new DataInputStream(socket.getInputStream());
			
			while(true) {
				
				String mensaje = dis.readUTF();
				
				synchronized (cadenas) {
					
					cadenas.add(mensaje);
				}
				
				if(mensaje.equalsIgnoreCase("FIN")) {
					break;
				}
				
				String maslarga = "";

				for(String cadena : cadenas) {
					
					System.out.println(cadena);
					if(cadena.length() > maslarga.length()) {
						maslarga = cadena;
					}
					
				}
				
				dos.writeUTF("La cadenas mas larga es: " + maslarga);
				
			}


			dis.close();
			dos.close();
			socket.close();
			
		} catch (Exception e) {
			
			e.printStackTrace();

		}
		
	}

}
