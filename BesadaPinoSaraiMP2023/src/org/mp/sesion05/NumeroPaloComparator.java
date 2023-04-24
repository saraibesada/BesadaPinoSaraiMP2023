package org.mp.sesion05;

import java.util.Comparator;

/**
 * Clase NumeroPaloComparator.
 * @author Sarai Besada Pino.
 *
 */
public class NumeroPaloComparator implements Comparator<Object>{

	/**
	 * Metodo compare. Recibe por parametros el objeto o1 y el objeto o2.
	 * @param o1 Objeto.
	 * @param o2 Objeto.
	 * @return resultado	Devuelve el resultado de la comparación entre los dos objetos.
	 */
	public int compare(Object o1, Object o2) {
		char[] palos = {'O','C','E','B'};
		
		Carta c1 = (Carta)o1;
		Carta c2 = (Carta)o2;
		
		char palo1 = c1.getPalo().charAt(0);
		char palo2 = c2.getPalo().charAt(0);
		
		int valorP1 = 0;
		int valorP2 = 0;
		
		if(c1.getNumero() > c2.getNumero()) return 1;
		if(c2.getNumero() > c1.getNumero()) return -1;
		else {
			for(int i = 0; i < palos.length; i++) {
				if(palo1 == palos[i]) valorP1 = i;
				if(palo2 == palos[i]) valorP2 = i;
			}
			
			if(valorP1 > valorP2) return 1;
			else if(valorP1 < valorP2) return -1;
			else return 0;
		}
		
		
	}

}
