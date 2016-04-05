package data_structures.test.dataTypes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import data_structures.code.dataTypes.HashTable;

/**
 * Tests for the {@link HashTable} class.
 *
 * @author Jose Uusitalo
 */
@SuppressWarnings("static-method")
public class HashTableTest
{
	private static final int SIZE_PRIME = 167;
	private static final int SIZE_ODD = 65;
	private static final int SIZE_EVEN = 32;

	private static HashTable primetable;
	private static HashTable oddtable;
	private static HashTable eventable;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception
	{
	}

	@Before
	public final void createHashTable()
	{
		primetable = new HashTable(SIZE_PRIME);
		oddtable = new HashTable(SIZE_ODD);
		eventable = new HashTable(SIZE_EVEN);
	}

	@Test
	public final void testCreate()
	{
		HashTable ht = new HashTable(12);
		assertEquals(12, ht.getMaxSize(), 0.001);
		assertEquals(0, ht.getSize());
	}

	@Test(expected = Exception.class)
	public final void testInsert_TooMany() throws Exception
	{
		HashTable ht = new HashTable(2);
		ht.insert(1);
		ht.insert(2);
		ht.insert(3);
	}

	@Test
	public final void testInsert() throws Exception
	{
		primetable.insert(2);
		assertTrue(Arrays.asList(primetable.getHashTable()).contains(2));
	}

	@Test
	public final void testInsert2() throws Exception
	{
		primetable.insert(100);
		assertTrue(Arrays.asList(primetable.getHashTable()).contains(100));
	}

	@Test
	public final void testInsert_Collision() throws Exception
	{
		System.out.println("\nCollision insert\n");
		primetable.insert(primetable.getHashTable().length - 1);
		assertTrue(Arrays.asList(primetable.getHashTable()).contains(primetable.getHashTable().length - 1));

		primetable.insert(0);
		assertTrue(Arrays.asList(primetable.getHashTable()).contains(0));
	}

	@Test
	public final void testInsert_FillTableSequential_Prime() throws Exception
	{
		System.out.println("\nFill table prime of size " + primetable.getMaxSize() + "\n");

		List<Integer> list = new ArrayList<Integer>();

		for (int value = 0; value < primetable.getMaxSize(); value++)
		{
			list.add(value);
			primetable.insert(value);
		}

		System.out.println("Done");

		assertTrue(Arrays.asList(primetable.getHashTable()).containsAll(list));
	}

	@Test
	public final void testInsert_FillTableSequential_Odd() throws Exception
	{
		System.out.println("\nFill table odd of size " + oddtable.getMaxSize() + "\n");

		List<Integer> list = new ArrayList<Integer>();

		for (int value = 0; value < oddtable.getMaxSize(); value++)
		{
			list.add(value);
			oddtable.insert(value);
		}

		System.out.println("Done");

		assertTrue(Arrays.asList(oddtable.getHashTable()).containsAll(list));
	}

	@Test
	public final void testInsert_FillTableSequential_Even() throws Exception
	{
		System.out.println("\nFill table even of size " + eventable.getMaxSize() + "\n");

		List<Integer> list = new ArrayList<Integer>();

		for (int value = 0; value < eventable.getMaxSize(); value++)
		{
			list.add(value);
			eventable.insert(value);
		}

		System.out.println("Done");

		assertTrue(Arrays.asList(eventable.getHashTable()).containsAll(list));
	}

	@Test
	public final void testFind() throws Exception
	{
		int index = primetable.insert(123);
		assertTrue(Arrays.asList(primetable.getHashTable()).contains(123));
		assertEquals(new Integer(123), primetable.getHashTable()[index]);
		assertEquals(index, primetable.find(123));
	}

	@Test
	public final void testFind_Collisions() throws Exception
	{
		primetable.insert(primetable.getHashTable().length - 1);
		int index = primetable.insert(0);
		assertTrue(Arrays.asList(primetable.getHashTable()).contains(0));
		assertEquals(new Integer(0), primetable.getHashTable()[index]);
		assertEquals(index, primetable.find(0));
	}

	@Test
	public final void testInsert_RandomFill() throws Exception
	{
		System.out.println("\nFill table odd of size " + oddtable.getMaxSize() + " - random\n");

		List<Integer> list = new ArrayList<Integer>();
		int r = 0;

		for (int i = 0; i < oddtable.getMaxSize(); i++)
		{
			do
			{
				r = (int) (Math.random() * oddtable.getHashTable().length * 2);
			}
			while (list.contains(r));

			System.out.println("Random: " + r);
			list.add(r);
			oddtable.insert(r);
		}

		System.out.println("Done");

		assertTrue(Arrays.asList(oddtable.getHashTable()).containsAll(list));
	}
}
