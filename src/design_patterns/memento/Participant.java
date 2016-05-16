package design_patterns.memento;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Random;

/**
 * A participant in a number guessing game of a {@link PuzzleMaster}.
 *
 * @author Jose Uusitalo
 */
public class Participant extends Thread
{
	/**
	 * A random number generator.
	 */
	private Random r;

	/**
	 * The solution to this participant's puzzle.
	 */
	private Object memento;

	/**
	 * The puzzle master currently hosting this participant's puzzle.
	 */
	private PuzzleMaster puzzleMaster;

	/**
	 * The delay between guesses in milliseconds.
	 */
	private long delay;

	/**
	 * The number of guesses done.
	 */
	private long guessCount;

	/**
	 * How fast this participant can guess numbers.
	 */
	private long guessesPerSecond;

	/**
	 * @param guessesPerSecond the number of guesses to perform each second
	 */
	public Participant(final int guessesPerSecond)
	{
		this.guessesPerSecond = guessesPerSecond;
		this.delay = Math.round(1000l / guessesPerSecond);
		this.r = new Random();
	}

	@Override
	public String toString()
	{
		return "P|" + Integer.toHexString(this.hashCode());
	}

	/**
	 * Call when this participant successfully guesses the solution to this puzzle master's puzzle.
	 *
	 * @param guess the correct guess
	 */
	private void win(final int guess)
	{
		System.out.println(this + " has guessed the solution '" + guess + "' for puzzle master " + puzzleMaster + " after " + guessCount + " guesses or "
				+ getTimePassedString() + " seconds.");

		leaveGame();
	}

	/**
	 * Gets the number of seconds that have passed since this participant has started guessing.
	 *
	 * @return seconds as a string
	 */
	private String getTimePassedString()
	{
		final NumberFormat formatter = new DecimalFormat("#0.00");
		final double seconds = (double) guessCount / (double) guessesPerSecond;

		return formatter.format(seconds);
	}

	/**
	 * Join the given {@link PuzzleMaster}'s game by requestion a solution memento to their game.
	 *
	 * @param puzzler puzzle master hosting a game
	 * @return <code>true</code> if this participant was not in a game already and successfully joined a game
	 */
	public boolean joinGame(final PuzzleMaster puzzler)
	{
		if (puzzleMaster == null)
		{
			this.puzzleMaster = puzzler;
			memento = puzzleMaster.joinGame();

			System.out.println(this + " has joined the game of puzzle master " + puzzleMaster + ".");

			return memento != null;
		}

		return false;
	}

	/**
	 * Stops guessing and leaves the current {@link PuzzleMaster}'s game.
	 */
	public void leaveGame()
	{
		System.out.println(this + " has left the game of puzzle master " + puzzleMaster + ".\n");
		puzzleMaster = null;
		memento = null;
	}

	/**
	 * Attempts to guess the solution to this participant's personal puzzle.
	 * On a successful guess they are removed from their {@link PuzzleMaster}'s game.
	 *
	 * @return <code>true</code> if the puzzle was solved
	 */
	public boolean guess()
	{
		final int guess = r.nextInt(PuzzleMaster.MAX_NUMBER);
		guessCount++;

		if (puzzleMaster.isSolution(guess, memento))
		{
			win(guess);

			return true;
		}

		return false;
	}

	/**
	 * Keeps guessing random numbers while this participant is a part of a game.
	 */
	@Override
	public void run()
	{
		while (puzzleMaster != null)
		{
			guess();

			try
			{
				Thread.sleep(delay);
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}
	}
}
