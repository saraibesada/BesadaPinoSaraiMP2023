package org.mp.sesion05;

import java.util.Comparator;

/**
 * Clase VolumenComparator.
 * @author Sarai Besada Pino.
 *
 */
public class VolumenComparator implements Comparator<Object>{

	/**
	 * Metodo compara. Recibe por parametros el objeto o1 y el objeto o2. Compara los dos obejtos y devuelve el resultado
	 * de la comparación.
	 * @param o1 Objeto.
	 * @param o2 Objeto.
	 * @return int Devuelve 1, -1 o 0 dependiendo de la condición que se cumpla.
	 */
	public int compare(Object o1, Object o2) {
		
		Accion a1 = (Accion)o1;
		Accion a2 = (Accion)o2;
		if(a1.getVolumen() > a2.getVolumen()) return 1;
		else if(a1.getVolumen() < a2.getVolumen()) return -1;
		else
			return 0;
	}

}
