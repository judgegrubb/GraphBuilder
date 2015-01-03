package cs1410;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;


import org.junit.Test;

public class GrapherTester {
	
	@Test
	public void testSummation() {
		Integer[] list = {1, 2, 3};
		assertEquals(6, Grapher.summation(new ArrayList<Integer>(Arrays.asList(list))));
		Integer[] list1 = {5, 7, 4, 2};
		assertEquals(18, Grapher.summation(new ArrayList<Integer>(Arrays.asList(list1))));
		Integer[] list2 = {20, 25, 1, 6, 2, 1};
		assertEquals(55, Grapher.summation(new ArrayList<Integer>(Arrays.asList(list2))));
	}
	
	@Test
	public void testAverage() {
		Integer[] list = {1, 2, 3};
		assertEquals(2, Grapher.average(new ArrayList<Integer>(Arrays.asList(list))));
		Integer[] list1 = {5, 7, 4, 2};
		assertEquals(4, Grapher.average(new ArrayList<Integer>(Arrays.asList(list1))));
		Integer[] list2 = {20, 25, 1, 6, 2, 1};
		assertEquals(9, Grapher.average(new ArrayList<Integer>(Arrays.asList(list2))));
	}
	
	@Test
	public void testMaximum() {
		Integer[] list = {1, 2, 3};
		assertEquals(3, Grapher.maximum(new ArrayList<Integer>(Arrays.asList(list))));
		Integer[] list1 = {5, 7, 4, 2};
		assertEquals(7, Grapher.maximum(new ArrayList<Integer>(Arrays.asList(list1))));
		Integer[] list2 = {20, 25, 1, 6, 2, 1};
		assertEquals(25, Grapher.maximum(new ArrayList<Integer>(Arrays.asList(list2))));
	}
	
	@Test
	public void testWidth() {
		Integer[] list = {1, 2, 3};
		assertEquals(60, Grapher.width(new ArrayList<Integer>(Arrays.asList(list)), 0));
		assertEquals(120, Grapher.width(new ArrayList<Integer>(Arrays.asList(list)), 1));
		assertEquals(180, Grapher.width(new ArrayList<Integer>(Arrays.asList(list)), 2));
		Integer[] list1 = {5, 7, 4, 2};
		assertEquals(128, Grapher.width(new ArrayList<Integer>(Arrays.asList(list1)), 0));
		assertEquals(180, Grapher.width(new ArrayList<Integer>(Arrays.asList(list1)), 1));
		assertEquals(102, Grapher.width(new ArrayList<Integer>(Arrays.asList(list1)), 2));
		assertEquals(51, Grapher.width(new ArrayList<Integer>(Arrays.asList(list1)), 3));
		Integer[] list2 = {20, 25, 1, 6, 2, 1};
		assertEquals(144, Grapher.width(new ArrayList<Integer>(Arrays.asList(list2)), 0));
		assertEquals(180, Grapher.width(new ArrayList<Integer>(Arrays.asList(list2)), 1));
		assertEquals(7, Grapher.width(new ArrayList<Integer>(Arrays.asList(list2)), 2));
		assertEquals(43, Grapher.width(new ArrayList<Integer>(Arrays.asList(list2)), 3));
		assertEquals(14, Grapher.width(new ArrayList<Integer>(Arrays.asList(list2)), 4));
		assertEquals(7, Grapher.width(new ArrayList<Integer>(Arrays.asList(list2)), 5));
	}
	
	@Test
	public void testAngle() {
		Integer[] list = {1, 2, 3};
		assertEquals(60, Grapher.angle(new ArrayList<Integer>(Arrays.asList(list)), 0));
		assertEquals(120, Grapher.angle(new ArrayList<Integer>(Arrays.asList(list)), 1));
		assertEquals(180, Grapher.angle(new ArrayList<Integer>(Arrays.asList(list)), 2));
		Integer[] list1 = {5, 7, 4, 2};
		assertEquals(100, Grapher.angle(new ArrayList<Integer>(Arrays.asList(list1)), 0));
		assertEquals(140, Grapher.angle(new ArrayList<Integer>(Arrays.asList(list1)), 1));
		assertEquals(80, Grapher.angle(new ArrayList<Integer>(Arrays.asList(list1)), 2));
		assertEquals(40, Grapher.angle(new ArrayList<Integer>(Arrays.asList(list1)), 3));
		Integer[] list2 = {20, 25, 1, 6, 2, 1};
		assertEquals(130, Grapher.angle(new ArrayList<Integer>(Arrays.asList(list2)), 0));
		assertEquals(163, Grapher.angle(new ArrayList<Integer>(Arrays.asList(list2)), 1));
		assertEquals(6, Grapher.angle(new ArrayList<Integer>(Arrays.asList(list2)), 2));
		assertEquals(39, Grapher.angle(new ArrayList<Integer>(Arrays.asList(list2)), 3));
		assertEquals(13, Grapher.angle(new ArrayList<Integer>(Arrays.asList(list2)), 4));
		assertEquals(6, Grapher.angle(new ArrayList<Integer>(Arrays.asList(list2)), 5));
	}
	
	@Test
	public void testCategorizer() {
		
		// test to make sure addition works
		String[] column1 = { "Utah", "Nevada", "California", "Oregon", "Utah", "California", "Nevada", "Nevada", "Oregon", "California" };
		Integer[] column2 = { 5, 6, 12, 8, 9, 10, 4, 4, 17, 6};
		String[] categories = { "Utah", "Nevada", "California" };
		Integer[] added = { 14, 14, 28};
		assertEquals((new ArrayList<Integer>(Arrays.asList(added))), 
				Grapher.categorizer(new ArrayList<String>(Arrays.asList(column1)), 
						new ArrayList<Integer>(Arrays.asList(column2)), 
						new ArrayList<String>(Arrays.asList(categories)), 
						0));
		
		String[] categories1 = { "Utah", "Nevada", "California", "Oregon" };
		Integer[] added1 = { 14, 14, 28, 25};
		assertEquals((new ArrayList<Integer>(Arrays.asList(added1))), 
				Grapher.categorizer(new ArrayList<String>(Arrays.asList(column1)), 
						new ArrayList<Integer>(Arrays.asList(column2)), 
						new ArrayList<String>(Arrays.asList(categories1)), 
						0));
		
		// test to make sure averaging works
		Integer[] averaged = { 7, 4, 9};
		assertEquals((new ArrayList<Integer>(Arrays.asList(averaged))), 
				Grapher.categorizer(new ArrayList<String>(Arrays.asList(column1)), 
						new ArrayList<Integer>(Arrays.asList(column2)), 
						new ArrayList<String>(Arrays.asList(categories)), 
						1));
		
		// test to make sure finding maximum works
		Integer[] maximums = { 9, 6, 12};
		assertEquals((new ArrayList<Integer>(Arrays.asList(maximums))), 
				Grapher.categorizer(new ArrayList<String>(Arrays.asList(column1)), 
						new ArrayList<Integer>(Arrays.asList(column2)), 
						new ArrayList<String>(Arrays.asList(categories)), 
						2));
	}
	
	@Test
	public void testCategorizerException() {
		// test to make sure an IllegalArgumentException is thrown
		// if a category has no numbers attached
		String[] column1 = {"Nevada", "California", "Oregon","California", "Nevada", "Nevada", "Oregon", "California" };
		Integer[] column2 = {6, 12, 8, 10, 4, 4, 17, 6};
		String[] categories = { "Utah", "Nevada", "California" };
		try {
			Grapher.categorizer(new ArrayList<String>(Arrays.asList(column1)), 
					new ArrayList<Integer>(Arrays.asList(column2)), 
					new ArrayList<String>(Arrays.asList(categories)), 
					0);
			fail("No exception was thrown");
		} catch (IllegalArgumentException e) {
		}
	}
	
}
