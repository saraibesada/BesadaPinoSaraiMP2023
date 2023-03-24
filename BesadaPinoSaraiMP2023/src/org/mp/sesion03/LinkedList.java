package org.mp.sesion03;
/**
 *LinkedList.
 * @author Joaquin Morales Nieto
 *@version sesion03
 * @param <E>
 */

import java.util.Iterator;
import java.util.NoSuchElementException;




public class LinkedList <E> extends AbstractList<E> {


	private Node<E> head;
	private Node<E> tail;

	/** Crea una lista por defecto*/
	public LinkedList() {
	}
	/** Crea una lista a partir de un array de objetos
	 * @param objects
	 * 	Array de objetos. 
	 */
	public LinkedList(E[] objects) {
		super(objects);
	}
	/** Devuelve el primer elemento de la lista
	 * @return primero 
	 * 	Devuelve el primer elemento de la lista.
	 */
	public E getFirst() {
		if(size == 0)
			return null;
		return head.element;
	}
	/**Devuelve el ultimo elemento de la lista.
	 *@return ultimo
	 *	Devuelve el ultimo elmento de la lista. 
	 */
	public E getLast() {
		if(size == 0)
			return null;
		return tail.element;
	}
	/**Añade un elemento a la cabeza de la lista.
	 * @param e 
	 * 	Elemento que añade. 
	 */
	public void addFirst(E e) {
		Node<E> nuevoNodo = new Node<E>(e); //Crea un nodo
		nuevoNodo.next = head; //Enlaza el nuevoNodo con la cabeza
		head = nuevoNodo; //La cabeza apunta al nuevoNodo
		size++; //Incrementa el tamaño de la lista

		if(tail == null) //si la lista esta vacia
			tail = head; //el nuevoNodo es el único en la lista
	}

	/**Añade un elemento al final de la lista
	 * @param e 
	 * 	Elemento que añade. 
	 */
	public void addLast(E e) {
		Node<E> nuevoNodo = new Node<E>(e); //Crea un nuevo nodo para e
		if(tail == null) {
			head = tail =nuevoNodo; //El nodo nuevo es el único de la lista
		}else {
			tail.next = nuevoNodo; //Enlaza el nuevo nodo con el último nodo
			tail = tail.next; //La cola apunta ahora al ultimo nodo
		}
		size++; //incrementa el tamaño
	}
	/**
	 * @param index posicion 
	 * @param e elmento 
	 * Añade el elemento e en la posición index. La posición del elemento head es 0.
	 */
	public void add(int index, E e) {
		if(index <= 0) addFirst(e); // Inserta al principio
		else if (index >= size) addLast(e); // Inserta al final
		else { //Inserta en medio
			Node<E> current = head;
			for(int i = 1; i< index; i++) {
				current = current.next;	// Situo current
			}
			Node<E> temp = current.next; // Situo temp
			current.next = new Node<E>(e); //Inserto el nuevo nodo
			(current.next).next = temp;
			size++; // Incrementa el tamaño
		}
	}

	/**Elimina el primer elemento de la lista y devuelve el elemento
	 * eliminado.
	 *@return elementoBorrado
	 *	Devuelve el elemento borrado. 
	 */
	public E removeFirst() {
		if(size==0) return null; //Nada que borrar
		else {
			Node<E> temp = head; // Conserva el primer nodo temporalmente
			head = head.next; // Mueve head para apuntar al siguiente nodo
			size--; // Reduce en 1 el tamaño
			if(head == null) tail = null; //La lista se pone vacia
			return temp.element; //Devuelve el elemento borrado
		}
	}

	/**Elimina el último elemento de la lista y devuelve el elemento
	 * eliminado.
	 * @return elementoBorrado
	 *  Devuelve el elemento borrado.
	 */
	public E removeLast() {
		if(size == 0) return null; //Nada que eliminar
		else if(size == 1) { //solo un elemento en la lista
			Node<E> temp = head;
			head = tail = null; //la lista la hacemos vacia
			size = 0;
			return temp.element;
		}else {
			Node <E> current = head;
			for(int i = 1; i < size -1; i++)
				current = current.next;
			Node <E> temp = tail;
			tail = current;
			tail.next = null;
			size--;
			return temp.element;
		}
	}

	/**
	 * @param index posicion
	 * Elimina el elemento en la posición index. Devuelve el
	 * elemento que fué eliminado de la lista.
	 */
	public E remove(int index) {
		if(index <0 || index >= size) return null; // Fuera de rango
		else if (index == 0) return removeFirst(); //Elimina el primero
		else if(index == size -1) return removeLast(); //Elimina el ultimo
		else {
			Node <E> previous = head;
			for(int i = 1; i < index; i++) {
				previous = previous.next;
			}
			Node <E> current = previous.next;
			previous.next = current.next;
			size--;
			return current.element;
		}

	}

	@Override /** Sobre-escribe toString() */
	public String toString() {
		StringBuilder result = new StringBuilder("[");
		if (size==0)
			result.append("]");
		else {
			Node<E> current = head;
			for (int i = 0; i < size; i++) {
				result.append(current.element);
				current=current.next;
				if(current != null) {
					result.append(", ");
				} else {
					result.append("]");
				}
			}
		}
		return result.toString();
	}
	/** Elimina todos los elementos de la lista*/
	public void clear() {
		size = 0;
	}
	/**
	 * @param e elemento 
	 * Devuelve true si la lista contiene el elemento e
	 */
	public boolean contains(E e) {
		Node<E> resultado = new Node<E>(e);
		for(int i=0; i<size; i++) {
			if(e == resultado.element)
				return true;
		} return false;

	}
	/**
	 * @param index posición
	 * @return aux.element elemento de la posicion especificada
	 * Devuelve el elemento en la posición index especificada  
	 */
	public E get(int index) {
		if(index < 0 || index >= size)
			return null;

		Node<E> aux = head;
		for(int i = 0; i < size; i++) {
			if(i == index) {
				aux = head;
				break;
			}
		}
		return aux.element;
	}

	/**
	 * @param e elemento
	 * @return -1 si no esta el elemento
	 * Devuelve el índice de la primera ocurrencia del elemento en la lista.
	 * Devuelve -1 si no está
	 */
	public int indexOf(E e) {
		Node<E> nuevo = head;
		for(int i = 0; i < size; i++) {
			if(nuevo.element == e) 
				return i;
			else
				nuevo = nuevo.next;
		}

		return -1;
	}

	/**
	 * @param e elemento
	 * @return posicion posicion del elemento
	 * Devuelve el índice de la última ocurrencia del elemento
	 * en la lista. Devuelve -1 si no está.
	 */
	public int lastIndexOf(E e) {
		Node <E> current = head;
		int posicion = -1;
		for(int i = 0; i < size; i++) {
			if(current.element == e) 
				posicion = i;
			current = current.next;
		}

		return posicion;
	}

	/**
	 * @param index posicion
	 * @param e elemento
	 * @return antiguo elemento sustituido
	 * Sustituye el elemento de la posición especificada
	 * en la lista por el elemento especificado.
	 */
	public E set(int index, E e) {
		if(index < 0 || index >= size ) { //Lo primero es comprobar que index se encuentra en el rango corercto
			return null; // si no es asi devuelve null.
		}
		E antiguo = remove(index); //Borro el elemento que contiene index y lo guardo para devolverlo despues
		add(index, e); //Ahora sustituyo el elmento e en index que ahora se encuentra vacio.

		return antiguo;
	}

	@Override
	/** Sobre-escribe el método iterator() definido en Iterable */
	public Iterator<E> iterator() {
		return new LinkedListIterator();
		// Devuelve una instancia de LinkedListIterator
	}



	/** Esta clase implementa la interface Iterator*/
	private class LinkedListIterator implements Iterator<E> {
		private Node<E> current = head;
		@Override
		public boolean hasNext() {
			return (current != null);
		}

		@Override
		public E next() {
			if(current == null)
				throw new NoSuchElementException ("No hay más elementos en la lista");
			E e = current.element;
			current = current.next;
			return e;
		}

		@Override
		public void remove() {
			if(size!=0) 
				LinkedList.this.remove(current.element);

		}
	}
	// Esta clase solo se usa en LinkedList, por eso es private.
	// Esta clase no necesita acceder a ningún miembro de instancia de	LinkedList,
	// por lo que se define estática.
	private static class Node<E> {
		//Propiedades

		E element;
		Node next;

		public Node(E o) {
			this.element = o;
		}

	}

}

