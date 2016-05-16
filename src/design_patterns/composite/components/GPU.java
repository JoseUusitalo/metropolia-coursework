package design_patterns.composite.components;

/**
 * A graphics processing unit.
 *
 * @author Jose Uusitalo
 */
public class GPU implements ComputerComponent
{
	@Override
	public double getPrice()
	{
		return 450.15;
	}
}
