package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Conexion {
	private static final String url = "jdbc:mysql://localhost/crud";
	private static final String usuario = "root";
	private static final String pswd = "";

	public static Connection open() throws SQLException {
		Properties props = new Properties();

		props.setProperty("user", usuario);
		props.setProperty("password", pswd);
		props.setProperty("ssl", "true");
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return DriverManager.getConnection(url, props);
	}

}
