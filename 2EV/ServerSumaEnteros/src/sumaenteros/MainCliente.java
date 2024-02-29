package sumaenteros;

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
			
			
			// Creamos el bucle para pedir datos hasta que se introduzca la palabra fin.
			while(true) {

				System.out.println("Introduzca un entero o FIN para salir:  ");
				String mensaje = sc.nextLine();
				
				// Enviamos la cadena introducida al servidor
				dos.writeUTF(mensaje);
				
				// Si la cadena introducida es fin salimos del bucle
				if(mensaje.equalsIgnoreCase("FIN")) {
					break;
				}
				
			}
			
			// Al salir del bucle mostramos por consola el mensaje que envía el servidor
			System.out.println(dis.readUTF());
			
			// Cerramos todas las conexiones
			sc.close();
			dis.close();
			dos.close();
			socket.close();
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}

	}

}
