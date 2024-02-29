package sumaenteros;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MainServidor {

	public static void main(String[] args) {

		try (ServerSocket serverSocket = new ServerSocket(6565)) {
			
			Socket socketCliente = serverSocket.accept();
			
			DataOutputStream dos = new DataOutputStream(socketCliente.getOutputStream());
			DataInputStream dis = new DataInputStream(socketCliente.getInputStream());
			
			int suma = 0;
			String mensaje; 

			while (true) {
				
				// Leemos lo que introduce el cliente 
				mensaje = dis.readUTF();
				
				// Si ha introducido la palabra fin, salimso del while lo que hace que finalice la conexión
				if (mensaje.equalsIgnoreCase("FIN")) {
					break;
				}
				
				// Intentamos convertir el mensaje a integer
				try {
					
					// Si es posible la conversión sumamos el numero introducido al total
					int numeroIntroducido = Integer.parseInt(mensaje);
					suma += numeroIntroducido;

					// Si no es posible convertirlo salta una excepcion
				}catch(Exception e) {
					
					System.out.println("El mensaeje introducido no es un entero");
				}
				
			}
			
			// Al recibir la palabra fin, salimos del while y mostramos al cliente el resultado de la suma
			dos.writeUTF("La suma de los enteros es: " + suma);
			
			// Despues de mostar el resultado cerramos la conexion
			dis.close();
			dos.close();
			socketCliente.close();
			serverSocket.close();


		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
