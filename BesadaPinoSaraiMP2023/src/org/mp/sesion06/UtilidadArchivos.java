package org.mp.sesion06;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * Clase UtilidadArchivos.
 * @author Sarai Besada Pino
 *
 */
public class UtilidadArchivos {

	private ArrayList<File> lista;
	

	/**
	 * Constructor. No recibe parámetros. Inicializa la lista.
	 */
	public UtilidadArchivos() {
		this.lista = new ArrayList<File>();
	}
	
	/**
	 * Copia el archivo origen en el directorio destino especificados por parámetros. 
	 * @param origen Archivo origen.
	 * @param destino Directorio destino.
	 * @exception IOException Excepcion.
	 */
	public static void copiar(File origen, File destino) throws IOException {
		
		try {
			FileInputStream in = new FileInputStream(origen);
			FileOutputStream out = new FileOutputStream(destino);
			
			byte [] buffer = new byte[1024];
			int size;
			
			while((size = in.read(buffer)) > 0) {
				out.write(buffer, 0, size);
			}
			in.close();
			out.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Lista los directorios o archivos que se encuentran en el directorio pasado por parametros.
	 * @param dir Directorio.
	 * @return lista Lista de archicos o directorios.
	 */
	public ArrayList<File> listarDirectoriosArchivos(File dir) {
		lista.clear();
		listarDirectoriosArchivosRec(dir);
		return lista;
	}
	
	/**
	 * Metodo privado que lista los directorios o archivos que se encuentran en el directorio pasado por parametros.
	 * @param dir Directorio.
	 */
	private void listarDirectoriosArchivosRec(File dir) {
		File [] archivos = dir.listFiles();
		
		for(File f : archivos) {
			if(!f.isDirectory())
				lista.add(f);
			else
				listarDirectoriosArchivosRec(f);
		}
	}
	
	/**
	 * Crea un archivo zip a partir de un directorio que recibe por parametros. Tambien recibe 
	 * por parametros el nombre del archivo y el camino de salida.
	 * @param dir Directorio.
	 * @param caminoSalida Camino de Salida.
	 * @param nombreArchivo Nombre del archivo.
	 */
	public void zip(File dir, String caminoSalida, String nombreArchivo) {
		listarDirectoriosArchivosRec(dir);
		byte[] buffer = new byte[1024];
		try {
			String ruta = caminoSalida + File.separator + nombreArchivo;
			ZipOutputStream out = new ZipOutputStream(new FileOutputStream(ruta));
			
			for(File f : lista) {
				FileInputStream in = new FileInputStream(f);
				out.putNextEntry(new ZipEntry(f.getPath()));
				
				int size;
				while((size = in.read(buffer)) > 0) {
					out.write(buffer, 0, size);
				}
				out.closeEntry();
				in.close();
			}
			out.close();
		}catch (Exception e) {}
	}
}
