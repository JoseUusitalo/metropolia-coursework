package data_structures.test.sortingAlgorithms;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

import data_structures.code.sortingAlgorithms.SelectionSort;
import data_structures.code.sortingAlgorithms.SortingAlgorithm;

/**
 * Tests for the {@link SelectionSort} class.
 *
 * @author Jose Uusitalo
 */
@SuppressWarnings("static-method")
public class SelectionSortTest
{
	@Test
	public final void testGeneratedSort()
	{
		SelectionSort sort = new SelectionSort(10);
		sort.run();
		System.out.println("Generated:");
		SortingAlgorithm.printDataset(sort.getUnsortedData());
		System.out.println("Sorted:");
		SortingAlgorithm.printDataset(sort.getSortedData());
		assertNotEquals(sort.getUnsortedData(), sort.getSortedData());
	}

	@Test
	public final void testPremadeSort()
	{
		int[] array = { 1, 0, 2, 2, 2, 10, 3, 6, 7, 1 };
		SelectionSort sort = new SelectionSort(array);
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
		SelectionSort sort = new SelectionSort(0);
		assertEquals("Selection Sort", sort.getName());
	}

	@Test
	public final void testGetComparisons()
	{
		SelectionSort sort = new SelectionSort(10);
		sort.run();
		System.out.println(sort.getComparisons());
	}
}
