package data_structures.test.sortingAlgorithms;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

import data_structures.code.sortingAlgorithms.QuickSort;
import data_structures.code.sortingAlgorithms.SortingAlgorithm;

/**
 * Tests for the {@link QuickSort} class.
 *
 * @author Jose Uusitalo
 */
@SuppressWarnings("static-method")
public class QuickSortTest
{
	@Test
	public final void generatedSortTest()
	{
		QuickSort sort = new QuickSort(10);
		sort.run();
		System.out.println("Generated:");
		SortingAlgorithm.printDataset(sort.getUnsortedData());
		System.out.println("Sorted:");
		SortingAlgorithm.printDataset(sort.getSortedData());
		assertNotEquals(sort.getUnsortedData(), sort.getSortedData());
	}

	@Test
	public final void premadeSortTest()
	{
		int[] array = { 1, 0, 2, 2, 2, 10, 3, 6, 7, 1 };
		QuickSort sort = new QuickSort(array);
		sort.run();
		System.out.println("Premade:");
		SortingAlgorithm.printDataset(sort.getUnsortedData());
		System.out.println("Sorted:");
		SortingAlgorithm.printDataset(sort.getSortedData());
		assertNotEquals(sort.getUnsortedData(), sort.getSortedData());
	}

	@Test
	public final void testGetName()
	{
		QuickSort sort = new QuickSort(0);
		assertEquals("Quick Sort", sort.getName());
	}

	@Test
	public final void testPrintResult()
	{
		QuickSort sort = new QuickSort(80);
		sort.run();
		sort.printResult();
	}
}
