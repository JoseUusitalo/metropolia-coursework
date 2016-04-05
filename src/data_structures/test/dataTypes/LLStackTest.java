package data_structures.test.dataTypes;

import static org.junit.Assert.assertEquals;

import java.util.Iterator;
import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.Test;

import data_structures.code.dataTypes.ArrayStack;
import data_structures.code.dataTypes.ArrayStackIterator;
import data_structures.code.dataTypes.LLStack;

/**
 * Tests for the {@link LLStack} class.
 *
 * @author Jose Uusitalo
 */
@SuppressWarnings("static-method")
public class LLStackTest
{
	private static final String str = "one";
	private static final String str2 = "two";
	private static final String str3 = "three";
	private static LLStack stack;

	@Before
	public final void makeStack()
	{
		stack = new LLStack();
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

		assertEquals(str, stack.top());
	}

	@Test
	public final void testPush2()
	{
		stack.push(str);
		stack.push(str2);

		Iterator<Object> it = stack.iterator();

		assertEquals(str, it.next());
		assertEquals(str2, it.next());
	}

	@Test
	public final void testPushOverflow()
	{
		ArrayStack smallStack = new ArrayStack(2);
		assertEquals(true, smallStack.push(str));
		assertEquals(true, smallStack.push(str2));
		assertEquals(false, smallStack.push(str3));

		ArrayStackIterator it = smallStack.iterator();

		assertEquals(str2, it.next());
		assertEquals(str, it.next());
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

		assertEquals(null, stack.top());
	}

	@Test
	public final void testPop()
	{
		stack.push(str);
		stack.push(str2);

		assertEquals(str2, stack.pop());
		assertEquals(str, stack.top());
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

		assertEquals(str2, stack.top());
	}

	@Test
	public final void testTop_null()
	{
		assertEquals(null, stack.top());
	}

	@Test
	public final void testPrint()
	{
		stack.push(str);
		stack.push(str2);
		stack.push(str3);
		stack.print();

		System.out.println("[LLStackTest.testPrint()] Please check that the console output contains the words 'one', 'two', and 'three' in that order.");
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

		assertEquals(1, stack.distance(str2));
	}

	@Test
	public final void testDistance_2()
	{
		stack.push(str);
		stack.push(str2);
		stack.push(str3);

		assertEquals(2, stack.distance(str3));
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

	@Test(expected = NoSuchElementException.class)
	public final void testIterator_Empty() throws NoSuchElementException
	{
		assertEquals(null, stack.iterator().next());
	}

	@Test
	public final void testIterator()
	{
		stack.push(str);

		Iterator<Object> it = stack.iterator();

		assertEquals(str, it.next());
		assertEquals(false, it.hasNext());
	}

	@Test
	public final void testIterator2()
	{
		stack.push(str);
		stack.push(str2);
		stack.push(str3);

		Iterator<Object> it = stack.iterator();

		assertEquals(str, it.next());
		assertEquals(str2, it.next());
		assertEquals(true, it.hasNext());
		assertEquals(str3, it.next());
		assertEquals(false, it.hasNext());
	}
}
