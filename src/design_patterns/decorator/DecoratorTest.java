package design_patterns.decorator;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

import design_patterns.decorator.reader.DecryptingTextReader;
import design_patterns.decorator.reader.PlainTextReader;
import design_patterns.decorator.reader.TextFileReader;
import design_patterns.decorator.writer.DecryptingTextWriter;
import design_patterns.decorator.writer.EncryptingTextWriter;
import design_patterns.decorator.writer.PlainTextWriter;
import design_patterns.decorator.writer.TextFileWriter;

/**
 * An example of the Decorator pattern used for writing encrypted text and decrypting the written text.
 *
 * @author Jose Uusitalo
 */
public class DecoratorTest
{
	/**
	 * Reads all lines of text from a text with the given name.
	 *
	 * @param filename name of the text file without the extension
	 * @return a list of strings
	 * @throws IOException if an I/O error occurs reading from the file or a malformed or unmappable byte sequence is read
	 */
	private static List<String> readLines(final String filename) throws IOException
	{
		return Files.readAllLines(FileSystems.getDefault().getPath("src/decorator/" + filename + ".txt"));
	}

	/**
	 * Reads all lines of text from a text with the given name.
	 *
	 * @param filename name of the text file without the extension
	 * @throws IOException if an I/O error occurs reading from the file or a malformed or unmappable byte sequence is read
	 */
	private static void printContents(final String filename) throws IOException
	{
		final List<String> lines = readLines(filename);

		System.out.println(filename + ".txt Contents:");
		lines.forEach((final String line) -> System.out.println("\t" + line));
		System.out.println();
	}

	/**
	 * @param args arguments
	 */
	public static void main(final String[] args)
	{
		try
		{
			final List<String> lines = new ArrayList<String>();
			lines.add("Hello World!");
			lines.add("This text is on a new line.");
			lines.add("Just another line to add some content to the file.");

			System.out.println("\t---- USING PLAIN TEXT WRITER ----");
			final TextFileWriter writer = new PlainTextWriter();
			writer.write("plain", lines);
			printContents("plain");

			System.out.println("\t---- USING ENCRYPTING WRITER ----");
			final TextFileWriter encryptingWriter = new EncryptingTextWriter(writer);
			encryptingWriter.write("encrypted", lines);
			printContents("encrypted");

			System.out.println("\t---- USING DECRYPTING WRITER ----");
			final TextFileWriter decryptingWriter = new DecryptingTextWriter(writer);
			decryptingWriter.write("encrypted-decrypted", readLines("encrypted"));
			printContents("encrypted-decrypted");

			System.out.println("\t---- USING MULTIWRITER ----");
			/*
			 * This writer does the following things:
			 * 1. Encrypts the lines.
			 * 2. Decrypts the lines.
			 * 3. Encrypts the lines.
			 * 4. Writes the lines to the file.
			 */
			final TextFileWriter multiWriter = new EncryptingTextWriter(new DecryptingTextWriter(new EncryptingTextWriter(writer)));

			// Write plain text file first so we can use it later.
			writer.write("multiwrite", lines);

			// Write the lines from multiwrite.txt to multiwrite.txt
			multiWriter.write("multiwrite", readLines("multiwrite"));
			printContents("multiwrite");

			System.out.println("\t---- USING PLAIN TEXT READER ----");
			final TextFileReader reader = new PlainTextReader();
			reader.read("plain").forEach((final String line) -> System.out.println(line));
			System.out.println();

			reader.read("encrypted").forEach((final String line) -> System.out.println(line));
			System.out.println();

			System.out.println("\t---- USING DECRYPTING READER ----");
			final TextFileReader decryptingReader = new DecryptingTextReader(reader);
			decryptingReader.read("encrypted").forEach((final String line) -> System.out.println(line));

		}
		catch (final IOException e)
		{
			e.printStackTrace();
		}
	}
}
