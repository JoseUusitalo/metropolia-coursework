package design_patterns.singleton;

/**
 * A singleton using the initialization-on-demand holder idiom.
 *
 * @author Jose Uusitalo
 */
public class SingletonLogger
{
	/**
	 * A private inner class holding the {@link SingletonLogger} instance.
	 *
	 * @author Jose Uusitalo
	 */
	private static class Holder
	{
		/**
		 * The only instance of {@link SingletonLogger}.
		 */
		private static final SingletonLogger INSTANCE = new SingletonLogger();
	}

	/**
	 * Logging level.
	 *
	 * @author Jose Uusitalo
	 */
	public enum LogLevel
	{
		INFO, WARN, ERROR;
	}

	/**
	 * Is logging enabled?
	 */
	private boolean enabled;

	/**
	 */
	private SingletonLogger()
	{
	}

	/**
	 * Gets the instance of this singleton.
	 *
	 * @return the singleton instance
	 */
	public static synchronized SingletonLogger getInstance()
	{
		return Holder.INSTANCE;
	}

	/**
	 * Checks if logging is enabled.
	 *
	 * @return <code>true</code> if logging is enabled
	 */
	public boolean isEnabled()
	{
		return enabled;
	}

	/**
	 * Enable/disable logging.
	 *
	 * @param enabled enable logging?
	 */
	public void setEnabled(final boolean enabled)
	{
		this.enabled = enabled;
	}

	/**
	 * Creates an {@link LogLevel#INFO} level log message.
	 *
	 * @param msg log message
	 */
	public void log(final String msg)
	{
		if (enabled)
			System.out.println("[LOG] " + LogLevel.INFO.toString() + ": " + msg);
	}

	/**
	 * Creates a log message at the specified level.
	 *
	 * @param level log message level
	 * @param msg log message
	 */
	public void log(final LogLevel level, final String msg)
	{
		if (enabled)
			System.out.println("[LOG] " + level.toString() + ": " + msg);
	}
}
