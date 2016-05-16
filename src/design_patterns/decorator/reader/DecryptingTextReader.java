package design_patterns.decorator.reader;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

/**
 * Text file reader that decrypts the read file.
 *
 * @author Jose Uusitalo
 */
public class DecryptingTextReader extends TextFileReaderDecorator
{
	/**
	 * @param textFileReader the {@link TextFileReader} whose output is to be decrypted
	 */
	public DecryptingTextReader(final TextFileReader textFileReader)
	{
		super(textFileReader);
	}

	@Override
	public List<String> read(final String filename) throws FileNotFoundException
	{
		return decrypt(super.read(filename));
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
