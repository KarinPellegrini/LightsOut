package view;

import java.awt.EventQueue;
import javax.swing.DefaultComboBoxModel;


import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PantallaInicio {

	private JFrame frame;
	private JTextField textField;
	private int nivelSeleccionado;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PantallaInicio window = new PantallaInicio();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PantallaInicio() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(216, 86, 144, 19);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Ingrese su nombre:");
		lblNewLabel.setBounds(38, 89, 144, 13);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Elija el nivel de dificultad:");
		lblNewLabel_1.setBounds(38, 124, 168, 13);
		frame.getContentPane().add(lblNewLabel_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(216, 120, 144, 21);
		frame.getContentPane().add(comboBox);
		
		comboBox.setModel(new DefaultComboBoxModel(new String [] {"Seleccione nivel", "3x3", "5x5", "7x7"}));
		
		JLabel lblNewLabel_2 = new JLabel("Lights Out");
		lblNewLabel_2.setBounds(183, 38, 80, 15);
		frame.getContentPane().add(lblNewLabel_2);
		
		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nivelSeleccionado = comboBox.getSelectedIndex();
				String nombreUsuario = textField.getText();
				System.out.println("El nivel seleccionado fue: " + nivelSeleccionado);
				System.out.println("El nombre del usuario es: " + nombreUsuario);
				
				Interfaz interfaz = new Interfaz(nivelSeleccionado,nombreUsuario);
				interfaz.getLightsOut().setVisible(true);
				
			}
		});
		
		
		btnConfirmar.setBounds(178, 210, 117, 21);
		frame.getContentPane().add(btnConfirmar);
	}
	
	
	public int getNivelSeleccionado() {
		return nivelSeleccionado;
	}

}
