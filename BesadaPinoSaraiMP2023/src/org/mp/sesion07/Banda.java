package org.mp.sesion07;

/**
 * Clase Banda.
 * @author Sarai Besada
 *
 */
public class Banda <T extends Number>{
	
	private String nombreBanda;
	private T[][] datos;
	
	/**
	 * Constructor de la clase Banda. Recibe por parametros el nombre, y el valor de los indices x e y.
	 * @param nombre Nombre de la banda.
	 * @param x Indice x.
	 * @param y Indice y.
	 */
	public Banda(String nombre, int x, int y) {
		this.nombreBanda = nombre;
		this.datos = (T[][]) new Number[x][y];
	}
	
	/**
	 * Constructor de la clase Banda. Recibe por parametros el nombre y un array de datos.
	 * @param nombre Nombre de la banda.
	 * @param datos Array de datos.
	 */
	public Banda(String nombre, T[][] datos) {
		this.nombreBanda = nombre;
		this.datos = datos.clone();
	}
	
	/**
	 * Metodo getNombeBanda. 
	 * @return nombreBanda Devuelve el nombre de la banda.
	 */
	public String getNombreBanda() {
		return nombreBanda;
	}
	
	/**
	 * Metodo setNombreBanda. Recibe por parametros el nombre de la banda.
	 * @param nombreBanda Nombre de la banda.
	 */
	public void setNombreBanda(String nombreBanda) {
		this.nombreBanda = nombreBanda;
	}
	
	/**
	 * Metodo getDatos.
	 * @return datos Devuelve datos.
	 */
	public T[][] getDatos(){
		return this.datos;
	}
	
	/**
	 * Metodo setDatos. Recibe por paramtros un array de datos.
	 * @param datos Array de datos.
	 */
	public void setDatos(T[][] datos) {
		this.datos = datos;
	}
	
	/**
	 * Metodo getDatoXY. Recibe por parametros los indices x e y.
	 * @param x Indice x.
	 * @param y Indice y.
	 * @return datos Devuelve el contenido de datos que se encuentra en la posicion especificada por los indices recibidos por parametros.
	 */
	public T getDatoXY(int x, int y){
		return datos[x][y];
	}
	
	/**
	 * Metodo setDatoXY. Recibe por parametros un dato, y los indices x e y.
	 * @param dato Dato.
	 * @param x Indice x.
	 * @param y Indice y.
	 */
	public void setDatoXY(T dato, int x, int y) {
		this.datos[x][y] = dato;
	}
	
	/**
	 * Metodo toString.
	 * @return string Devuelve una de cadena de string.
	 */
	public String toString() {
		String resultado = nombreBanda + ": \n";
		
		for(int i = 0; i < datos.length; i++) {
			for(int j = 0; j < datos[0].length; j++) {
					resultado += datos[i][j] + " ";
			}
			resultado += "\n";
		}
		
		return resultado;
	}
}
