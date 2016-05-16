package design_patterns.state;

/**
 * A Pokémon that defaults to the {@link Bulbasaur} evolution.
 *
 * @author Jose Uusitalo
 */
public class Pokemon
{
	/**
	 * The current evolution state of this Pokémon.
	 */
	private EvolutionState state;

	/**
	 * Experience points.
	 */
	protected int xp;

	/**
	 */
	public Pokemon()
	{
		state = Bulbasaur.getInstance();
	}

	/**
	 * Makes this Pokémon roar.
	 */
	public void roar()
	{
		state.roar();
	}

	/**
	 * Makes this Pokémon stomp the ground.
	 */
	public void stomp()
	{
		state.stomp();
	}

	/**
	 * Makes this Pokémon greet you.
	 */
	public void greet()
	{
		state.greet();
	}

	/**
	 * Changes the amount of experience points this Pokémon has.
	 *
	 * @param points points to modify the experience by
	 */
	public void modExperiencePoints(final int points)
	{
		xp += points;
		state.checkExperiencePoints(this, xp);
	}

	/**
	 * Changes the state of this Pokémon.
	 *
	 * @param es the evolution state to change this Pokémon to
	 */
	public void changeState(final EvolutionState es)
	{
		state = es;
	}
}
