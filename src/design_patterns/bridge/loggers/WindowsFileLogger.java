package design_patterns.bridge.loggers;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

import design_patterns.bridge.bridge.LogAPI;

/**
 * A logger that writes log files on the Windows operating system.
 * Technically the same code should also work on Linux but this is just an example.
 * A concrete implementor in the bridge pattern.
 *
 * @author Jose Uusitalo
 */
public class WindowsFileLogger implements LogAPI
{
	/**
	 * The file writer.
	 */
	private Writer bw;

	@Override
	public void writeToFile(final String filepath, final String line)
	{
		if (bw == null)
		{
			try
			{
				bw = new BufferedWriter(new FileWriter(filepath));
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}

		try
		{
			bw.write(line + "\n");
			bw.flush();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}
