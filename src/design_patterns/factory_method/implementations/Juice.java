package design_patterns.factory_method.implementations;

import design_patterns.factory_method.interfaces.Drink;

/**
 * A drink of juice.
 *
 * @author Jose Uusitalo
 */
public class Juice implements Drink
{
	@Override
	public String toString()
	{
		return "Juice";
	}
}
