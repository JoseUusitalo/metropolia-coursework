package data_structures.code;

import data_structures.code.sortingAlgorithms.MergeSort;
import data_structures.code.sortingAlgorithms.QuickSort;
import data_structures.code.sortingAlgorithms.SelectionSort;

public class SortingAlgorithms
{
	public static void main(String[] args)
	{
		int datasetSize = 15000;
		double datasetSizeMultiplier = 2.0;
		int maxDatasetSize = 100000;

		System.out.println("DatasetSize,Algorithm,Comparisons,Time (ns)");

		runMergeSort(datasetSize, datasetSizeMultiplier, maxDatasetSize);
		runQuickSort(datasetSize, datasetSizeMultiplier, maxDatasetSize);
		runSelectionSort(datasetSize, datasetSizeMultiplier, maxDatasetSize);
	}

	private static void runMergeSort(final int datasetSize, final double datasetSizeMultiplier, final int maxDatasetSize)
	{
		for (int dataset = datasetSize; dataset <= maxDatasetSize; dataset *= datasetSizeMultiplier)
		{
			MergeSort mergeSort = new MergeSort(dataset);
			mergeSort.run();
			mergeSort.printResult();
		}
	}

	private static void runQuickSort(final int datasetSize, final double datasetSizeMultiplier, final int maxDatasetSize)
	{
		for (int dataset = datasetSize; dataset <= maxDatasetSize; dataset *= datasetSizeMultiplier)
		{
			QuickSort quickSort = new QuickSort(dataset);
			quickSort.run();
			quickSort.printResult();
		}
	}

	private static void runSelectionSort(final int datasetSize, final double datasetSizeMultiplier, final int maxDatasetSize)
	{
		for (int dataset = datasetSize; dataset <= maxDatasetSize; dataset *= datasetSizeMultiplier)
		{
			SelectionSort selectionSort = new SelectionSort(dataset);
			selectionSort.run();
			selectionSort.printResult();
		}
	}
}
