package design_patterns.factory_method.implementations;

import design_patterns.factory_method.abstracts.FeedingCreature;
import design_patterns.factory_method.interfaces.Drink;

/**
 * A headmaster creature.
 *
 * @author Jose Uusitalo
 */
public class Headmaster extends FeedingCreature
{
	@Override
	public Drink createDrink()
	{
		return new Coffee();
	}
}
