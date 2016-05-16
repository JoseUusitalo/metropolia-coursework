package design_patterns.bridge.loggers;

import design_patterns.bridge.bridge.LogAPI;

/**
 * A logger that writes log files on the Linux operating system.
 * A concrete implementor in the bridge pattern.
 *
 * @author Jose Uusitalo
 */
public class LinuxFileLogger implements LogAPI
{
	@Override
	public void writeToFile(final String filepath, final String line)
	{
		System.out.println("Doing logging on the Linux file system: " + line);
	}
}
