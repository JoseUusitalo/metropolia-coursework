package data_structures.code.sortingAlgorithms;

import java.time.Duration;

/**
 * Common features for using sorting algorithms and getting data about the results.
 *
 * @author Jose Uusitalo
 */
public interface ISort
{
	/**
	 * Gets the name of this sorting algorithm.
	 *
	 * @return the name of this algorithm
	 */
	public abstract String getName();

	/**
	 * Gets the number of comparisons performed by this sorting algorithm.
	 */
	public abstract long getComparisons();

	/**
	 * Gets the Duration it took to sort the dataset.
	 */
	public abstract Duration getDuration();

	/**
	 * Gets the original random dataset.
	 *
	 * @return unsorted dataset
	 */
	public abstract int[] getUnsortedData();

	/**
	 * Gets the sorted dataset.
	 *
	 * @return sorted dataset
	 */
	public abstract int[] getSortedData();

	/**
	 * Prints the results of the sort.
	 */
	public abstract void printResult();

	/**
	 * Generates the dataset and runs this sorting algorithm.
	 */
	public abstract void run();
}
