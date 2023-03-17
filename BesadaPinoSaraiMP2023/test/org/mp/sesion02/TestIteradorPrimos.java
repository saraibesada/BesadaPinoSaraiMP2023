package org.mp.sesion02;

import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.Test;


public class TestIteradorPrimos {
	private Iterator<Integer> iteradorPrimos;

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testPropiedades() {

		iteradorPrimos = new IteradorPrimos(10);
		assertEquals(10, ((IteradorPrimos)iteradorPrimos).getLimite());
		assertEquals(2, ((IteradorPrimos) iteradorPrimos).getActual());

	}



	@Test 
	public void testEsPrimo() {
		assertEquals(true,IteradorPrimos.esPrimo(2));
		assertEquals(true,IteradorPrimos.esPrimo(5));
		assertEquals(false,IteradorPrimos.esPrimo(9));
		assertEquals(false,IteradorPrimos.esPrimo(4));

	}

	@Test
	public void testNext() {

		iteradorPrimos = new IteradorPrimos(10);
		Integer actual = iteradorPrimos.next();
		assertEquals(new Integer(2), actual);
		assertEquals(new Integer(3), iteradorPrimos.next());
		assertEquals(new Integer(5), iteradorPrimos.next());
		assertEquals(new Integer(7), iteradorPrimos.next());
		try {
			assertEquals(new Integer(11), iteradorPrimos.next());
			fail("Debería haber lanzado una excepción");
		} catch (NoSuchElementException e) {
			assertEquals(e.getMessage(), "No se puede acceder a más números primos");
		}
		
	}

	@Test
	public void testHasNext() {
		iteradorPrimos = new IteradorPrimos(10);
		for (int i = 1; i <= 4; i++) {
			assertEquals(true, iteradorPrimos.hasNext());
			iteradorPrimos.next();
		}
		assertEquals(false,iteradorPrimos.hasNext());
	}

	@Test
	public void testRemove() {
		iteradorPrimos = new IteradorPrimos(10);

		try {
			iteradorPrimos.remove();
			fail("Debería haber lanzado una excepción");
		} catch (UnsupportedOperationException e) {
			assertEquals(e.getMessage(), "Método no soportado");

		}

	}

	@Test 
	public void testMostrarPrimos() {
		String cadenaGenerada, cadena;

		iteradorPrimos = new IteradorPrimos(1);
		cadenaGenerada =  ((IteradorPrimos) iteradorPrimos).mostrarPrimos();
		cadena = "";
		assertEquals(cadenaGenerada, cadena);

		iteradorPrimos = new IteradorPrimos(10);
		cadenaGenerada = ((IteradorPrimos) iteradorPrimos).mostrarPrimos();
		cadena = "\t" + 2 + "\t" + 3 + "\t" + 5 + "\t" + 7;
		assertEquals(cadenaGenerada, cadena);


		iteradorPrimos = new IteradorPrimos(17);
		cadenaGenerada = ((IteradorPrimos) iteradorPrimos).mostrarPrimos();
		cadena = "\t" + 2 + "\t" + 3 + "\t" + 5 + "\t" + 7 + "\t" + +11 + "\t" + 13 + "\t" + 17;
		assertEquals(cadenaGenerada, cadena);

		iteradorPrimos = new IteradorPrimos(20);
		cadenaGenerada = ((IteradorPrimos) iteradorPrimos).mostrarPrimos();
		cadena = "\t" + 2 + "\t" + 3 + "\t" + 5 + "\t" + 7 + "\t" + +11 + "\t" + 13 + "\t" + 17 + "\t" + 19;
		assertEquals(cadenaGenerada, cadena);

		iteradorPrimos = new IteradorPrimos(70);
		cadenaGenerada = ((IteradorPrimos) iteradorPrimos).mostrarPrimos();
		cadena = "\t" + 2 + "\t" + 3 + "\t" + 5 + "\t" + 7 + "\t" + 11 + "\t" + 13 + "\t" + 17 + "\t" + 19 + "\t" + 23
				+ "\t" + 29 + "\n" + "\t" + 31 + "\t" + 37 + "\t" + 41 + "\t" + 43 + "\t" + 47 + "\t" + 53 + "\t" + 59
				+ "\t" + 61 + "\t" + 67;
		assertEquals(cadenaGenerada, cadena);

	}

}
