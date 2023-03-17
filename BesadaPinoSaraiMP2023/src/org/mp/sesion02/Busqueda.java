package org.mp.sesion02;

/**
 * Clase Busqueda. Busqueda binaria.
 * @author Sarai Besada
 * @version sesion02
 *
 */
public class Busqueda {

	/**
	 * Metodo Busqueda Binaria que va dividiendo el array y busca el elemento clave o por el subarray derecho
	 * o por el subarray izquierdo.
	 * @param a Array.
	 * @param clave Clave. 
	 * @param <E> elemento de una coleccion.
	 * @return -1 Busqueda.
	 * @throws ExcepcionArrayVacio en caso de arrray vacio.
	 */
	public static <E extends Comparable<E>> int busquedaBinaria(E[] a, E clave) throws ExcepcionArrayVacio{ //Declaro cualquier excepcion que no sea RunTimeException o sus derivados.

		if(a.length == 0) throw new ExcepcionArrayVacio("Array vacío");

		int primero = 0;
		int ultimo = a.length-1;
		int central;

		if(clave.compareTo(a[0]) < 0 || clave.compareTo(a[ultimo]) > 0) return -1;
		else{
			while(ultimo >= primero) {
				central = (primero+ultimo)/2;
				if(clave.compareTo(a[central]) < 0) ultimo = central-1;
				else if(clave.compareTo(a[central]) > 0) primero = central + 1;
				else
					return central;

			}
		}
		return -1;
	}

}
