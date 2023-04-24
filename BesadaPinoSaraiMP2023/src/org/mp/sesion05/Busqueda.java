package org.mp.sesion05;

import java.util.Arrays;

public class Busqueda {

	private int numElementos;
	private int[] datos;
	private int numBuscado;

	public Busqueda(int numElementos) {
		this.numElementos = numElementos;
		datos = new int[numElementos];
		inicializaDatos();
	}
	
	private void inicializaDatos() {

		NumerosAleatorios aleatorio = new NumerosAleatorios();
		for (int i = 0; i < datos.length; i++) {
			datos[i] = aleatorio.randomInt(5 * i, (5 * i) + 4);
		}
		Arrays.sort(datos);
		numBuscado = datos[aleatorio.randomInt(0, (datos.length - 1))];
	}

	public int getNumElementos() {
		return numElementos;
	}

	public int[] getDatos() {
		return datos;
	}

	public void setDatos(int[] datosModelo) {
		this.datos = (int[])datosModelo.clone();
		
	}

	public int getNumBuscado() {
		return numBuscado;
	}

	public void setNumBuscado(int buscar) {
		numBuscado = buscar;
	}

	public String toString() {
		if (datos == null) {
			return null;
		} else {
			String s = "Problema busqueda con " + numElementos +"\n" + "{";
			for (int i = 0; i < datos.length; i++) {
				s += datos[i];
				s += (i < datos.length - 1 ? ", " : "}");
			}
			return s;
		}
	}
	

}