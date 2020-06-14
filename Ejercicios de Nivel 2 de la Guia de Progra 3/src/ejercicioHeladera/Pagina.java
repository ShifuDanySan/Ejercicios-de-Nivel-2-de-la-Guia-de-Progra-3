package ejercicioHeladera;

public class Pagina {
	
	public Pagina(int cantidadIngredientes) {
		this.cantidadIngredientes = cantidadIngredientes;
		String pagina[] = new String[this.cantidadIngredientes];
		this.ingredientes = pagina;
	}

	public void cargarIngredienteAPagina(String ingrediente, int posicion) {
		this.ingredientes[posicion] = ingrediente;

	}

	public String dimeIngredienteDePagina(int posicion) {
		return this.ingredientes[posicion];
	}

	public int largoDeVectorPagina() {

		return cantidadIngredientes;
	}

	private int cantidadIngredientes = 0;
	private String ingredientes[];
}
