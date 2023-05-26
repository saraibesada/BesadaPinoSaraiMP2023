package org.mp.sesion07;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
/**
 * Clase ImagenDAO
 * @author Sarai Besada
 *
 */
public class ImagenDAO {
	/**
	 * Metodo escribirArchivo. Recibe por paramtros el nombre del archivo y la imagen. 
	 * Este metodo escribe en el archivo pasado por parametros. 
	 * @param nombreArchivo Nombre del archivo.
	 * @param imagen Imagen.
	 * @throws IOException Excepcion.
	 */
	public static void escribirArchivo(String nombreArchivo, Imagen imagen) throws IOException{

		File file = new File(nombreArchivo);
		PrintWriter pw = new PrintWriter(file);
		String nombre = file.getName();
		nombre = nombre.substring(0, nombre.indexOf("."));
		pw.println(nombre + ".dat");
		pw.println(imagen.getTipoImagen());
		pw.println(imagen.getFormatoImagen());
		pw.println(imagen.getNumeroBandas());

		String bandas = "[";

		for(int i = 0; i < imagen.getNumeroBandas(); i++) {
			if(i < imagen.getNumeroBandas()-1)
				bandas += imagen.getBandas().get(i).getNombreBanda() + ";";
			else
				bandas += imagen.getBandas().get(i).getNombreBanda() + "]";
		}
		pw.println(bandas);

		pw.println(imagen.getLineas());
		pw.println(imagen.getColumnas());
		pw.close();

		String nombreNuevo = file.getParent() + File.separator + nombre + ".dat";
		if(imagen.getFormatoImagen().equals("BSQ")) escribirBSQ(nombreNuevo, imagen);
	}
	/**
	 * Metodo privado escribirBSQ. Recibe por parametros el nombre del archivo y la imagen. 
	 * Este metodo escribe la parte BSQ.
	 * @param nombreArchivo Nombre del archivo.
	 * @param imagen Imagen.
	 * @throws IOException Excepcion.
	 */
	private static void escribirBSQ(String nombreArchivo, Imagen imagen) throws IOException{
		File file = new File(nombreArchivo);
		FileOutputStream fos = new FileOutputStream(file);
		DataOutputStream dos = new DataOutputStream(fos);

		int lineas = imagen.getLineas();
		int columnas = imagen.getColumnas();

		for(int i = 0; i < imagen.getNumeroBandas(); i++) {
			for(int j = 0; j < lineas; j++) {
				for(int k = 0; k < columnas; k++) {
					if(imagen.getTipoImagen().equals("Integer")) {
						int dato = (int) imagen.getBanda(i).getDatoXY(k, j);
						dos.writeInt(dato);
					}
					else if(imagen.getTipoImagen().equals("Double")) {
						double dato = (double) imagen.getBanda(i).getDatoXY(k, j);
						dos.writeDouble(dato);
					}
				}
			}
		}dos.close();

	}
	/**
	 * Metodo leerArchivo. Recibe por paramtros el nombre del archivo.
	 * Este metodo lee la imagen a partir del archivo pasado por paramtros.
	 * @param nombreArchivo Nombre del archivo.
	 * @return imagen Devuelve la imagen.
	 * @throws IOException Excepcion.
	 */
	public static Imagen leerArchivo(String nombreArchivo) throws IOException {
		File file = new File(nombreArchivo);
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);

		Imagen imagen;

		String archivoImagen = br.readLine();
		String tipoImagen = br.readLine();
		String formatoImagen = br.readLine();
		int numeroBandas = Integer.parseInt(br.readLine());
		ArrayList<Banda<?>> bandas = new ArrayList<Banda<?>>();

		String bandasString = br.readLine();
		bandasString = bandasString.substring(1, bandasString.length()-1);
		String [] arrayBandas = bandasString.split(";");

		int lineas = Integer.parseInt(br.readLine());
		int columnas = Integer.parseInt(br.readLine());

		for(int i = 0; i < arrayBandas.length; i++) {
			bandas.add(new Banda<>(arrayBandas[i], lineas, columnas));
		}

		imagen = new Imagen(lineas, columnas, formatoImagen, tipoImagen);

		archivoImagen = System.getProperty("user.dir") + File.separator + "src" + File.separator + 
				"org" + File.separator + "mp" + File.separator + "sesion07" + File.separator + archivoImagen;

		imagen = leerBSQ(archivoImagen, imagen, arrayBandas, tipoImagen);

		br.close();
		return imagen;			
	}
	/**
	 * Metodo privado leerBSQ. Recibe por parametros el nombre del archivo, la imagen, el numero de bandas y el tipo de imagen.
	 * Este metodo lee la parte BSQ.
	 * @param nombreArchivo Nombre del archivo.
	 * @param imagen Imagen.
	 * @param nbandas Numero de bandas.
	 * @param tipoImagen Tipo de Imagen.
	 * @return imagen Devuelve la imagen.
	 * @throws IOException Excepcion.
	 */
	private static Imagen leerBSQ(String nombreArchivo, Imagen imagen, String[] nBandas, String tipoImagen) throws IOException{

		File file = new File(nombreArchivo);
		FileInputStream fi = new FileInputStream(file);
		DataInputStream dis = new DataInputStream(fi);

		int lineas = imagen.getLineas();
		int columnas = imagen.getColumnas();

		for(int i = 0; i < nBandas.length; i++) {
			Number[][] datos = new Number[lineas][columnas];
			for(int j = 0; j < lineas; j++) {
				for(int k = 0; k < columnas; k++) {
					if(tipoImagen.equals("Integer")) datos[j][k] = dis.readInt();
					if(tipoImagen.equals("Double")) datos[j][k] = dis.readDouble();
				}
			}
			Banda<?> banda = new Banda<>(nBandas[i], datos);
			imagen.anadirBanda(banda);
		}dis.close();
		return imagen;
	}



}
