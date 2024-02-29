package adivinarnumero;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class HiloCliente extends Thread{
	
	Socket socket;
	ServerSocket serversocket;
	int numeroaleatorio;

	public HiloCliente(Socket socket, ServerSocket serversocket, int numeroaleatorio) {
		this.socket = socket;
		this.serversocket = serversocket;
		this.numeroaleatorio = numeroaleatorio;
	}

	public Socket getSocket() {
		return socket;
	}

	public void setSocket(Socket socket) {
		this.socket = socket;
	}
	
	public int getNumeroaleatorio() {
		return numeroaleatorio;
	}

	public void setNumeroaleatorio(int numeroaleatorio) {
		this.numeroaleatorio = numeroaleatorio;
	}

	public ServerSocket getServersocket() {
		return serversocket;
	}

	public void setServersocket(ServerSocket serversocket) {
		this.serversocket = serversocket;
	}

	public void run() {
		
		try {
			
			DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
			DataInputStream dis = new DataInputStream(socket.getInputStream());
			
			while(true) {
				
				String mensaje = dis.readUTF();
				
				try {
					
					int intento = Integer.parseInt(mensaje);
					
	                if (intento == numeroaleatorio) {
	                	dos.writeUTF("1");
	                    break;
	                } else {
	                	dos.writeUTF("0");
	                }
					
				}catch (Exception e) {
					
					if(mensaje.equalsIgnoreCase("FIN")) {

						dis.close();
						dos.close();
						socket.close();
						serversocket.close();
						break;
						
					}else {
						System.out.println("Introduzca un entero");
					}
					
				}

			}

			dis.close();
			dos.close();
			socket.close();
			
		} catch (Exception e) {
			
			e.printStackTrace();

		}


		
		
	}
	

}
