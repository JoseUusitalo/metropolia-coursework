package data_structures.test.searchAlgorithms;

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
@SuiteClasses({ BinarySearchTest.class })
public class AllSearchAlgorithmTests
{
	@BeforeClass
	public final static void before()
	{
		System.out.println("\n-------- Starting Search Algorithm Tests... --------\n");
	}

	@AfterClass
	public final static void after()
	{
		System.out.println("\n-------- Search Algorithm Tests Done.--------\n");
	}
}
