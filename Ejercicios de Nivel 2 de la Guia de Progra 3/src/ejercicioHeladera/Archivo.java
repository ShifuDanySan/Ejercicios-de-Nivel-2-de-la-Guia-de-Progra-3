package ejercicioHeladera;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Archivo {
	public Archivo(String direccion) {
		this.direccion = direccion;
	}

	public void leeArchivo() {
		String texto = "";
		try {
			BufferedReader bf = new BufferedReader(new FileReader(this.direccion));
			String temp = "";
			int i = 0;
			String bfRead;
			if ((bfRead = bf.readLine()) != null) {
				for (i = 0; i < bfRead.length(); i++) {
					if (i == 0) {
						cantidadDeIngredientesEnHeladera = Character.getNumericValue(bfRead.charAt(i));
					}
					if (i == 2) {
						cantidadPaginas = Character.getNumericValue(bfRead.charAt(i));
					}
				}
			}
			this.ingredientesEnHeladera = new String[cantidadDeIngredientesEnHeladera];
			String aux = "";
			if ((bfRead = bf.readLine()) != null) {
				i = 0;
				for (int j = 0; j < bfRead.length(); j++) {
					if (bfRead.charAt(j) != ' ') {
						aux += bfRead.charAt(j);
					} else {
						ingredientesEnHeladera[i] = aux;
						i++;
						aux = "";
					}
					if (j == bfRead.length() - 1) {
						ingredientesEnHeladera[i] = aux;
					}
				}

			}

			libro = new Pagina[cantidadPaginas];
			String aux2 = "";
			for (int k = 0; k < cantidadPaginas; k++) {

				bfRead = "";
				if ((bfRead = bf.readLine()) != null) {
					cantidadIngredientesEnPagina = Integer.parseInt(bfRead);
				}
				bfRead = "";
				Pagina pagina = new Pagina(cantidadIngredientesEnPagina);

				if ((bfRead = bf.readLine()) != null) {
					aux2 = "";
					i = 0;
					for (int j = 0; j < bfRead.length(); j++) {
						if (bfRead.charAt(j) != ' ') {
							aux2 += bfRead.charAt(j);
						} else {
							pagina.cargarIngredienteAPagina(aux2, i);
							i++;
							aux2 = "";
						}
						if (j == bfRead.length() - 1) {

							pagina.cargarIngredienteAPagina(aux2, i);
						}
					}
				}
				libro[k] = pagina;
				cantidadIngredientesEnPagina = 0;

			}

			bf.close();// cierro el archivo
		} catch (IOException e) {// controlo excepciones
			System.out.println("No se encuentra el archivo");
		}

	}

	public Pagina[] contenidoLibro(){
		return libro;
	}
	
	public String[] dameIngredientesHeladera() {
		return ingredientesEnHeladera;
	}
	
	public int dimeCantIngredientesHeladera() {
		return cantidadDeIngredientesEnHeladera;
	}
	
	
	
	
	
	
	

	private int cantidadDeIngredientesEnHeladera = 0;
	private int cantidadPaginas = 0;
	private String ingredientesEnHeladera[];
	private int cantidadIngredientesEnPagina = 0;
	private Pagina libro[];
	private String direccion;
}