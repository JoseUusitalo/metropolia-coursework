package design_patterns.decorator.reader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * A text file reader that reads plain text files.
 *
 * @author Jose Uusitalo
 */
public class PlainTextReader implements TextFileReader
{
	@Override
	public List<String> read(final String filename) throws FileNotFoundException
	{
		final List<String> lines = new ArrayList<String>();
		final File file = new File("src/decorator/" + filename + ".txt");
		System.out.println("Reading: " + file.getAbsolutePath());

		try
		{
			final BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
			bufferedReader.lines().forEach((final String line) -> lines.add(line));
			bufferedReader.close();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}

		return lines;
	}
}
