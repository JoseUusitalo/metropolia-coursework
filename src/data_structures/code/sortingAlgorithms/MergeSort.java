package data_structures.code.sortingAlgorithms;

import java.time.Instant;

public class MergeSort extends SortingAlgorithm
{
	/**
	 * Temporary array for storing data.
	 */
	private int[] tempArray;

	public MergeSort(final int dataSize)
	{
		this.premadeDataset = false;
		this.datasetSize = dataSize;
		this.tempArray = new int[dataSize];
		this.sortedData = new int[dataSize];
		this.unsortedData = new int[dataSize];
	}

	public MergeSort(final int[] dataset)
	{
		this.premadeDataset = true;
		this.datasetSize = dataset.length;
		this.sortedData = dataset;
		this.unsortedData = dataset.clone();
		this.tempArray = new int[dataset.length];
	}

	/**
	 * Merges the two sorted halves of the given array so both halves are interlaced together in the correct order.
	 *
	 * @param array array with two sorted halves (subarrays)
	 * @param first first index of the first subarray
	 * @param middleIndex last index of the first subarray
	 * @param last last index of the last subarray
	 */
	private void merge(final int array[], final int first, final int middleIndex, final int last)
	{
		/*
		 * Assumption:
		 * Subrrays array[first...middleIndex] and array[middleIndex+1...last] are sorted.
		 */

		// Running index number for the first subarray.
		int currentFirstSubarrayIndex = first;

		// Running index number for the last subarray.
		int currentLastSubarrayIndex = middleIndex + 1;

		// Running index for the temporary array where the result is written.
		int tempIndex = 0;

		comparisons += 2; // First while loop check.
		while (currentFirstSubarrayIndex < middleIndex + 1 && currentLastSubarrayIndex < last + 1)
		{
			comparisons++; // If check.

			if (array[currentFirstSubarrayIndex] < array[currentLastSubarrayIndex])
			{
				tempArray[tempIndex++] = array[currentFirstSubarrayIndex++];
			}
			else
			{
				tempArray[tempIndex++] = array[currentLastSubarrayIndex++];
			}

			comparisons += 2; // While loop check.
		}

		/*
		 * Either the first or the last subarray has now been looped through.
		 * Moving the rest of the elements from the other subarray to the temp array.
		 */

		comparisons++; // First while loop check.
		while (currentFirstSubarrayIndex < middleIndex + 1)
		{
			tempArray[tempIndex++] = array[currentFirstSubarrayIndex++];
			comparisons++; // While loop check.
		}

		comparisons++; // First while loop check.
		while (currentLastSubarrayIndex < last + 1)
		{
			tempArray[tempIndex++] = array[currentLastSubarrayIndex++];
			comparisons++; // While loop check.
		}

		comparisons++; // First for loop check.
		// Move the temp array back to the original array.
		for (currentFirstSubarrayIndex = 0; currentFirstSubarrayIndex < tempIndex; currentFirstSubarrayIndex++)
		{
			array[first + currentFirstSubarrayIndex] = tempArray[currentFirstSubarrayIndex];
			comparisons++; // While loop check.
		}
	}

	/**
	 * Sort the data.
	 *
	 * @param array array to sort
	 * @param first first index of the subrarray to sort
	 * @param last last index of the subarray to sort
	 */
	private void sort(final int array[], final int first, final int last)
	{
		comparisons++; // If loop

		// At least two elements are required to sort.
		if (first < last)
		{
			/*
			 * The decimal part is lost but ultimately it means nothing.
			 * The goal is to split the array in two and it is irrelevant which part of the array is larger.
			 */
			int middleIndex = (first + last) / 2;

			// Sort the first half of the array.
			sort(array, first, middleIndex);

			// Sort the last half of the array.
			sort(array, middleIndex + 1, last);

			// Merge the two sorted arrays.
			merge(array, first, middleIndex, last);
		}
	}

	@Override
	public void run()
	{
		if (!premadeDataset)
			super.generateData();
		start = Instant.now();
		sort(sortedData, 0, datasetSize - 1);
		end = Instant.now();
	}

	@Override
	public String getName()
	{
		return "Merge Sort";
	}
}
