package design_patterns.factory_method.implementations;

import design_patterns.factory_method.interfaces.Drink;

/**
 * A drink of water.
 *
 * @author Jose Uusitalo
 */
public class Water implements Drink
{
	@Override
	public String toString()
	{
		return "Water";
	}
}
