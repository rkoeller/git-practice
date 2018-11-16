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
		Random randomGenerator = new Random();
		Row row1 = new Row();
		Row row2 = new Row();
		Row row3 = new Row();
		row1.randomize(randomGenerator);
		row2.randomize(randomGenerator);
		row3.randomize(randomGenerator);
		System.out.println(row1);
		System.out.println(row2);
		System.out.println(row3);
		Row solution = Row.addTo(Row.addTo(row1, row2), row3);
		System.out.println(solution);
		System.out.println();
		
		Player p1 = new Player(row1, row2, row3);
		p1.print();

		p1.shiftRowRight((byte) 1);
		p1.shiftRowRight((byte) 2);
		p1.shiftRowLeft((byte) 3);
		p1.print();
	}
}
