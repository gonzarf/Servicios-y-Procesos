package multiCadenaLarga;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class MainServidor {
	
	static ArrayList<String> cadenas = new ArrayList<>();
	
	public static void main(String[] args) {
		
			try (ServerSocket serverSocket = new ServerSocket(6565)) {
				
				while (true) {
				
				Socket socketCliente = serverSocket.accept();
				
				// Lanzamos el hilo que gestiona la conexion de cada cliente 
				HiloCliente hilo = new HiloCliente(socketCliente, cadenas);
				hilo.start();
	
				}

			} catch (IOException e) {
				e.printStackTrace();
			}

	}

}
