import java.sql.*;
import java.util.Arrays;


public class Pokemon {
	
	private int clave;
	private String nombre;
	private int numero;
	private int nivel;
	private int salud;
	private int ataque;
	private int defensa;
	private int velocidad;
	private String tipo1;
	private String tipo2;
	private String notas;
	private  Movimiento [] listaMovimientos;
	
	
	public Pokemon(int clave, String nombre, int numero, int nivel, int salud, int ataque, int defensa, int velocidad,
			String tipo1, String tipo2, String notas) {
		this.clave = clave;
		this.nombre = nombre;
		this.numero = numero;
		this.nivel = nivel;
		this.salud = salud;
		this.ataque = ataque;
		this.defensa = defensa;
		this.velocidad = velocidad;
		this.tipo1=tipo1;
		this.tipo2=tipo2;
		this.notas = notas;
	}

	public Pokemon(int clave,Connection conexion) {
		this.clave = clave;
		if (conexion ==null) 
			conexion= Conexion.conexion(ConstantesBD.URL, ConstantesBD.USUARIO, ConstantesBD.PASS);
		
		try(Statement st=conexion.createStatement();Statement st2 = conexion.createStatement();
				ResultSet rs=st.executeQuery("select * from pokedex where clave="+clave);
				) {
			
			while (rs.next()) {
				this.numero = rs.getInt(2);
				this.nombre = rs.getString(3);
				this.nivel = rs.getInt(4);
				this.salud = rs.getInt(5);
				this.ataque = rs.getInt(6);
				this.defensa = rs.getInt(7);
				this.velocidad = rs.getInt(8);
				this.tipo1=rs.getString(9);;
				this.tipo2=rs.getString(10);;
				this.notas = rs.getString(11);

			}
		}catch(SQLException e){ 
			System.out.println(e); 
		}catch(Exception e){ 
			System.out.println(e);
		}	
	}

	
	
	public Pokemon() {
		super();
	}

	public Movimiento[] getListaMovimientos() {
		return listaMovimientos;
	}

	public void setListaMovimientos(Movimiento[] listaMovimientos) {
		this.listaMovimientos = listaMovimientos;
	}

	@Override
	public String toString() {
		return "Pokemon [clave=" + clave + ", nombre=" + nombre + ", numero=" + numero + ", nivel=" + nivel + ", salud="
				+ salud + ", ataque=" + ataque + ", defensa=" + defensa + ", velocidad=" + velocidad + ", tipo1="
				+ tipo1 + ", tipo2=" + tipo2 + ", notas=" + notas + ", listaMovimientos="
				+ Arrays.toString(listaMovimientos) + "]";
	}
	
}
