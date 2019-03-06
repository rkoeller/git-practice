package test;

import fun.Puzzle;
import fun.Row;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest
{
	private Row row1 = new Row(new byte[] {1, 1, 0, 1, 0, 0, 0, 0, 1, 0});
	private Row row2 = new Row(new byte[] {0, 1, 1, 1, 0, 1, 0, 0, 0, 1});
	private Row row3 = new Row(new byte[] {1, 1, 1, 0, 0, 1, 0, 0, 0, 0});
	private Puzzle p;

	@org.junit.jupiter.api.BeforeEach
	void init()
	{
		p = new Puzzle(row1, row2, row3, true);
	}

	@org.junit.jupiter.api.Test
	void testShiftRowRight()
	{
		p.shiftRowRight(1);
		assertEquals(new Row(new byte[] {0, 1, 1, 0, 1, 0, 0, 0, 0, 1}), p.getRow1());

		p.shiftRowRight(1);
		assertEquals(new Row(new byte[] {1, 0, 1, 1, 0, 1, 0, 0, 0, 0}), p.getRow1());

		p.shiftRowRight(1);
		assertEquals(new Row(new byte[] {0, 1, 0, 1, 1, 0, 1, 0, 0, 0}), p.getRow1());
	}

	@org.junit.jupiter.api.Test
	void testShiftRowLeft()
	{
		p.shiftRowLeft(1);
		assertEquals(new Row(new byte[] {1, 0, 1, 0, 0, 0, 0, 1, 0, 1}), p.getRow1());

		p.shiftRowLeft(1);
		assertEquals(new Row(new byte[] {0, 1, 0, 0, 0, 0, 1, 0, 1, 1}), p.getRow1());

		p.shiftRowLeft(1);
		assertEquals(new Row(new byte[] {1, 0, 0, 0, 0, 1, 0, 1, 1, 0}), p.getRow1());
	}
}
