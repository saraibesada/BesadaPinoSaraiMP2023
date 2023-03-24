package org.mp.sesion03;

public interface List<E> extends Iterable<E>{

  /** Anade un nuevo elemento al final de la lista
   * @param e 
   * 	Elemento que añade. 
   */
  public void add(E e);

  /** 
   * @param index posicion de la lista
   * @param e elemento de la lista
   * Anade un nuevo elemento en la posicion especificada por index en la lista */
  public void add(int index, E e);

  /** Borra todos los elementos de la lista */
  public void clear();

  /** Devuelve true si la lista contiene el elemento e
   * @param e 
   * 	Elemento que debe buscar. 
   * @return true
   * 	Devuelve true si la lista contiene el elemento pasado por parametro y si no lo contiene devuelve false.
   */
  public boolean contains(E e);

  /** Devuelve el elemento de la lista que esta en la posicion especificada por index 
   * @param index
   *  Posicion del elemento.
   * @return e
   *  Elemento que se encuentra en la posicion pasada por paramentro. 
   */
  public E get(int index);

  /** Devuelve el indice de la primera ocurrencia del elemento e en la lista.
   *  Devuelve -1 si no esta. 
   * @param e 
   * 	Elemento.  
   * @return ocurrencia
   *  Devuelve la primera ocurrencia del elemento pasado por parametro y si no esta devuelve -1.
   */
  public int indexOf(E e);

  /** Devuelve true si la lista no tiene elementos 
   * @return true
   *  Devuelve true si la lista esta vacia. 
   */
  public boolean isEmpty();

  /** Devuelve el indice de la ultima ocurrencia del elemento e en la lista.
   *  Devuelve -1 si no esta. 
   * @param e
   * 	Elemento.
   * @return ocurrencia
   *  Devuelve la ultima ocurrencia del elemento pasado por parametro y si no esta devuelve -1.  
   */
  public int lastIndexOf(E e);

  /** Borra la primera ocurrencia del elemento e en la lista.
   *  Desplaza la subsecuencia de elementos a la izquierda.
   *  Devuelve true si el elemento se ha borrado.
   * @param e
   * 	Elemento.  
   * @return true
   * 	Devuelve true si el elemento ha sido eliminado y false si no lo ha sido.
   */
  public boolean remove(E e);

  /** Borra el elemento de la posicion especificada por index de la lista.
   *  Desplaza la subsecuencia de elementos a la izquierda.
   *  Devuelve el elemento que ha sido borrado de la lista.
   * @param index
   * 	Posicion especificada. 
   * @return e
   *  Elemento eliminado. 
   */
  public E remove(int index);

  /** Sustituye el elemento de la posicion especificada por index en la lista
   *  por el elemento e y devuelve el elemento antiguo
   * @param e
   * 	Elemento. 
   * @param index
   * 	Posicion especificada.
   * @return e
   * 	Elemento sustituido. 
   */
  public E set(int index, E e);

  /** Devuelve el numero de elementos de la lista 
   * @return size
   *  Tamaño de la lista. 
   */
  public int size();
}
