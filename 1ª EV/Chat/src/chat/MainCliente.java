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
			Socket socket = new Socket("PC18621", 6565);
			DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
			DataInputStream dis = new DataInputStream(socket.getInputStream());
			Scanner sc = new Scanner(System.in);
			String mensaje;
			String pc;
			String mensajeFinal;

			System.out.println("Desea enviar o recibir: \n1:enviar\n2.Recibir");
			int eleccion = sc.nextInt();

			if (eleccion == 1) {
				while (continuar) {

					System.out.print("Introduce el PC con el que quiere comunicarse: "); // Pedimos el nombre del pc al
																							// que se quiere enviar el
																							// mensaje.
					pc = sc.nextLine();

					// Leemos del teclado y enviamos el mensaje al server
					System.out.print("Introduce el mensaje para el server: ");
					mensaje = sc.nextLine();

					mensajeFinal = pc + " " + mensaje; // Creamos el mensaje final donde indicamos el nombre del pc y el
														// mensaje a enviar, ambos separados por un espacio.

					dos.writeUTF(mensajeFinal); // Enviamos el mensaje final al servidor

				}

			} else if (eleccion == 2) {

				while (continuar) {

					// Recibimos la respuesta del server
					mensaje = dis.readUTF();
					System.out.println("Respuesta: " + mensaje);

					continuar = !mensaje.equalsIgnoreCase("exit");
				}

			}

			// Cierre de todas las conexiones o streams de datos
			sc.close();
			dos.close();
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
