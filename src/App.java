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

		Pokemon pk1= new Pokemon(0001,conexion);
		
		
		Movimiento [] listaMovimientos;
		listaMovimientos = new Movimiento [4];
		listaMovimientos[0]= new Movimiento(1,conexion);
		listaMovimientos[1]= new Movimiento(2,conexion);
		listaMovimientos[2]= new Movimiento(3,conexion);
		listaMovimientos[3]= new Movimiento(4,conexion);
		
		pk1.setListaMovimientos(listaMovimientos);
		
		System.out.println(pk1);
		//Conexion.desConexion(conexion);
		
		
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
		
		JComboBox comboBoxPokemon = new JComboBox();
		comboBoxPokemon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("SELECTED: ---->" + ((String)comboBoxPokemon.getSelectedItem()));
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
		
		JComboBox comboBoxNivel = new JComboBox();
		comboBoxNivel.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"}));
		comboBoxNivel.setBounds(298, 20, 46, 22);
		contentPane.add(comboBoxNivel);
		
		JLabel LabelAtaque1 = new JLabel("A\u00F1adir Ataque:");
		LabelAtaque1.setBounds(12, 66, 94, 14);
		contentPane.add(LabelAtaque1);
		
		JComboBox comboBoxAtaque1 = new JComboBox();
		comboBoxAtaque1.setBounds(118, 63, 74, 20);
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
		btnNewButton.setBounds(185, 152, 133, 33);
		contentPane.add(btnNewButton);
	}
}
