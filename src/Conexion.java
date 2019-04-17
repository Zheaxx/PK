

import java.sql.*;

public class Conexion {
	
	public static Connection conexion(String url,String usuario,String contraseña) {
		try {
			Connection conexion = DriverManager.getConnection(url,usuario,contraseña);
			System.out.println("Usuario: "+usuario+" conectado.");
			return conexion;
		} catch (SQLException e) {
			System.out.println(e);
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}
	
	public static void desConexion (Connection conexion) {
		try {
			if (conexion !=null) {
				System.out.println("Desconectado.");
				conexion.close();
			}
		} catch (SQLException e) {
			System.out.println(e);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
