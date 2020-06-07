package ejercicioHeladera;

public class Main {

	public static void main(String[] args) {
		Archivo entrada=new Archivo("C:\\Users\\Daniel\\git\\Ejercicios-de-Nivel-2-de-la-Guia-de-Progra-3\\Ejercicios de Nivel 2 de la Guia de Progra 3\\src\\ejercicioHeladera\\entrada.txt");
		entrada.leeArchivo();
		//System.out.println("PATORUCITO ES GAY");
	/*	Pagina libro[]=entrada.contenidoLibro();
		for(int i=0;i<libro.length;i++) {
			for(int j=0;j<libro[i].largoDeVectorPagina();j++) {
				System.out.println(libro[j].dimeIngredienteDePagina(j));
			
			}
		}*/
	}
}
