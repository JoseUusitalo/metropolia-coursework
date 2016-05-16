package design_patterns.bridge;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import design_patterns.bridge.bridge.LogAPI;
import design_patterns.bridge.loggers.Logger;

/**
 * A factory that creates the correct logger according to the operating system defined in the properties file using
 * reflection.
 *
 * @author Jose Uusitalo
 */
public class LoggerFactory
{
	/**
	 * The properties data.
	 */
	private static Properties properties;

	/**
	 * Loads the properties from the properties file into memory.
	 */
	private static void loadProperties()
	{
		properties = new Properties();

		try
		{
			final FileInputStream in = new FileInputStream("src/bridge/os.properties");
			properties.load(in);
			in.close();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * Gets the appropriate logger according to the operating system defined in the properties file.
	 *
	 * @return a {@link Logger}
	 */
	public static Logger getLogger()
	{
		if (properties == null)
			loadProperties();

		try
		{
			switch (properties.getProperty("os"))
			{
				case "win":
					return new Logger((LogAPI) Class.forName("bridge.loggers.WindowsFileLogger").newInstance());
				case "linux":
					return new Logger((LogAPI) Class.forName("bridge.loggers.LinuxFileLogger").newInstance());
				default:
					// Unknown operating system, logging to the console.
					return new Logger((LogAPI) Class.forName("bridge.loggers.ConsoleLogger").newInstance());
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();

			return null;
		}
	}
}
