package data_structures.test.dataTypes;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import data_structures.code.dataTypes.Stack;
import data_structures.code.dataTypes.StackIterator;

/**
 * Tests for the {@link Stack} class.
 *
 * @author Jose Uusitalo
 */
@SuppressWarnings("static-method")
public class StackTest
{
	private static final String str = "one";
	private static final String str2 = "two";
	private static final String str3 = "three";
	private static Stack stack;

	@Before
	public final void makeStack()
	{
		stack = new Stack();
	}

	@Test
	public final void testStack()
	{
		assertEquals(0, stack.size());
		assertEquals(null, stack.top());
	}

	@Test
	public final void testPush()
	{
		stack.push(str);

		assertEquals(str, stack.top().get());
	}

	@Test
	public final void testPush2()
	{
		stack.push(str);
		stack.push(str2);

		assertEquals(str2, stack.top().get());
		assertEquals(str, stack.top().next().get());
	}

	@Test
	public final void testSize_Push()
	{
		stack.push(str);

		assertEquals(1, stack.size());

		stack.push(str2);

		assertEquals(2, stack.size());
	}

	@Test
	public final void testSize_Pop()
	{
		stack.push(str);
		stack.push(str2);

		assertEquals(2, stack.size());

		stack.pop();

		assertEquals(1, stack.size());
	}

	@Test
	public final void testPush_null()
	{
		stack.push(null);

		assertEquals(null, stack.top().get());
	}

	@Test
	public final void testPop()
	{
		stack.push(str);
		stack.push(str2);

		assertEquals(str2, stack.pop());
		assertEquals(str, stack.top().get());
	}

	@Test
	public final void testPop_Empty()
	{
		assertEquals(null, stack.pop());
	}

	@Test
	public final void testTop()
	{
		stack.push(str);
		stack.push(str2);

		assertEquals(str2, stack.top().get());
	}

	@Test
	public final void testTop_null()
	{
		assertEquals(null, stack.top());
	}

	@Test
	public final void testNext()
	{
		stack.push(str);
		stack.push(str2);

		assertEquals(str2, stack.top().get());
		assertEquals(str, stack.top().next().get());
	}

	@Test
	public final void testNext_null()
	{
		stack.push(str);

		assertEquals(null, stack.top().next());
	}

	@Test
	public final void testPrint()
	{
		stack.push(str);
		stack.push(str2);
		stack.push(str3);
		stack.print();

		System.out.println("[StackTest.testPrint()] Please check that the console output contains the words 'three', 'two', and 'one' in that order.");
	}

	@Test
	public final void testEmpty()
	{
		assertEquals(true, stack.empty());

		stack.push(str);

		assertEquals(false, stack.empty());
	}

	@Test
	public final void testDistance()
	{
		stack.push(str);
		stack.push(str2);

		assertEquals(1, stack.distance(str));
	}

	@Test
	public final void testDistance_2()
	{
		stack.push(str);
		stack.push(str2);
		stack.push(str3);

		assertEquals(2, stack.distance(str));
	}

	@Test
	public final void testDistance_Top()
	{
		stack.push(str);

		assertEquals(0, stack.distance(str));
	}

	@Test
	public final void testDistance_Empty()
	{
		assertEquals(-1, stack.distance(str));
	}

	@Test
	public final void testDistance_Null()
	{
		stack.push(str);

		assertEquals(-1, stack.distance(str2));
	}

	@Test
	public final void testDistance_Null2()
	{
		stack.push(str);
		stack.push(str2);
		stack.push(str3);

		assertEquals(-1, stack.distance("zero"));
	}

	@Test
	public final void testIterator_Empty()
	{
		assertEquals(null, stack.iterator().next());
	}

	@Test
	public final void testIterator()
	{
		stack.push(str);

		StackIterator it = stack.iterator();

		assertEquals(str, it.next().get());
		assertEquals(false, it.hasNext());
	}

	@Test
	public final void testIterator2()
	{
		stack.push(str);
		stack.push(str2);
		stack.push(str3);

		StackIterator it = stack.iterator();

		assertEquals(str3, it.next().get());
		assertEquals(str2, it.next().get());
		assertEquals(true, it.hasNext());
		assertEquals(str, it.next().get());
		assertEquals(false, it.hasNext());
	}

	@Test
	public final void testStackItemSet()
	{
		stack.push(str);
		assertEquals(str, stack.top().get());
		stack.top().set(str2);
		assertEquals(str2, stack.top().get());
	}
}
