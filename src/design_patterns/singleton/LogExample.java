package design_patterns.singleton;

import design_patterns.singleton.SingletonLogger.LogLevel;

/**
 * An example of using a singleton logger.
 *
 * @author Jose Uusitalo
 */
public class LogExample
{
	/**
	 * @param args arguments
	 */
	public static void main(final String[] args)
	{
		final SingletonLogger logger = SingletonLogger.getInstance();

		// The constructor SingletonLogger() is not visible
		// final SingletonLogger secondLogger = new SingletonLogger();

		final SingletonLogger secondLoggerInstance = SingletonLogger.getInstance();

		System.out.println("The first instance of the logger is the same as the second instance: " + logger.equals(secondLoggerInstance));

		logger.log("Logger is disabled!");
		secondLoggerInstance.setEnabled(true);

		logger.log("First log message.");
		logger.log(LogLevel.WARN, "It works!");
		logger.log("Now disabling logging.");
		logger.setEnabled(false);

		secondLoggerInstance.log("This does not work.");
		System.out.println("Logging is enabled: " + logger.isEnabled());
		System.out.println("Turning it on.");
		logger.setEnabled(true);

		if (logger.isEnabled())
			secondLoggerInstance.log("Ok!");
		else
			logger.log(LogLevel.ERROR, "Logging is disabled!");
	}
}
