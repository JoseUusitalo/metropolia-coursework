package data_structures.test.dataTypes;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import data_structures.code.dataTypes.Queue;

/**
 * Tests for the {@link Queue} class.
 *
 * @author Jose Uusitalo
 */
@SuppressWarnings("static-method")
public class QueueTest
{
	private static final String str = "one";
	private static final String str2 = "two";
	private static final String str3 = "three";
	private static Queue queue;

	@Before
	public final void makeQueue()
	{
		queue = new Queue();
	}

	@Test
	public final void testQueue()
	{
		assertEquals(0, queue.size());
		assertEquals(null, queue.head());
	}

	@Test
	public final void testEnqueue()
	{
		queue.enqueue(str);

		assertEquals(str, queue.head().get());
	}

	@Test
	public final void testEnqueue2()
	{
		queue.enqueue(str);
		queue.enqueue(str2);

		assertEquals(str, queue.head().get());
		assertEquals(str2, queue.head().next().get());
	}

	@Test
	public final void testSize_Enqueue()
	{
		queue.enqueue(str);

		assertEquals(1, queue.size());

		queue.enqueue(str2);

		assertEquals(2, queue.size());
	}

	@Test
	public final void testSize_Dequeue()
	{
		queue.enqueue(str);
		queue.enqueue(str2);

		assertEquals(2, queue.size());

		queue.dequeue();

		assertEquals(1, queue.size());

		queue.dequeue();

		assertEquals(0, queue.size());
	}

	@Test
	public final void testEnqueue_null()
	{
		queue.enqueue(null);

		assertEquals(null, queue.head().get());
	}

	@Test
	public final void testDequeue()
	{
		queue.enqueue(str);
		queue.enqueue(str2);

		assertEquals(str, queue.dequeue());
		assertEquals(str2, queue.head().get());
	}

	@Test
	public final void testDequeue_Empty()
	{
		assertEquals(null, queue.dequeue());
	}

	@Test
	public final void testFirst()
	{
		queue.enqueue(str);
		queue.enqueue(str2);

		assertEquals(str, queue.head().get());
	}

	@Test
	public final void testFirst_null()
	{
		assertEquals(null, queue.head());
	}

	@Test
	public final void testNext()
	{
		queue.enqueue(str);
		queue.enqueue(str2);

		assertEquals(str, queue.head().get());
		assertEquals(str2, queue.head().next().get());
	}

	@Test
	public final void testNext_null()
	{
		queue.enqueue(str);

		assertEquals(null, queue.head().next());
	}

	@Test
	public final void testPrint()
	{
		queue.enqueue(str);
		queue.enqueue(str2);
		queue.enqueue(str3);
		queue.print();

		System.out.println("[QueueTest.testPrint()] Please check that the console output contains the words 'one', 'two', and 'three' in that order.");
	}

	@Test
	public final void testPeek()
	{
		queue.enqueue(str);

		assertEquals(str, queue.peek());
	}

	@Test
	public final void testPeek_Empty()
	{
		assertEquals(null, queue.peek());
	}

	@Test
	public final void testEmpty()
	{
		assertEquals(true, queue.empty());

		queue.enqueue(str);

		assertEquals(false, queue.empty());
	}

	@Test
	public final void testDistance()
	{
		queue.enqueue(str);
		queue.enqueue(str2);

		assertEquals(1, queue.distance(str2));
	}

	@Test
	public final void testDistance_2()
	{
		queue.enqueue(str);
		queue.enqueue(str2);
		queue.enqueue(str3);

		assertEquals(2, queue.distance(str3));
	}

	@Test
	public final void testDistance_Top()
	{
		queue.enqueue(str);

		assertEquals(0, queue.distance(str));
	}

	@Test
	public final void testDistance_Empty()
	{
		assertEquals(-1, queue.distance(str));
	}

	@Test
	public final void testDistance_Null()
	{
		queue.enqueue(str);

		assertEquals(-1, queue.distance(str2));
	}

	@Test
	public final void testDistance_Null2()
	{
		queue.enqueue(str);
		queue.enqueue(str2);
		queue.enqueue(str3);

		assertEquals(-1, queue.distance("zero"));
	}

	@Test
	public final void testQueueItemSet()
	{
		queue.enqueue(str);
		assertEquals(str, queue.head().get());
		queue.head().set(str2);
		assertEquals(str2, queue.head().get());
	}
}
