package org.mp.sesion04;
/**
 * Clase GenericJosephus.
 *@author Sarai Besada Pino
 *@version sesion04
 *@param <E> tipo generico
 */

public class GenericJosephus<E> {

	private int k ;
	private int n ;
	private GenericQueue<E> cola = new GenericQueue<E>();
	
	/**
	 * Constructor que recibe por parametros dos variables int y un aaray de objetos.
	 * @param k frecuencia con la que eliminamos
	 * @param n numero de personas
	 * @param objects array
	 */
	public GenericJosephus(int k, int n, E [] objects) {
		this.k = k;
		this.n= n;
		cola = new GenericQueue<E>();
		if (objects != null) {
			for (int i=0; i<objects.length; i++) {
				cola.enqueue(objects[i]);
			}
		}
	}
	/** 
	 * Este metodo devuelve el valor de la cola.
	 * @return cola valor de la cola
	 */
	public GenericQueue<E> getCola(){
		return cola;
	}
	/** Metodo toString. 
	 *@return string cadena
	 */
	public String toString() {
		return "Problema de Josephus: k=" + k + ", n=" + n + "\n" +
				cola.toString();
	}
	/**
	 * Metodo que elimina las personas de la cola que se le pasa por parametro y devuelve las personas que son eliminadas.
	 * @param cola donde estan las personas a las que vamos a ir eliminando
	 * @return salida devuelve el String con las personas a las que va eliminando
	 */
	public String ordenEliminar(GenericQueue<E> cola) {
		String salida = "";

		if(n == 0) {
			throw new RuntimeException("No hay ninguna persona");
		}else if(n == 1){
			return "Solo hay una persona";
		}else {
			salida = salida + "Orden de eliminación: \n";
			while(cola.getSize()!=0) {
				for(int i = 0; i < k - 1; i++) {
					cola.enqueue(cola.dequeue());
				}
				salida += "Debe morir " + cola.dequeue() + "\n";
			}
		}

		return salida;
	}


}

