package design_patterns.bridge;

import design_patterns.bridge.bridge.AbstractLogger;

/**
 * The client that uses the abstraction in the bridge pattern.
 *
 * @author Jose Uusitalo
 */
public class Client
{
	/**
	 * @param args arguments
	 */
	public static void main(final String[] args)
	{
		final AbstractLogger logger = LoggerFactory.getLogger();

		logger.log("Hello World.");
		logger.log("Hello again!");

		System.out.println("Done logging.");
	}
}
