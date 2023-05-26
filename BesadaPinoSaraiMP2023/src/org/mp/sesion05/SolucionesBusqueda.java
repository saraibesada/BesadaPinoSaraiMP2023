package org.mp.sesion05;

/**
 * Clase SolucionesBusqueda. 
 * @author Sarai Besada
 *	Esta calse implenta tres metodos de busqueda: lineal, binaria recursiva y binaria Iterativa.
 */

public class SolucionesBusqueda {
	
	/**
	 * La busqueda lineal implementa un bucle for que va iterando cada valor del array datos hasta encontrar el 
	 * numero buscado o hasta que itere todos los valores que contiene el array. Recibe por parametros un objeto de la clase
	 * Busqueda.
	 * @param busqueda 
	 * 	Objeto de la clase Busqueda.
	 * @return buscado 
	 * 	Devuelve el numero buscado.
	 * @throws ElementoNoEncontradoException
	 * 	Excepcion para elementos no encontrados.
	 */
	public static int  busquedaLineal  (Busqueda busqueda) throws ElementoNoEncontradoException{
		
		int buscado = busqueda.getNumBuscado();
		boolean encontrado = false;
		int [] datos = busqueda.getDatos();
		for(int i = 0; i < datos.length; i++) {
			if(buscado == datos[i]) {
				encontrado = true;
				break;
			}
		} 
		if(!encontrado)
			throw new ElementoNoEncontradoException("No encontrado");
		return buscado;
	}
	
	/**
	 * La busqueda Binaria recursiva resuelve el problema en problemas menores, aplica la 
	 * tecnica recursiva divide y venceras. Este metodo implementa el metodo privado 
	 * busquedaBinariaRec.
	 * @param busqueda
	 * 	Objeto de la clase Busqueda.
	 * @return buscado
	 * 	Devuelve el numero buscado en el array.
	 * @throws ElementoNoEncontradoException
	 * 	Excepcion para elementos no encontrados.
	 */
	public static int busquedaBinariaRec (Busqueda busqueda) throws ElementoNoEncontradoException{
		boolean encontrado = false;
		int inicio = 0;
		int [] datos = busqueda.getDatos();
		int fin = datos.length-1;
		int buscado = busqueda.getNumBuscado();
		busquedaBinariaRec(datos, buscado, inicio, fin);
		if(encontrado == false)
			throw new ElementoNoEncontradoException("No encontrado");
		return buscado;
	}
	
	/**
	 * Este metodo privado se encarga de realizar la busqueda binaria recursiva con los datos que recibe por parametros.
	 * @param datos
	 * 	Array de datos.
	 * @param buscado
	 * 	Numero que buscamos.
	 * @param inicio
	 * 	Posicion de inicio de la busqueda.
	 * @param fin
	 * 	Posicion de fin de la busqueda.
	 * @return numero buscado.
	 */
	private static int busquedaBinariaRec(int [] datos, int buscado, int inicio, int fin) {
		
		int posicionMedia = (inicio+fin)/2;
		int valorMedio = datos[posicionMedia];
		
		if(inicio > fin) return -1;
		else if(valorMedio == buscado) return valorMedio;
		else if(valorMedio < buscado)
			return busquedaBinariaRec(datos, buscado, posicionMedia+1, fin);
		else
			return busquedaBinariaRec(datos, buscado, inicio, posicionMedia-1);
	}
	
	/**
	 * Busqueda binaria iterativa.
	 * @param busqueda
	 * 	Objeto de la clase Busqueda.
	 * @return numero Devuelve el numero buscado.	
	 * @throws ElementoNoEncontradoException Excepcion.
	 */
	public static int busquedaBinariaIter (Busqueda busqueda) throws ElementoNoEncontradoException{
		
		int clave = busqueda.getNumBuscado();
		int [] datos =  busqueda.getDatos();
		int primero = 0;
		int ultimo = busqueda.getNumElementos()-1;
		int central;
		if(busqueda.getNumElementos() == 0) throw new ElementoNoEncontradoException("Array vacio");
		else if ((clave < (datos[primero])) || (clave > (datos[busqueda.getNumElementos()-1])))
			throw new ElementoNoEncontradoException("No encontrado");
		else {
			while(ultimo >= primero) {
				central = (primero + ultimo)/2;
				if(clave < (datos[central]))
					ultimo = central -1;
				else if(clave > (datos[central]))
					primero = central + 1;
				else 
					return central;
			}throw new ElementoNoEncontradoException("No encontrado");
		}
	}

}
