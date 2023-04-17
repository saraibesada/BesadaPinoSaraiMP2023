package org.mp.sesion05;

/**
 * Clase Accion.
 * @author Sarai Besada Pino
 *
 */

public class Accion implements Comparable<Object>{

	private String nombre;
	private long volumen;
	
	/**
	 * Constructor. Recibe por parametros el nombre y el volumen.
	 * @param nombre nombre de la acción.
	 * @param volumen volumen de la acción.
	 */
	public Accion(String nombre, long volumen) {
		this.nombre = nombre;
		this.volumen = volumen;
	}
	
	/**
	 * Getter.
	 * @return nombre Devuelve el nombre de la acción.
	 */
	public String getNombre() {
		return nombre;
	}
	
	/**
	 * Setter. Recibe por parametros el nombre de la acción.
	 * @param nombre nombre de la acción.
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	/**
	 * Getter.
	 * @return volumen Devuelve el volumen de la acción.
	 */
	public long getVolumen() {
		return volumen;
	}
	
	/**
	 * Setter. Recibe por parametros el volumen de la acción.
	 * @param volumen Volumen de la acción.
	 */
	public void setVolumen(long volumen) {
		this.volumen = volumen;
	}
	
	/**
	 * Metodo Equals.
	 * @param obj Objeto.
	 * @return boolean	Devuelve el resultado de comparar el objeto recibido por parametros.
	 * 	
	 */
	public boolean equals(Object obj) {
		Accion otro = (Accion) obj;
		return
				(this.volumen == otro.getVolumen())&&(this.nombre.equals(otro.getNombre()));
		
	}

	/**
	 * Metodo compareTo. Recibe por parametros un Objeto o. Devuelve el resutlado de la comparación.
	 * @param o Objeto.
	 * @return int Devuelve el resultado de la comparación.
	 */
	public int compareTo(Object o) {
		
		Accion other = (Accion) o;
		
		return this.nombre.compareTo(other.getNombre());
	}
	
	/**
	 * Metodo toString.
	 * @return string Devuelve una cadena.
	 */
	public String toString() {
		return nombre + ": " + volumen;
	}

	
	
}
