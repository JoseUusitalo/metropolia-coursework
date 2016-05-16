package design_patterns.bridge.loggers;

import design_patterns.bridge.bridge.LogAPI;

/**
 * The default implementation that logs to console only.
 *
 * @author Jose Uusitalo
 */
public class ConsoleLogger implements LogAPI
{
	@Override
	public void writeToFile(final String filepath, final String line)
	{
		System.out.println("LOG: " + line);
	}
}
