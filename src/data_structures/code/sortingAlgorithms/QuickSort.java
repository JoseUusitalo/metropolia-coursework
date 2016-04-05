package data_structures.code.sortingAlgorithms;

import java.time.Instant;

public class QuickSort extends SortingAlgorithm
{
	public QuickSort(final int dataSize)
	{
		this.premadeDataset = false;
		this.datasetSize = dataSize;
		this.sortedData = new int[dataSize];
		this.unsortedData = new int[dataSize];
	}

	public QuickSort(final int[] dataset)
	{
		this.premadeDataset = true;
		this.datasetSize = dataset.length;
		this.sortedData = dataset;
		this.unsortedData = dataset.clone();
	}

	private void quickSort(int table[], int lo0, int hi0)
	{
		int lo = lo0;
		int hi = hi0;
		int mid, swap;

		mid = table[(lo0 + hi0) / 2];

		comparisons++;
		while (lo <= hi)
		{
			comparisons++;
			while (table[lo] < mid)
			{
				++lo;
				comparisons++;
			}

			comparisons++;
			while (table[hi] > mid)
			{
				--hi;
				comparisons++;
			}

			comparisons++;
			if (lo <= hi)
			{
				swap = table[lo];
				table[lo] = table[hi];
				++lo;
				table[hi] = swap;
				--hi;
			}
			comparisons++;
		}

		comparisons++;
		if (lo0 < hi)
		{
			quickSort(table, lo0, hi);
		}

		comparisons++;
		if (lo < hi0)
		{
			quickSort(table, lo, hi0);
		}
	}

	@Override
	public void run()
	{
		if (!premadeDataset)
			super.generateData();
		start = Instant.now();
		quickSort(sortedData, 0, datasetSize - 1);
		end = Instant.now();
	}

	@Override
	public String getName()
	{
		return "Quick Sort";
	}
}
