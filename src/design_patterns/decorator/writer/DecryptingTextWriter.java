package design_patterns.decorator.writer;

import java.util.ArrayList;
import java.util.List;

/**
 * Text file writer that decrypts the given encrypted lines and writes the decrypted contents to a new file.
 *
 * @author Jose Uusitalo
 */
public class DecryptingTextWriter extends TextFileWriterDecorator
{
	/**
	 * @param textFileWriter the {@link TextFileWriter} whose output is to be decrypted
	 */
	public DecryptingTextWriter(final TextFileWriter textFileWriter)
	{
		super(textFileWriter);
	}

	@Override
	public void write(final String filename, final List<String> encryptedLines)
	{
		super.write(filename, decrypt(encryptedLines));
	}

	/**
	 * Decrypts the given lines of text.
	 *
	 * @param encryptedLines lines of text to decrypt
	 * @return a list of decrypted lines
	 */
	@SuppressWarnings("static-method")
	private List<String> decrypt(final List<String> encryptedLines)
	{
		final List<String> decryptedLines = new ArrayList<String>();
		char[] plainChars = null;
		char[] encryptedChars = null;

		for (final String line : encryptedLines)
		{
			encryptedChars = line.toCharArray();
			plainChars = new char[encryptedChars.length];

			for (int i = 0; i < encryptedChars.length; i++)
				plainChars[i] = (char) ((encryptedChars[i] - encryptedLines.size()) - encryptedChars.length);

			decryptedLines.add(new String(plainChars));
		}

		System.out.println("Decrypted.");

		return decryptedLines;
	}
}
