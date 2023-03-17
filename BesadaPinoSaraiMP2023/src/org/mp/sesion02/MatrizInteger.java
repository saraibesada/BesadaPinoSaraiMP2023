package org.mp.sesion02;

public class MatrizInteger extends MatrizGenerica<Integer>{
	
	/**
	 * Metodo suma. Suma dos valores que se le pasan como parametros.
	 * @param o1 Valor uno.
	 * @param o2 Valor dos.
	 * @return La suma de los dos valores que se le pasan como parametros.
	 */
	protected Integer sumar(Integer o1, Integer o2) {
		return new Integer (o1+o2);
	}
	
	/**
	 * Metodo multiplicar. Multiplica dos valores que se le pasan como parametros.
	 * @param o1 Valor uno.
	 * @param o2 Valor dos.
	 * @return La multiplicacion de los dos valores que se le pasan como parametros.
	 */
	protected Integer multiplicar(Integer o1, Integer o2) {
		return new Integer(o1*o2);
	}
	
	/**
	 * Metodo cero. 
	 * @return Devuelve cero.
	 */
	protected Integer cero() {
		return new Integer(0);
	}

	

}
