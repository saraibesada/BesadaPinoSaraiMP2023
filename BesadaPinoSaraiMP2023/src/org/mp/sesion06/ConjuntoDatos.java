package org.mp.sesion06;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

/**
 * Clase ConjuntoDatos.
 * @author Sarai Besada Pino
 * @version sesion06
 * 
 *
 */
public class ConjuntoDatos {

	private File archivoTexto;
	private String separador;
	private Locale locale;
	private List cabecera;
	private int numeroLineas;
	private int numeroColumnas;
	private double[][] datos;

	/**
	 * Contructor de la clase ConjuntoDatos. Recibe por parametros un archivo o directorio, un separador y un locale. Lanza una 
	 * excepcion si el directorio o archivo no existe.
	 * @param archivoTexto archivo o directorio.
	 * @param separador separador 
	 * @param locale locale
	 * @throws Exception manda una excepcion si el archivo o directorio no existe. 
	 */
	public ConjuntoDatos(File archivoTexto, String separador, Locale locale) throws Exception {

		this.archivoTexto = archivoTexto;
		this.separador = separador;
		this.locale = locale;
		cabecera = cabecera(archivoTexto);
		numeroLineas = numLineas(archivoTexto);
		numeroColumnas = numColumnas(archivoTexto);
		datos = leerDatos(archivoTexto, numeroLineas, numeroColumnas);

	}

	/**
	 * Metodo privado cabecera. Recibe por parametros un archivo o directorio.
	 * @param archivoTexto archivo o directorio 
	 * @return cabecera 
	 * @throws IOException excecion 
	 */
	private List cabecera(File archivoTexto) throws IOException {

		cabecera = new ArrayList<String>();
		try {

			FileInputStream fs = new FileInputStream(archivoTexto);
			DataInputStream entrada = new DataInputStream(fs);
			BufferedReader buffer = new BufferedReader(new InputStreamReader(entrada));
			String temp = buffer.readLine();
			entrada.close();
			String [] temp2 = temp.split(";");
			for(int i = 0; i < temp2.length; i++) {
				cabecera.add(temp2[i]);
			}
		}catch(Exception e) {
			e.getMessage();
		}
		return cabecera;

	}

	/**
	 * Metodo privado numLineas. Recibe por parametros un archivo o directorio. 
	 * @param archivo archivo o directorio
	 * @return numLineas	numero de lineas.
	 * @throws IOException lanza una excepcion.
	 */
	private int  numLineas(File archivo) throws IOException {
		try {
			int count;
			FileInputStream fstream = new FileInputStream(archivoTexto);
			DataInputStream entrada = new DataInputStream(fstream);
			BufferedReader buffer = new BufferedReader(new InputStreamReader(entrada));
			String[] temp = buffer.readLine().split(";");
			char c = temp[0].charAt(0);
			if(Character.isLetter(c)) {
				count = -1;
			}else {
				count = 0;
			}
			fstream.close();
			fstream = new FileInputStream(archivoTexto);
			entrada = new DataInputStream(fstream);
			buffer = new BufferedReader(new InputStreamReader(entrada));

			while(buffer.readLine() != null) {
				count++;
			}
			buffer.close();
			return count;
		}catch(Exception e) {
			e.getMessage();
		}
		return numeroLineas;
	}
	/**
	 * Metodo privado que devuelve el numero de columnas. Recibe por parametros un archivo o directorio.
	 * @param archivoTexto archivo o directorio
	 * @return numColumnas numero de columnas.
	 * @throws IOException lanza una excepcion.
	 */
	private int numColumnas(File archivoTexto) throws IOException{
		FileReader fr = new FileReader(archivoTexto);
		BufferedReader br = new BufferedReader(fr);

		String cadena;
		int numColumnas = 0;
		cadena = br.readLine();

		Scanner scanner = new Scanner(cadena);
		scanner.useDelimiter(";");


		while(scanner.hasNext()) {
			scanner.next();
			numColumnas+=1;
		}
		br.close();
		return  numColumnas;
	}

	/**
	 * Metodo privado que crea un array bidimensional a partir de un archivo y devuelve el array bidimensional.
	 * Recibe por parametros un arcvhivo o directorio, el numero de filas y el numero de columnas.
	 * @param archivoTexto archivo o directorio
	 * @param filas Filas
	 * @param columnas Columnas
	 * @return datos Array bidimensional.
	 */
	private double[][] leerDatos(File archivoTexto, int filas, int columnas){
		datos = new double[filas][columnas];
		int count;
		try {
			FileInputStream fstream = new FileInputStream(archivoTexto);
			DataInputStream entrada = new DataInputStream(fstream);
			BufferedReader buffer = new BufferedReader(new InputStreamReader(entrada));
			String [] temp = buffer.readLine().split(";");
			char c = temp[0].charAt(0);
			if(Character.isLetter(c)) {
				count = -1;
			}else {
				count = 0;
			}
			fstream.close();
			fstream = new FileInputStream(archivoTexto);
			entrada = new DataInputStream(fstream);
			buffer = new BufferedReader(new InputStreamReader(entrada));
			String linea;
			double temp2;

			while((linea = buffer.readLine()) !=null) {
				if(count >=0) {
					String [] elementos = linea.split(";");
					for(int i = 0; i < elementos.length; i++) {
						try {
							temp2 = Double.parseDouble(elementos[i]);
							datos[count][i] = temp2;
						}catch(Exception e) {
							datos[count][i] = 0;
						}
					}
				}count++;
			}entrada.close();
		}catch (Exception e) {
			e.getMessage();
		}
		return datos;
	}

	/**
	 * Getter. Devuelve el array de elementos de la columna especificada por parametros.
	 * @param columna Columna.
	 * @return array Array de elementos en esa columna.
	 */
	public double[] getColumna(int columna) {
		double [] array = new double [numeroColumnas];

		for(int i = 0; i < array.length; i++) {
			array[i] = datos[i][columna];
		}
		return array;
	}

	/**
	 * Getter. Devuelve el array de elementos de la columna especificada por parametros.
	 * @param columna Columna.
	 * @return array Array de elementos en esa columna.
	 * @throws IOException Excepcion.
	 */
	public double[] getColumna(String columna) throws IOException {

		int columnaString = -1;
		String aux;
		Iterator<String> iterador = cabecera.iterator();
		int pos = 0;
		while(true) {
			aux = iterador.next();
			if(aux.equals(columna)) {
				columnaString = pos;
				break;
			}pos++;
		}
		double [] array = new double [numeroLineas];
		for(int i = 0; i < array.length; i++) {
			array [i] = datos[i][columnaString];
		}

		return array;
	}

	/**
	 * Getter. Devuelve el archivo o directorio.
	 * @return archivoTexto Archivo o directorio.
	 */
	public File getArchivoTexto() {
		return archivoTexto;
	}

	/**
	 * Getter. Devuelve la cabecera.
	 * @return cabecera Cabecera.
	 */
	public List getCabecera() {
		return cabecera;
	}

	/**
	 * Getter. Devuelve el array bidimensional datos.
	 * @return datos Array bidimensional.
	 */
	public double[][] getDatos() {
		return datos;
	}

	/**
	 * Getter. Devuelve el locale.
	 * @return locale Locale.
	 */
	public Locale getLocale() {
		return locale;
	}

	/**
	 * Getter. Devuelve el separador.
	 * @return separador Separador
	 */
	public Object getSeparador() {
		return separador;
	}

	/**
	 * Getter. Devuelve el numero de lineas.
	 * @return numeroLineas Numero Lineas.
	 */
	public int getNumeroLineas() {
		return numeroLineas;
	}

	/**
	 * Getter. Devuelve el numero de columnas.
	 * @return numeroColumnas Numero Columnas.
	 */
	public int getNumeroColumnas() {
		return numeroColumnas;
	}

	/**
	 * Exporta un archivo con datos. Recibe por parametros la cabecera, un archivo o directorio y el separador.
	 * @param cabecera Cabecera.
	 * @param archivoTexto Archivo o directorio.
	 * @param separador Separador.
	 */
	public void exportar(String[] cabecera, String archivoTexto, String separador) {

		int nColumnas = cabecera.length;
		int count = 0;
		int []iColumnas = new int[nColumnas];
		String aux = "";

		for(int i = 0; i < this.cabecera.size(); i++) {
			if(this.cabecera.get(i).equals(cabecera[count])) {
				iColumnas[count] = i;
				count++;
				if(count == nColumnas) {
					break;
				}
			}
		}try {
			//FileWriter fw = new FileWriter(archivoTexto);
			//BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter pw = new PrintWriter(archivoTexto);

			aux = "";
			for(int i = 0; i < cabecera.length; i++) {
				if(i == cabecera.length-1) {
					aux += cabecera[i];
				}else {
					aux += cabecera[i] + separador;
				}
			}pw.println(aux);
			count = 0;
			aux = "";
			for(int linea = 0; linea < datos[0].length; linea++) {
				for(int columna = 0; columna < nColumnas; columna++) {
					if(columna == nColumnas - 1) {
						aux += datos[linea][iColumnas[count]];
						count = 0;
					}else {
						aux += datos[linea][iColumnas[count]] + separador;
						count++;
					}
				}pw.println(aux);
				aux = "";

			}pw.close();
		}catch(IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Crea y exporta un nuevo conjunto de datos. Recibe por parametros la cabecera, un archivo o directorio, el separador y el locale.
	 * @param cabecera Cabecera.
	 * @param archivoTexto Archivo o directorio.
	 * @param separador Separador.
	 * @param locale Locale.
	 * @return ConjuntoDatos Nuevo conjunto de datos.
	 * @throws Exception Excepcion.
	 */
	public ConjuntoDatos conjuntoDatos(String[] cabecera, String archivoTexto, String separador, Locale locale) throws Exception{
		exportar(cabecera, archivoTexto, separador);
		return new ConjuntoDatos(new File(archivoTexto), separador, locale);
	}


















}
