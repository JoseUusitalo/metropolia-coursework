package data_structures.code.sortingAlgorithms;

import java.time.Duration;
import java.time.Instant;
import java.util.Random;

/**
 * Common features shared by sorting algorithms.
 *
 * @author Jose Uusitalo
 */
public abstract class SortingAlgorithm implements ISort
{
	/**
	 * The name of this algorithm.
	 */
	protected static String name;

	/**
	 * Was this sorting algorithm initialized with a premade dataset?
	 */
	protected boolean premadeDataset;

	/**
	 * The size of the dataset.
	 */
	protected int datasetSize;

	/**
	 * The final sorted dataset.
	 */
	protected int[] sortedData;

	/**
	 * The original generated random dataset.
	 */
	protected int[] unsortedData;

	/**
	 * An index variable for iterating through the dataset.
	 */
	protected int index;

	/**
	 * The number of comparisons performed by this algorithm.
	 */
	protected long comparisons;

	/**
	 * The Instant the sorting began.
	 */
	protected Instant start;

	/**
	 * The Instant sorting ended.
	 */
	protected Instant end;

	/**
	 * Generates a random set of data of the size specified in this algorithm's contructor.
	 */
	protected void generateData()
	{
		Random r = new Random();

		// For every element in the array.
		for (index = 0; index < datasetSize; index++)
		{
			// Generate a random number between [0, 1000[
			unsortedData[index] = r.nextInt(1000);
		}

		// Copy the unsorted data to the sorted dataset so it can be sorted.
		sortedData = unsortedData.clone();
	}

	@Override
	public long getComparisons()
	{
		return comparisons;
	}

	@Override
	public Duration getDuration()
	{
		return Duration.between(start, end);
	}

	@Override
	public int[] getUnsortedData()
	{
		return unsortedData;
	}

	@Override
	public int[] getSortedData()
	{
		return sortedData;
	}

	@Override
	public void printResult()
	{
		System.out.println(datasetSize + "," + getName() + "," + comparisons + "," + Duration.between(start, end).toNanos());
	}

	/**
	 * Prints the given dataset.
	 *
	 * @param dataset dataset to print
	 */
	public static void printDataset(final int[] dataset)
	{
		int datasetSize = dataset.length;

		for (int index = 0; index < datasetSize; index++)
		{
			System.out.print(dataset[index] + " ");

			// New line every 40 elements.
			if (index > 0 && index % 40 == 0)
				System.out.println();
		}
		System.out.println();
	}
}
