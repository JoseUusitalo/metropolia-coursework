package design_patterns.factory_method.implementations;

import design_patterns.factory_method.abstracts.FeedingCreature;
import design_patterns.factory_method.interfaces.Drink;

/**
 * A student creature.
 *
 * @author Jose Uusitalo
 */
public class Student extends FeedingCreature
{
	@Override
	public Drink createDrink()
	{
		return new Juice();
	}
}
