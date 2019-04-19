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
		
		/*
		Pokemon pk1= new Pokemon(0001,conexion);
		
		
		Movimiento [] listaMovimientos;
		listaMovimientos = new Movimiento [4];
		listaMovimientos[0]= new Movimiento(1,conexion);
		listaMovimientos[1]= new Movimiento(2,conexion);
		listaMovimientos[2]= new Movimiento(3,conexion);
		listaMovimientos[3]= new Movimiento(4,conexion);
		
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

	public DefaultComboBoxModel getnivelList(String nombre) throws SQLException{
		DefaultComboBoxModel<Integer> model;
		Statement st = conexion.createStatement();
		
		model = new DefaultComboBoxModel<Integer>();
		
		ResultSet rs=st.executeQuery("select distinct(nivel) from pokedex where nombre ='"+ nombre+"'");
		
		while(rs.next()) {
			model.addElement(rs.getInt(1));
		}
	
		
		return model;		
	}
	
	public Pokemon getPokemon(String nombre, int nivel) throws SQLException{
		
		Statement st = conexion.createStatement();
		ResultSet rs=st.executeQuery("select clave from pokedex where nombre='"+nombre+"' and nivel ="+nivel+" ");
		Pokemon pk= new Pokemon ();
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
		setBounds(100, 100, 516, 245);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel LabelPokemon = new JLabel("Pokemon");
		LabelPokemon.setBounds(12, 24, 65, 14);
		contentPane.add(LabelPokemon);
		
		JComboBox comboBoxNivel = new JComboBox();
		comboBoxNivel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("SELECTED: ---->" + ((Integer)comboBoxNivel.getSelectedItem()));
		
			}
		});
		
		comboBoxNivel.setBounds(326, 21, 105, 20);
		contentPane.add(comboBoxNivel);
		
		
		JComboBox comboBoxPokemon = new JComboBox();
		comboBoxPokemon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("SELECTED: ---->" + ((String)comboBoxPokemon.getSelectedItem()));
				try{
					if(comboBoxNivel != null)
					comboBoxNivel.setModel(getnivelList(comboBoxPokemon.getSelectedItem().toString()));
				}catch (SQLException e) {
					// TODO: handle exception
				}
			}
		});
		try{
		comboBoxPokemon.setModel(getPokemonList());
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
		
		JComboBox comboBoxAtaque1 = new JComboBox();
		comboBoxAtaque1.setBounds(120, 63, 74, 20);
		contentPane.add(comboBoxAtaque1);
		
		JLabel LabelAtaque2 = new JLabel("A\u00F1adir Ataque:");
		LabelAtaque2.setBounds(12, 108, 94, 14);
		contentPane.add(LabelAtaque2);
		
		JComboBox comboBoxAtaque2 = new JComboBox();
		comboBoxAtaque2.setBounds(120, 105, 74, 20);
		contentPane.add(comboBoxAtaque2);
		
		JLabel LabelAtaque3 = new JLabel("A\u00F1adir Ataque:");
		LabelAtaque3.setBounds(251, 65, 94, 14);
		contentPane.add(LabelAtaque3);
		
		JComboBox comboBoxAtaque3 = new JComboBox();
		comboBoxAtaque3.setBounds(357, 62, 74, 20);
		contentPane.add(comboBoxAtaque3);
		
		JLabel LabelAtaque4 = new JLabel("A\u00F1adir Ataque:");
		LabelAtaque4.setBounds(251, 107, 94, 14);
		contentPane.add(LabelAtaque4);
		
		JComboBox comboBoxAtaque4 = new JComboBox();
		comboBoxAtaque4.setBounds(357, 104, 74, 20);
		contentPane.add(comboBoxAtaque4);
		
		JButton btnNewButton = new JButton("A\u00F1adir Pokemon");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {				
					System.out.println(getPokemon((String)comboBoxPokemon.getSelectedItem(),
										(Integer)comboBoxNivel.getSelectedItem()) ) ;
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(185, 152, 133, 33);
		contentPane.add(btnNewButton);
	}
}
