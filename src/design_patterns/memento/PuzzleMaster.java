package design_patterns.memento;

import java.util.Random;

/**
 * A puzzle master that runs a number guessing game.
 *
 * @author Jose Uusitalo
 */
public class PuzzleMaster
{
	/**
	 * The maximum number in the guessing game. (Exclusive.)
	 */
	public static final int MAX_NUMBER = 100;

	/**
	 * A pseudo-random number generator.
	 */
	private Random r;

	/**
	 * Initialize the puzzle random number generator.
	 */
	public PuzzleMaster()
	{
		r = new Random();
		System.out.println(this + " is now hosting a game of number guessing in the range [0, " + (MAX_NUMBER - 1) + "].");
	}

	@Override
	public String toString()
	{
		return "PM|" + Integer.toHexString(this.hashCode());
	}

	/**
	 * Join this puzzle master's game by requesting a secret solution to a number guessing puzzle.
	 *
	 * @return a puzzle solution memento (a random number in the range [0, 64])
	 */
	public Object joinGame()
	{
		return new SolutionMemento(r.nextInt(MAX_NUMBER));
	}

	/**
	 * Checks if the given guess matches the given solution memento.
	 *
	 * @param memento solution memento to check against
	 * @param guess the guessed number in the range [0, 64]
	 * @return <code>true</code> if the guess is correct
	 */
	@SuppressWarnings("static-method")
	public boolean isSolution(final int guess, final Object memento)
	{
		return ((SolutionMemento) memento).solution == guess;
	}

	/**
	 * A memento class containing the secret solution to a {@link PuzzleMaster}'s number guessing puzzle.
	 *
	 * @author Jose Uusitalo
	 */
	private class SolutionMemento
	{
		/**
		 * The secret solution of this memento.
		 */
		private int solution;

		/**
		 * @param solution the solution to this memento
		 */
		public SolutionMemento(final int solution)
		{
			this.solution = solution;
		}
	}
}
