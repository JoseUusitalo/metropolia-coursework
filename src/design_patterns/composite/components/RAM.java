package design_patterns.composite.components;

/**
 * A stick of random access memory.
 *
 * @author Jose Uusitalo
 */
public class RAM implements ComputerComponent
{
	@Override
	public double getPrice()
	{
		return 35.99;
	}
}
