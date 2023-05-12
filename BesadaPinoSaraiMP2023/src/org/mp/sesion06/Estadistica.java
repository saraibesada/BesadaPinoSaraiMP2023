package org.mp.sesion06;

import java.io.IOException;

import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;
/**
 * Clase Estadistica.
 * @author Sarai Besada 
 *
 */
public class Estadistica {

	private ConjuntoDatos cd;
	
	/**
	 * Constructor. Recibe por parametros un conjunto de datos.
	 * @param cd Conjunto de datos.
	 */
	public Estadistica(ConjuntoDatos cd) {
		this.cd = cd;
	}

	/**
	 * Devuelve la media de los datos, de la columna que recibe por parametros.
	 * @param columna Columna.
	 * @return media Devuelve la media. 
	 * @throws IOException Excepcion.
	 */
	public double media(String columna) throws IOException {
		
		DescriptiveStatistics ds = new DescriptiveStatistics(cd.getColumna(columna));
		
		return ds.getMean();
	}
	/**
	 * Devuelve el maximo de los datos, de la columna que recibe por parametros.
	 * @param columna Columna.
	 * @return max Devuelve el maximo.
	 * @throws IOException Excepcion.
	 */
	public double max(String columna) throws IOException {
		
		DescriptiveStatistics ds = new DescriptiveStatistics(this.cd.getColumna(columna));
		
		return ds.getMax();
	}
	/**
	 * Devuelve el minimo de los datos, de la columna que recibe por parametros.
	 * @param columna Columna.
	 * @return min Devuelve el minimo.
	 * @throws IOException Excepcion.
	 */
	public double min(String columna) throws IOException {
		
		DescriptiveStatistics ds = new DescriptiveStatistics(this.cd.getColumna(columna));
		
		return ds.getMin();
	}
	/**
	 * Realiza la suma de los datos, de la columna que recibe por parametros y la devuelve.
	 * @param columna Columna.
	 * @return suma Devuelve la suma.
	 * @throws IOException Excepcion.
	 */
	public double suma(String columna) throws IOException {
		
		DescriptiveStatistics ds = new DescriptiveStatistics(this.cd.getColumna(columna));
		
		return ds.getSum();
	}
}
