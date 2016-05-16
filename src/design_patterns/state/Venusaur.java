package design_patterns.state;

/**
 * The final evolution state.
 * A singleton.
 *
 * @author Jose Uusitalo
 * @see Venusaur
 */
public class Venusaur extends EvolutionState
{
	/**
	 * This evolution state instance.
	 */
	private static EvolutionState INSTANCE = null;

	/**
	 */
	private Venusaur()
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
			INSTANCE = new Venusaur();

		return INSTANCE;
	}

	@Override
	public void roar()
	{
		System.out.println("\tRROAAAARRR!!");
	}

	@Override
	public void stomp()
	{
		System.out.println("\tThere's an earthquake!!");
	}

	@Override
	public void greet()
	{
		System.out.println("\tVenusaur greets you with a ");
		roar();
		stomp();
		stomp();
	}

	@Override
	public void checkExperiencePoints(final Pokemon p, final int points)
	{
		System.out.println("\tVenusaur is feeling stronger! (" + points + ")");
	}
}