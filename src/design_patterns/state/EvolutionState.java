package design_patterns.state;

/**
 * An abstract class representing the state of a {@link Pokemon} objects evolution.
 *
 * @author Jose Uusitalo
 */
public abstract class EvolutionState
{
	/**
	 * Prints a roar effect.
	 */
	public abstract void roar();

	/**
	 * Prints a stomp effect.
	 */
	public abstract void stomp();

	/**
	 * Prints a greeting.
	 */
	public abstract void greet();

	/**
	 * Changes the amount of experience points a {@link Pokemon} has.
	 *
	 * @param p Pokémon to change
	 * @param points points to modify the experience by
	 */
	public abstract void checkExperiencePoints(final Pokemon p, final int points);

	/**
	 * Changes the state of the given {@link Pokemon}.
	 *
	 * @param p Pokémon to change
	 * @param es the evolution state to change the Pokémon to
	 */
	@SuppressWarnings("static-method")
	public void changeState(final Pokemon p, final EvolutionState es)
	{
		p.changeState(es);
	}
}
