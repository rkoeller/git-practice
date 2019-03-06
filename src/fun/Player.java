package fun;

/**
 * Player.java
 * @author Ryan Koeller
 */
public class Player
{
	private Puzzle puzzle;

	public Player()
	{
		puzzle = new Puzzle();
	}

	public void shiftRowRight(int num)
	{
		puzzle.shiftRowRight(num);
		showPuzzle();
	}

	public void shiftRowLeft(int num)
	{
		puzzle.shiftRowLeft(num);
		showPuzzle();
	}

	public void checkSolution()
	{
		boolean solved = puzzle.checkSolution();
		if(solved)
		{
			System.out.println("Congratulations! You solved the puzzle!");
		}
		else
		{
			System.out.println("Puzzle not solved.");
		}
	}

	public void showPuzzle()
	{
		puzzle.print();
	}
}
