package ejercicioHeladera;

public class Main {

	public static void main(String[] args) {
		Archivo entrada = new Archivo(
				"C:\\Users\\Usuario1\\Desktop\\Proyectos en gitHub\\Ejercicios-de-Nivel-2-de-la-Guia-de-Progra-3\\Ejercicios de Nivel 2 de la Guia de Progra 3\\src\\ejercicioHeladera\\entrada.txt");
		entrada.leeArchivo();
		
		Pagina libro[]=entrada.contenidoLibro(); 
		String ingredientesHeladera[] = new String[entrada.dimeCantIngredientesHeladera()];
		ingredientesHeladera = entrada.dameIngredientesHeladera();
		
		int realizables[] = new int[20];
		int cant=recetas(ingredientesHeladera,libro,realizables);
		
		System.out.println("Cantidad de recetas que puede realizar:"+cant);
		
		System.out.println("Numeros de paginas donde se encuentran: ");
		for(int i=0;i<cant;i++) {
			System.out.println(realizables[i]);
			
		}
		
		
	}
	
	
	public static int recetas(String heladera[], Pagina libro[], int realizables[]) {
		int cantRecetasRealizables=0;
		int posVec=0;
		
		for(int i=0;i<libro.length;i++) { //Recoriendo libro  
			boolean losIngredientesEstanEnHeladera =true;
			int j=0;
			while(j<libro[i].largoDeVectorPagina() && losIngredientesEstanEnHeladera ==true) {//Recoriendo ingredientes de las paginas
				
				boolean ingredienteEsta=false;
				int x=0;
				while(x<heladera.length && ingredienteEsta==false) {//Recoriendo ingredientes en Heladera
					
					if(libro[i].dimeIngredienteDePagina(j).equals(heladera[x])==true) {
						ingredienteEsta=true;
					}
					x++;
					
					}
				
				if(ingredienteEsta==false) {
					losIngredientesEstanEnHeladera =false;
				}
				j++;
			
				}
			
			if(losIngredientesEstanEnHeladera ==true) {
				cantRecetasRealizables++;
				realizables[posVec]=i+1;
				posVec++;
				
			}
					
			}
		return cantRecetasRealizables;	
	}	
}
