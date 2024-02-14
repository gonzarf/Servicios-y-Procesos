package main;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class MainServidor {
	
	private static ArrayList<HiloCliente> listaSocket = new ArrayList<>();


	public static void main(String[] args) {

		try (ServerSocket serverSocket = new ServerSocket(6565)) {

			while (true) {

				Socket socketCliente = serverSocket.accept();
				
				
				HiloCliente hiloCliente = new HiloCliente(socketCliente);
				
				hiloCliente.start();
				
				
				listaSocket.add(hiloCliente);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
