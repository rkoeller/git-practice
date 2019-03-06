package fun;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main
{
	public static void main(String[] args)
	{
		Player player = new Player();
		menu(player);
	}

	static public void menu(Player player)
	{
		Scanner scanner = new Scanner(System.in);
		byte choice;
		byte rowNum;

		/*
		 * Repeat until choice = 5
		 */
		do
		{
			System.out.println("1. Show Puzzle");
			System.out.println("2, Shift Row# Right");
			System.out.println("3, Shift Row# Left");
			System.out.println("4. Check Solution");
			System.out.print("Enter Choice: ");
			try
			{
				choice = scanner.nextByte();

				switch (choice)
				{
					case 1:
						player.showPuzzle();
						System.out.println();
						break;
					case 2:
						System.out.print("Which row?: ");
						rowNum = scanner.nextByte();
						player.shiftRowRight(rowNum);
						System.out.println();
						break;
					case 3:
						System.out.print("Which row?: ");
						rowNum = scanner.nextByte();
						player.shiftRowLeft(rowNum);
						System.out.println();
						break;
					case 4:
						player.checkSolution();
						System.out.println();
						break;
				}
			} catch (InputMismatchException e)
			{
				choice = 0;
				System.out.println("Invalid Input...\n");
			}
		} while (choice != 5);
	}
}
