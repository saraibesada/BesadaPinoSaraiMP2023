package org.mp.sesion01;

public class Fraccion implements Comparable<Object> {

	private int numerador;
	private int denominador;
	
	/**
	 * Contructor por defecto.
	 */
	public Fraccion() {
		numerador = 0;
		denominador = 1;
	}

	/**
	 * Metodo constructor de la clase Fraccion.
	 * @param numerador
	 * Se le pasa por parametros el numerador de la Fraccion.
	 * @param denominador
	 * Se le pasa por parametros el denominador de la Fraccion.
	 */
	public Fraccion(int numerador, int denominador) {
		this.numerador = ((denominador > 0) ? 1 : -1) * numerador;
		this.denominador = Math.abs(denominador);
	}
	/**
	 * Metodo equals, con el que comparamos si dos fracciones son iguales, pero
	 * comparando sus numeradores y denominadores.
	 */
	@Override
	public boolean equals(Object obj) {

		if (!(obj instanceof Fraccion))
			return false;
		Fraccion otro = (Fraccion) obj;
		if (denominador != otro.denominador)
			return false;
		if (numerador != otro.numerador)
			return false;
		return true;
		
	}

	/**
	 * Getter.
	 * @return numerador
	 * Devuelve el nunmerador de la Fraccion
	 */
	public int getNumerador() {
		return numerador;
	}

	/**
	 * Getter.
	 * @return denominador
	 * Devuelve el denominador de la Fraccion.
	 */
	public int getDenominador() {
		return denominador;
	}
	/**
	 * Metodo toString que devuelve una cadena.
	 */
	@Override
	public String toString() {
		if (denominador == 1)
			return numerador + "";
		else
			return numerador + "/" + denominador;
	}

	/**
	 * Suma de fracciones.
	 * @param b
	 *Se le pasa por parametro un valor b del tipo Fraccion.
	 * @return fraccion obtenida al sumar la fraccion b consigo misma.
	 */
	public Fraccion sumar(Fraccion b) {
		int num = numerador * b.getDenominador() + denominador * b.getNumerador();
		int den = denominador * b.getDenominador();
		return new Fraccion(num, den);

	}
	/**
	 * Suma de dos fracciones.
	 * @param a
	 *Se le pasa por parametro un valor a del tipo Fraccion.
	 * @param b
	 *Se le pasa por parametro un valor b del tipo Fraccion.
	 * @return fraccion obtenida al sumar la fraccion a con la fraccion b.
	 */
	public static Fraccion sumar(Fraccion a, Fraccion b) {
		int num = a.getNumerador() * b.getDenominador() + b.getNumerador() * a.getDenominador();
		int den = a.getDenominador() * b.getDenominador();
		return new Fraccion(num, den);
	}


	/**
	 * Resta de fracciones.
	 * @param b
	 *Se le pasa por parametro un valor b del tipo Fraccion.
	 * @return fraccion obtenida al restarle la fraccion b.
	 */
	public Fraccion restar(Fraccion b) {
		int num = numerador * b.getDenominador() - denominador * b.getNumerador();
		int den = denominador * b.getDenominador();
		return new Fraccion(num, den);
	}

	/**
	 * Multiplicacion de fracciones
	 * @param b
	 *Se le pasa por parametro un valor b del tipo Fraccion.
	 * @return fraccion obtenida al multiplicarla con b.
	 */
	public Fraccion multiplicar(Fraccion b) {
		return new Fraccion(numerador * b.getNumerador(), denominador * b.getDenominador());
	}

	/**
	 * Division de fracciones.
	 * @param b
	 *Se le pasa por parametro un valor b del tipo Fraccion.
	 * @return fraccion obtenida al dividirse por la fraccion b.
	 */
	public Fraccion dividir(Fraccion b) {
		return new Fraccion(numerador * b.getDenominador(), denominador * b.getNumerador());
	}

	/**
	 * Minimo comun multiplo.
	 * @param u
	 * Se le pasa por parametros un valor u que es de tipo entero.
	 * @param v
	 * Se le pasa por parametros un valor v que es de tipo entero.
	 * @return el minimo comun multiplo de u y v.
	 */
	private static int mcd(int u, int v) {
		u = Math.abs(u);
		v = Math.abs(v);
		if (v == 0) {
			return u;
		}
		int r;
		while (v != 0) {
			r = u % v;
			u = v;
			v = r;
		}
		return u;
	}

	/**
	 * Simplificacion de la fraccion.
	 * @return la fraccion simplificada.
	 */
	public Fraccion simplificar() {
		int dividir = mcd(numerador, denominador);
		numerador /= dividir;
		denominador /= dividir;
		return this;
	}
	/**
	 * Metodo compareTo, con el cual podemos comparar dos fracciones, por su solucion
	 * no por numerador y denominador, es decir, 3/2 tiene la misma solucion que 6/4
	 */
	public int compareTo(Object o) {

		Fraccion otro = (Fraccion) o;

		double valorFraccion = (double) numerador / denominador;
		double valorOtro = (double) otro.getNumerador() / otro.getDenominador();

		if (valorFraccion > valorOtro)
			return 1;
		else if (valorFraccion < valorOtro)
			return -1;
		else
			return 0;


}
}
