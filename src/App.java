import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;

public class App extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static Connection conexion= null;
	

	String nombrePokemon;
	int nivelPokemon = 1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		
		conexion= Conexion.conexion(ConstantesBD.URL, ConstantesBD.USUARIO, ConstantesBD.PASS);

	


		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					App frame = new App();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		//rellenarPA(conexion);

		/*
		Pokemon pk1= new Pokemon(0001,conexion);
		
		

		
		pk1.setListaMovimientos(listaMovimientos);
		

		
		System.out.println(pk1);
		
		*/
	}
	
	public static void rellenarPA(Connection conexion) {
		
		if (conexion ==null) 
			conexion= Conexion.conexion(ConstantesBD.URL, ConstantesBD.USUARIO, ConstantesBD.PASS);
		
		try(Statement st=conexion.createStatement();Statement st2 = conexion.createStatement();) {

		int codP;
		int codA;
		
		for (int i = 764; i <= 769; i++) {
			ResultSet rs= st.executeQuery("SELECT clave FROM ataques WHERE tipo ='psiquico' ");
			while (rs.next()) {	
		//		if(i<92 || i>94) {
				codP=i;
				codA=rs.getInt(1);
				st2.executeUpdate("INSERT INTO pokemonataques  VALUES("+codP+","+codA+")");
		//		}
		}
		
		}
		
		}catch(SQLException e){ 
			System.out.println(e); 
		}catch(Exception e){ 
			System.out.println(e);
		}
		
	}
	
	public DefaultComboBoxModel getPokemonList() throws SQLException{
		DefaultComboBoxModel<String> model;
		Statement st = conexion.createStatement();
		
		model = new DefaultComboBoxModel<String>();
		
		ResultSet rs=st.executeQuery("select distinct(nombre) from pokedex");
		
		while(rs.next()) {
			model.addElement(rs.getString(1));
		}
	
		return model;		
	}

	public DefaultComboBoxModel getNivelList(String nombre) throws SQLException{
		DefaultComboBoxModel<Integer> model;
		Statement st = conexion.createStatement();
		
		model = new DefaultComboBoxModel<Integer>();
		
		ResultSet rs=st.executeQuery("select distinct(nivel) from pokedex where nombre ='"+ nombre+"'");
		
		while(rs.next()) {
			model.addElement(rs.getInt(1));
		}
	
		
		return model;		
	}
	
	public DefaultComboBoxModel getAtaqueList(Pokemon poke) throws SQLException{
		DefaultComboBoxModel<String> model;
		
		model = new DefaultComboBoxModel<String>();
		
		for(Movimiento mov : poke.getMovimientosPermitidos()) {
			model.addElement(mov.getNombre());
		}
		
		return model;		
	}
	
	public Pokemon getPokemon(String nombre, int nivel) throws SQLException{
		
		Statement st = conexion.createStatement();
		ResultSet rs=st.executeQuery("select clave from pokedex where nombre='"+nombre+"' and nivel ="+nivel+" ");
		Pokemon pk = null;
		while(rs.next()) {
			pk =new Pokemon (rs.getInt(1),conexion);
		}
		return pk;
	}
	/**
	 * Create the frame.
	 */
	public App() {		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 580, 398);
		setTitle("POKEBUILDER v1.0");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//--- COMPONENTS CREATION ----//
		JComboBox comboBoxNivel = new JComboBox();
		JComboBox comboBoxPokemon = new JComboBox();
		JButton btnNewButton = new JButton("A\u00F1adir Pokemon");


		
		JComboBox comboBoxAtaque1 = new JComboBox();
		comboBoxAtaque1.setEnabled(false);
		comboBoxAtaque1.setBounds(120, 63, 105, 20);
		contentPane.add(comboBoxAtaque1);
		comboBoxAtaque1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		JComboBox comboBoxAtaque2 = new JComboBox();
		comboBoxAtaque2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		comboBoxAtaque2.setEnabled(false);
		comboBoxAtaque2.setBounds(120, 105, 105, 20);
		contentPane.add(comboBoxAtaque2);
		
		JComboBox comboBoxAtaque3 = new JComboBox();
		comboBoxAtaque3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		comboBoxAtaque3.setEnabled(false);
		comboBoxAtaque3.setBounds(357, 62, 112, 20);
		contentPane.add(comboBoxAtaque3);
		
		JComboBox comboBoxAtaque4 = new JComboBox();
		comboBoxAtaque4.setEnabled(false);
		comboBoxAtaque4.setBounds(357, 104, 112, 20);
		contentPane.add(comboBoxAtaque4);
		comboBoxAtaque4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				btnNewButton.setEnabled(true);
			}
		});
		
		btnNewButton.setEnabled(false);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {				
					Movimiento[] listaMovimientos = new Movimiento[4];
					Pokemon poke = getPokemon((String)comboBoxPokemon.getSelectedItem(),
							(Integer)comboBoxNivel.getSelectedItem());
					
					for(Movimiento mov : poke.getMovimientosPermitidos()) {
						if(mov.getNombre().equals((String)comboBoxAtaque1.getSelectedItem())) 
							listaMovimientos[0] = mov;
						
						else if(mov.getNombre().equals((String)comboBoxAtaque2.getSelectedItem()))
							listaMovimientos[1] = mov;
						
						else if(mov.getNombre().equals((String)comboBoxAtaque3.getSelectedItem()))
							listaMovimientos[2] = mov;
						
						else if(mov.getNombre().equals((String)comboBoxAtaque4.getSelectedItem()))
							listaMovimientos[3] = mov;
						
					}
					
					if(listaMovimientos.length == 4)
						poke.setListaMovimientos(listaMovimientos);
					else
						System.out.println("FALTAN ATAQUES POR SELECCIONAR");
					
					System.out.println(poke) ;
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnNewButton.setBounds(251, 208, 133, 33);
		contentPane.add(btnNewButton);
		
		JLabel LabelPokemon = new JLabel("Pokemon");
		LabelPokemon.setBounds(12, 24, 65, 14);
		contentPane.add(LabelPokemon);
		
		
		comboBoxNivel.setEnabled(false);
		comboBoxNivel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				comboBoxAtaque1.setEnabled(true);
				comboBoxAtaque2.setEnabled(true);
				comboBoxAtaque3.setEnabled(true);
				comboBoxAtaque4.setEnabled(true);
				
				nivelPokemon=(Integer)comboBoxNivel.getSelectedItem();
				Pokemon newPoke;

				try {
					newPoke = getPokemon(nombrePokemon, nivelPokemon);
					System.out.println("SELECTED: ---->" + newPoke.getNombre());
					if(newPoke != null) {
						comboBoxAtaque1.setModel(getAtaqueList(newPoke));
						comboBoxAtaque2.setModel(getAtaqueList(newPoke));
						comboBoxAtaque3.setModel(getAtaqueList(newPoke));
						comboBoxAtaque4.setModel(getAtaqueList(newPoke));
						
						comboBoxAtaque1.setSelectedIndex(0);
						comboBoxAtaque2.setSelectedIndex(1);
						comboBoxAtaque3.setSelectedIndex(2);
						comboBoxAtaque4.setSelectedIndex(3);
						
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		comboBoxNivel.setBounds(326, 21, 76, 20);
		contentPane.add(comboBoxNivel);
		
		
		comboBoxPokemon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				comboBoxNivel.setEnabled(true);
				nombrePokemon = comboBoxPokemon.getSelectedItem().toString();
				
				try{
					if(comboBoxNivel != null) {
						comboBoxNivel.setModel(getNivelList(nombrePokemon));
						comboBoxNivel.setSelectedIndex(0);
					}					
				}catch (SQLException e) {
					// TODO: handle exception
				}
			}
		});
		try{
		comboBoxPokemon.setModel(getPokemonList());
		if(comboBoxPokemon.getModel().getSize() > 0) {
			//comboBoxPokemon.setSelectedIndex(0);
		}
		}catch (SQLException e) {
			// TODO: handle exception
		}
		comboBoxPokemon.setBounds(89, 21, 105, 20);
		contentPane.add(comboBoxPokemon);
		
		JLabel LabelNivel = new JLabel("Nivel");
		LabelNivel.setBounds(251, 24, 46, 14);
		contentPane.add(LabelNivel);
		

		JLabel LabelAtaque1 = new JLabel("A\u00F1adir Ataque:");
		LabelAtaque1.setBounds(12, 66, 94, 14);
		contentPane.add(LabelAtaque1);
		
		
		JLabel LabelAtaque2 = new JLabel("A\u00F1adir Ataque:");
		LabelAtaque2.setBounds(12, 108, 94, 14);
		contentPane.add(LabelAtaque2);
		
		
		JLabel LabelAtaque3 = new JLabel("A\u00F1adir Ataque:");
		LabelAtaque3.setBounds(251, 65, 94, 14);
		contentPane.add(LabelAtaque3);
		
		
		JLabel LabelAtaque4 = new JLabel("A\u00F1adir Ataque:");
		LabelAtaque4.setBounds(251, 107, 94, 14);
		contentPane.add(LabelAtaque4);
		
	
	}
}
