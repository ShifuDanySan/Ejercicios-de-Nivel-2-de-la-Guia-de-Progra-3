package ejercicioElegido;

import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class VentanaConBotonesParaArchivoEntradaSalida extends JFrame implements ActionListener {
	VentanaConBotonesParaArchivoEntradaSalida() {
		super("SoftwareMaster");
		nombreJugador1 = JOptionPane.showInputDialog("Ingrese el nombre del jugador 1");
		nombreJugador2 = JOptionPane.showInputDialog("Ingrese el nombre del jugador 2");
		nombreJugador1 = nombreJugador1.toLowerCase();
		nombreJugador2 = nombreJugador2.toLowerCase();
		nombreJugador1 = nombreJugador1.toUpperCase().charAt(0)
				+ nombreJugador1.substring(1, nombreJugador1.length()).toLowerCase();
		nombreJugador2 = nombreJugador2.toUpperCase().charAt(0)
				+ nombreJugador2.substring(1, nombreJugador2.length()).toLowerCase();
		jugador1 = new Jugador(nombreJugador1);
		jugador2 = new Jugador(nombreJugador2);
		setLayout(null);// para que los elementos no esten desacomodados
		Toolkit miPantalla = Toolkit.getDefaultToolkit();
		Image miIconoDeVentana = miPantalla.getImage("src/ejercicioElegido/icono.jpg");
		setIconImage(miIconoDeVentana);
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		label1 = new JLabel("JUGADOR 1: " + jugador1.dimeNombre());
		label1.setBounds(10, 0, 1500, 40);
		label2 = new JLabel("JUGADOR 2: " + jugador2.dimeNombre());
		label2.setBounds(10, 30, 1500, 40);

		botonAzul = new JButton("Cargar Linea en Archivo");
		botonAzul.setBounds(50, 70, 180, 40);
		botonAzul.setBackground(Color.blue);

		botonAmarillo = new JButton("Mostrar archivo Entrada");
		botonAmarillo.setBounds(50, 130, 180, 40);
		botonAmarillo.setBackground(Color.yellow);

		botonVerde = new JButton("Iniciar Proceso");
		botonVerde.setBounds(50, 200, 180, 40);
		botonVerde.setBackground(Color.green);

		botonNaranja = new JButton("Mostrar archivo Salida");
		botonNaranja.setBounds(50, 270, 180, 40);
		botonNaranja.setBackground(Color.orange);

		botonVioleta = new JButton("Eliminar Archivo Entrada");
		botonVioleta.setBounds(400, 70, 180, 40);
		botonVioleta.setBackground(Color.magenta);

		botonTurqueza = new JButton("Eliminar Archivo Salida");
		botonTurqueza.setBounds(400, 130, 180, 40);
		botonTurqueza.setBackground(Color.cyan);

		botonRojo = new JButton("Finalizar");
		botonRojo.setBounds(50, 340, 180, 40);
		botonRojo.setBackground(Color.red);

		add(label1);
		add(label2);
		add(botonAzul);
		add(botonVerde);
		add(botonAmarillo);
		add(botonNaranja);
		add(botonVioleta);
		add(botonTurqueza);
		add(botonRojo);

		botonAzul.addActionListener(this);
		botonVerde.addActionListener(this);
		botonAmarillo.addActionListener(this);
		botonNaranja.addActionListener(this);
		botonVioleta.addActionListener(this);
		botonTurqueza.addActionListener(this);
		botonRojo.addActionListener(this);

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == botonAzul) {
			jugadaJugador1 = JOptionPane
					.showInputDialog("Ingrese La jugada del JUJADOR 1:\n1: Piedra\n2: Papel\n3: Tijera");

			if (jugadaJugador1.equalsIgnoreCase("1") == true) {
				jugadaJugador1 = "Piedra";
			} else if (jugadaJugador1.equalsIgnoreCase("2") == true) {
				jugadaJugador1 = "Papel";
			} else {
				jugadaJugador1 = "Tijera";
			}

			jugadaJugador2 = JOptionPane
					.showInputDialog("Ingrese La jugada del JUJADOR 2:\n1: Piedra\n2: Papel\n3: Tijera");

			if (jugadaJugador2.equalsIgnoreCase("1") == true) {
				jugadaJugador2 = "Piedra";
			} else if (jugadaJugador2.equalsIgnoreCase("2") == true) {
				jugadaJugador2 = "Papel";
			} else {
				jugadaJugador2 = "Tijera";
			}

			archivoEntrada.escribeArchivo(jugadaJugador1 + " " + jugadaJugador2);
		}
		if (e.getSource() == botonAmarillo) {
			if (archivoEntrada.leeArchivo().equals("") == false) {
				System.out.println("Archivo Entrada:\n\n" + archivoEntrada.leeArchivo() + "\n\n\n\n\n\n\n\n");
			}
		}
		if (e.getSource() == botonVerde) {
			entrada += archivoEntrada.leeArchivo();
			pos = 0;
			System.out.println("NOMBRE: " + jugador1.dimeNombre());
			while (entrada.charAt(pos) != ' ') {
				jugada1 += entrada.charAt(pos);
				pos++;
			}

			for (int j = pos + 1; j < entrada.length() - 1; j++) {
				if (entrada.charAt(j) != ' ') {
					jugada2 += entrada.charAt(j);
				}
			}

			jugador1.definirJugada(jugada1);
			jugador2.definirJugada(jugada2);

			if (jugador1.dimeJugada().equals("Tijera")) {

				if (jugador2.dimeJugada().equals("Papel")) {
					ganador += jugador1.dimeNombre();
				}
				if (jugador2.dimeJugada().equals("Piedra")) {

					ganador += jugador2.dimeNombre();
				}

			}

			if (jugador1.dimeJugada().equals("Papel")) {

				if (jugador2.dimeJugada().equals("Piedra")) {

					ganador += jugador1.dimeNombre();
				}
				if (jugador2.dimeJugada().equals("Tijera")) {

					ganador += jugador2.dimeNombre();
				}

			}
			if (jugador1.dimeJugada().equals("Piedra")) {

				if (jugador2.dimeJugada().equals("Tijera")) {

					ganador += jugador1.dimeNombre();
				}
				if (jugador2.dimeJugada().equals("Papel")) {

					ganador += jugador2.dimeNombre();
				}

			}

			if (jugador1.dimeJugada().equals(jugador2.dimeJugada())) {
				ganador += "Empate";
			}
			archivoSalida.escribeArchivo(ganador);
			// System.out.println(archivoSalida.leeArchivo());
			System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
			JOptionPane.showMessageDialog(null, "El Archivo de Salida ha sido correctamente actualizado");

		}
		if (e.getSource() == botonNaranja) {
			salida = archivoSalida.leeArchivo();
			if (salida.contentEquals("") == false) {

				System.out.println("Archivo Salida:\n\nGanador: " + salida + "\n\n\n\n\n\n\n");
			}
		}
		if (e.getSource() == botonVioleta) {
			archivoEntrada.eliminaArchivo("entrada.txt");
			JOptionPane.showMessageDialog(null, "El archivo de ENTRADA se ha eliminado exitosamente");
		}
		if (e.getSource() == botonTurqueza) {
			archivoSalida.eliminaArchivo("salida.txt");
			JOptionPane.showMessageDialog(null, "El archivo de SALIDA se ha eliminado exitosamente");
		}
		if (e.getSource() == botonRojo) {
			System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n");
			System.exit(0);
		}
	}

	private JLabel label1;
	private JLabel label2;
	private JLabel label3;
	private JLabel label4;
	private JLabel label5;
	private JButton botonAzul;
	private JButton botonAmarillo;
	private JButton botonVerde;
	private JButton botonNaranja;
	private JButton botonVioleta;
	private JButton botonTurqueza;
	private JButton botonRojo;

	private String nombreJugador1;
	private String nombreJugador2;
	private Jugador jugador1;
	private Jugador jugador2;
	private String jugadaJugador1 = "";
	private String jugadaJugador2 = "";

	private Archivo archivoEntrada = new Archivo("entrada.txt");
	private Archivo archivoSalida = new Archivo("salida.txt");
	private String entrada = "";
	private String jugada1 = "";
	private String jugada2 = "";
	private String ganador = "";
	private String salida = "";
	private int pos = 0;
}
