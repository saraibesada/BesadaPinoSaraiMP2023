package org.mp.sesion05;

import java.util.LinkedList;
import java.util.List;


/**
 * Clase Acciones.
 * @author Sarai Besada Pino.
 *
 */
public class Acciones {

	private List<Accion> acciones;
	
	public Acciones() {
		this.acciones = new LinkedList<Accion>();
	}
	
	public void add(Accion accion) {
		this.acciones.add(accion);
	}
	
	public List<Accion> getAcciones() {
		return this.acciones;
	}
}
