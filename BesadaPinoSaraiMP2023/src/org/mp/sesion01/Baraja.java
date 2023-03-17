package org.mp.sesion01;

/**
 * @author Sarai
 *
 */

public class Baraja {

	private String nombreBaraja;
	private Carta[] cartas;


	public Baraja() {

	}

	public Baraja(String nombreBaraja, Carta [] cartas) {
		this.nombreBaraja = nombreBaraja;
		this.cartas = new Carta[cartas.length];
		for (int i = 0; i < cartas.length; i++) {
			this.cartas[i] = cartas[i];
		}
	}

	public String getNombreBaraja() {
		return this.nombreBaraja;
	}
	public Carta [] getCartas() {
		return this.cartas;
	}
	
	public void insercion(Carta[] array) {
		for (int i = 1; i < array.length; i++) {
			Carta aux = array[i];
			int j;
			for (j = i - 1; (j >= 0) && (aux.compareTo(array[j]) < 0); j--) {
				array[j + 1] = array[j];
			}
			array[j + 1] = aux;
		}
	}
	

}