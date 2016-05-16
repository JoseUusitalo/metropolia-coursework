package design_patterns.decorator.reader;

import java.io.FileNotFoundException;
import java.util.List;

/**
 * A decorator object for adding new functionality to objects implementing the {@link TextFileReader} interface.
 *
 * @author Jose Uusitalo
 */
public abstract class TextFileReaderDecorator implements TextFileReader
{
	/**
	 * The object handling the reading of text files.
	 */
	private TextFileReader reader;

	/**
	 * @param textFileReader the {@link TextFileReader} whose output is to be modified
	 */
	public TextFileReaderDecorator(final TextFileReader textFileReader)
	{
		reader = textFileReader;
	}

	@Override
	public List<String> read(final String filename) throws FileNotFoundException
	{
		return reader.read(filename);
	}
}
