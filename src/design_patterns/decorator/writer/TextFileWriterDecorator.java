package design_patterns.decorator.writer;

import java.util.List;

/**
 * A decorator object for adding new functionality to objects implementing the {@link TextFileWriter} interface.
 *
 * @author Jose Uusitalo
 */
public abstract class TextFileWriterDecorator implements TextFileWriter
{
	/**
	 * The object handling the writing of text files.
	 */
	private TextFileWriter writer;

	/**
	 * @param textFileWriter the {@link TextFileWriter} whose output is to be written to a file
	 */
	public TextFileWriterDecorator(final TextFileWriter textFileWriter)
	{
		writer = textFileWriter;
	}

	@Override
	public void write(final String filename, final List<String> lines)
	{
		writer.write(filename, lines);
	}
}
