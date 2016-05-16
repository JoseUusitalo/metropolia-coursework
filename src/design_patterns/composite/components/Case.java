package design_patterns.composite.components;

import java.util.HashSet;
import java.util.Set;

/**
 * A computer case that holds multiple components.
 *
 * @author Jose Uusitalo
 */
public class Case implements ComputerComponent
{
	/**
	 * A set of componenets in this case.
	 */
	private Set<ComputerComponent> components;

	/**
	 */
	public Case()
	{
		components = new HashSet<ComputerComponent>();
	}

	@Override
	public boolean attach(final ComputerComponent component)
	{
		return components.add(component);
	}

	@Override
	public boolean detach(final ComputerComponent component)
	{
		return components.remove(component);
	}

	@Override
	public double getPrice()
	{
		double sum = 299.99;

		for (final ComputerComponent c : components)
			sum += c.getPrice();

		return sum;
	}
}
