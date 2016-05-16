package design_patterns.visitor;

/**
 * An implementation of the {@link EvolutionVisitor}.
 *
 * @author Jose Uusitalo
 */
public class BonusVisitor implements EvolutionVisitor
{
	@Override
	public void visit(final Bulbasaur bulbasaur, final Pokemon character)
	{
		final int points = (int) Math.round(character.getXP() / 2.5 / bulbasaur.getEvolutionLevel());
		System.out.println("<BONUS +" + points + "p>");
		character.modBonusPoints(points);
	}

	@Override
	public void visit(final Ivysaur ivysaur, final Pokemon character)
	{
		final int points = (int) Math.round(character.getXP() / 2.0 / ivysaur.getEvolutionLevel());
		System.out.println("<BONUS +" + points + "p>");
		character.modBonusPoints(points);
	}

	@Override
	public void visit(final Venusaur venusaur, final Pokemon character)
	{
		final int points = (int) Math.round(character.getXP() / 1.5 / venusaur.getEvolutionLevel());
		System.out.println("<BONUS +" + points + "p>");
		character.modBonusPoints(points);
	}
}
