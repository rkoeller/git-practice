package fun;

import java.util.Random;

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
		row1.randomize(randomGenerator);
		row2.randomize(randomGenerator);
		System.out.println(row1);
		System.out.println(row2);
		Row row3 = Row.addTo(row1, row2);
		System.out.println(row3);
	}
}
