import java.sql.*;
import java.util.ArrayList;
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
	private ArrayList<Movimiento> movimientosPermitidos;
	
	
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
				ResultSet rs2 = st2.executeQuery("select * from ataques where clave in ( select claveataq from pokemonataques where clavepoke =" + clave+")");
				) {
			System.out.println("jul");
			movimientosPermitidos = new ArrayList<Movimiento>();
			
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
			
			while(rs2.next()) {
				movimientosPermitidos.add(new Movimiento(rs2.getInt(1),rs2.getString(2), rs2.getString(3), rs2.getInt(4), rs2.getInt(5), rs2.getInt(6), rs2.getString(7)));
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
	
	

	public ArrayList<Movimiento> getMovimientosPermitidos() {
		return movimientosPermitidos;
	}
	
	

	public int getClave() {
		return clave;
	}

	public void setClave(int clave) {
		this.clave = clave;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int getNivel() {
		return nivel;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}

	public int getSalud() {
		return salud;
	}

	public void setSalud(int salud) {
		this.salud = salud;
	}

	public int getAtaque() {
		return ataque;
	}

	public void setAtaque(int ataque) {
		this.ataque = ataque;
	}

	public int getDefensa() {
		return defensa;
	}

	public void setDefensa(int defensa) {
		this.defensa = defensa;
	}

	public int getVelocidad() {
		return velocidad;
	}

	public void setVelocidad(int velocidad) {
		this.velocidad = velocidad;
	}

	public String getTipo1() {
		return tipo1;
	}

	public void setTipo1(String tipo1) {
		this.tipo1 = tipo1;
	}

	public String getTipo2() {
		return tipo2;
	}

	public void setTipo2(String tipo2) {
		this.tipo2 = tipo2;
	}

	public String getNotas() {
		return notas;
	}

	public void setNotas(String notas) {
		this.notas = notas;
	}

	public void setMovimientosPermitidos(ArrayList<Movimiento> movimientosPermitidos) {
		this.movimientosPermitidos = movimientosPermitidos;
	}

	@Override
	public String toString() {
		return "Pokemon [clave=" + clave + ", nombre=" + nombre + ", numero=" + numero + ", nivel=" + nivel + ", salud="
				+ salud + ", ataque=" + ataque + ", defensa=" + defensa + ", velocidad=" + velocidad + ", tipo1="
				+ tipo1 + ", tipo2=" + tipo2 + ", notas=" + notas + ", listaMovimientos="
				+ Arrays.toString(listaMovimientos) + "]";
	}
	
}
