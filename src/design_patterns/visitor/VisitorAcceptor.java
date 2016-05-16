package design_patterns.visitor;

/**
 * An interface for accept an {@link EvolutionVisitor}.
 *
 * @author Jose Uusitalo
 */
public interface VisitorAcceptor
{
	/**
	 * Accepts the given {@link EvolutionVisitor}.
	 *
	 * @param v visiting visitor
	 * @param character the {@link Pokemon} that is visiting this visitor acceptor
	 */
	public void accept(final EvolutionVisitor v, final Pokemon character);
}
