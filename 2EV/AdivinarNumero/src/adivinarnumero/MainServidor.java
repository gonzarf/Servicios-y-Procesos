package adivinarnumero;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

public class MainServidor {
	
	public static void main(String[] args) {
		
			try (ServerSocket serverSocket = new ServerSocket(6565)) {
				
				// Generamos el nuemro aleatorio a adivinar 
				Random r = new Random();
				int numero = r.nextInt(0,10);
				
				
				while (true) {
				
				Socket socketCliente = serverSocket.accept();
				
				// Lanzamos el hilo que gestiona la conexion de cada cliente 
				HiloCliente hilo = new HiloCliente(socketCliente, serverSocket , numero);
				hilo.start();
	
				}

			} catch (IOException e) {
				e.printStackTrace();
			}

	}

}
