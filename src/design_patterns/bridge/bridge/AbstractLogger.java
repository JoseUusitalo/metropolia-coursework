package design_patterns.bridge.bridge;

/**
 * The abstraction in the bridge pattern.
 *
 * @author Jose Uusitalo
 */
public abstract class AbstractLogger
{
	/**
	 * Path to the log file.
	 */
	final private String logpath = "./log.txt";

	/**
	 * The logger in use.
	 */
	private LogAPI implementation;

	/**
	 * @param implementation the logger implementation to be used
	 */
	public AbstractLogger(final LogAPI implementation)
	{
		this.implementation = implementation;
	}

	/**
	 * Writes the given message to the log file.
	 *
	 * @param msg message to log
	 */
	public void log(final String msg)
	{
		implementation.writeToFile(logpath, msg);
	}
}
