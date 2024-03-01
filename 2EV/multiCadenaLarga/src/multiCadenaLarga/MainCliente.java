package multiCadenaLarga;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class MainCliente {

	public static void main(String[] args) {
		
		try {
			Socket socket = new Socket("PC18631", 6565);
			DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
			DataInputStream dis = new DataInputStream(socket.getInputStream());
			Scanner sc = new Scanner(System.in);

			while (true) {

				System.out.println("Introduzca una cadena: ");
				String mensaje = sc.nextLine();
				
				dos.writeUTF(mensaje);
				
				if (mensaje.equalsIgnoreCase("FIN")) {
					break;
				}
				
				System.out.println(dis.readUTF());
			}

			dis.close();
			dos.close();
			sc.close();
			socket.close();

		} catch (Exception e) {

			e.printStackTrace();

		}
	}

}
