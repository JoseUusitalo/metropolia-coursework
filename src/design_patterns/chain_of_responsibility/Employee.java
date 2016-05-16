package design_patterns.chain_of_responsibility;

/**
 * An employee.
 *
 * @author Jose Uusitalo
 */
public class Employee
{
	/**
	 * The name of this employee.
	 */
	private String name;

	/**
	 * The pay of this employee.
	 */
	private double pay;

	/**
	 * @param name the name of this employee
	 */
	public Employee(final String name)
	{
		this.name = name;
		this.pay = 2000;
	}

	/**
	 * Gets the name of this employee.
	 *
	 * @return the employee's name
	 */
	public String getName()
	{
		return name;
	}

	/**
	 * Gets the pay of the employee.
	 *
	 * @return the employee's pay
	 */
	public double getPay()
	{
		return pay;
	}

	/**
	 * Gives this employee a raise of the given percent.
	 *
	 * @param percent percent to raise this employee's pay by
	 */
	public void giveRaise(final double percent)
	{
		this.pay = pay * (1.0 + percent);
	}
}
