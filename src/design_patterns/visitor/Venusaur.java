package design_patterns.visitor;

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
		super.evolutionLevel = 3;
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

	@Override
	public void accept(final EvolutionVisitor v, final Pokemon character)
	{
		System.out.println("A visitor is visiting a Venusaur.");
		v.visit(this, character);
	}
}