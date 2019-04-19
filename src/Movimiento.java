import java.sql.*;

public class Movimiento {

	private int clave;
	private String tipo;
	private String nombre;
	private int impactar;
	private int daño;
	private int requisitos;
	private String notas;
	
	
	public Movimiento() {
		
	}
	public Movimiento(int clave, String tipo, String nombre, int impactar, int daño, int requisitos, String notas) {
		super();
		this.clave = clave;
		this.tipo = tipo;
		this.nombre = nombre;
		this.impactar = impactar;
		this.daño = daño;
		this.requisitos = requisitos;
		this.notas = notas;
	}
	public Movimiento(int clave,Connection conexion) {
		this.clave = clave;
		if (conexion ==null) 
			conexion= Conexion.conexion(ConstantesBD.URL, ConstantesBD.USUARIO, ConstantesBD.PASS);
		
		try(Statement st=conexion.createStatement();Statement st2 = conexion.createStatement();
				ResultSet rs=st.executeQuery("select * from ataques where clave="+clave);
				) {
			
			while (rs.next()) {
				this.tipo = rs.getString(2);
				this.nombre = rs.getString(3);
				this.impactar = rs.getInt(4);
				this.daño = rs.getInt(5);
				this.requisitos = rs.getInt(6);
				this.notas = rs.getString(7);

			}
		}catch(SQLException e){ 
			System.out.println(e); 
		}catch(Exception e){ 
			System.out.println(e);
		}	
	}
	@Override
	public String toString() {
		return "Movimiento [clave=" + clave + ", tipo=" + tipo + ", nombre=" + nombre + "]";
	}
	public String getNombre() {
		return nombre;
	}
	
	
	
}
