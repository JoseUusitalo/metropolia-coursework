package data_structures.test.searchAlgorithms;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import data_structures.code.searchAlgorithms.BinarySearch;

/**
 * Tests for the {@link BinarySearch} class.
 *
 * @author Jose Uusitalo
 */
@SuppressWarnings("static-method")
public class BinarySearchTest
{
	private final static List<Integer> listEven = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 5, 8, 13, 21));
	private final static List<Integer> listOdd = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 5, 8, 13, 21, 34));
	private static BinarySearch bsEven;
	private static BinarySearch bsOdd;

	@Before
	public final void createList()
	{
		bsEven = new BinarySearch(listEven);
		bsOdd = new BinarySearch(listOdd);
	}

	@Test
	public final void testFind_Even()
	{
		assertEquals(2, bsEven.find(3));
	}

	@Test
	public final void testFind_Odd()
	{
		assertEquals(2, bsOdd.find(3));
	}

	@Test
	public final void testFind_Even_Min()
	{
		assertEquals(1, bsEven.find(listEven.get(1)));
	}

	@Test
	public final void testFind_Odd_Min()
	{
		assertEquals(1, bsOdd.find(listOdd.get(1)));
	}

	@Test
	public final void testFind_Even_Max()
	{
		assertEquals(listEven.size() - 1, bsEven.find(listEven.get(listEven.size() - 1)));
	}

	@Test
	public final void testFind_Odd_Max()
	{
		assertEquals(listOdd.size() - 1, bsOdd.find(listOdd.get(listOdd.size() - 1)));
	}

	@Test
	public final void testInsert()
	{
		System.out.println(listEven + " + 9");
		assertTrue(bsEven.insert(9));
		System.out.println(bsEven.getList());
	}

	@Test
	public final void testInsert_Min()
	{
		System.out.println(listOdd + " + -1");
		assertTrue(bsOdd.insert(-1));
		System.out.println(bsOdd.getList());
	}

	@Test
	public final void testInsert_Max()
	{
		System.out.println(listEven + " + 9999");
		assertTrue(bsEven.insert(9999));
		System.out.println(bsEven.getList());
	}

	@Test
	public final void testInsert_Duplicate()
	{
		System.out.println(listEven + " + 2");
		assertFalse(bsEven.insert(2));
		System.out.println(bsEven.getList());
	}
}
