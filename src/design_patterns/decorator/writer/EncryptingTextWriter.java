package design_patterns.decorator.writer;

import java.util.ArrayList;
import java.util.List;

/**
 * Text file writer that encrypts the given lines.
 *
 * @author Jose Uusitalo
 */
public class EncryptingTextWriter extends TextFileWriterDecorator
{
	/**
	 * @param textFileWriter the {@link TextFileWriter} whose output is to be encrypted
	 */
	public EncryptingTextWriter(final TextFileWriter textFileWriter)
	{
		super(textFileWriter);
	}

	@Override
	public void write(final String filename, final List<String> lines)
	{
		super.write(filename, encrypt(lines));
	}

	/**
	 * Encrypts the given lines of text.
	 *
	 * @param lines lines of text to encrypt
	 * @return a list of encrypted lines
	 */
	@SuppressWarnings("static-method")
	private List<String> encrypt(final List<String> lines)
	{
		final List<String> encryptedLines = new ArrayList<String>();
		char[] plainChars = null;
		char[] encryptedChars = null;

		for (final String line : lines)
		{
			plainChars = line.toCharArray();
			encryptedChars = new char[plainChars.length];

			for (int i = 0; i < plainChars.length; i++)
				encryptedChars[i] = (char) (plainChars[i] + lines.size() + plainChars.length);

			encryptedLines.add(new String(encryptedChars));
		}

		System.out.println("Encrypted.");

		return encryptedLines;
	}
}
