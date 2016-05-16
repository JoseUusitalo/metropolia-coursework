package design_patterns.state;

/**
 * An example using the state pattern.
 *
 * @author Jose Uusitalo
 */
public class Main
{
	/**
	 * A five day training session with Bulbasaur.
	 *
	 * @param args arguments
	 */
	public static void main(final String[] args)
	{
		final Pokemon pokemon = new Pokemon();

		for (int i = 1; i < 6; i++)
		{
			System.out.println("\n ---- DAY " + i + " ----\n");

			System.out.println("> Hello.");
			pokemon.greet();

			sleep(1500);

			System.out.println("\n> Attack!");
			pokemon.stomp();

			sleep(1500);

			System.out.println("<EXP +10>");
			pokemon.modExperiencePoints(10);

			sleep(1000);

			System.out.println("\n> Bye.");
			pokemon.roar();

			sleep(1500);
		}
	}

	/**
	 * Makes the thread sleep for the given number of milliseconds.
	 *
	 * @param ms milliseconds to sleep
	 */
	private static void sleep(final long ms)
	{
		try
		{
			Thread.sleep(ms);
		}
		catch (final InterruptedException e)
		{
			e.printStackTrace();
		}
	}
}
