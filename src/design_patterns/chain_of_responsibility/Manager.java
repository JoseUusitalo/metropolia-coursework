package design_patterns.chain_of_responsibility;

/**
 * The Manager only handles raises under 3%.
 *
 * @author Jose Uusitalo
 */
public class Manager extends RaiseHandler
{
	@Override
	public void handleRaise(final Employee employee, final double percent)
	{
		if (Double.compare(percent, 0.02) <= 0)
		{
			System.out.println("─► Manager says \"Alright, I'll see what I can do.\"");
			employee.giveRaise(percent);
		}
		else
		{
			System.out.println("┬○ Manager says \"This is beyond my responsibilities.\"");
			super.handleRaise(employee, percent);
		}
	}
}
