package design_patterns.chain_of_responsibility;

/**
 * A raise handler is person capapble of handling employee raise requests.
 *
 * @author Jose Uusitalo
 */
public abstract class RaiseHandler
{
	/**
	 * The next handler higher in the hierarchy.
	 */
	private RaiseHandler nextHandler;

	/**
	 * Assigns the handlers that is above this in the hierarchy.
	 *
	 * @param successor the next handler
	 */
	public void setSuccessor(final RaiseHandler successor)
	{
		nextHandler = successor;
	}

	/**
	 * Handles a raise request for the given employee.
	 *
	 * @param employee employee who requested a raise
	 * @param percent raise percent
	 */
	public void handleRaise(final Employee employee, final double percent)
	{
		if (nextHandler != null)
			nextHandler.handleRaise(employee, percent);
	}
}
