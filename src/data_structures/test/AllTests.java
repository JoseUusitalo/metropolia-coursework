package data_structures.test;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import data_structures.test.dataTypes.AllDataTypeTests;
import data_structures.test.searchAlgorithms.AllSearchAlgorithmTests;
import data_structures.test.sortingAlgorithms.AllSortingAlgorithmTests;

@RunWith(Suite.class)
// @formatter:off
@SuiteClasses({ AllDataTypeTests.class,
				AllSearchAlgorithmTests.class,
				AllSortingAlgorithmTests.class,
				PostfixCalculatorTest.class })
//@formatter:on
public class AllTests
{
	@BeforeClass
	public final static void before()
	{
		System.out.println("\n-------- Starting All Tests... --------\n");
	}

	@AfterClass
	public final static void after()
	{
		System.out.println("\n-------- All Tests Done. --------\n");
	}
}
