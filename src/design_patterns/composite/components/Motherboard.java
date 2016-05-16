package design_patterns.composite.components;

import java.util.HashSet;
import java.util.Set;

/**
 * A motherboardd that can hold multiple components.
 *
 * @author Jose Uusitalo
 */
public class Motherboard implements ComputerComponent
{
	/**
	 * A set of components in this case.
	 */
	private Set<ComputerComponent> components;

	/**
	 */
	public Motherboard()
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
		double sum = 199.95;

		for (final ComputerComponent c : components)
			sum += c.getPrice();

		return sum;
	}
}
