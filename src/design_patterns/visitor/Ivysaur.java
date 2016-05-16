package design_patterns.visitor;

/**
 * The second evolution state preceeding {@link Venusaur}.
 * A singleton.
 *
 * @author Jose Uusitalo
 * @see Bulbasaur
 */
public class Ivysaur extends EvolutionState
{
	/**
	 * This evolution state instance.
	 */
	private static EvolutionState INSTANCE = null;

	/**
	 */
	private Ivysaur()
	{
		super.evolutionLevel = 2;
	}

	/**
	 * Get an instance of this evolution state.
	 *
	 * @return the instance
	 */
	public static EvolutionState getInstance()
	{
		if (INSTANCE == null)
			INSTANCE = new Ivysaur();

		return INSTANCE;
	}

	@Override
	public void roar()
	{
		System.out.println("\tRoar!");
	}

	@Override
	public void stomp()
	{
		System.out.println("\tThe ground shakes!");
	}

	@Override
	public void greet()
	{
		System.out.println("\tIvysaur greets you with a ");
		roar();
		stomp();
		stomp();
	}

	@Override
	public void checkExperiencePoints(final Pokemon p, final int points)
	{
		if (points >= 35)
		{
			System.out.println("\tIvysaur is evolving!");
			changeState(p, Venusaur.getInstance());
		}
		else
			System.out.println("\tIvysaur is feeling stronger! (" + points + "/35)");
	}

	@Override
	public void accept(final EvolutionVisitor v, final Pokemon character)
	{
		System.out.println("A visitor is visiting a Ivysaur.");
		v.visit(this, character);
	}
}
