package test;

import fun.Row;

import static org.junit.jupiter.api.Assertions.*;

class RowTest
{

	@org.junit.jupiter.api.Test
	void testAddTo()
	{
		Row row1 = new Row(new byte[] {1, 1, 0, 1, 0, 0, 0, 0, 1, 0});
		Row row2 = new Row(new byte[] {0, 1, 1, 1, 0, 1, 0, 0, 0, 1});
		Row expected = new Row(new byte[] {1, 2, 1, 2, 0, 1, 0, 0, 1, 1});

		assertEquals(expected, Row.addTo(row1, row2));
	}
}
