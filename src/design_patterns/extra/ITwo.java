package design_patterns.extra;

/**
 * An interface declaring a default method {@link ITwo#doTheThing()}.
 *
 * @author Jose Uusitalo
 */
public interface ITwo
{
	/**
	 * Prints "Interface Two".
	 */
	public default void doTheThing()
	{
		System.out.println("Interface Two.");
	}
}
