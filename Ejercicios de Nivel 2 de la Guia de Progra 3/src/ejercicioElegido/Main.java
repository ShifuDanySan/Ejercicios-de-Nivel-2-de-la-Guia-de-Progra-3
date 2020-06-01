package ejercicioElegido;

import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {
		Archivo archivoEntrada = new Archivo(
				"C:\\Users\\Usuario1\\Desktop\\Proyectos en gitHub\\Ejercicios-de-Nivel-2-de-la-Guia-de-Progra-3\\Ejercicios de Nivel 2 de la Guia de Progra 3\\entrada.txt");
		Archivo archivoSalida = new Archivo(
				"C:\\Users\\Usuario1\\Desktop\\Proyectos en gitHub\\Ejercicios-de-Nivel-2-de-la-Guia-de-Progra-3\\Ejercicios de Nivel 2 de la Guia de Progra 3\\salida.txt");
		
		
		
		String nombreJugador1 = JOptionPane.showInputDialog("Ingrese el nombre del jugador 1");
		String nombreJugador2 = JOptionPane.showInputDialog("Ingrese el nombre del jugador 2");
		
		nombreJugador1 = nombreJugador1.toLowerCase();
		nombreJugador2 = nombreJugador2.toLowerCase();
		
		nombreJugador1 = nombreJugador1.toUpperCase().charAt(0) + nombreJugador1.substring(1, nombreJugador1.length()).toLowerCase();
		nombreJugador2 = nombreJugador2.toUpperCase().charAt(0) + nombreJugador2.substring(1, nombreJugador2.length()).toLowerCase();
		
		Jugador jugador1 = new Jugador(nombreJugador1);
		Jugador jugador2 = new Jugador(nombreJugador2);
		String entrada = archivoEntrada.leeArchivo();
		String jugada1="", jugada2="";
		String ganador = "";		
		
	

		int pos=0;
		while(entrada.charAt(pos)!=' ') {
			jugada1 +=entrada.charAt(pos);
			pos++;
		}
		
		
		for(int j=pos+1;j<entrada.length()-1;j++) {
			if(entrada.charAt(j)!=' ') {
			jugada2 += entrada.charAt(j);
			}
		}
		
		jugador1.definirJugada(jugada1);
		jugador2.definirJugada(jugada2);
		
		
		if(jugador1.dimeJugada().equals("Tijera")) {
			
			if(jugador2.dimeJugada().equals("Papel")) {
				
				ganador += jugador1.dimeNombre();
			}
			if(jugador2.dimeJugada().equals("Piedra")) {
				
				ganador += jugador2.dimeNombre();
			}
	
		}
		
		if(jugador1.dimeJugada().equals("Papel")) {
			
			if(jugador2.dimeJugada().equals("Piedra")) {
				
				ganador += jugador1.dimeNombre();
			}
			if(jugador2.dimeJugada().equals("Tijera")) {
				
				ganador += jugador2.dimeNombre();
			}
			
		}
		if(jugador1.dimeJugada().equals("Piedra")) {
			
			if(jugador2.dimeJugada().equals("Tijera")) {
				
				ganador += jugador1.dimeNombre();
			}
			if(jugador2.dimeJugada().equals("Papel")) {
				
				ganador += jugador2.dimeNombre();
			}
			
		}
		
		if(jugador1.dimeJugada().equals(jugador2.dimeJugada())) {
			ganador +="Empate";
		}
		
		
		
		archivoSalida.escribeArchivo(ganador);
		System.out.println(archivoSalida.leeArchivo());
	}

}
