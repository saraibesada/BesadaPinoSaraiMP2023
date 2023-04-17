package org.mp.sesion04;

import org.mp.sesion03.ArrayList;

/**
 * Clase GenericStack.
 * @author Sarai Besada Pino
 *
 * @param <E> generica.
 */
public class GenericStack<E> {
	private ArrayList<E>
	lista = new ArrayList<E>(); //Siempre se olvida instanciar y
	//lanza la excepción NullPointerException

	/**
	 * Metodo que devuelve el tamaño de la lista.
	 * @return size tamaño de la lista.
	 */
	public int getSize() {
		return lista.size();
	}

	/**
	 * Devuelve el elemento de la cima, no lo elimina.
	 * @return elemento elemento de la cima.
	 */
	public E peek() {
		return lista.get(getSize() - 1);
	}

	/**
	 * Añade un elemento en la cima de la pila.
	 * @param o elemento a añadir en la pila.
	 */
	public void push(E o) {
		lista.add(o);
	}

	/**
	 * Elimina un elemento de la cima y lo devuelve.
	 * @return o elemento eliminado.
	 */
	public E pop() {
		E o = lista.get(getSize() - 1);
		lista.remove(getSize() - 1);
		return o;
	}

	/**
	 * Devuelve verdadero si la pila esta vacia.
	 * @return boolean true si la pila esta vacia, false si la pila no esta vacia.
	 */
	public boolean isEmpty() {
		return lista.isEmpty();
	}

	@Override
	public String toString() {
		return "Pila: " + lista.toString();
	}
}
