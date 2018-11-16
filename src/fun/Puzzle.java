package fun;

import java.util.Random;

/**
 * Puzzle.java
 * @author Ryan Koeller
 */
public class Puzzle
{
	/**
     * @param args the command line arguments
     */
	public static void main(String[] args)
	{
		Row row1 = new Row();
		Row row2 = new Row();
		Row row3 = new Row();

		System.out.println(row1);
		System.out.println(row2);
		System.out.println(row3);
		Row solution = Row.addTo(Row.addTo(row1, row2), row3);
		System.out.println(solution);
		System.out.println();
		
		Player p1 = new Player(row1, row2, row3);
		p1.print();

		p1.shiftRowRight(1);
		p1.shiftRowRight( 2);
		p1.shiftRowLeft(3);
		p1.print();
	}
}
