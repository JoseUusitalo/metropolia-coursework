package design_patterns.chain_of_responsibility;

/**
 * The Chief Executive Officer capable of handling raises over 4%.
 *
 * @author Jose Uusitalo
 */
public class CEO extends RaiseHandler
{
	@Override
	public void handleRaise(final Employee employee, final double percent)
	{
		if (Double.compare(percent, 0.05) >= 0 && Double.compare(percent, 0.08) < 0)
		{
			System.out.println(" └─► CEO says \"I will take your request into consideration.\"");
			employee.giveRaise(percent);
		}
		else
			System.out.println(" └─○ CEO says \"No.\"");
	}
}
