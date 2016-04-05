package data_structures.code.dataTypes;

/**
 * A basic implementation of a stack data type.
 *
 * @author Jose Uusitalo
 */
public class Stack
{
	/**
	 * A reference to the topmost {@link StackItem} in the stack.
	 */
	private StackItem top; // Initially null.

	/**
	 * The number of items in the stack.
	 */
	private int size; // Initially 0.

	/**
	 * Gets the iterator for this stack.
	 *
	 * @return the iterator for this stack
	 */
	public StackIterator iterator()
	{
		return new StackIterator(this);
	}

	/**
	 * Gets the number of items in the stack.
	 *
	 * @return the size of the stack
	 */
	public int size()
	{
		return size;
	}

	/**
	 * Look at the topmost {@link StackItem} in this stack without removing it.
	 *
	 * @return the top of the stack or <code>null</code> if stack is empty
	 */
	public StackItem top()
	{
		if (empty())
			return null;

		return top;
	}

	/**
	 * Removes the topmost {@link StackItem} from the stack.
	 *
	 * @return the Object at the top of the stack
	 */
	public Object pop()
	{
		if (top == null)
			return null;

		final Object o = top.get();
		top = top.next();
		size--;

		return o;
	}

	/**
	 * Adds a new object to the top of the stack.
	 *
	 * @param o object to add to the top
	 */
	public boolean push(final Object o)
	{
		top = new StackItem(o, top);
		size++;
		return true;
	}

	/**
	 * Prints each stack item on its own line.
	 */
	public void print()
	{
		StackItem head = top;

		while (head != null)
		{
			System.out.println(head.get());
			head = head.next();
		}
	}

	/**
	 * Checks if this stack is empty.
	 *
	 * @return <code>true</code> if this stack is empty
	 */
	public boolean empty()
	{
		return size() == 0;
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
		StackItem head = top;

		// The first item in the list is considered to be at index 0.
		int index = 0;

		while (head != null)
		{
			if (head.get().equals(o))
				break;
			index++;
			head = head.next();
		}

		// Index is within the list?
		if (size - 1 >= index)
			return index;
		return -1;
	}
}
