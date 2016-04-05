package data_structures.test.dataTypes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import data_structures.code.dataTypes.BinaryHeap;

/**
 * Tests for the {@link BinaryHeap} class.
 *
 * @author Jose Uusitalo
 */
@SuppressWarnings("static-method")
public class BinaryHeapTest
{
	private static final ArrayList<Integer> initialHeap = new ArrayList<Integer>(Arrays.asList(11, 20, 16, 25, 32, 18, 66, 65, 27));
	private static final ArrayList<Integer> added5Heap = new ArrayList<Integer>(Arrays.asList(5, 11, 16, 25, 20, 18, 66, 65, 27, 32));
	private static final ArrayList<Integer> added33Heap = new ArrayList<Integer>(Arrays.asList(11, 20, 16, 25, 32, 18, 66, 65, 27, 33));
	private static final ArrayList<Integer> added21Heap = new ArrayList<Integer>(Arrays.asList(11, 20, 16, 25, 21, 18, 66, 65, 27, 32));
	private static final ArrayList<Integer> added13Heap = new ArrayList<Integer>(Arrays.asList(11, 13, 16, 25, 20, 18, 66, 65, 27, 32));
	private static final ArrayList<Integer> deletedRootHeap = new ArrayList<Integer>(Arrays.asList(16, 20, 18, 25, 32, 66, 65, 27));

	private static BinaryHeap heap;

	@Before
	public void createHeap()
	{
		heap = new BinaryHeap(initialHeap);
	}

	@After
	public void destroyHeap()
	{
		heap = null;
	}

	@Test
	public final void testInsert_Last()
	{
		System.out.println("\tLast");
		System.out.println("Initial:\t" + heap.getHeap());
		System.out.println("Expected:\t" + added33Heap);

		assertEquals(9, heap.insert(33));

		System.out.println("Actual:\t\t" + heap.getHeap());

		assertTrue(heap.getHeap().equals(added33Heap));
	}

	@Test
	public final void testInsert()
	{
		System.out.println("\tMiddle");
		System.out.println("Initial:\t" + heap.getHeap());
		System.out.println("Expected:\t" + added21Heap);

		assertEquals(4, heap.insert(21));

		System.out.println("Actual:\t\t" + heap.getHeap());

		assertTrue(heap.getHeap().equals(added21Heap));
	}

	@Test
	public final void testInsert_Root()
	{
		System.out.println("\tRoot");
		System.out.println("Initial:\t" + heap.getHeap());
		System.out.println("Expected:\t" + added5Heap);

		assertEquals(0, heap.insert(5));

		System.out.println("Actual:\t\t" + heap.getHeap());

		assertTrue(heap.getHeap().equals(added5Heap));
	}

	@Test
	public final void testInsert_Middle2()
	{
		System.out.println("\tMiddle 2");
		System.out.println("Initial:\t" + heap.getHeap());
		System.out.println("Expected:\t" + added13Heap);

		assertEquals(1, heap.insert(13));

		System.out.println("Actual:\t\t" + heap.getHeap());

		assertTrue(heap.getHeap().equals(added13Heap));
	}

	@Test
	public final void testInsert_Duplicate()
	{
		assertEquals(-1, heap.insert(11));
	}

	@Test
	public final void testInsert_Duplicate_Valid()
	{
		assertEquals(1, heap.insert(16));
	}

	@Test
	public final void testInsert_Duplicate2()
	{
		assertEquals(-1, heap.insert(32));
	}

	@Test
	public final void testGetSize()
	{
		assertEquals(initialHeap.size(), heap.size());
	}

	@Test
	public final void testInsert_Empty()
	{
		BinaryHeap bh = new BinaryHeap();
		assertEquals(0, bh.insert(10));
	}

	@Test
	public final void testDeleteMinEmpty()
	{
		BinaryHeap bh = new BinaryHeap();
		bh.deleteMin();
	}

	@Test
	public final void testDeleteMin_One()
	{
		BinaryHeap bh = new BinaryHeap();
		assertEquals(0, bh.insert(10));
		assertEquals(1, bh.size());
		bh.deleteMin();
		assertEquals(0, bh.size());
	}

	@Test
	public final void testDeleteMin()
	{
		System.out.println("\tDelete Minimum");
		System.out.println("Initial:\t" + heap.getHeap());
		System.out.println("Expected:\t" + deletedRootHeap);

		heap.deleteMin();

		System.out.println("Actual:\t\t" + heap.getHeap());

		assertTrue(heap.getHeap().equals(deletedRootHeap));
	}
}
