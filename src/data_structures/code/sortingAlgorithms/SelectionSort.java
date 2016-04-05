package data_structures.code.sortingAlgorithms;

import java.time.Instant;

public class SelectionSort extends SortingAlgorithm
{
	private int smallest, tempSmallest, j;

	public SelectionSort(final int dataSize)
	{
		this.premadeDataset = false;
		this.datasetSize = dataSize;
		this.sortedData = new int[dataSize];
		this.unsortedData = new int[dataSize];
	}

	public SelectionSort(final int[] dataset)
	{
		this.premadeDataset = true;
		this.datasetSize = dataset.length;
		this.sortedData = dataset;
		this.unsortedData = dataset.clone();
	}

	private void sortData()
	{
		comparisons++; // Outer for loop.

		// For every element in the array.
		for (index = 0; index < datasetSize; index++)
		{
			// Assume that the current element is the smallest.
			smallest = index;
			comparisons++; // Inner for loop,

			// For every element in the array after the current one.
			for (j = index + 1; j < datasetSize; j++)
			{
				comparisons++; // If check.

				// Does a smaller value exist?
				if (sortedData[j] < sortedData[smallest])
				{
					// New smallest value index.
					smallest = j;
				}

				comparisons++; // Inner for loop end.
			}

			comparisons++; // If check.

			// Is the new smallest value index different from the original?
			if (smallest != index)
			{
				// Store the smallest found value in a temporary variable.
				tempSmallest = sortedData[smallest];

				// Set the old smallest value to the index where the smallest value was.
				sortedData[smallest] = sortedData[index];

				// Set the smallest value to the current index.
				sortedData[index] = tempSmallest;
			}

			comparisons++; // Outer for loop end.
		}
	}

	@Override
	public void run()
	{
		if (!premadeDataset)
			generateData();
		start = Instant.now();
		sortData();
		end = Instant.now();
	}

	@Override
	public String getName()
	{
		return "Selection Sort";
	}
}
