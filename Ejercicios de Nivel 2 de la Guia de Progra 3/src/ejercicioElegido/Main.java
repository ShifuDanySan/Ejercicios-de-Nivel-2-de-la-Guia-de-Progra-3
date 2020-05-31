package ejercicioElegido;

public class Main {

	public static void main(String[] args) {
		Archivo archivoEntrada = new Archivo(
				"C:\\Users\\Daniel\\Documents\\Mis Aplicaciones\\GitHub\\Espacio de Trabajo\\Ejercicios de Nivel 2 de la Guia de Progra 3\\Ejercicios de Nivel 2 de la Guia de Progra 3\\entrada.txt");
		Archivo archivoSalida = new Archivo(
				"C:\\Users\\Daniel\\Documents\\Mis Aplicaciones\\GitHub\\Espacio de Trabajo\\Ejercicios de Nivel 2 de la Guia de Progra 3\\Ejercicios de Nivel 2 de la Guia de Progra 3\\salida.txt");
		Jugador jugador1 = new Jugador("Ana");
		Jugador jugador2 = new Jugador("Bartolo");
		String entrada = archivoEntrada.leeArchivo();
		String ganador = "";

		archivoSalida.escribeArchivo(ganador);
		System.out.println(archivoSalida.leeArchivo());
	}

}
