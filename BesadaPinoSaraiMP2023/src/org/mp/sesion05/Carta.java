package org.mp.sesion05;

public class Carta implements Comparable<Object> {

	private String palo;
	private int numero;
	private int valor;


	public Carta() {

	}

	public Carta(String palo, int numero) {
		this.palo = palo;
		this.numero = numero;

		switch(palo) {
		case "O": 
			this.valor = numero;
			break;

		case "C": 
			this.valor = numero + 12;
			break;

		case "E": 
			this.valor = numero + 24;
			break;

		case "B": 
			this.valor = numero + 36;
			break;
		}
	}

	public String getPalo() {
		return this.palo;
	}

	public int getValor() {
		return this.valor;
	}

	public int getNumero(){
		return this.numero;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Carta other = (Carta) obj;
		if (numero != other.numero)
			return false;
		if (palo == null) {
			if (other.palo != null)
				return false;
		} else if (!palo.equals(other.palo))
			return false;
		if (valor != other.valor)
			return false;
		return true;
	}

	public int compareTo(Object o) {
		Carta other = (Carta) o;
		if(this.valor > other.valor) return 1;
		else if(this.valor < other.valor) return -1;
		else return 0;
	}
}