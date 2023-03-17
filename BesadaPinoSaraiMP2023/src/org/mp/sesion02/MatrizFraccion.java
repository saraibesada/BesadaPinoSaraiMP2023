package org.mp.sesion02;
/**
 * Clase MatrizFraccion. Esta clase permite crear matrices de fracciones.
 * @author Sarai Besada
 *@version Sesion02.
 */
public class MatrizFraccion extends MatrizGenerica<Fraccion>{

	/**
	 * Metodo sumar. Permite sumar dos fracciones.
	 * @param o1 Fraccion uno.
	 * @param o2 Fraccion dos.
	 * @return La suma de las dos fracciones.
	 */
	protected Fraccion sumar(Fraccion o1, Fraccion o2) {
		return Fraccion.sumar(o1, o2);
	}

	/**
	 * Metodo multiplicar. Permite multiplicar dos fracciones.
	 * @param o1 Fraccion uno.
	 * @param o2 Fraccion dos.
	 * @return El resultado de multiplicar las dos fracciones.
	 */
	protected Fraccion multiplicar(Fraccion o1, Fraccion o2) {
		return o1.multiplicar(o2);
	}

	/**
	 * Metodo cero.
	 * @return Devuelve cero.
	 */
	protected Fraccion cero() {
		return new Fraccion(0,1);
	}

}
