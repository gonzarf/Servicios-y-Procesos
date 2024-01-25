package chat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class MainCliente {

	public static void main(String[] args) {

		try {

			boolean continuar = true;
			Socket socket = new Socket("PC18631", 6565);
			DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
			DataInputStream dis = new DataInputStream(socket.getInputStream());
			String mensaje;
			String pc;
			String mensajeFinal;
			
			Ventana ventana = new Ventana();

			ventana.setVisible(true);
			
			Ventana.dos = dos;
			
			HiloRecibir hilo = new HiloRecibir(dis, socket);
			
			hilo.start();
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
