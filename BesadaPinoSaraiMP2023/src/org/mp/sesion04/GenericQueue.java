package org.mp.sesion04;

import org.mp.sesion03.LinkedList;
/**
 * Clase GenericQueue.
 * @author Sarai Besada Pino 
 *
 * @param <E> generica.
 */
public class GenericQueue<E> {
	private LinkedList<E> lista
	= new LinkedList<E>(); // No olvidar new

	/**
	 * Metodo que añade un elmento en la cola.
	 * @param e elemento que se le pasa por parametros.
	 */
	public void enqueue(E e) {
		lista.addLast(e);
	}

	/**
	 * Metodo que elimina el primer elemento de la cola.
	 * @return removeFirst devuelve el elemento eliminado.
	 */
	public E dequeue() {
		return lista.removeFirst();
	}

	/**
	 * Metodo que devuelve el numero de elementos de la cola.
	 * @return size numero de elementos de la cola.
	 */
	public int getSize() {
		return lista.size();
	}

	@Override
	public String toString() {
		return "Cola: " + lista.toString();
	}
}
