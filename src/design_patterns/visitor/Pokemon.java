package design_patterns.visitor;

/**
 * A Pokémon that defaults to the {@link Bulbasaur} evolution.
 *
 * @author Jose Uusitalo
 */
public class Pokemon implements VisitorAcceptor
{
	/**
	 * The current evolution state of this Pokémon.
	 */
	private EvolutionState state;

	/**
	 * Experience points.
	 */
	private int xp;

	/**
	 * Bonus points.
	 */
	private int bonus;

	/**
	 * Gets the experience points this pokemon has.
	 *
	 * @return the number of experience points
	 */
	public int getXP()
	{
		return xp;
	}

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
	 * Gets the number of bonus points this pokemon has.
	 *
	 * @return the number of bonus points
	 */
	public int getBonusPoints()
	{
		return bonus;
	}

	/**
	 * Changes the amount of bonus points this Pokémon has.
	 *
	 * @param points points to modify the experience by
	 */
	public void modBonusPoints(final int points)
	{
		bonus += points;
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

	@Override
	public void accept(final EvolutionVisitor v, final Pokemon character)
	{
		state.accept(v, this);
	}
}
