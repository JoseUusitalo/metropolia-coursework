package design_patterns.visitor;

/**
 * A visitor interface for visiting various {@link EvolutionState}s.
 *
 * @author Jose Uusitalo
 */
public interface EvolutionVisitor
{
	/**
	 * Visits a {@link Bulbasaur} state.
	 *
	 * @param bulbasaur the Bulbasaur to visit
	 * @param character the {@link Pokemon} that is visiting
	 */
	public void visit(final Bulbasaur bulbasaur, final Pokemon character);

	/**
	 * Visits a {@link Ivysaur} state.
	 *
	 * @param ivysaur the Ivysaur to visit
	 * @param character the {@link Pokemon} that is visiting
	 */
	public void visit(final Ivysaur ivysaur, final Pokemon character);

	/**
	 * Visits a {@link Venusaur} state.
	 *
	 * @param venusaur the Venusaur to visit
	 * @param character the {@link Pokemon} that is visiting
	 */
	public void visit(final Venusaur venusaur, final Pokemon character);
}
