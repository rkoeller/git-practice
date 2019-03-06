package fun;

import java.util.Random;

/**
 * Puzzle.java
 * @author Ryan Koeller
 */
public class Puzzle
{
	private Row row1;
	private Row row2;
	private Row row3;
	private Row solution;
	private static final int DEBUG = 1;

	public Puzzle()
	{
		row1 = new Row();
		row2 = new Row();
		row3 = new Row();

		updateSolution();
		shuffleAll();
	}

	public Puzzle(Row row1, Row row2, Row row3, boolean noShuffle)
	{
		this.row1 = row1;
		this.row2 = row2;
		this.row3 = row3;

		updateSolution();

		if(!noShuffle)
		{
			shuffleAll();
		}
	}

	private void shuffle(Row r)
	{
		Random rand = new Random();
		byte temp;

		// rand.nextInt(max - min + 1) + min
		// move row to the right 1 - 9 (inclusive) times
		for(int i = 0; i < rand.nextInt(9 - 1 + 1) + 1; i++)
		{
			temp = r.getRow()[r.getRowLength() - 1];
			for(int j = r.getRowLength() - 1; j > 0; j--)
			{
				r.getRow()[j] = r.getRow()[j -1];
			}
			r.getRow()[0] = temp;
		}
	}

	private void shuffleAll()
	{
		shuffle(row1);
		shuffle(row2);
		shuffle(row3);
	}

	public void shiftRowRight(int rowNum)
	{
		if (DEBUG == 1) System.out.println("Shifting row " + rowNum + " right.");
		if(rowNum == 1)
		{
			shiftRowRight(row1);
		}
		else if(rowNum == 2)
		{
			shiftRowRight(row2);
		}
		else if(rowNum == 3)
		{
			shiftRowRight(row3);
		}
		else
		{
			System.out.println("Row does not exist: " + rowNum);
		}
	}

	/**
	 * Used by public method to shift specific rows
	 * @param r row to be shifted
	 */
	private void shiftRowRight(Row r)
	{
		byte temp = r.getRow()[r.getRowLength() - 1];
		for(int i = r.getRowLength() - 1; i > 0; i--)
		{
			r.getRow()[i] = r.getRow()[i -1];
		}
		r.getRow()[0] = temp;
	}

	public void shiftRowLeft(int rowNum)
	{
		if (DEBUG == 1) System.out.println("Shifting row " + rowNum + " left.");
		if(rowNum == 1)
		{
			shiftRowLeft(row1);
		}
		else if(rowNum == 2)
		{
			shiftRowLeft(row2);
		}
		else if(rowNum == 3)
		{
			shiftRowLeft(row3);
		}
		else
		{
			System.out.println("Row does not exist: " + rowNum);
		}
	}

	private void shiftRowLeft(Row r)
	{
		byte temp = r.getRow()[0];
		for(int i = 0; i < r.getRowLength() - 1; i++)
		{
			r.getRow()[i] = r.getRow()[i + 1];
		}
		r.getRow()[r.getRowLength() - 1] = temp;
	}

	private void updateSolution()
	{
		solution = Row.addTo(Row.addTo(row1, row2), row3);
	}

	public Row getRow1()
	{
		return row1;
	}

	public Row getRow2()
	{
		return row2;
	}

	public Row getRow3()
	{
		return row3;
	}

	public Row getSolution()
	{
		return solution;
	}

	/**
	 * Adds current position of rows together and checks equality to solution
	 */
	public boolean checkSolution()
	{
		Row tempRow = new Row(Row.addTo(row1, Row.addTo(row2, row3)));
		return tempRow.equals(solution);
	}

	public void print()
	{
		System.out.println(row1 + ": Row 1" + "\n" +
				row2 + ": Row 2" + "\n" +
				row3 + ": Row 3" + "\n" +
				solution + ": Solution");
	}

	@Override
	public String toString()
	{
		return "Puzzle{" +
				"row1=" + row1 +
				", row2=" + row2 +
				", row3=" + row3 +
				", solution=" + solution +
				'}';
	}
}
