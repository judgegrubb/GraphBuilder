package cs1410;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class Grapher
{
	/**
	 * If column1 and column2 have different lengths, throws an IllegalArgumentException. ++
	 * If column2 contains any non-positive numbers, throws an IllegalArgumentException. ++
	 * If categories and colors have different lengths, or are of length zero, throws an IllegalArgumentException. ++
	 * If categories contains any duplicates, throws an IllegalArgumentException. ++
	 * If operation is anything other than 0, 1, or 2, throws an IllegalArgumentException. ++
	 * 
	 * Put side-by-side, the lists column1 and column2 represent a table, where each row contains a string and
	 * a number.  For example, here is a table that might give the number of people named Zebediah in different parts
	 * of four states.
	 * 
	 * <pre>
	 *  Utah          5
	 *  Nevada        6
	 *  California   12
	 *  Oregon        8
	 *  Utah          9
	 *  California   10
	 *  Nevada        4
	 *  Nevada        4
	 *  Oregon       17
	 *  California    6
	 * </pre>
	 * 
	 * Let c be a string that appears in the parameter categories.  We can associate c with a list of numbers by collecting 
	 * every number that is paired with c in the table.  For example, if categories = [Utah, Nevada, California], we get the
	 * following pairings:
	 * 
	 * Utah       [5, 9]
	 * Nevada     [6, 4, 4]
	 * California [12, 10, 6]
	 * 
	 * We can convert each list to a number by either summing it, averaging it, or finding its maximum.  For example, if we 
	 * choose to sum the lists, we get the following pairings:
	 * 
	 * Utah       14
	 * Nevada     14
	 * California 28
	 * 
	 * The job of this method is to use column1, column2, and categories to obtain a pairing between strings and numbers as
	 * described above.  (If any of the names in categories is paired with no numbers, the method should throw an IllegalArgumentException.) 
	 * The method should sum each list if operation is 0, average each list if operation is 1, or find the maximum of each list if operation is 2.
	 * 
	 * Once the method has paired each name in categories with a number, it should display the data with either a pie chart (if usePieChart is
	 * true) or a bar graph (otherwise).  The area of each slice (of a pie chart) and the length of each bar (in a bar graph) should be proportional 
	 * to the number being graphed.  In the example above, in a pie chart Utah and Nevada should each have a quarter of the pie and California should
	 * have half.  In a bar graph, California's line should be twice as long as Utah's and Nevada's.
	 * 
	 * In both the pie chart and the bar graph, the color used for categories[i] should be colors[i].
	 * 
	 * The method should display the pie chart or bar graph by drawing on the g parameter.  The example code below draws both a pie chart
	 * and a bar graph for the situation described above.  
	 */
	public static void drawGraph (Graphics g, ArrayList<String> column1,
			ArrayList<Integer> column2, ArrayList<String> categories,
			ArrayList<Color> colors, int operation, boolean usePieChart)
	{
		// test a bunch of stuff and throw the necessary errors
		throwErrors(column1, column2, categories, colors, operation);
		
		// find the needed number for each category based on the operation requested
		ArrayList<Integer> categorized = categorizer(column1, column2, categories, operation);
		
		if (usePieChart) {
			drawPie(g, categories, colors, categorized);
		} else {
			drawBar(g, categories, colors, categorized);
		}
	}
	
	/**
	 * Takes in the two columns, categories, colors and operations and checks them for 
	 * different errors. If needed throws IllegalArgumentException.
	 * returns nothing.
	 * @param column1
	 * @param column2
	 * @param categories
	 * @param colors
	 * @param operation
	 */
	
	public static void throwErrors(ArrayList<String> column1, ArrayList<Integer> column2, ArrayList<String> categories, ArrayList<Color> colors, int operation) {
		// test several error options and
		// throw IllegalArgumentException if
		// any of them are true
		if (column1.size() != column2.size()) {
			throw new IllegalArgumentException();//exceptionTest4
		} else if (colors.size() != categories.size() || colors.size() == 0 || categories.size() == 0) {
			throw new IllegalArgumentException();//exceptionTest1
		} else if (operation < 0 || operation > 2) {
			throw new IllegalArgumentException();//exceptionTest5 && exceptionTest6
		}
		
		for (int i : column2) {
			if (i < 1) {
				throw new IllegalArgumentException();//exceptionTest2
			}
		}
		
		for (int i = 0; i < categories.size(); i++) {
			for (int x = 0; x < categories.size(); x++) {
				if (categories.get(i) == categories.get(x) && i != x) {
					throw new IllegalArgumentException(); //exceptionTest3
				}
			}
		}
	}

	/**
	 * takes in the graphics object, the categories, colors and the categorized integers
	 * and draws a pie chart based on these
	 * @param g
	 * @param categories
	 * @param colors
	 * @param categorized
	 */
	public static void drawPie(Graphics g, ArrayList<String> categories, ArrayList<Color> colors, ArrayList<Integer> categorized) {
		// this is the real code
		int x = 100;
		int y = 100;
		int angle = 0;
		int angleStart = 0;
		for (int i = 0; i < categories.size(); i++) {
			angle = angle(categorized, i);
			g.setColor(colors.get(i));
			g.fillArc(x, y, 100, 100, angleStart, angle);
			g.fillRect(x + 110, y + (i*15), 10, 10);
			angleStart += angle;
			g.setColor(Color.black);
			g.drawString(categories.get(i), x + 125, y + 10 + (i * 15));
		}
	}
	
	/**
	 * takes in the graphics object, the categories, colors and the categorized integers
	 * and draws a bar graph based on these
	 * @param g
	 * @param categories
	 * @param colors
	 * @param categorized
	 */
	public static void drawBar(Graphics g, ArrayList<String> categories, ArrayList<Color> colors, ArrayList<Integer> categorized) {
		// this is the real code
		int x = 200;
		int y = 100;
		int width = 0;
		for (int i = 0; i < categories.size(); i++) {
			width = width(categorized, i);
			g.setColor(colors.get(i));
			g.fillRect(x - width, y + (i * 25), width, 25);
			g.setColor(Color.black);
			g.drawString(categories.get(i), x + 5, y + 20 + (i * 25));
		}
	}
	
	
	/**
	 * calculates the correct width for the bar graph based
	 * on the premise that the longest bar should be about
	 * 180 pixels wide.
	 * @param categorized
	 * @param i
	 * @return
	 */
	public static int width(ArrayList<Integer> categorized, int i) {
		int max = maximum(categorized);
		int width = (int) ((((double) categorized.get(i)) / max) * 180);
		return width;
	}
	
	/**
	 * calculates the correct width for the bar graph based
	 * on the premise that the longest bar should be about
	 * 180 pixels wide.
	 * @param categorized
	 * @param i
	 * @return
	 */
	public static int angle(ArrayList<Integer> categorized, int i) {
		int sum = summation(categorized);
		int angle = (int) ((((double) categorized.get(i)) / sum) * 360);
		return angle;
	}
	
	/**
	 * takes in column1, column2 and categories and returns the data from column2 categorized based on the operation
	 * @param column1
	 * @param column2
	 * @param categories
	 * @param operation
	 * @return
	 */
	
	public static ArrayList<Integer> categorizer(ArrayList<String> column1, ArrayList<Integer> column2, ArrayList<String> categories, int operation) {
		ArrayList<Integer> categorized = new ArrayList<Integer>();
		for (int i = 0; i < categories.size(); i++) {
			ArrayList<Integer> categoryNumbers = new ArrayList<Integer>();
			for (int x = 0; x < column1.size(); x++) {
				if (column1.get(x) == categories.get(i)) {
					categoryNumbers.add(column2.get(x));
				}
			}
			if (categoryNumbers.size() < 1) {
				throw new IllegalArgumentException();
			}
			
			int categoryNumber = 0;
			if (operation == 0) {
				categoryNumber = summation(categoryNumbers);
			} else if (operation == 1) {
				categoryNumber = average(categoryNumbers);
			} else if (operation == 2) {
				categoryNumber = maximum(categoryNumbers);
			}
			categorized.add(categoryNumber);
		}
		return categorized;
	}
	
	/**
	 * takes in the arrayList with the numbers for a certain
	 * category and returns their sum
	 * @param category
	 * @return
	 */
	public static int summation(ArrayList<Integer> category) {
		int sum = 0;
		for(int i = 0; i < category.size(); i++) {
			sum += category.get(i);
		}
		return sum;
	}
	
	/**
	 * takes in the arrayList with the numbers for a certain
	 * category and returns their average
	 * @param category
	 * @return
	 */
	public static int average(ArrayList<Integer> category) {
		int sum = 0;
		for(int i = 0; i < category.size(); i++) {
			sum += category.get(i);
		}
		return sum/category.size();
	}
	
	/**
	 * takes in the arrayList with the numbers for a certain
	 * category and returns their max
	 * @param category
	 * @return
	 */
	public static int maximum(ArrayList<Integer> category) {
		int max = 0;
		for(int i = 0; i < category.size(); i++) {
			if (category.get(i) > max) {
				max = category.get(i);
			}
		}
		return max;
	}
}
