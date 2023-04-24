package org.mp.sesion05;

import java.util.Arrays;

/**
 * Clase Ordenación.
 * @author Sarai Besada Pino.
 *
 */
public class Ordenacion {

	/**
	 * Ordenación por Inserción. Este metodo hace una llamada al metodo privado ordenación por inserción.
	 * @param a		recibe por parametros un array de Comparable.
	 */
	public static void ordenacionPorInsercion(Comparable [] a) {

		ordenacionPorInsercion(a, 0, a.length-1);

	}

	/**
	 * Metodo privado ordenación por inserción. Este metodo recibe por parametros un array de comparable, y la posiion izquierda y derecha.
	 * @param a array de comprable.
	 * @param izq posición izquierda del array.
	 * @param der posición derecha del array.
	 */
	private static void ordenacionPorInsercion(Comparable [] a, int izq, int der) {
		int j;
		Comparable tmp;
		for(int p = izq + 1; p <= der; p++) {
			tmp = a[p];
			for(j = p;j > izq && (tmp.compareTo(a[j - 1]) < 0); j--) {
				a[j] = a[j - 1];
			}
			a[j] = tmp;
		}
	}

	/**
	 * MergeSort. Recibe por paramentros un array de Comparable. Llama al metodo privado de MergeSort.
	 * @param a	array de comparable.
	 */
	public static void mergeSort(Comparable[] a) {
		
		Comparable [] vectorTemp = new Comparable[a.length];
		mergeSort(a, vectorTemp, 0, a.length - 1);
		
	}
	 

	/**
	 * Metodo privado de MergeSort. Recibe por parametros dos arrays de Comparable, la posición izquierda y la posición derecha del array. 
	 * @param a array de Comparable.
	 * @param vectorTemp array de Comparable.
	 * @param izq posición izquierda del array.
	 * @param der posición derecha del array.
	 */
	private static void mergeSort(Comparable [] a, Comparable [] vectorTemp, int izq, int der ) {
		if(izq < der) {
			int centro = (izq + der)/2;
			mergeSort(a, vectorTemp, izq, centro);
			mergeSort(a, vectorTemp, centro + 1, der);
			mezclar(a, vectorTemp, izq, centro + 1, der);
		}
	}
	
	/**
	 * Metodo mezclar. El proposito de este metodo es el de mezclar el contenido del array. Recibe por paramentros dos arrays de Comparable, la posición izquierda, derecha
	 * y la posición fin del array.
	 * @param a	Array de Comparable.
	 * @param vectorAux	Array de Comparable.
	 * @param posIzq	posición izquierda del array.
	 * @param posDer	posición derecha del array.
	 * @param posFin	posición final del array.
	 */
	private static void mezclar(Comparable [] a, Comparable [] vectorAux, int posIzq, int posDer, int posFin) {
		
		int finIzq = posDer -1;
		int posAux = posIzq;
		int numElementos = posFin - posIzq + 1;
		while((posIzq <= finIzq) && (posDer <= posFin)) {
			if(a[posIzq].compareTo(a[posDer]) <= 0)
				vectorAux[posAux++] = a[posIzq++];
			else
				vectorAux[posAux++] = a[posDer++];
		}
		
		//Copia el resto de la primera mitad del array
		while(posIzq <= finIzq)
			vectorAux[posAux++] = a[posIzq++];
		//Copia el resto de la segunda mitad del array
		while(posDer <= posFin)
			vectorAux[posAux++] = a[posDer++];
		//Copia el vector temporal en el original
		for(int i = 0; i < numElementos; i++, posFin--)
			a[posFin] = vectorAux[posFin];
	}

	/**
	 * Metodo Sort. Recibe por paramentros un array de Comparable. Hace una llamada al metodo sort de la clase Arrays.
	 * @param a Array de Comparable.
	 */
	public static void sort(Comparable [] a) {
		Arrays.sort(a);
	}

}