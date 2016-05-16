package design_patterns.state;

/**
 * The first evolution state preceeding {@link Ivysaur}.
 * A singleton.
 *
 * @author Jose Uusitalo
 */
public class Bulbasaur extends EvolutionState
{
	/**
	 * This evolution state instance.
	 */
	private static EvolutionState INSTANCE = null;

	/**
	 */
	private Bulbasaur()
	{
	}

	/**
	 * Get an instance of this evolution state.
	 *
	 * @return the instance
	 */
	public static EvolutionState getInstance()
	{
		if (INSTANCE == null)
			INSTANCE = new Bulbasaur();

		return INSTANCE;
	}

	@Override
	public void roar()
	{
		System.out.println("\trawr");
	}

	@Override
	public void stomp()
	{
		System.out.println("\t*stomp*");
	}

	@Override
	public void greet()
	{
		System.out.println("\tBulbasaur greets you with a ");
		roar();
		stomp();
		stomp();
	}

	@Override
	public void checkExperiencePoints(final Pokemon p, final int points)
	{
		if (points >= 15)
		{
			System.out.println("\tBulbasaur is evolving!");
			changeState(p, Ivysaur.getInstance());
		}
		else
			System.out.println("\tBulbasaur is feeling stronger! (" + points + "/15)");
	}
}
