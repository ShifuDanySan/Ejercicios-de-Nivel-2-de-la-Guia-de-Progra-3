package ejercicioElegido;

public class Jugador {
	public Jugador(String nombre) {
		this.nombre = nombre;
	}

	public String dimeNombre() {
		return this.nombre;
	}

	public void definirJugada(String jugada) {
		jugadaRealizada = jugada;
	}

	public String dimeJugada() {
		return jugadaRealizada;
	}

	private String nombre;
	private String jugadaRealizada;
}
