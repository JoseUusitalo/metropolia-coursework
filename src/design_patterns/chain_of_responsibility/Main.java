package design_patterns.chain_of_responsibility;

/**
 * An example of a chain or responsibility pattern.
 *
 * @author Jose Uusitalo
 */
public class Main
{
	/**
	 * @param args arguments
	 */
	public static void main(final String[] args)
	{
		final RaiseHandler ceo = new CEO();
		final RaiseHandler dephead = new DepartmentHead();
		final RaiseHandler manager = new Manager();
		final Employee employee = new Employee("Jane");
		final double oldPay = employee.getPay();

		manager.setSuccessor(dephead);
		dephead.setSuccessor(ceo);

		System.out.println(employee.getName() + "'s pay is: " + Math.round(employee.getPay()));
		System.out.println();

		for (double d = 0.01; d <= 0.09; d += 0.01)
		{
			System.out.println(employee.getName() + " asks their manager for a " + (int) (d * 100) + "% raise.");
			manager.handleRaise(employee, d);
			System.out.println("New pay is: " + Math.round(employee.getPay()));
			System.out.println();

			try
			{
				Thread.sleep(3000l);
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}

		System.out.println("In the end " + employee.getName() + " successfully managed to increase their pay by "
				+ Math.round(employee.getPay() / oldPay * 100.0 - 100.0) + "%!");
	}
}
