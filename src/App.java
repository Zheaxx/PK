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

public class App extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
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
		setBounds(100, 100, 569, 425);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(41, 165, 46, 14);
		contentPane.add(lblNewLabel);
		
		JComboBox comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("SELECTED: ---->" + ((String)comboBox.getSelectedItem()));
			}
		});
		try{
		comboBox.setModel(getPokemonList());
		}catch (SQLException e) {
			// TODO: handle exception
		}
		comboBox.setBounds(97, 162, 76, 20);
		contentPane.add(comboBox);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(385, 165, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(465, 162, 28, 20);
		contentPane.add(comboBox_1);
		
		textField = new JTextField();
		textField.setBounds(307, 162, 46, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setBounds(230, 165, 46, 14);
		contentPane.add(lblNewLabel_2);
	}
}
