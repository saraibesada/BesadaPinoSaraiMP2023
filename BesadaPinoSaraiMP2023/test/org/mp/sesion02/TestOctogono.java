package org.mp.sesion02;

import static org.junit.Assert.*;

import java.util.GregorianCalendar;

import org.junit.Before;
import org.junit.Test;

public class TestOctogono {

	private Octogono[] octogonos = { new Octogono("azul", true, 8.1), new Octogono("verde", false, 3.0), new Octogono(),
			new Octogono("negro", false, 8.1) };
	private GregorianCalendar fechaHoy = new GregorianCalendar();

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testGetterYSetter() {

		assertEquals("blanco", octogonos[2].getColor());
		assertEquals("azul", octogonos[0].getColor());
		assertFalse(octogonos[2].esRelleno());
		assertTrue(octogonos[0].esRelleno());
		assertEquals(0, octogonos[2].getLado(), 0.01);
		assertEquals(8.10, octogonos[0].getLado(), 0.01);
		assertEquals(octogonos[2].fechaCreado, octogonos[2].getFechaCreado());
		octogonos[0].setColor("amarillo");
		assertEquals("amarillo", octogonos[0].getColor());
		octogonos[0].setRelleno(false);
		assertFalse(octogonos[0].esRelleno());
		octogonos[0].setLado(10.89);
		assertEquals(10.89, octogonos[0].getLado(), 0.01);
	}

	@Test
	public void testToString() {

		assertEquals("Creado el " + fechaHoy + "\ncolor: azul y relleno: true",
				"Creado el " + octogonos[0].getFechaCreado() + "\ncolor: " + octogonos[0].getColor() + " y relleno: "
						+ octogonos[0].esRelleno());

	}

	@Test
	public void testGetPerimetro() {
		assertEquals(64.800, octogonos[0].getPerimetro(), 0.001);
		assertEquals(24.000, octogonos[1].getPerimetro(), 0.001);
		assertEquals(0.000, octogonos[2].getPerimetro(), 0.001);
	}

	@Test
	public void testGetArea() {
		assertEquals(316.793, octogonos[0].getArea(), 0.001);
		assertEquals(43.455, octogonos[1].getArea(), 0.001);
		assertEquals(0.000, octogonos[2].getArea(), 0.001);
	}

	@Test
	public void testCompareTo() {
		assertEquals(-1, octogonos[1].compareTo(octogonos[0]));
		assertEquals(0, octogonos[0].compareTo(octogonos[3]));
		assertEquals(1, octogonos[0].compareTo(octogonos[2]));

	}

	@Test
	public void testClone() {
		Octogono o1 = new Octogono("rojo", true, 7.0);
		Octogono o2 = (Octogono) (o1.clone());
		assertEquals(o1.getColor(), o2.getColor());
		assertEquals(o1.esRelleno(), o2.esRelleno());
		assertEquals(o1.getLado(), o2.getLado(), 0.01);
		assertEquals(o1.getFechaCreado(), o2.getFechaCreado());
	}

	@Test
	public void testComoColorear() {
		
		assertTrue(octogonos[0] instanceof DeColor);
		assertEquals("Colorear los 8 lados de verde", octogonos[1].comoColorear());
		assertEquals("Colorear los 8 lados de blanco", octogonos[2].comoColorear());

	}

}
