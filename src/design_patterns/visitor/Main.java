package design_patterns.visitor;

/**
 * A state pattern example expanded with the visitor pattern.
 *
 * @author Jose Uusitalo
 */
public class Main
{
	/**
	 * A five day training session with Bulbasaur.
	 * After each day a visitor visits the pokemon.
	 *
	 * @param args arguments
	 */
	public static void main(final String[] args)
	{
		final Pokemon pokemon = new Pokemon();
		final EvolutionVisitor visitor = new BonusVisitor();

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

			System.out.println();
			pokemon.accept(visitor, pokemon);
			System.out.println();

			sleep(1000);

			System.out.println("Current Experience Points: " + pokemon.getXP());
			System.out.println("Current Bonus Points: " + pokemon.getBonusPoints());

			sleep(1000);
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
