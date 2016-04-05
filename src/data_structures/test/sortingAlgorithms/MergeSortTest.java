package data_structures.test.sortingAlgorithms;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.time.Duration;

import org.junit.Test;

import data_structures.code.sortingAlgorithms.MergeSort;
import data_structures.code.sortingAlgorithms.SortingAlgorithm;

/**
 * Tests for the {@link MergeSort} class.
 *
 * @author Jose Uusitalo
 */
@SuppressWarnings("static-method")
public class MergeSortTest
{
	@Test
	public final void testGeneratedSort()
	{
		MergeSort sort = new MergeSort(10);
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
		MergeSort sort = new MergeSort(array);
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
		MergeSort sort = new MergeSort(0);
		assertEquals("Merge Sort", sort.getName());
	}

	@Test
	public final void testGetDuration()
	{
		MergeSort sort = new MergeSort(10);
		sort.run();
		assertEquals(-1, sort.getDuration().compareTo(Duration.ofMillis(3000)));
	}

	@Test
	public final void testPrintDataset()
	{
		MergeSort sort = new MergeSort(80);
		sort.run();
		SortingAlgorithm.printDataset(sort.getSortedData());
	}
}
