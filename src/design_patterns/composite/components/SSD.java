package design_patterns.composite.components;

/**
 * A solid disk drive.
 *
 * @author Jose Uusitalo
 */
public class SSD implements ComputerComponent
{
	@Override
	public double getPrice()
	{
		return 109.80;
	}
}
