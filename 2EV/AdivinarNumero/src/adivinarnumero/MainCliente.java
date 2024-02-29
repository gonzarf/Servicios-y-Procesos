package adivinarnumero;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class MainCliente {

	public static void main(String[] args) {

		try {
			Socket socket = new Socket("192.168.1.133", 6565);
			DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
			DataInputStream dis = new DataInputStream(socket.getInputStream());
			Scanner sc = new Scanner(System.in);

			while (true) {

				System.out.println("Introduzca un numero del 1 al 10: ");
				String mensaje = sc.nextLine();
				
				dos.writeUTF(mensaje);
				
				if (mensaje.equalsIgnoreCase("FIN")) {
					break;
				}
				
				String respuesta = dis.readUTF();
				
				if(respuesta.equals("1")){
					System.out.println("HAS GANADO!!");
					break;
				}else  {
					System.out.println("Sigue intentandolo");
				}
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
