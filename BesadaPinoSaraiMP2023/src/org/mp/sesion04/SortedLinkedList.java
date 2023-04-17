package org.mp.sesion04;
import java.util.Iterator;

import org.mp.sesion03.LinkedList;

/**
 * Clase SortedLinkedList.
 * @author Sarai Besada Pino
 *@version Sesion04
 *@param <E> tipo generico
 */
public class SortedLinkedList<E extends Comparable<E>> extends LinkedList<E> {
	
	/**Constructor por defecto*/
	public SortedLinkedList() {
	}
	
	/**
	 * Constructor que recibe por parametros un array de objetos.
	 * @param objects
	 * Array de objetos comparable.
	 */
	public SortedLinkedList(Comparable<E>[] objects) {
		for(int i = 0;i < objects.length; i++) {
			addSorted(objects[i]);
		}
	}
	
	public void addFirst(E o) {
		throw new UnsupportedOperationException("No garantiza orden");
	}
	public void addLast(E o) {
		throw new UnsupportedOperationException("No garantiza orden");
	}
	public void add(E o) {
		throw new UnsupportedOperationException("No garantiza orden");
	}
	public void add(int index, E o) {
		throw new UnsupportedOperationException("No garantiza orden");
	}
	public E set(int index, E o) {
		throw new UnsupportedOperationException("No garantiza orden");
	}
	
	/**Metodo que añade un objeto e que se le pasa por parametro, en un orden creciente.
	 * @param e objeto e
	 */
	public void addSorted(Comparable<E> e) {
		E obj = (E) e;
		
		if(isEmpty() || e.compareTo(getFirst()) < 0) {
			super.addFirst(obj);
		}else if(e.compareTo(getLast())>0) {
			super.addLast(obj);
		}else {
			int i = 0;
			Iterator<E> iterador = this.iterator(); //Lo hemos igualado al iterator de la calse padre LinkedList
			while(iterador.hasNext()) {
				if(iterador.next().compareTo(obj)<0) {
					i++;
				}
				else
					break;
			}
			super.add(i, obj);
		}
	}
	 /**
	  * Metodo toString sobre-escrito.
	  */
	public String toString() {
		return "Lista ordenada: " + super.toString();
	}




}
