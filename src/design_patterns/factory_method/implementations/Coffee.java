package design_patterns.factory_method.implementations;

import design_patterns.factory_method.interfaces.Drink;

/**
 * A drink of coffee.
 *
 * @author Jose Uusitalo
 */
public class Coffee implements Drink
{
	@Override
	public String toString()
	{
		return "Coffee";
	}
}
