package org.mp.sesion05;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mp.sesion05.Ordenacion;
import org.mp.sesion05.NumerosAleatorios;

public class OrdenacionTestA {

	private String mensaje;

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testVectorNormal() {

		Integer[] array = { new Integer(3), new Integer(1), new Integer(2),
				new Integer(8), new Integer(3), new Integer(5), new Integer(2),
				new Integer(8), new Integer(4), new Integer(1), new Integer(7),
				new Integer(10), new Integer(4), new Integer(1),
				new Integer(7), new Integer(10), new Integer(4),
				new Integer(1), new Integer(7), new Integer(10),
				new Integer(4), new Integer(1), new Integer(7),
				new Integer(10), new Integer(4), new Integer(1),
				new Integer(7), new Integer(10), new Integer(4),
				new Integer(1), new Integer(7), new Integer(10),
				new Integer(4), new Integer(1), new Integer(7),
				new Integer(10), new Integer(4), new Integer(1),
				new Integer(7), new Integer(10), new Integer(4),
				new Integer(1), new Integer(7), new Integer(10),
				new Integer(4), new Integer(1), new Integer(7),
				new Integer(10), new Integer(4), new Integer(1),
				new Integer(7), new Integer(10), new Integer(4),
				new Integer(1), new Integer(7), new Integer(10),
				new Integer(3), new Integer(6), new Integer(2), new Integer(8) };

		Integer[] temp = (Integer[]) array.clone();

		Ordenacion.ordenacionPorInsercion(temp);

		mensaje = "Falla: No está ordenado";
		for (int i = 0, j = 1; j < temp.length; i++, j++) {
			assertTrue(mensaje, temp[i].intValue() <= temp[j].intValue());
		}

		temp = (Integer[]) array.clone();

		Ordenacion.mergeSort(temp);

		for (int i = 0, j = 1; j < temp.length; i++, j++) {
			assertTrue(mensaje, temp[i].intValue() <= temp[j].intValue());
		}

		temp = (Integer[]) array.clone();

		Ordenacion.sort(temp);

		for (int i = 0, j = 1; j < temp.length; i++, j++) {
			assertTrue(mensaje, temp[i].intValue() <= temp[j].intValue());
		}

	}

	@Test
	public void testVectorAleatorio() {

		Integer[] array = new Integer[1000];

		NumerosAleatorios aleatorio = new NumerosAleatorios();

		for (int i = 0; i < array.length; i++) {
			array[i] = new Integer(aleatorio.randomInt(-1000, 1000));
		}
		Integer[] temp = (Integer[]) array.clone();

		Ordenacion.ordenacionPorInsercion(temp);

		mensaje = "Falla: No está ordenado";
		for (int i = 0, j = 1; j < temp.length; i++, j++) {
			assertTrue(mensaje, temp[i].intValue() <= temp[j].intValue());
		}

		temp = (Integer[]) array.clone();

		Ordenacion.mergeSort(temp);

		for (int i = 0, j = 1; j < temp.length; i++, j++) {
			assertTrue(mensaje, temp[i].intValue() <= temp[j].intValue());
		}

		temp = (Integer[]) array.clone();

		Ordenacion.sort(temp);

		for (int i = 0, j = 1; j < temp.length; i++, j++) {
			assertTrue(mensaje, temp[i].intValue() <= temp[j].intValue());
		}

	}

}
