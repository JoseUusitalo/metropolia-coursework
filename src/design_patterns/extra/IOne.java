package design_patterns.extra;

/**
 * An interface declaring a default method {@link IOne#doTheThing()}.
 *
 * @author Jose Uusitalo
 */
public interface IOne
{
	/**
	 * Prints "Interface One".
	 */
	public default void doTheThing()
	{
		System.out.println("Interface One.");
	}
}
