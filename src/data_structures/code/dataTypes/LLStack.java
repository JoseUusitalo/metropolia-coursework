package data_structures.code.dataTypes;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * <p>A basic implementation of a stack data type with a {@link LinkedList}.</p>
 * <p>NOTICE: The iteration order is reversed compared to the other stacks!</p>
 *
 * @author Jose Uusitalo
 */
public class LLStack
{
	/**
	 * The stack.
	 */
	private LinkedList<Object> stack;

	public LLStack()
	{
		stack = new LinkedList<Object>();
	}

	/**
	 * Gets the iterator for this stack.
	 *
	 * @return the iterator for this stack
	 */
	public Iterator<Object> iterator()
	{
		return stack.iterator();
	}

	/**
	 * Gets the number of items in the stack.
	 *
	 * @return the size of the stack
	 */
	public int size()
	{
		return stack.size();
	}

	/**
	 * Look at the top item of this stack without removing it.
	 *
	 * @return the top Object of this stack or <code>null</code> if stack is empty
	 */
	public Object top()
	{
		if (empty())
			return null;

		return stack.getLast();
	}

	/**
	 * Removes the topmost object from the stack.
	 *
	 * @return the Object at the top of the stack
	 */
	public Object pop()
	{
		if (top() == null)
			return null;

		final Object o = top();
		stack.remove(size() - 1);

		/*
		 * The same as doing:
		 * return stack.pop();
		 */

		return o;
	}

	/**
	 * Adds a new object to the top of the stack.
	 *
	 * @param o object to add to the top
	 */
	public void push(final Object o)
	{
		stack.add(o);
	}

	/**
	 * Prints each stack item on its own line.
	 */
	public void print()
	{
		Iterator<Object> it = iterator();

		while (it.hasNext())
		{
			System.out.println(it.next());
		}
	}

	/**
	 * Checks if this stack is empty.
	 *
	 * @return <code>true</code> if this stack is empty
	 */
	public boolean empty()
	{
		return stack.isEmpty();
	}

	/**
	 * Gets the distance of the given object from the top of this stack.
	 * The topmost stack item has the distance of <code>0</code>.
	 * {@link Object#equals(Object)} method is used to compare the objects.
	 *
	 * @param o object to search for
	 * @return the number of stack items above the given object in this stack or <code>-1</code> if given object is not
	 * in the stack
	 */
	public int distance(final Object o)
	{
		Iterator<Object> it = iterator();

		// The first item in the list is considered to be at index 0.
		int index = 0;

		while (it.hasNext())
		{
			if (it.next().equals(o))
				break;
			index++;
		}

		// Index is within the list?
		if (size() - 1 >= index)
			return index;
		return -1;
	}
}
