package data_structures.test.sortingAlgorithms;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * Tests for all sorting algorithms.
 *
 * @author Jose Uusitalo
 */
@RunWith(Suite.class)
//@formatter:off
@SuiteClasses({ MergeSortTest.class,
				QuickSortTest.class,
				SelectionSortTest.class })
//@formatter:on
public class AllSortingAlgorithmTests
{
	@BeforeClass
	public final static void before()
	{
		System.out.println("\n-------- Starting Sorting Algorithm Tests... --------\n");
	}

	@AfterClass
	public final static void after()
	{
		System.out.println("\n-------- Sorting Algorithm Tests Done. --------\n");
	}
}
