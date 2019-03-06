package fun;

import java.lang.StringBuffer;
import java.util.Arrays;
import java.util.Random;

/**
 * Row.java
 * @author Ryan Koeller
 */
public class Row
{
	private byte[] nums = new byte[10];

	public Row()
	{
		randomize();
	}

	public Row(Row row)
	{
		nums = row.nums;
	}

	/**
	 * Row constructor that copies a byte array of length 10
	 * @param nums byte array to be copied
	 */
	public Row(byte[] nums)
	{
		if (nums.length == this.nums.length)
		{
			for(int i = 0; i < nums.length; i++)
			{
				this.nums[i] = nums[i];
			}
		}
	}

	/**
	 * Initializes nums with 1s and 0s
	 */
	private void randomize()
	{
		Random randomGenerator = new Random();
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
	 * @return nums array
	 */
	public byte[] getRow()
	{
		return nums;
	}
	
	/**
	 * @return length of nums
	 */
	public int getRowLength()
	{
		return nums.length;
	}

	@Override
	public boolean equals(Object o)
	{
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Row row = (Row) o;
		return Arrays.equals(nums, row.nums);
	}

	@Override
	public int hashCode()
	{
		return Arrays.hashCode(nums);
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
	 * @return newString represented as a string
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
