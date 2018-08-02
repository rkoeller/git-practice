/**
 * Row.java
 * @author Ryan Koeller
 */
package fun;

import java.lang.StringBuffer;
import java.util.Random;

public class Row
{
	private byte[] nums = new byte[10];

	public Row()
	{

	}

	/**
	 * Initializes nums with 1s and 0s
	 * 
	 * @param randomGenerator Random object used to create random numbers
	 */
	public void randomize(Random randomGenerator)
	{
		for (int i = 0; i < nums.length; i++)
		{
			int randomNum = randomGenerator.nextInt(10);
			if (randomNum > 5) // 40% chance
			{
				nums[i] = 1;
			} else
			{
				nums[i] = 0;
			}
		}
	}

	/**
	 * Adds two rows together
	 * 
	 * @param r1 First row to be added
	 * @param r2 Second row to be added
	 * @return sum of both rows
	 */
	public static Row addTo(Row r1, Row r2)
	{
		Row r3 = new Row();

		for (int i = 0; i < r1.nums.length; i++)
		{
			r3.nums[i] = (byte) (r1.nums[i] + r2.nums[i]);
		}

		return r3;
	}

	/**
	 * Prints nums to console
	 */
	public void print()
	{
		for (int i = 0; i < nums.length - 1; i++)
		{
			System.out.print(nums[i]);
		}
		System.out.println(nums[nums.length - 1]);
	}

	/**
	 * @return nums represented as a string
	 */
	public String toString()
	{
		StringBuffer newString = new StringBuffer(nums.length);
		for (int i = 0; i < nums.length; i++)
		{
			newString.append(nums[i]);
		}
		return newString.toString();
	}
}
