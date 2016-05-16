package design_patterns.bridge.loggers;

import design_patterns.bridge.bridge.AbstractLogger;
import design_patterns.bridge.bridge.LogAPI;

/**
 * The "refined abstraction" in the bridge pattern.
 *
 * @author Jose Uusitalo
 */
public class Logger extends AbstractLogger
{
	/**
	 * @param implementation the logger implementation to be used
	 */
	public Logger(final LogAPI implementation)
	{
		super(implementation);
	}

	@Override
	public void log(final String msg)
	{
		super.log(msg);
	}
}
