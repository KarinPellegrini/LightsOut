package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import presenter.Presenter;
import java.awt.Button;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Window.Type;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.DropMode;


public class Interfaz {

	private JFrame lightsOut;
	private JTextField tituloJuego;
	private JTextField resultado;
	private JPanel seccionTurnos;
	private JLabel turnos;
	private JPanel contenerdorTurnos;
	private JTextField contTurnos;
	private JPanel panelJuego;
	private Button[][] celdas;
	private Presenter presenter;
	private JButton botonMenu;
	private int nivelSeleccionado;
	private String nombreUsuario;
	
	
    public Interfaz(int nivelSeleccionado, String nombreUsuario) {
        this.nivelSeleccionado = nivelSeleccionado;
        this.nombreUsuario = nombreUsuario;
        // Resto del código del constructor...
        initialize();
    }
	
	

	private final Color VERDE_ENCENDIDO = new Color(47, 195, 79), 
			VERDE_APAGADO = new Color(43, 71, 39), 
			VERDE_INTERMEDIO1 = new Color(43, 131, 39), 
			VERDE_INTERMEDIO2 = new Color(43, 157, 39);

	/**
	 * Create the application.
	 */
	public Interfaz() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		if(nivelSeleccionado==1 || nivelSeleccionado==0) {
			presenter = new Presenter(3);
		} else if (nivelSeleccionado==2) {
			presenter = new Presenter(5);
		} else if(nivelSeleccionado==3) {
			presenter = new Presenter(7);
		}
//		presenter = new Presenter(nivelSeleccionado);
		
		presenter.estadoDelTablero();
		
		lightsOut = new JFrame();
		getLightsOut().setType(Type.UTILITY);
		getLightsOut().getContentPane().setForeground(new Color(0, 0, 0));
		getLightsOut().setBackground(new Color(255, 255, 255));
		getLightsOut().setForeground(new Color(255, 255, 255));
		getLightsOut().setBounds(100, 100, 700, 500);
		getLightsOut().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getLightsOut().getContentPane().setLayout(new BorderLayout(0, 0));
		
		getLightsOut().setVisible(true);
		
		JPanel contenedorTitulo = new JPanel();
		contenedorTitulo.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		getLightsOut().getContentPane().add(contenedorTitulo, BorderLayout.NORTH);
		contenedorTitulo.setLayout(new BorderLayout(0, 0));
		
		tituloJuego = new JTextField();
		tituloJuego.setColumns(10);
		tituloJuego.setEditable(false);
		tituloJuego.setForeground(new Color(255, 255, 255));
		tituloJuego.setHorizontalAlignment(SwingConstants.CENTER);
		tituloJuego.setBackground(new Color(40, 40, 40));
		tituloJuego.setFont(new Font("Monospaced", Font.BOLD | Font.ITALIC, 16));
		tituloJuego.setText("Lights out");
		contenedorTitulo.add(tituloJuego, BorderLayout.CENTER);
		
		seccionTurnos = new JPanel();
		FlowLayout flowLayout = (FlowLayout) seccionTurnos.getLayout();
		flowLayout.setHgap(3);
		flowLayout.setVgap(0);
		seccionTurnos.setBorder(null);
		contenedorTitulo.add(seccionTurnos, BorderLayout.EAST);
		
		turnos = new JLabel("Turnos: ");
		turnos.setHorizontalAlignment(SwingConstants.CENTER);
		turnos.setFont(new Font("Segoe Print", Font.PLAIN, 13));
		seccionTurnos.add(turnos);
		
		contenerdorTurnos = new JPanel();
		contenerdorTurnos.setBorder(null);
		seccionTurnos.add(contenerdorTurnos);
		
		contTurnos = new JTextField();
		contTurnos.setForeground(new Color(255, 255, 255));
		turnos.setLabelFor(contTurnos);
		contTurnos.setHorizontalAlignment(SwingConstants.CENTER);
		contTurnos.setBackground(new Color(40, 40, 40));
		contTurnos.setFont(new Font("Segoe Print", Font.PLAIN, 13));
		contTurnos.setEditable(false);
		contTurnos.setText("0\r\n");
		contenerdorTurnos.add(contTurnos);
		contTurnos.setColumns(3);
		
		JPanel estado = new JPanel();
		estado.setBorder(new LineBorder(new Color(0, 0, 0), 8));
		getLightsOut().getContentPane().add(estado, BorderLayout.SOUTH);
		estado.setLayout(new BoxLayout(estado, BoxLayout.X_AXIS));
		resultado = new JTextField("¡ ¡ ¡ Ánimo " + nombreUsuario +  " ! ! !");
		resultado.setEditable(false);
		resultado.setFont(new Font("Monospaced", Font.BOLD | Font.ITALIC, 15));
		resultado.setForeground(new Color(255, 255, 255));
		resultado.setHorizontalAlignment(SwingConstants.CENTER);
		resultado.setBackground(new Color(40, 40, 40));
		estado.add(resultado);
		resultado.setColumns(10);
		
		botonMenu = new JButton("Menú");
		botonMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
			
		
		});
		// Boton que simula una partida ganada.
		botonMenu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				falseTodos();	
			}
		});

		botonMenu.setFont(new Font("Segoe Print", Font.PLAIN, 13));
		estado.add(botonMenu);
		
		panelJuego = new JPanel();
		panelJuego.setBackground(new Color(65, 119, 64));
		panelJuego.setForeground(new Color(192, 192, 192));
		panelJuego.setBorder(new EmptyBorder(25, 25, 25, 25));
		getLightsOut().getContentPane().add(panelJuego, BorderLayout.CENTER);
		panelJuego.setLayout(new GridLayout(presenter.largoDelTablero(), presenter.largoDelTablero(), 20, 20));
		
		celdas = new Button[presenter.largoDelTablero()][presenter.largoDelTablero()]; // se inicializa con el tamaño del tablero
		
		
		for (int i = 0; i < celdas.length; i++) {
			int fila = i;
			for (int j = 0; j < celdas[i].length; j++) {
				int col = j;
				celdas[fila][col] = new Button();
				
				if (presenter.estaEncendida(fila,col)) celdas[fila][col].setBackground(VERDE_ENCENDIDO);
				else celdas[fila][col].setBackground(VERDE_APAGADO);
				
				panelJuego.add(celdas[fila][col]);
				celdas[fila][col].addMouseListener(new MouseAdapter() {
					
					@Override
					public void mouseClicked(MouseEvent e) 
					{ 
						if(presenter.verificaEstadoDelTablero())
							resultado.setText("!!! Felicidades" + nombreUsuario + ", acabás de ganar el juego ¡¡¡");
						else
							colorearVecinos(fila,col);
							contTurnos.setText(""+presenter.sumarUnTurno());
							presenter.estadoDelTablero();
					}
					
					@Override
					public void mouseEntered(MouseEvent e) 
					{
						if (celdas[fila][col].getBackground().equals(VERDE_ENCENDIDO)) 
							celdas[fila][col].setBackground(VERDE_INTERMEDIO1);
						
						else if (celdas[fila][col].getBackground().equals(VERDE_APAGADO)) 
							celdas[fila][col].setBackground(VERDE_INTERMEDIO2);
						
					}
					@Override
			         public void mouseExited(MouseEvent e) {
						if (celdas[fila][col].getBackground().equals(VERDE_INTERMEDIO2)) 
						
							celdas[fila][col].setBackground(VERDE_APAGADO);
						
						else if (celdas[fila][col].getBackground().equals(VERDE_INTERMEDIO1)) 
							celdas[fila][col].setBackground(VERDE_ENCENDIDO);
						
			         }
				});
			}
		}
		
//		GridBagLayout gridBagLayout = new GridBagLayout();
//		gridBagLayout.columnWidths = new int[]{460, 0};
//		gridBagLayout.rowHeights = new int[]{261, 0};
//		gridBagLayout.columnWeights = new double[]{0.0, Double.MIN_VALUE};
//		gridBagLayout.rowWeights = new double[]{0.0, Double.MIN_VALUE};
//		
		}
	
	// Metodo que simula una partida ganada.
	private void falseTodos() {
		presenter.todosFalse();
		
		
	}
	
	private void colorearVecinos(int fila, int col) {
		colorearVecinosFila(col);
		colorearVecinosColumna(fila,col);
	}


	private void colorearVecinosFila(int col) {
		for (int row = 0; row < celdas.length; row++) {
			if (presenter.estaEncendida(row, col))
				celdas[row][col].setBackground(VERDE_APAGADO);
			else celdas[row][col].setBackground(VERDE_ENCENDIDO);
			presenter.cambiarEstado(row, col);
		}
	}
	
	private void colorearVecinosColumna(int fila, int colum) {
		for (int col = 0; col < celdas.length; col++) {
			if (col!=colum) {
				if (presenter.estaEncendida(fila, col))
					celdas[fila][col].setBackground(VERDE_APAGADO);
				else celdas[fila][col].setBackground(VERDE_ENCENDIDO);				
					presenter.cambiarEstado(fila, col);
			}
		}
	}

	public JFrame getLightsOut() {
		return lightsOut;
	}
	
}
