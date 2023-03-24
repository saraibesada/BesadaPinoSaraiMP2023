package org.mp.sesion03;

public abstract class AbstractList<E> implements List<E> {

	protected int size = 0; // Tamano de la lista

	/** Crea una lista por defecto */
	protected AbstractList() {
	}

	/** Crea una lista a partir de un array de objetos */
	protected AbstractList(E[] objects) {
		for (int i = 0; i < objects.length; i++)
					add(objects[i]);
	}

	/** Anade un nuevo elemento al final de la lista */
	public void add(E e) {
		add(size, e);
	}

	/** Devuelve true si la lista no contiene ningun elemento */
	public boolean isEmpty() {
		return size == 0;
	}

	/** Devuelve el numero de elementos de la lista */
	public int size() {
		return size;
	}

	/**Elimina la primera ocurrencia del elemento e de la lista. 
	 * Busca el elemento e. Si lo encuentra, como devuelve la posición
	 *  invoca al método remove(index) para eliminar.
	 * Devuelve true si el elemento se elimino.
	 * 
	 */
	public boolean remove(E e) {
		int posicionDondeEsta = indexOf(e);
		
		if (posicionDondeEsta >= 0) { // Busca e en el array
			remove(posicionDondeEsta); // Elimina en la posicion que lo ha encontrado
			return true;
		} else
			return false;
	}
}
