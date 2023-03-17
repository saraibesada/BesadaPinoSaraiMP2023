package org.mp.sesion02;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class TestBusqueda {

	private String [] apellidos = {"Amat","García","Martín"}; // ordenados en orden creciente
	private Integer [] enteros  = {4,70,120,540};
	private Fraccion [] fracciones = { new Fraccion(-1, 5) , new Fraccion(-1, 8), new Fraccion(1,8), new Fraccion(1,5)};
    private Double [] reales = {};
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testArrayVacio() throws ExcepcionArrayVacio {
		try{
			Busqueda.busquedaBinaria(reales, 2.50);
			fail("Debería haber lanzado una excepción");
		}
		catch(ExcepcionArrayVacio e){
			assertEquals(e.getMessage(), "Array vacío");

		}
	}

	@Test
	public void testValoresFueraArray() throws ExcepcionArrayVacio {

		assertEquals(-1, Busqueda.busquedaBinaria(apellidos, "Abad"));
		assertEquals(-1, Busqueda.busquedaBinaria(enteros, 999));
		assertEquals(-1, Busqueda.busquedaBinaria(fracciones, new Fraccion(2,1)));
	}
	@Test 
	public void testBusquedaSinExito() throws ExcepcionArrayVacio {
		assertEquals(-1, Busqueda.busquedaBinaria(apellidos, "Benítez"));
		assertEquals(-1, Busqueda.busquedaBinaria(enteros, 420));
		assertEquals(-1, Busqueda.busquedaBinaria(fracciones, new Fraccion(1,2)));

	}
	@Test
	public void testBusquedaConExito() throws ExcepcionArrayVacio {
		assertEquals(0, Busqueda.busquedaBinaria(apellidos, "Amat"));
		assertEquals(2, Busqueda.busquedaBinaria(enteros, 120));
		assertEquals(3, Busqueda.busquedaBinaria(fracciones, new Fraccion(1,5)));


	}
	@Test
	public void testLimiteArray() throws ExcepcionArrayVacio {
		assertEquals(2, Busqueda.busquedaBinaria(apellidos, "Martín"));
		assertEquals(3, Busqueda.busquedaBinaria(enteros, 540));
		assertEquals(0, Busqueda.busquedaBinaria(fracciones, new Fraccion(-1,5)));
	}

}
