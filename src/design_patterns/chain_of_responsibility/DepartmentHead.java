package design_patterns.chain_of_responsibility;

/**
 * The Department Head can handle raises between and 3% and 4%.
 *
 * @author Jose Uusitalo
 */
public class DepartmentHead extends RaiseHandler
{
	@Override
	public void handleRaise(final Employee employee, final double percent)
	{
		if (Double.compare(percent, 0.02) > 0 && Double.compare(percent, 0.05) < 0)
		{
			System.out.println("└─► Department Head says \"I see, I will think about it.\"");
			employee.giveRaise(percent);
		}
		else
		{
			System.out.println("└┬○ Department Head says \"This is beyond my responsibilities.\"");
			super.handleRaise(employee, percent);
		}
	}
}
