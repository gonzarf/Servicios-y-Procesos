package main;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import conexion.Conexion;

public class HiloCliente extends Thread {

	private Socket socket;
	DataInputStream dis;
	static DataOutputStream dos;
	static String id;
	static String nombre;
	static String edad;
	static String apellido1;
	static String apellido2;
	static String nacimiento;

	public HiloCliente(Socket socket) {
		this.socket = socket;
	}

	public void run() {
		String mensaje;

		try {
			dis = new DataInputStream(socket.getInputStream());
			dos = new DataOutputStream(socket.getOutputStream());

			do {
				dos.writeUTF("1.Mostrar datos  \n2.Actualizar \n3.Borrar \n4Anadir \n5.Salir");
				mensaje = dis.readUTF();

				try (Connection con = Conexion.open()) {
					
					if(mensaje.equals("1")) {
						
						mostrar(con, "SELECT * FROM persona");

					}else if(mensaje.equals("2")) {
						
						dos.writeUTF("Introduce id de la persona a modificar: ");
						Integer idmodificar = Integer.parseInt(dis.readUTF());

						dos.writeUTF("Introduce el nombre: ");
						String nombreN = dis.readUTF();
						
						dos.writeUTF("Introduce el primer apellido: ");
						String apellido1N = dis.readUTF();
						
						dos.writeUTF("Introduce el segundo apellido: ");
						String apellido2N = dis.readUTF();
						
						dos.writeUTF("Introduce la nueva edad: ");
						Integer edadN = Integer.parseInt(dis.readUTF());
						
						dos.writeUTF("Introduce la nueva fecha de nacimiento: ");
						String nacimientoN = dis.readUTF();
						
						actualizar(con, idmodificar, nombreN, apellido1N, apellido2N, edadN, nacimientoN);
						
					
					} else if(mensaje.equals("3")) {
						
						dos.writeUTF("INtroduce el id de la persona que desea borrar: ");
						Integer idBorrar = Integer.parseInt(dis.readUTF());
						
						borrar(con, idBorrar);
						
					} else if (mensaje.equals("4")) {
						
						dos.writeUTF("Introduzca el nombre: ");
						nombre = dis.readUTF();
						
						dos.writeUTF("Introduzca el primer apellido: ");
						apellido1 = dis.readUTF();
						
						dos.writeUTF("Introduzca el segundo apellido: ");
						apellido2 = dis.readUTF();
						
						dos.writeUTF("Introduzca la edad: ");
						Integer edadInsert = Integer.parseInt(dis.readUTF());
						
						dos.writeUTF("Introduzca la fecha de nacimiento: ");
						nacimiento = dis.readUTF();
						
						anadir(con, nombre, apellido1, apellido2, edadInsert, nacimiento); 
						
					} else if (mensaje.equals("5")) {
						
						dos.writeUTF("FIN");
					}
					
				} catch (SQLException ex) {
					ex.printStackTrace();
				}

			} while (!mensaje.equals("5"));
			
			dis.close();
			dos.close();
			socket.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void mostrar(Connection con, String query) {

		try (PreparedStatement ps = con.prepareStatement(query)) {

			try (ResultSet rs = ps.executeQuery()) {

				while (rs.next()) {
					id = rs.getString("id");
					nombre = rs.getString("nombre");
					apellido1 = rs.getString("apellido1");
					apellido2 = rs.getString("apellido2");
					nacimiento = rs.getString("nacimiento");
					edad = rs.getString("edad");

					dos.writeUTF("ID: " + id + "Nombre: " + nombre + "Primer apellido: " + apellido1 + "Segundo apellido: " + apellido2 + "Edad: " + edad + "Fecha nacimiento: " + nacimiento + "\n");

				}

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}

	}
	
	private static void actualizar(Connection con, Integer pk, String nombreN, String apellido1N,
			String apellido2N, Integer edadN, String nacimientoN) {
		String sql = "UPDATE persona SET nombre = ?, apellido1 = ?, apellido2 = ?, edad = ?, nacimiento = ? WHERE id = ?";

		try (PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setString(1, nombreN);
			ps.setString(2, apellido1N);
			ps.setString(3, apellido2N);
			ps.setInt(4, edadN);
			ps.setString(5, nacimientoN);
			ps.setInt(6, pk);

			int nFilas = ps.executeUpdate();

			try {
				dos.writeUTF("Se han modificado " + nFilas + " correctamente.\n");
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}

	}
	
	private static void borrar(Connection con, int pk) {
		String sql = "DELETE FROM persona WHERE id = ?";

		try (PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setInt(1, pk);

			int nFilas = ps.executeUpdate();

			try {
				dos.writeUTF("Se han borrado " + nFilas + " correctamente.\n");
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}

	}
	
	private static void anadir(Connection con, String nombre, String apellido1, String apellido2, Integer edad, String nacimiento ) {
		String sql = "INSERT INTO clientes VALUES (NULL, ?, ?, ?, ?, ?)";

		try (PreparedStatement ps = con.prepareStatement(sql)) {

				ps.setString(1, nombre);
				ps.setString(2, apellido1);
				ps.setString(3, apellido2);
				ps.setInt(4, edad);
				ps.setString(5, nacimiento);

				int nFilas = ps.executeUpdate();

				try {
					dos.writeUTF("Se han añadido " + nFilas + " correctamente.\n");
				} catch (IOException e) {
					e.printStackTrace();
				}

		} catch (SQLException ex) {
			ex.printStackTrace();
		}

	}
	
	

}
