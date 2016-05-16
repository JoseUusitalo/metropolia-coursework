package design_patterns.bridge.bridge;

/**
 * The implementor in the bridge pattern.
 *
 * @author Jose Uusitalo
 */
public interface LogAPI
{
	/**
	 * Writes the given line of text to a file.
	 *
	 * @param filepath file path of the file to write to
	 * @param line text to write
	 */
	public void writeToFile(final String filepath, final String line);
}
