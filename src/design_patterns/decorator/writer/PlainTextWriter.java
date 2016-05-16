package design_patterns.decorator.writer;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * Text file writer that writes the given lines into a file unchanged.
 *
 * @author Jose Uusitalo
 */
public class PlainTextWriter implements TextFileWriter
{
	@Override
	public void write(final String filename, final List<String> lines)
	{
		final File file = new File("src/decorator/" + filename + ".txt");
		boolean ok = false;

		try
		{
			final BufferedWriter bw = new BufferedWriter(new FileWriter(file));

			for (final String line : lines)
			{
				bw.write(line);
				bw.newLine();
			}

			bw.flush();
			bw.close();

			System.out.println("File written to: " + file.getAbsolutePath());
			ok = true;
		}
		catch (FileNotFoundException ex)
		{
			ex.printStackTrace();
		}
		catch (IOException ex)
		{
			ex.printStackTrace();
		}

		if (!ok)
		{
			file.delete();

			System.out.println("Failed to write file.");
		}
	}
}
