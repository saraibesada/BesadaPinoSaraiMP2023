package org.mp.sesion02;

public class Octogono extends ObjetoGeometrico implements Comparable<Octogono>, Cloneable, DeColor{

	private double lado;
	public Octogono() {	
	}

	public Octogono(String color, boolean relleno, double lado) {
		super(color, relleno);
		this.lado = lado;
	}


	public double getLado() {
		return lado;
	}


	public void setLado(double lado) {
		this.lado = lado;
	}

	public int compareTo(Octogono o) {
		if(this.getArea() > o.getArea())return 1;
		else if(this.getArea() < o.getArea()) return -1;
		else
			return 0;
	}

	public String comoColorear() {
		return "Colorear los 8 lados de " + this.color;
	}

	public String toString() {
		return super.toString();
	}

	public double getPerimetro() {
		return 8*this.lado;
	}

	public double getArea() {
		return (2 + (4/Math.sqrt(2)))*Math.pow(lado, 2);
	}
	
	public Octogono clone() {
		Octogono oct = new Octogono(this.color, this.relleno, this.lado);
		return oct;
	}
}
