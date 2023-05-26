package org.mp.sesion07;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

public class BandaTestA {

	@Before
	public void setUp() throws Exception {
	}
	
	@Test
	public void testBandaIntegers() {
		
		Integer [][] a = new Integer[10][10];
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[0].length; j++) {
				a[i][j]=100;
			}			
		}
		
		String string =
				"BandaIntegers: \n" + 
				"100 100 100 100 100 100 100 100 100 100 \n" + 
				"100 100 100 100 100 100 100 100 100 100 \n" + 
				"100 100 100 100 100 100 100 100 100 100 \n" + 
				"100 100 100 100 100 100 100 100 100 100 \n" + 
				"100 100 100 100 100 100 100 100 100 100 \n" + 
				"100 100 100 100 100 100 100 100 100 100 \n" + 
				"100 100 100 100 100 100 100 100 100 100 \n" + 
				"100 100 100 100 100 100 100 100 100 100 \n" + 
				"100 100 100 100 100 100 100 100 100 100 \n" + 
				"100 100 100 100 100 100 100 100 100 100 \n";
		
		Banda<Integer> bandai = new Banda<>("BandaIntegers",a);
		
		assertTrue(bandai.getDatoXY(0, 0)==100);
		assertTrue(bandai.getDatoXY(9, 9)==100);
		
		assertArrayEquals(bandai.getDatos(), a);
		
		assertEquals(bandai.toString(),string);
		
		bandai.setDatoXY(10, 2, 2);
		
		assertTrue(bandai.getDatoXY(2, 2)==10);
		
		a[2][2] = 10;
		
		assertArrayEquals(bandai.getDatos(), a);		
		
	}
	
	@Test
	public void testBandaDoubles() {
		
		Double [][] b = new Double[10][10];
		for (int i = 0; i < b.length; i++) {
			for (int j = 0; j < b[0].length; j++) {
				b[i][j]=100.1;
			}
			
		}
		
		Banda<Double> bandad = new Banda<>("BandaDoubles",b);
		System.out.println(bandad);
		assertTrue(bandad.getDatoXY(0, 0)==100.1);
		assertTrue(bandad.getDatoXY(9, 9)==100.1);
		
		assertArrayEquals(bandad.getDatos(), b);
		
		String string =
				"BandaDoubles: \n" + 
				"100.1 100.1 100.1 100.1 100.1 100.1 100.1 100.1 100.1 100.1 \n" + 
				"100.1 100.1 100.1 100.1 100.1 100.1 100.1 100.1 100.1 100.1 \n" + 
				"100.1 100.1 100.1 100.1 100.1 100.1 100.1 100.1 100.1 100.1 \n" + 
				"100.1 100.1 100.1 100.1 100.1 100.1 100.1 100.1 100.1 100.1 \n" + 
				"100.1 100.1 100.1 100.1 100.1 100.1 100.1 100.1 100.1 100.1 \n" + 
				"100.1 100.1 100.1 100.1 100.1 100.1 100.1 100.1 100.1 100.1 \n" + 
				"100.1 100.1 100.1 100.1 100.1 100.1 100.1 100.1 100.1 100.1 \n" + 
				"100.1 100.1 100.1 100.1 100.1 100.1 100.1 100.1 100.1 100.1 \n" + 
				"100.1 100.1 100.1 100.1 100.1 100.1 100.1 100.1 100.1 100.1 \n" + 
				"100.1 100.1 100.1 100.1 100.1 100.1 100.1 100.1 100.1 100.1 \n" ; 
		
		assertEquals(bandad.toString(),string);
		
		bandad.setDatoXY(10.1, 2, 2);
		
		assertTrue(bandad.getDatoXY(2, 2)==10.1);
		
		b[2][2] = 10.1;
		
		assertArrayEquals(bandad.getDatos(), b);
	
	}
}