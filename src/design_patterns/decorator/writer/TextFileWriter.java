package design_patterns.decorator.writer;

import java.util.List;

/**
 * A simple interface for a text file writer.
 *
 * @author Jose Uusitalo
 */
public interface TextFileWriter
{
	/**
	 * Creates a new text file with the given filename and contents.
	 *
	 * @param filename name of the text file
	 * @param lines contents of the text file
	 */
	public void write(final String filename, final List<String> lines);
}
