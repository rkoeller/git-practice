package fun;

import java.util.Objects;
import java.util.Random;

/**
 * Player.java
 * @author Ryan Koeller
 */
public class Player
{
	private Row r1;
	private Row r2;
	private Row r3;
	private Row playerSolution;
	private static final int DEBUG = 1;
	
	public Player(Row r1, Row r2, Row r3)
	{
		this.r1 = r1;
		this.r2 = r2;
		this.r3 = r3;
		
		shuffleAll();
		updatePlayerSolution();
	}

	public Player(Row r1, Row r2, Row r3, boolean noShuffle)
	{
		this.r1 = r1;
		this.r2 = r2;
		this.r3 = r3;
		if(!noShuffle)
		{
			shuffleAll();
		}
		updatePlayerSolution();
	}

	@Override
	public boolean equals(Object o)
	{
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Player player = (Player) o;
		return Objects.equals(r1, player.r1) &&
				Objects.equals(r2, player.r2) &&
				Objects.equals(r3, player.r3) &&
				Objects.equals(playerSolution, player.playerSolution);
	}

	@Override
	public int hashCode()
	{
		return Objects.hash(r1, r2, r3, playerSolution);
	}

	public Row getR1()
	{
		return r1;
	}

	public Row getR2()
	{
		return r2;
	}

	public Row getR3()
	{
		return r3;
	}

	public Row getPlayerSolution()
	{
		return playerSolution;
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
		shuffle(r1);
		shuffle(r2);
		shuffle(r3);
	}

	public void shiftRowRight(int rowNum)
	{
		if (DEBUG == 1) System.out.println("Shifting row " + rowNum + " right.");
		if(rowNum == 1)
		{
			shiftRowRight(r1);
		}
		else if(rowNum == 2)
		{
			shiftRowRight(r2);
		}
		else if(rowNum == 3)
		{
			shiftRowRight(r3);
		}
		else
		{
			System.out.println("Row does not exist: " + rowNum);
		}
		updatePlayerSolution();
	}

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
			shiftRowLeft(r1);
		}
		else if(rowNum == 2)
		{
			shiftRowLeft(r2);
		}
		else if(rowNum == 3)
		{
			shiftRowLeft(r3);
		}
		else
		{
			System.out.println("Row does not exist: " + rowNum);
		}
		updatePlayerSolution();
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

	private void updatePlayerSolution()
	{
		playerSolution = Row.addTo(Row.addTo(r1, r2), r3);
	}
	
	public void print()
	{
		System.out.println("Player rows are:");
		System.out.println(r1);
		System.out.println(r2);
		System.out.println(r3);
	}
}
