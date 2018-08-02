package fun;

/**
 * Player.java
 * @author Ryan Koeller
 */

import java.util.Random;;

public class Player
{
	private Row r1;
	private Row r2;
	private Row r3;
	
	Player(Row r1, Row r2, Row r3)
	{
		this.r1 = r1;
		this.r2 = r2;
		this.r3 = r3;
		
		shuffleAll();
	}
	
	private void shuffle(Row r)
	{
		Random rand = new Random();
		byte temp;
		// rand.nextInt(max - min + 1) + min
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
	
	public void print()
	{
		System.out.println("Player rows are:");
		System.out.println(r1);
		System.out.println(r2);
		System.out.println(r3);
	}
}
