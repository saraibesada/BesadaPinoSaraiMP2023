package org.mp.sesion02;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class IteradorPrimos implements Iterator<Integer>{

	private int limite;
	private int actual;
	
	public IteradorPrimos(int limite) {
		this.limite = limite;
		this.actual = 2;
	}

	public int getLimite() {
		return limite;
	}

	public void setLimite(int limite) {
		this.limite = limite;
	}

	public int getActual() {
		return actual;
	}

	public void setActual(int actual) {
		this.actual = actual;
	}

	@Override
	public boolean hasNext() {
		int numero = actual;
		while(!esPrimo(numero)) numero++;
		if(numero > limite) return false;
		else return true;
	}
	@Override
	public Integer next() {
		while(!esPrimo(actual)) {
			actual++;
			if(actual > limite) throw new NoSuchElementException("No se puede acceder a más números primos");
		}
		return actual++;
	}
	
	public void remove() {
		throw new UnsupportedOperationException("Método no soportado");
	}
	
	public static boolean esPrimo(int numero) {
		boolean primo = true;
		if(numero < 0) numero = -numero;
		if(numero <= 3) primo = true;
		for(int denominador = 2; denominador < numero; denominador++) {
			if(numero%denominador == 0) {
				primo = false;
			}
		}
		return primo;
	}



	public String mostrarPrimos() {
		String cadena = "";
		int numero = 1;
		while(hasNext()) {
			cadena = cadena + "\t" + this.next();
			
			if(numero%10 == 0) cadena = cadena + "\n";
			numero++;
		}
		return cadena;
	}
	
	
}
