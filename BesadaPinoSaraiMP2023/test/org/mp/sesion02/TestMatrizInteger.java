package org.mp.sesion02;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestMatrizInteger {
	
	
	
	@Test
	public void testSumar() {
		Integer i1 = new Integer(25);
		Integer i2 = new Integer(20);
		MatrizInteger m = new MatrizInteger();
		assertEquals(new Integer(45), m.sumar(i1, i2));

	}

	@Test
	public void testMultiplicar() {
		Integer i1 = new Integer(25);
		Integer i2 = new Integer(20);
		MatrizInteger m = new MatrizInteger();
		assertEquals(new Integer(500), m.multiplicar(i1, i2));

	}

	@Test
	public void testCero() {
		MatrizInteger m = new MatrizInteger();
		assertEquals(new Integer(0), m.cero());
	}

	@Test
	public void testValue() {
		Integer[][] m1 = { { 1, 2, 3 }, { 4, 5, 6 }, { 1, 1, 1 } };

		assertEquals(4, m1[1][0].intValue());
		assertEquals(4, m1[1][0].longValue());
		assertEquals(4.0, m1[1][0].floatValue(), 0.1);
		assertEquals(4.0, m1[1][0].doubleValue(), 0.1);

	}

	@Test
	public void testSumaProductoMatrices() {
		Integer[][] m1 = { { 1, 2, 3 }, { 4, 5, 6 }, { 1, 1, 1 } };
		Integer[][] m2 = { { 1, 1, 1 }, { 2, 2, 2 }, { 0, 0, 0 } };

		Integer[][] suma = { { 2, 3, 4 }, { 6, 7, 8 }, { 1, 1, 1 } };
		Integer[][] producto = { { 5, 5, 5 }, { 14, 14, 14 }, { 3, 3, 3 } };

		MatrizInteger matrizInteger = new MatrizInteger();

		assertEquals(suma, matrizInteger.sumarMatrices(m1, m2));
		assertEquals(producto, matrizInteger.multiplicarMatrices(m1, m2));

	}

	@Test
	public void testSumaProductoMatricesConExcepcion() {
		Integer[][] m3 = { { 1, 1, 1 }, { 2, 2, 2 }, { 0, 0, 0 } };
		Integer[][] m4 = { { 4, 5, 6 }, { 1, 1, 1 } };
		
		try {
			MatrizInteger matrizInteger = new MatrizInteger();

			matrizInteger.sumarMatrices(m3, m4);

			fail("Debería haber lanzado una excepción");
		} catch (RuntimeException e) {
			assertEquals(e.getMessage(), "Las matrices no tienen el mismo tamaño");

		}
		try {
			MatrizInteger matrizInteger = new MatrizInteger();
			matrizInteger.multiplicarMatrices(m3, m4);
			fail("Debería haber lanzado una excepción");
		} catch (RuntimeException e) {
			assertEquals(e.getMessage(), "No coinciden las columnas de la primera matriz con las filas de la segunda");

		}
	}
}
