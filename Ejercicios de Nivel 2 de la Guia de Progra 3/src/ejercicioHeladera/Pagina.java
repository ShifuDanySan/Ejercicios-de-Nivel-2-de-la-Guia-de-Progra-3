package ejercicioHeladera;

public class Pagina {
	public Pagina(int cantidadIngredientes) {
		this.cantidadIngredientes=cantidadIngredientes;
		String pagina[]= new String [this.cantidadIngredientes];
		this.pagina=pagina;
	}
	
	
	public void cargarIngredienteAPagina(String ingrediente, int posicion) {
		this.pagina[posicion]=ingrediente;
		//System.out.println(this.pagina[posicion]);
		
	}
	public String dimeIngredienteDePagina(int posicion) {
		return this.pagina[posicion];
	}
	public int largoDeVectorPagina() {
		
		return cantidadIngredientes;
	}
	private int cantidadIngredientes=0;
	private String pagina[];
}
