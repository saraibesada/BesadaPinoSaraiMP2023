package org.mp.sesion02;

import static org.junit.Assert.*;


import org.junit.Test;

public class TestMatrizFraccion {
	
		
	@Test
	public void testSumar() {
		Fraccion f1 = new Fraccion(1,2);
		Fraccion f2 = new Fraccion(1,3);
		MatrizFraccion m = new MatrizFraccion();
		assertEquals(new Fraccion(5,6), m.sumar(f1, f2));

	}

	@Test
	public void testMultiplicar() {
		Fraccion f1 = new Fraccion(1,2);
		Fraccion f2 = new Fraccion(1,3);
		MatrizFraccion m = new MatrizFraccion();
		assertEquals(new Fraccion(1,6), m.multiplicar(f1, f2));


	}

	@Test
	public void testCero() {
		
		MatrizFraccion m = new MatrizFraccion();
		assertEquals(new Fraccion(0,1), m.cero());
	}

	@Test
	public void testValue() {
		Fraccion[][] m1 = new Fraccion[3][3];
		for (int i = 0; i < m1.length; i++)
			for (int j = 0; j < m1[0].length; j++) {
				m1[i][j] = new Fraccion(i + 2, j + 3);

			}
		
		assertEquals(1, m1[2][0].intValue());
		assertEquals(1, m1[2][0].longValue());
		assertEquals(1.333334, m1[2][0].floatValue(), 0.0001);
		assertEquals(1.3333333333333333, m1[2][0].doubleValue(), 0.00000000001);

	}

	@Test
	public void testSumaProductoMatrices() {

		Fraccion[][] m1 = new Fraccion[3][3];
		Fraccion[][] m2 = new Fraccion[3][3];
		for (int i = 0; i < m1.length; i++) {
			for (int j = 0; j < m1[0].length; j++) {
				m1[i][j] = new Fraccion(i + 2, j + 3);
				m2[i][j] = new Fraccion(i + 3, j + 4);
			}
		}
		
		Fraccion[][] suma = { { new Fraccion(17,12),new Fraccion(22,20),new Fraccion(27,30)},{ new Fraccion(24,12),new Fraccion(31,20),new Fraccion(38,30)} , { new Fraccion(31,12),new Fraccion(40,20),new Fraccion(49,30)} };
		Fraccion[][] producto = { { new Fraccion(5760,3840),new Fraccion(9000,7500),new Fraccion(12960,12960)},{ new Fraccion(8640,3840),new Fraccion(13500,7500),new Fraccion(19440,12960)} , { new Fraccion(11520,3840),new Fraccion(18000,7500),new Fraccion(25920,12960)} };

		MatrizFraccion matrizFraccion = new MatrizFraccion();

		assertEquals(suma, matrizFraccion.sumarMatrices(m1, m2));
		assertEquals(producto, matrizFraccion.multiplicarMatrices(m1, m2));

	}

	@Test
	public void testSumaProductoMatricesConExcepcion() {

		Fraccion[][] m3 = new Fraccion[3][3];
		Fraccion[][] m4 = new Fraccion[2][3];
		for (int i = 0; i < m3.length; i++) {
			for (int j = 0; j < m3[0].length; j++) {
				m3[i][j] = new Fraccion(i + 2, j + 3);

			}
		}
		for (int i = 0; i < m4.length; i++) {
			for (int j = 0; j < m4[0].length; j++) {
				m4[i][j] = new Fraccion(i + 2, j + 3);

			}
		}
		
		try {
			MatrizFraccion matrizFraccion = new MatrizFraccion();

			matrizFraccion.sumarMatrices(m3, m4);

			fail("Debería haber lanzado una excepción");
		} catch (RuntimeException e) {
			assertEquals(e.getMessage(), "Las matrices no tienen el mismo tamaño");

		}
		try {
			MatrizFraccion matrizFraccion = new MatrizFraccion();
			matrizFraccion.multiplicarMatrices(m3, m4);
			fail("Debería haber lanzado una excepción");
		} catch (RuntimeException e) {
			assertEquals(e.getMessage(), "No coinciden las columnas de la primera matriz con las filas de la segunda");

		}
	}
}
