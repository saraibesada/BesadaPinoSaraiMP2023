package org.mp.sesion07;

import java.util.ArrayList;
/**
 * Clase Imagen.
 * @author Sarai Besada
 *
 */
public class Imagen {

	private String formatoImagen;
	private String tipoImagen;
	private int lineas;
	private int columnas;
	private ArrayList<Banda<?>> bandas;
	/**
	 * Constructor de la clase Imagen. Recibe por parametros lineas, columnas, formato de la Imagen y tipo Imagen.
	 * @param lineas Lineas.
	 * @param columnas Columnas.
	 * @param formatoImagen Formato de la Imagen.
	 * @param tipoImagen Tipo de la Imagen.
	 */
	public Imagen(int lineas, int columnas, String formatoImagen, String tipoImagen) {
		this.formatoImagen = formatoImagen;
		this.tipoImagen = tipoImagen;
		this.lineas = lineas;
		this.columnas = columnas;
		this.bandas = new ArrayList<Banda<?>>();
	}
	/**
	 * Metodo getDatosPixel, recibe por parametros los indices x e y. Devuelve el array de datos de los pixels.
	 * @param x Indice x.
	 * @param y Indice y.
	 * @return datosPixel Array de datos de Pixel.
	 * @throws XYFueraImagenException Excepcion.
	 */
	public Number[] getDatosPixel(int x, int y) throws XYFueraImagenException {
		if(!XYValida(x, y, x, y)) throw new XYFueraImagenException("XY No valida");
		Number[] datoPixel = new Number[getNumeroBandas()];
		int count = 0;
		//Recorremos la lista de bandas para  obtener el dato que se encuentra en x y.
		for(Banda<?> banda : bandas) {
			datoPixel[count] = banda.getDatoXY(x, y); 
			count++;
		}
		return datoPixel;
	}
	/**
	 * Metodo extraerImagen. Recibe por parametros los indices x1, y1, x2 e y2. Devuelve la imagen.
	 * @param x1 Indice x1.
	 * @param y1 Indice y1.
	 * @param x2 Indice x2.
	 * @param y2 Indice y2.
	 * @return aux Devuelve la Imagen.
	 * @throws XYFueraImagenException Excepcion.
	 */
	public Imagen extraerImagen(int x1, int y1, int x2, int y2) throws XYFueraImagenException {
		//Devuelve una imagen
		if(!XYValida(x1, y1, x2, y2)) throw new XYFueraImagenException("Coordenadas fuera de la imagen");
		int lineas = y2 - y1 + 1;
		int columnas = x2 - x1 + 1;
		Imagen aux = new Imagen(lineas, columnas, formatoImagen, tipoImagen);
		//Este primer bucle se utiliza para recorrer la lista de bandas.
		for(int i = 0; i < getNumeroBandas(); i++) {
			Number [][] datos = new Number[lineas][columnas];
			//Este segundo bucle se utiliza para recorrer y y cargar los datos en la matriz de datos.
			for(int j = y1, m = 0; j <= x2; j++, m++) {
				//Este tercer bucle se utiliza para recorrer x 
				for(int k = x1, n = 0; k <= y2; k++, n++) {
					datos[m][n] = getBanda(i).getDatoXY(j,k);
				}
			}
			aux.anadirBanda(new Banda<>(getBanda(i).getNombreBanda(), datos));			
		}
		
		return aux;
	}
	/**
	 * Metodo añadir banda. Añade la banda que recibe por parametros.
	 * @param banda Banda.
	 */
	public void anadirBanda(Banda<?> banda) {
		this.bandas.add(banda);
	}
	/**
	 * Metodo eliminar banda. Elimina la banda que se le especifica por parametros con el indice i.
	 * @param i Indice i.
	 */
	public void eliminarBanda(int i) {
		this.bandas.remove(i);
	}
	/**
	 * Metodo getFormatoImagen. Devuelve el formato de la Imagen.
	 * @return formatoImagen Devuelve el formato de la Imagen.
	 */
	public String getFormatoImagen() {
		return formatoImagen;
	}
	/**
	 * Metodo setFormatoImagen. Recibe por parametros el formato de la Imagen.
	 * @param formatoImagen El formato de la Imagen.
	 */
	public void setFormatoImagen(String formatoImagen) {
		this.formatoImagen = formatoImagen;
	}
	/**
	 * Metodo getTipoImagen. Devuelve el tipo de la Imagen.
	 * @return tipoImagen Devuelve el tipo de la Imagen.
	 */
	public String getTipoImagen() {
		return tipoImagen;
	}
	/**
	 * Metodo setTipoImagen. Recibe por parametros el tipo de la Imagen.
	 * @param tipoImagen El tipo de la Imagen.
	 */
	public void setTipoImagen(String tipoImagen) {
		this.tipoImagen = tipoImagen;
	}
	/**
	 * Metodo getLineas. Devuelve el numero de lineas.
	 * @return lineas Devuelve el numero de lineas.
	 */
	public int getLineas() {
		return lineas;
	}
	/**
	 * Metodo getColumnas. Devuelve el numero de columnas.
	 * @return columnas Devuelve el numero de columnas.
	 */
	public int getColumnas() {
		return columnas;
	}
	/**
	 * Metodo getBandas. Devuelve las bandas.
	 * @return bandas Devuelve las bandas.
	 */
	public ArrayList<Banda<?>> getBandas() {
		return bandas;
	}
	/**
	 * Metodo setBandas. Recibe por paramtros un array de bandas.
	 * @param bandas Array de bandas.
	 */
	public void setBandas(ArrayList<Banda<?>> bandas) {
		this.bandas = bandas;
	}
	/**
	 * Metodo getBanda. Recibe por parametros el indice i y devuelve la banda que se encuentra en ese indice.
	 * @param i Indice i.
	 * @return banda Devuelve la banda.
	 */
	public Banda<Number> getBanda(int i){
		return (Banda<Number>) this.bandas.get(i);
	}
	/**
	 * Metodo getNumeroBandas. Devuelve el numero de bandas.
	 * @return numeroBandas Devuelve el numero de bandas.
	 */
	public int getNumeroBandas() {
		return this.bandas.size();
	}
	/**
	 * Metodo privado XYValida. Recibe por parametros los indices x1, y1, x2 e y2. Devuelve true si los indices pasados por parametros son correctos
	 * y false si los indices son incorrectos.
	 * @param x1 Indice x1.
	 * @param y1 Indice y1.
	 * @param x2 Indice x2.
	 * @param y2 Indice y2.
	 * @return validez Devuelve true si los indices son correctos y false si los indices son incorrectos.
	 * @throws XYFueraImagenException Excepcion.
	 */
	private boolean XYValida(int x1, int y1, int x2, int y2) {
		if(x1 < 0 || x2 < 0 || y1 < 0 || y2 < 0) return false;
		if(x1 >= columnas || x2 >= columnas || y1 >= lineas || y2 >= lineas) return false;
		return true;
	}
	/**
	 * Metodo toString. Devuelve toda la información de la imagen y sus bandas.
	 */
	public String toString() {		
		return "Tipo Imagen: " + this.tipoImagen + "\nFormato Imagen: " + this.formatoImagen +
				"\nNumero de Bandas: " + getNumeroBandas() + "\nBandas: " + this.bandas.toString() +
				"\nLineas: " + this.lineas + "\nColumnas: " + this.columnas;
	}
	
}
