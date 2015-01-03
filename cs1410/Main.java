package cs1410;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;
import graphics.GraphWindow;

public class Main {
	/**
	 * Area to test different data and exceptions
	 * My personal favorite is test8() just because
	 * football. But you can make your own well-
	 * educated decisions.
	 */
	public static void main (String[] args) {
		test8();
	}
	
	/**
	 * Takes the sample data and turns it into a test
	 * draws with a pie chart
	 */
	
	public static void test1() {
		String[] column1 = { "Utah", "Nevada", "California", "Oregon", "Utah", "California", "Nevada", "Nevada", "Oregon", "California" };
		Integer[] column2 = { 5, 6, 12, 8, 9, 10, 4, 4, 17, 6};
		String[] categories = { "Utah", "Nevada", "California" };
		Color[] colors = { Color.red, Color.blue, Color.green };
		new GraphWindow(new ArrayList<String>(Arrays.asList(column1)),
				new ArrayList<Integer>(Arrays.asList(column2)),
				new ArrayList<String>(Arrays.asList(categories)),
				new ArrayList<Color>(Arrays.asList(colors)), 0, true);
	}
	
	/**
	 * Does the same thing as test1 except it draws a 
	 * bar graph instead of a pie chart
	 */
	
	public static void test2() {
		String[] column1 = { "Utah", "Nevada", "California", "Oregon", "Utah", "California", "Nevada", "Nevada", "Oregon", "California" };
		Integer[] column2 = { 5, 6, 12, 8, 9, 10, 4, 4, 17, 6};
		String[] categories = { "Utah", "Nevada", "California" };
		Color[] colors = { Color.red, Color.blue, Color.green };
		new GraphWindow(new ArrayList<String>(Arrays.asList(column1)),
				new ArrayList<Integer>(Arrays.asList(column2)),
				new ArrayList<String>(Arrays.asList(categories)),
				new ArrayList<Color>(Arrays.asList(colors)), 0, false);
	}

	/**
	 * A non-exceptional test case for "by-hand" testing
	 * Shouldn't throw an exception
	 */
	public static void test3() {
		ArrayList<String> col1 = new ArrayList<String>();
		col1.add("Utah");
		ArrayList<Integer> col2 = new ArrayList<Integer>();
		col2.add(50);
		ArrayList<String> cats = new ArrayList<String>();
		cats.add("Utah");
		ArrayList<Color> colors = new ArrayList<Color>();
		colors.add(Color.red);
		new GraphWindow(col1, col2, cats, colors, 0, true);
	}
	
	/**
	 * Takes the sample data and turns it into a test
	 * draws with a pie chart except now it actually
	 * uses the data based on the Oregon category
	 */
	public static void test4() {
		String[] column1 = { "Utah", "Nevada", "California", "Oregon", "Utah", "California", "Nevada", "Nevada", "Oregon", "California" };
		Integer[] column2 = { 5, 6, 12, 8, 9, 10, 4, 4, 17, 6};
		String[] categories = { "Utah", "Nevada", "California", "Oregon" };
		Color[] colors = { Color.red, Color.blue, Color.green, Color.cyan };
		new GraphWindow(new ArrayList<String>(Arrays.asList(column1)),
				new ArrayList<Integer>(Arrays.asList(column2)),
				new ArrayList<String>(Arrays.asList(categories)),
				new ArrayList<Color>(Arrays.asList(colors)), 0, true);
	}
	
	/**
	 * Does the same thing as test4 except it draws a 
	 * bar graph instead of a pie chart
	 */
	public static void test5() {
		String[] column1 = { "Utah", "Nevada", "California", "Oregon", "Utah", "California", "Nevada", "Nevada", "Oregon", "California" };
		Integer[] column2 = { 5, 6, 12, 8, 9, 10, 4, 4, 17, 6};
		String[] categories = { "Utah", "Nevada", "California", "Oregon" };
		Color[] colors = { Color.red, Color.blue, Color.green, Color.cyan };
		new GraphWindow(new ArrayList<String>(Arrays.asList(column1)),
				new ArrayList<Integer>(Arrays.asList(column2)),
				new ArrayList<String>(Arrays.asList(categories)),
				new ArrayList<Color>(Arrays.asList(colors)), 0, false);
	}
	
	/**
	 * brand new test with
	 * a bunch of new data
	 */
	
	public static void test6() {
		// AP top 4 poll (week 7)
		String[] column1 = { "Florida State", "Mississippi State", "Ole Miss", "Mississippi State", "Florida State", "Auburn", "Ole Miss", "Auburn" };
		Integer[] column2 = { 1061, 320, 316, 1000, 400, 455, 1004, 1004};
//		Integer[] column2 = { 1461, 1459, 1320, 1320 };
		String[] categories = { "Florida State", "Auburn", "Mississippi State", "Ole Miss" };
		Color[] colors = { Color.magenta, Color.orange, Color.red, Color.blue };
		new GraphWindow(new ArrayList<String>(Arrays.asList(column1)),
				new ArrayList<Integer>(Arrays.asList(column2)),
				new ArrayList<String>(Arrays.asList(categories)),
				new ArrayList<Color>(Arrays.asList(colors)), 0, true);
	}
	
	/**
	 * same as test6 but with bar graph instead
	 * of pie chart
	 */
	
	public static void test7() {
		// AP top 4 poll (week 7)
				String[] column1 = { "Florida State", "Mississippi State", "Ole Miss", "Mississippi State", "Florida State", "Auburn", "Ole Miss", "Auburn" };
				Integer[] column2 = { 1061, 320, 316, 1000, 400, 455, 1004, 1004};
//				Integer[] column2 = { 1461, 1459, 1320, 1320 };
				String[] categories = { "Florida State", "Auburn", "Mississippi State", "Ole Miss" };
				Color[] colors = { Color.magenta, Color.orange, Color.red, Color.blue };
				new GraphWindow(new ArrayList<String>(Arrays.asList(column1)),
						new ArrayList<Integer>(Arrays.asList(column2)),
						new ArrayList<String>(Arrays.asList(categories)),
						new ArrayList<Color>(Arrays.asList(colors)), 0, false);
	}
	
	
	/**
	 * Tests the bar graph to its full extent
	 * using the data from the AP top 25 poll (week 7)
	 * Proves the for loop is working great
	 */
	public static void test8() {
		String[] column1 = { "Florida State", "Auburn", "Mississippi State", "Ole Miss", "Baylor", "Notre Dame", "Alabama", "Michigan State", "TCU", "Arizona", "Oklahoma", "Oregon", "Georgia", "Texas A&M", "Ohio State", "Oklahoma State", "Kansas State", "UCLA", "East Carolina", "Arizona State", "Nebraska", "Georgia Tech", "Missouri", "Utah", "Stanford" };
		Integer[] column2 = { 1461, 1459, 1320, 1320, 1258, 1186, 1060, 981, 979, 951, 904, 888, 854, 731, 534, 527, 486, 460, 344, 325, 283, 235, 212, 206, 143 };
		String[] categories = { "Florida State", "Auburn", "Mississippi State", "Ole Miss", "Baylor", "Notre Dame", "Alabama", "Michigan State", "TCU", "Arizona", "Oklahoma", "Oregon", "Georgia", "Texas A&M", "Ohio State", "Oklahoma State", "Kansas State", "UCLA", "East Carolina", "Arizona State", "Nebraska", "Georgia Tech", "Missouri", "Utah", "Stanford" };
		Color[] colors = { Color.magenta, Color.orange, Color.red, Color.blue, Color.green, Color.blue, Color.magenta, Color.black, Color.pink, Color.blue, Color.red, Color.green, Color.red, Color.magenta, Color.black, Color.orange, Color.pink, Color.cyan, Color.black, Color.magenta, Color.red, Color.blue, Color.darkGray, Color.red, Color.magenta};
		new GraphWindow(new ArrayList<String>(Arrays.asList(column1)),
				new ArrayList<Integer>(Arrays.asList(column2)),
				new ArrayList<String>(Arrays.asList(categories)),
				new ArrayList<Color>(Arrays.asList(colors)), 0, false);
	}
	
	/**
	 * same as test 1 but uses the averages instead of
	 * the sums to graph the stuff
	 */
	public static void test9() {
		String[] column1 = { "Utah", "Nevada", "California", "Oregon", "Utah", "California", "Nevada", "Nevada", "Oregon", "California" };
		Integer[] column2 = { 5, 6, 12, 8, 9, 10, 4, 4, 17, 6};
		String[] categories = { "Utah", "Nevada", "California" };
		Color[] colors = { Color.red, Color.blue, Color.green };
		new GraphWindow(new ArrayList<String>(Arrays.asList(column1)),
				new ArrayList<Integer>(Arrays.asList(column2)),
				new ArrayList<String>(Arrays.asList(categories)),
				new ArrayList<Color>(Arrays.asList(colors)), 1, true);
	}
	
	/**
	 * same as test 2 but with averages
	 */
	public static void test10() {
		String[] column1 = { "Utah", "Nevada", "California", "Oregon", "Utah", "California", "Nevada", "Nevada", "Oregon", "California" };
		Integer[] column2 = { 5, 6, 12, 8, 9, 10, 4, 4, 17, 6};
		String[] categories = { "Utah", "Nevada", "California" };
		Color[] colors = { Color.red, Color.blue, Color.green };
		new GraphWindow(new ArrayList<String>(Arrays.asList(column1)),
				new ArrayList<Integer>(Arrays.asList(column2)),
				new ArrayList<String>(Arrays.asList(categories)),
				new ArrayList<Color>(Arrays.asList(colors)), 1, false);
	}
	
	/**
	 * same as test 1 but with the maximums
	 */
	public static void test11() {
		String[] column1 = { "Utah", "Nevada", "California", "Oregon", "Utah", "California", "Nevada", "Nevada", "Oregon", "California" };
		Integer[] column2 = { 5, 6, 12, 8, 9, 10, 4, 4, 17, 6};
		String[] categories = { "Utah", "Nevada", "California" };
		Color[] colors = { Color.red, Color.blue, Color.green };
		new GraphWindow(new ArrayList<String>(Arrays.asList(column1)),
				new ArrayList<Integer>(Arrays.asList(column2)),
				new ArrayList<String>(Arrays.asList(categories)),
				new ArrayList<Color>(Arrays.asList(colors)), 2, true);
	}
	
	/**
	 * same as test 2 but with the maximums
	 */
	public static void test12() {
		String[] column1 = { "Utah", "Nevada", "California", "Oregon", "Utah", "California", "Nevada", "Nevada", "Oregon", "California" };
		Integer[] column2 = { 5, 6, 12, 8, 9, 10, 4, 4, 17, 6};
		String[] categories = { "Utah", "Nevada", "California" };
		Color[] colors = { Color.red, Color.blue, Color.green };
		new GraphWindow(new ArrayList<String>(Arrays.asList(column1)),
				new ArrayList<Integer>(Arrays.asList(column2)),
				new ArrayList<String>(Arrays.asList(categories)),
				new ArrayList<Color>(Arrays.asList(colors)), 2, false);
	}
	
	/**
	 * An exceptional test case for "by-hand" testing
	 * Should disappear or never appear and throw
	 * an IllegalArgumentException
	 */
	public static void exceptionTest1() {
		new GraphWindow(new ArrayList<String>(), new ArrayList<Integer>(),
				new ArrayList<String>(), new ArrayList<Color>(), 0, true);
	}
	
	/**
	 * Tests to make sure an exception is thrown when you 
	 * try to use a column2 that contains non-positive
	 * numbers. Should throw an IllegalArgumentException
	 */
	public static void exceptionTest2() {
		String[] column1 = { "Utah", "Nevada", "California", "Oregon", "Utah", "California", "Nevada", "Nevada", "Oregon", "California" };
		Integer[] column2 = { 5, 6, 12, 8, 9, 10, -2, 4, 17, 6};
		String[] categories = { "Utah", "Nevada", "California" };
		Color[] colors = { Color.red, Color.blue, Color.green };
		new GraphWindow(new ArrayList<String>(Arrays.asList(column1)),
				new ArrayList<Integer>(Arrays.asList(column2)),
				new ArrayList<String>(Arrays.asList(categories)),
				new ArrayList<Color>(Arrays.asList(colors)), 0, true);
	}
	
	/**
	 * tests to make sure an exception is thrown when you
	 * have a repeating category. Should throw an IllegalArgumentException
	 */
	public static void exceptionTest3() {
		String[] column1 = { "Utah", "Nevada", "California", "Oregon", "Utah", "California", "Nevada", "Nevada", "Oregon", "California" };
		Integer[] column2 = { 5, 6, 12, 8, 9, 10, 4, 4, 17, 6};
		String[] categories = { "Utah", "Nevada", "California", "California" };
		Color[] colors = { Color.red, Color.blue, Color.green, Color.green };
		new GraphWindow(new ArrayList<String>(Arrays.asList(column1)),
				new ArrayList<Integer>(Arrays.asList(column2)),
				new ArrayList<String>(Arrays.asList(categories)),
				new ArrayList<Color>(Arrays.asList(colors)), 0, true);
	}

	/**
	 * tests to make sure an exception is thrown when the length of
	 * column1 and column2 are not the same
	 */
	
	public static void exceptionTest4() {
		String[] column1 = { "Utah", "Nevada", "California", "Oregon", "Utah", "California", "Nevada", "Nevada", "Oregon", "California" };
		Integer[] column2 = { 5, 6, 12, 8, 9, 10, 4, 4, 17, 6, 7};
		String[] categories = { "Utah", "Nevada", "California" };
		Color[] colors = { Color.red, Color.blue, Color.green };
		new GraphWindow(new ArrayList<String>(Arrays.asList(column1)),
				new ArrayList<Integer>(Arrays.asList(column2)),
				new ArrayList<String>(Arrays.asList(categories)),
				new ArrayList<Color>(Arrays.asList(colors)), 0, true);
	}
	
	/**
	 * tests to make sure an exception is thrown when operation is
	 * greater than 2
	 */
	
	public static void exceptionTest5() {
		String[] column1 = { "Utah", "Nevada", "California", "Oregon", "Utah", "California", "Nevada", "Nevada", "Oregon", "California" };
		Integer[] column2 = { 5, 6, 12, 8, 9, 10, 4, 4, 17, 6};
		String[] categories = { "Utah", "Nevada", "California" };
		Color[] colors = { Color.red, Color.blue, Color.green };
		new GraphWindow(new ArrayList<String>(Arrays.asList(column1)),
				new ArrayList<Integer>(Arrays.asList(column2)),
				new ArrayList<String>(Arrays.asList(categories)),
				new ArrayList<Color>(Arrays.asList(colors)), 3, true);
	}
	
	/**
	 * test to make sure an exception is thrown when operation is
	 * less than 0
	 */
	
	public static void exceptionTest6() {
		String[] column1 = { "Utah", "Nevada", "California", "Oregon", "Utah", "California", "Nevada", "Nevada", "Oregon", "California" };
		Integer[] column2 = { 5, 6, 12, 8, 9, 10, 4, 4, 17, 6};
		String[] categories = { "Utah", "Nevada", "California" };
		Color[] colors = { Color.red, Color.blue, Color.green };
		new GraphWindow(new ArrayList<String>(Arrays.asList(column1)),
				new ArrayList<Integer>(Arrays.asList(column2)),
				new ArrayList<String>(Arrays.asList(categories)),
				new ArrayList<Color>(Arrays.asList(colors)), -1, true);
	}
}
