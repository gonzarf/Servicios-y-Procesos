/*Haz un cliente y un servidor (monocliente). 
 * El cliente envía cadenas al servidor (lectura por teclado). 
 * Cuando el cliente envía la cadena "FIN" (mayúsculas o minúsculas), el servidor le responde con la cadena más larga de todas. 
 * El cliente muestra dicha cadena y termina*/

package cadenalarga;

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
			
			String mensaje;
			String cadenalarga = "";
			
			while(true) {
				
				// Leemos mensaje que nos llega del servidor
				mensaje = dis.readUTF();
				
				// Si el mensaje es fin terminamos el bucle y la conexión
				if(mensaje.equalsIgnoreCase("FIN")) {
					
					break;
				}
				
				// Si la cadena es mas larga que la cadena que está guardada, la sustituimos
				if(mensaje.length() > cadenalarga.length()) {
					
					cadenalarga = mensaje;
				}
				
				
			}
			
			dos.writeUTF("La cadena mas larga que se ha introducido es: " + cadenalarga);
			
			dos.close();
			dis.close();
			socketCliente.close();
			serverSocket.close();
			
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
			

	}

}
