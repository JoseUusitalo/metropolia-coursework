package data_structures.code.dataTypes;

/**
 * A basic implementation of a stack data type using arrays.
 *
 * @author Jose Uusitalo
 */
public class ArrayStack
{
	/**
	 * Index of the topmost stack item.
	 */
	private int top;

	/**
	 * The number of items in the stack.
	 */
	private int size; // Initially 0.

	/**
	 * The stack array.
	 */
	private Object[] stack;

	public ArrayStack(final int maxSize)
	{
		stack = new Object[maxSize];
		top = -1;
	}

	public ArrayStack()
	{
		this(255);
	}

	/**
	 * Gets the iterator for this stack.
	 *
	 * @return the iterator for this stack
	 */
	public ArrayStackIterator iterator()
	{
		return new ArrayStackIterator(this);
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
	 * Look at the top item of this stack without removing it.
	 *
	 * @return the top Object of this stack or <code>null</code> if stack is empty
	 */
	public Object top()
	{
		if (empty())
			return null;

		return stack[top];
	}

	/**
	 * Removes the topmost {@link StackItem} from the stack.
	 *
	 * @return the Object at the top of the stack
	 */
	public Object pop()
	{
		if (top == -1)
			return null;

		final Object o = top();
		top -= 1;
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
		if (top + 1 < stack.length)
		{
			stack[top + 1] = o;
			top++;
			size++;
			return true;
		}

		return false;
	}

	/**
	 * Prints each stack item on its own line.
	 */
	public void print()
	{
		ArrayStackIterator it = iterator();

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
		return size == 0;
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
		if (size > 0)
		{
			ArrayStackIterator it = iterator();

			int index = 0;

			while (it.hasNext())
			{
				if (it.next().equals(o))
					break;
				index++;
			}

			// Index is within the list?
			if (size - 1 >= index)
				return index;
		}
		return -1;
	}

	protected Object getIndex(final int index)
	{
		return stack[index];
	}
}
