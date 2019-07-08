import java.util.ArrayList;

public class Entrenador {
	String nombre;
	ArrayList<Pokemon> pokemonPC;
	Pokemon [] pokemonCinturon;
	final int MAX_CINTURON=6;
	int i =0;
	
	public Entrenador() {
		this.nombre = "Entrenador";
		pokemonCinturon= new Pokemon [6];
	}
		
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public void addPokePC (Pokemon pk) {
		pokemonPC.add(pk);
	}
	
	public void addPokeCint (Pokemon pk) {
		if (i>=MAX_CINTURON) {
			System.out.println("Máximo de pokemon de cinturón alcanzado.");
			
		} else {
			pokemonCinturon [i]=pk;
		i++;
		}
					
	}
}
