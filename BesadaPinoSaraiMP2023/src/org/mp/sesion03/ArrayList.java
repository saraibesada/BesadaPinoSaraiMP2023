package org.mp.sesion03;

import java.util.Iterator;
import java.util.NoSuchElementException;
/**
 *ArrayList.
 * @author Sarai Besada Pino
 *@version sesion03
 * 
 */
public class ArrayList <E> extends AbstractList<E>{

	private static final int CAPACIDAD_INICIAL = 16;
	private E [] data = (E[]) new Object[CAPACIDAD_INICIAL];
	private int current = 0;



	/**
	 * Crea una ArrayList por defecto.
	 */
	public ArrayList() {
		this.size = 0;
	}

	/**
	 * @param objects
	 * Crea una lista a partir de un array de objetos.
	 */
	public ArrayList(E[] objects) {
		for(int i = 0; i<objects.length;i++){
			add(objects[i]); // Advertencia: no usar super(objects)!
		}
	}

	/**
	 * @param index posicion especifica
	 * @param e nuevo elemento
	 * Añade un nuevo elmenento e en la posición especificada index de la lista.
	 */
	public void add(int index, E e) {
		// Verifica cuando el array esta lleno. De ser asi 
		// crea un nuevo array con el doble tamaño más 1 y copia
		// el array en el nuevo utilizando el método System.arraycopy y
		// pone el nuevo array como el array a utilizar

		ensureCapacity(); 
		if(index < 0|| index > size)
			throw new IndexOutOfBoundsException ("Indice: " + index + ", Tamaño: " + this.size);
		//Mueve los elementos a la derecha desde la posición especificada por index
		for(int i = size-1; i >= index; i--) {
			data[i + 1] = data[i];
		}
		// Inserta un nuevo elemento en data[index]
		data[index]=e;

		// Incrementa el tamaño en 1
		size++;		
	}
	
	/** Crea un nuevo array con el doble tamaño más 1 */
	private void ensureCapacity() {
		// Verifica cuando el array esta lleno. De ser asi 
		// crea un nuevo array con el doble tamaño más 1 y copia
		// el array en el nuevo utilizando el método System.arraycopy y
		// pone el nuevo array como el array a utilizar
		if(size >= data.length) {
			E[] nuevo = (E[]) new Object[(size*2)+1];
			System.arraycopy(data, 0, nuevo, 0, size);
			data = nuevo;
		}
	}

	/**
	 * Elimina todos los elementos de la lista
	 */
	public void clear() {
		// Crea un nuevo array de tamaño CAPACIDAD_INICIAL y resetea la variable size a 0
		data = (E[]) new Object[CAPACIDAD_INICIAL];
		size = 0;
	}

	@Override
	/**
	/*@param e elemento de la lista
	 *  Devuelve true si la lista contiene el elemento de la lista especifiacdo por parametro.
	 */

	public boolean contains(E e) {
		//Comprueba si e esta en el array comparando cada elemento del array con e usando
		// para ello eequals.
		for(int i = 0; i<size; i++) {
			if(data[i].equals(e))
				return true;
		}
		return false;
	}

	@Override/**
	 *@param index posicion del elemento 
	 *Devuelve el elemento en la posicion especificada por index.*/
	public E get(int index) {
		checkIndex(index);
		return data[index];
	}

	private void checkIndex(int index) {
		// Comprueba si index está en el rango
		// Si no, el método lanza esa Excepción
		if(index < 0 || index >= size)
			throw new IndexOutOfBoundsException
			("Indice: " + index + ", Tamaño: " + this.size);
	}

	@Override /**
	 *@param e elemento de la lista
	 *Devuelve el índice de la primera ocurrencia del elemento en la lista
	 *Devuelve -1 si no está.
	 **/
	public int indexOf(E e) {
		for (int i = 0; i < size; i++)

			if (e.equals(data[i]))
				return i;


		return -1;
	}

	@Override/**
	 *@param e elemento de la lista
	 *Devuelve el índice de la última ocurrencia del elemento en la lista.
	 *Devuelve -1 si no está.
	 */
	public int lastIndexOf(E e) {
		for(int i = this.size-1; i>=0; i--) {
			if(e.equals(data[i]));
			return i;
		}
		return -1;
	}

	@Override/**
	 *@param index posicion del elemento
	 *Elimina el elemento en la posicion especificada en la lista.
	 *Desplaza la subsecuencia de elemento a la izquierda.
	 *Devuelve el elemento eliminado.
	 */
	public E remove(int index) {
		checkIndex(index);
		E e = data[index];

		for(int i = index; i<size-1; i++) {
			data[i] = data[i+1];
		}
		data[size-1]=null;
		size--;
		return e;
	}

	@Override/**
	 *@param index posicion especifica del elemento
	 *@param e elemento especificado de la lista
	 *Sustituye el elemento de la posicion especificada en la lista
	 *por el elemento especificado
	 */
	public E set(int index, E e) {
		checkIndex(index);
		E antiguo = data[index];
		data [index] = e;
		return antiguo;
	}



	@Override
	public String toString() {
		StringBuilder resultado = new StringBuilder("[");

		for(int i = 0; i<size; i++) {
			resultado.append(data[i]);
			if(i<size-1)resultado.append(", ");
		}

		return resultado.toString() + "]";
	}
	/**
	 * Ajusta la capacidad del array al tamño de la lista.
	 */
	public void trimToSize() {
		// si el tamaño del array es distinto de la capacidad
		// Crea un nuevo array del tamaño del que se tiene
		// Copia el array en el nuevo array utilizando System.arraycopy
		// Si tamaño == capacidad, no es necesario hacer nada
		if(data.length == size) {
			throw new NoSuchElementException("Guapit@ no necesitas hacer un trim, el tamaño coincide con la capacidad");
		}
		if(data.length != size) {
			E[] nuevo = (E[]) new Object[size];
			System.arraycopy(data, 0, nuevo, 0, size);
			data = nuevo;
		}
	}

	@Override/** Sobre-escribe el método iterator() definido en Iterable */
	public Iterator<E> iterator() {
		// Devuelve una instancia de java.util.Iterator, una instancia de ArrayListIterator
		return new ArrayListIterator();
	}

	private class ArrayListIterator implements java.util.Iterator<E>{
		// Esta clase implementa la interface Iterator
		// Implementa por tanto los métodos hasNext, next y remove
		// Usa current para indicar la posición del elemento que está siendo atravesado

		public boolean hasNext() {
			return current < size;
		}

		public E next() {
			if(current == size) {
				throw new NoSuchElementException("No hay más elementos en la lista");
			}
			E e = data[current];
			current++;
			return e;
		}

		public void remove() {
			ArrayList.this.remove(current);
		}
	}

}
