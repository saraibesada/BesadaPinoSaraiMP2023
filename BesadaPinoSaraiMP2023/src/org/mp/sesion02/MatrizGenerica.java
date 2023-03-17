package org.mp.sesion02;
/**
 *MatrizGenerica. Esta clase contine las operaciones basicas entres matrices.
 * @author Sarai Besada
 *@version sesion02
 *
 */
public abstract class MatrizGenerica<E extends Number> {

	protected abstract E sumar(E o1, E o2);
	protected abstract E multiplicar(E o1, E o2);
	protected abstract E cero();
	
	/**
	 * Metodo que suma dos matrices siempre que tengan el mismo tamaño.
	 * Si no tienen el mismo tamaño manda una excepcion.
	 * @param matriz1 pasamos por parametro la matriz1
	 * @param matriz2 pasamos por parametro la matriz2
	 * @return matrizSuma La matriz resultado de sumar las dos matrices.
	 */
	public E[][] sumarMatrices (E[][] matriz1, E[][] matriz2){

		if(matriz1.length != matriz2.length || matriz1[0].length != matriz2[0].length) {
			throw new RuntimeException("Las matrices no tienen el mismo tamaño");
		}

		E[][] matrizSuma = (E[][]) new Number[matriz1.length][matriz1[0].length];

		for(int i = 0; i < matriz1.length; i++) {
			for(int j = 0; j < matriz1[0].length; j++) {
				matrizSuma[i][j] = sumar(matriz1[i][j], matriz2[i][j]);
			}
		}
		return matrizSuma;
	}
	
	/**
	 * Metodo que multiplica dos matrices siempre que tengan el mismo numero de colunmas y de filas.
	 * Si no tienen el mismo tamaño manda una excepcion.
	 * @param matriz1 Matriz uno.
	 * @param matriz2 Matriz dos.
	 * @return matrizMultiplicar La matriz resultado de multiplicar las dos matrices.
	 */
	public E[][] multiplicarMatrices(E[][] matriz1, E[][] matriz2){
		
		if(matriz1.length != matriz2.length || matriz1[0].length != matriz2[0].length) {
			throw new RuntimeException("No coinciden las columnas de la primera matriz con las filas de la segunda");
		}
		
		E[][] matrizMultiplicar = (E[][]) new Number[matriz1.length][matriz2[0].length];
		for(int i = 0; i < matrizMultiplicar.length; i++) {
			for(int j = 0; j < matrizMultiplicar[0].length; j++) {
				matrizMultiplicar[i][j] = cero();
				for(int k = 0; k < matrizMultiplicar.length; k++) {
					matrizMultiplicar[i][j] = sumar(matrizMultiplicar[i][j], multiplicar(matriz1[i][k], matriz2[k][j]));
				}
			}
		}
		return matrizMultiplicar;
	}

}
