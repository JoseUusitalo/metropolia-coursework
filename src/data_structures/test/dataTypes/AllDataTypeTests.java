package data_structures.test.dataTypes;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * Tests for all data types.
 *
 * @author Jose Uusitalo
 */
@RunWith(Suite.class)
//@formatter:off
@SuiteClasses({ ArrayStackTest.class,
				BinaryHeapTest.class,
				BinarySearchTreeTest.class,
				HashTableTest.class,
				LLStackTest.class,
				QueueTest.class,
				StackTest.class })
//@formatter:on
public class AllDataTypeTests
{
	@BeforeClass
	public final static void before()
	{
		System.out.println("\n-------- Starting Data Type Tests... --------\n");
	}

	@AfterClass
	public final static void after()
	{
		System.out.println("\n-------- Data Type Tests Done. --------\n");
	}
}
