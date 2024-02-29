package cadenalarga;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class MainCliente {

	public static void main(String[] args) {
		
		try {
			
			Socket socket = new Socket("192.168.1.133", 6565);
			DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
			DataInputStream dis = new DataInputStream(socket.getInputStream());
			Scanner sc = new Scanner(System.in);
			
			String mensaje; 
			
			while(true) {
				
				// Pedimos una cadena que enviar al servidor
				System.out.println("Introduzca una cadena o fin para salir: ");
				mensaje = sc.nextLine();
				
				// Mandamos el mensaje que se ha escrito al servidor
				dos.writeUTF(mensaje);
				
				// Si es fin, terminamos el bucle y la conexion
				if( mensaje.equalsIgnoreCase("FIN")) {
					break;
				}

			}
			
			// Mostramos la respuesta del servidor
			System.out.println(dis.readUTF());
			
			// Cerramos las conexiones
			dos.close();
			dis.close();
			socket.close();
			sc.close();
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}


}
