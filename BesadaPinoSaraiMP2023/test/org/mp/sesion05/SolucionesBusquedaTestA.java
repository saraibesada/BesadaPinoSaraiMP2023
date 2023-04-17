package org.mp.sesion05;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

public class SolucionesBusquedaTestA {

	@Before
	public void setUp() throws Exception {
	}

	@Test	
    public void testBusquedaExitosa() {
        
        Busqueda busqueda = new Busqueda(100);
        int[] datos = new int[100];
        for (int i = 0; i < datos.length; i++) {
            datos[i]=i;
        }
        busqueda.setDatos(datos);
        busqueda.setNumBuscado(99);
      
        try {
            assertEquals(99, SolucionesBusqueda.busquedaLineal(busqueda));
        } catch (ElementoNoEncontradoException e) {
             e.printStackTrace();
        }
        
        try {
            assertEquals(99, SolucionesBusqueda.busquedaBinariaIter(busqueda));
        } catch (ElementoNoEncontradoException e) {
             e.printStackTrace();
        }
        
        try {
            assertEquals(99, SolucionesBusqueda.busquedaBinariaRec(busqueda));
        } catch (ElementoNoEncontradoException e) {
             e.printStackTrace();
        }
        
        int indice = Arrays.binarySearch(datos, 99);
        assertEquals(99, datos[indice]);
         
    }

	@Test    
    public void testBusquedaSinExito() {
        
        Busqueda busqueda = new Busqueda(100);
        int[] datos = new int[100];
        for (int i = 0; i < datos.length; i++) {
            datos[i]=i*2;
        }
        busqueda.setDatos(datos);
        busqueda.setNumBuscado(3);
    
        ElementoNoEncontradoException excepcion = new ElementoNoEncontradoException("No encontrado");
        
        try {
            assertEquals(3, SolucionesBusqueda.busquedaLineal(busqueda));
        } catch (ElementoNoEncontradoException e) {
             //e.printStackTrace();
            assertEquals(excepcion.getMessage(), e.getMessage());
        }
        
        try {
            assertEquals(3, SolucionesBusqueda.busquedaBinariaIter(busqueda));
        } catch (ElementoNoEncontradoException e) {
             //e.printStackTrace();
            assertEquals(excepcion.getMessage(), e.getMessage());
        }
        
        try {
            assertEquals(3, SolucionesBusqueda.busquedaBinariaRec(busqueda));
        } catch (ElementoNoEncontradoException e) {
             //e.printStackTrace();
            assertEquals(excepcion.getMessage(), e.getMessage());
 
        }
        
        int indice = Arrays.binarySearch(datos, 99);
        assertTrue(indice<0);
    }
    


}
