package org.mp.sesion05;

/**
 * Excepcion para elementos no encontrados
 */
public class ElementoNoEncontradoException extends Exception {
	/**
	 * Constructor para la excepcion
	 * 
	 * @param s
	 *            contiene mensaje con el error
	 */
	public ElementoNoEncontradoException(String s) {
		super(s);
	}
}