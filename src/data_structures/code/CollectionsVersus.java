package data_structures.code;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

import data_structures.code.dataTypes.BinarySearchTree;

/**
 * A class comparing the time performance of Java Collections API {@link TreeSet} and my own {@link BinarySearchTree}
 * implementation.
 *
 * @author Jose Uusitalo
 */
public class CollectionsVersus
{
	/**
	 * Runs the comparison.
	 *
	 * @param args
	 */
	public static void main(final String[] args)
	{
		final int datasetSize = 5000;
		final int datasetRangeStart = 0;
		final int datasetRangeEnd = Integer.MAX_VALUE - 1;
		final int repeats = 100;

		Set<Integer> dataset = null;

		final List<String> results = new ArrayList<String>();

		results.add("Source,Algorithm,Dataset Hash,Dataset Size,Dataset Range Start,Dataset Range End,Time (ms)");

		for (int i = 1; i < repeats + 1; i++)
		{
			dataset = generateDataset(datasetSize, datasetRangeStart, datasetRangeEnd);

			// Run both with the same dataset.
			System.out.println("Running TreeSet...");
			results.add(runJCAPI_TreeSet(dataset, datasetRangeStart, datasetRangeEnd));
			System.out.println("Done.");

			System.out.println("Running BinarySearchTree...");
			results.add(runMy_BinarySearchTree(dataset, datasetRangeStart, datasetRangeEnd));
			System.out.println("Done.");

			System.out.println(i + "/" + repeats);
			System.out.println();
		}

		System.out.println("Generating ordered dataset.");

		Set<Integer> set = new LinkedHashSet<Integer>();

		for (int i = 0; i < datasetSize; i++)
			set.add(i);

		System.out.println("Done.");

		System.out.println("Running TreeSet with ordered dataset...");
		results.add(runJCAPI_TreeSet(set, datasetRangeStart, datasetRangeEnd));
		System.out.println("Done.");

		System.out.println("Running BinarySearchTree with ordered dataset...");
		results.add(runMy_BinarySearchTree(set, datasetRangeStart, datasetRangeEnd));
		System.out.println("Done.");

		System.out.println("Generating reverse ordered dataset.");

		set = new LinkedHashSet<Integer>();

		for (int i = datasetSize - 1; i >= 0; i--)
			set.add(i);

		System.out.println("Running TreeSet with reverse ordered dataset...");
		results.add(runJCAPI_TreeSet(set, datasetRangeStart, datasetRangeEnd));
		System.out.println("Done.");

		System.out.println("Running BinarySearchTree with reverse ordered dataset...");
		results.add(runMy_BinarySearchTree(set, datasetRangeStart, datasetRangeEnd));
		System.out.println("Done.");

		// Print the results.
		System.out.println("---- RESULTS ----\n");

		for (final String s : results)
			System.out.println(s);
	}

	/**
	 * Generates the specified number of random Integers in the specified range without duplicates.
	 *
	 * @param datasetSize number of Integers to generate
	 * @param rangeStart integer range start
	 * @param rangeEnd integer range end
	 * @return a set of unique integers
	 */
	private static Set<Integer> generateDataset(final int datasetSize, final int rangeStart, final int rangeEnd)
	{
		System.out.println("Generating dataset of size " + datasetSize + " in the range [" + rangeStart + ", " + rangeEnd + "]");

		final Set<Integer> set = new HashSet<Integer>();
		final Random random = new Random();
		int rand = 0;
		int randMax = (rangeEnd - rangeStart) + 1;

		for (int i = 0; i < datasetSize; i++)
		{
			do
			{
				rand = random.nextInt(randMax) + rangeStart;
			}
			while (!set.add(rand));
		}

		System.out.println("Done.");
		return set;
	}

	/**
	 * Runs my {@link BinarySearchTree} implementation and measures the time performance.
	 * First adds all the given Integers in the dataset to the tree and then prints out the numbers in order from
	 * smallest to largest.
	 *
	 * @param dataset a set of unique integers
	 * @param datasetRangeStart the minimum allowed integer the dataset was generated with
	 * @param datasetRangeEnd the maximum allowed integer the dataset was generated with
	 * @return a results string containing the name of the used algorithm; the hash, size, start, and end range of the
	 * dataset as well as the time it took for the process to run in milliseconds
	 */
	private static String runMy_BinarySearchTree(final Set<Integer> dataset, final int datasetRangeStart, final int datasetRangeEnd)
	{
		BinarySearchTree bst = new BinarySearchTree();

		// Start the clock.
		final Instant start = Instant.now();

		// Add all the pregenerated numbers to the tree.
		for (final Integer i : dataset)
			bst.add(i);

		// Print the values in order from smallest to largest.
		// System.out.println(bst.getInOrder());
		bst.getInOrder();

		// Stop the clock.
		final Instant end = Instant.now();

		// Return the results as a string.
		return "Me,BinarySearchTree," + dataset.hashCode() + "," + dataset.size() + "," + datasetRangeStart + "," + datasetRangeEnd + ","
				+ Duration.between(start, end).toMillis();
	}

	private static String runJCAPI_TreeSet(final Set<Integer> dataset, final int datasetRangeStart, final int datasetRangeEnd)
	{
		Set<Integer> tree = new TreeSet<Integer>();

		// Start the clock.
		final Instant start = Instant.now();

		// Add all the pregenerated numbers to the tree.
		for (final Integer i : dataset)
			tree.add(i);

		// Print the values in order from smallest to largest.
		final Iterator<Integer> it = tree.iterator();

		while (it.hasNext())
		{
			it.next();
			// System.out.print(it.next() + ", ");
		}

		// Stop the clock.
		final Instant end = Instant.now();

		// System.out.println();

		// Return the results as a string.
		return "JCAPI,TreeSet," + dataset.hashCode() + "," + dataset.size() + "," + datasetRangeStart + "," + datasetRangeEnd + ","
				+ Duration.between(start, end).toMillis();
	}
}
