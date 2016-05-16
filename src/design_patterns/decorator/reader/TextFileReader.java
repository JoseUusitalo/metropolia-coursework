package design_patterns.decorator.reader;

import java.io.FileNotFoundException;
import java.util.List;

/**
 * A simple interface for a text file reader.
 *
 * @author Jose Uusitalo
 */
public interface TextFileReader
{
	/**
	 * Reads the contents of an existing text file.
	 *
	 * @param filePath the path to the text file
	 * @return the lines of text in the file
	 * @throws FileNotFoundException if the specified file did not exist
	 */
	public List<String> read(final String filePath) throws FileNotFoundException;
}
