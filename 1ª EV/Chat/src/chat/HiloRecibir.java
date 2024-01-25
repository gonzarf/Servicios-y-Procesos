package chat;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class HiloRecibir extends Thread {

	private DataInputStream dis;
	private Socket socket;


	public HiloRecibir(DataInputStream dis, Socket socket) {

		this.dis = dis;
		this.socket = socket;
	}


	public void run() {
		
		String mensaje;
		
		try {
			
			mensaje = dis.readUTF();
			
			if (!mensaje.isEmpty() ) {
			
				Ventana.escribirVentana( socket.getInetAddress().getHostName() + ": " +  mensaje);
			
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}



	}

}
