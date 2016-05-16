package design_patterns.template_method;

import java.util.Scanner;

/**
 * A tic-tac-toe game.
 *
 * @author Jose Uusitalo
 */
public class TicTacToe extends AbstractGame
{
	/**
	 * The index representing a column in arrays.
	 */
	private static final int COLUMN = 0;

	/**
	 * The index representing a row in arrays.
	 */
	private static final int ROW = 1;

	/**
	 * The game board.
	 */
	private char[][] board;

	/**
	 * A scanner for reading keyboard input.
	 */
	private Scanner read;

	/**
	 * The previously active player.
	 */
	private int lastPlayer;

	/**
	 * The most recently played coordinates.
	 */
	private int[] lastCoordinates;

	/**
	 * Current round number.
	 */
	private int round;

	/**
	 * Is the end of the game a tie?
	 */
	private boolean tie;

	@Override
	void initializeGame()
	{
		board = new char[3][3];
		read = new Scanner(System.in);
		lastCoordinates = new int[] { 0, 0 };

		for (int row = 0; row < 3; row++)
		{
			for (int column = 0; column < 3; column++)
				board[column][row] = ' ';
		}

		System.out.println("-- TIC TAC TOE --");
		printBoard();
	}

	@Override
	void makePlay(final int player)
	{
		this.lastPlayer = player;
		printPlayerBanner(player);
		playSlot(player, readSlot());
		printBoard();
	}

	@Override
	boolean endOfGame()
	{
		/*
		 * Win checking algorithm adapted from: http://stackoverflow.com/a/19579695
		 */

		final int size = board.length;
		final int lastCol = lastCoordinates[COLUMN];
		final int lastRow = lastCoordinates[ROW];
		final char lastMarker = lastPlayer == 0 ? 'X' : 'O';
		final boolean onDiagonal = (lastRow == lastCol) || (lastCol == -1 * lastRow + (size - 1));

		boolean rowWin = true;
		boolean colWin = true;
		boolean diagWin = true;
		boolean diagWin2 = true;

		for (int n = 0; n < size; n++)
		{
			if (board[lastCol][n] != lastMarker)
				colWin = false;

			if (board[n][lastRow] != lastMarker)
				rowWin = false;
		}

		if (onDiagonal)
		{
			for (int n = 0; n < board.length; n++)
			{
				if (board[n][n] != lastMarker)
					diagWin = false;
				if (board[n][-1 * n + (board.length - 1)] != lastMarker)
					diagWin2 = false;
			}
		}
		else
		{
			diagWin = false;
			diagWin2 = false;
		}

		boolean win = rowWin || colWin || diagWin || diagWin2;

		if (!win && round == 9)
		{
			tie = true;
			win = true;
		}

		return win;
	}

	@Override
	void printWinner()
	{
		if (tie)
			System.out.println("\n - TIE! -\n");
		else
			System.out.println("\n- PLAYER " + (lastPlayer + 1) + " WINS! -\n");
	}

	/**
	 * Prints the game board in its current state.
	 */
	private void printBoard()
	{
		final int size = board.length;
		final StringBuilder sb = new StringBuilder();

		sb.append("\n");

		for (int row = 0; row < size; row++)
		{
			sb.append(" ");

			for (int column = 0; column < size; column++)
			{
				sb.append(board[column][row]);

				if (column < size - 1)
					sb.append(" | ");
				else
					sb.append(" \n");
			}

			if (row < size - 1)
				sb.append("-----------\n");
		}

		System.out.println(sb.toString());
	}

	/**
	 * Prints a banner displaying the currently active player.
	 *
	 * @param player player index
	 */
	@SuppressWarnings("static-method")
	private void printPlayerBanner(final int player)
	{
		System.out.println("PLAYER " + (player + 1));
		System.out.println("--------");
	}

	/**
	 * Asks the player for the slot they want to play.
	 *
	 * @return the slot number
	 */
	private int readSlot()
	{
		int slot = -1;

		do
		{
			System.out.print("Mark Index [1-9]: ");

			try
			{
				slot = Integer.valueOf(read.next());
			}
			catch (final NumberFormatException e)
			{
				System.out.println("Not a number!");
			}
		}
		while (!isValidSlot(slot));

		return slot;
	}

	/**
	 * Checks if the given slot is valid.
	 *
	 * @param slot slot number
	 * @return <code>true</code> if the slot is valid
	 */
	private boolean isValidSlot(final int slot)
	{
		if (slot >= 1 && slot <= 9)
		{
			final int[] coords = toCoordinates(slot - 1);

			if (board[coords[COLUMN]][coords[ROW]] == ' ')
				return true;

			System.out.println("Already marked!");
			return false;
		}

		System.out.println("Out of bounds!");

		return false;
	}

	/**
	 * Plays the given slot with the given player.
	 *
	 * @param player the player 0 or 1
	 * @param slot slot to play
	 */
	private void playSlot(final int player, final int slot)
	{
		int[] coords = toCoordinates(slot - 1);
		this.lastCoordinates = coords;
		this.round++;

		if (player == 0)
			board[coords[COLUMN]][coords[ROW]] = 'X';
		else
			board[coords[COLUMN]][coords[ROW]] = 'O';
	}

	/**
	 * Converts the given index to a coordinate pair on a 3x3 board.
	 *
	 * @param index a value [0-9]
	 * @return a (column, row) coordinate pair
	 */
	@SuppressWarnings("static-method")
	private int[] toCoordinates(final int index)
	{
		int coords[] = new int[2];

		coords[COLUMN] = index % 3;

		if (index <= 2)
			coords[ROW] = 0;
		else if (index <= 5)
			coords[ROW] = 1;
		else
			coords[ROW] = 2;

		return coords;
	}
}