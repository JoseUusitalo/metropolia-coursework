package data_structures.code.dataTypes;

/**
 * An iterator for my {@link ArrayStack} class.
 *
 * @author Jose Uusitalo
 */
public class ArrayStackIterator implements MyIterator
{
	/**
	 * The {@link ArrayStack} to iterate over.
	 */
	private ArrayStack stack;

	/**
	 * Current {@link StackItem}.
	 */
	private Object current;

	private int index;

	ArrayStackIterator(final ArrayStack stack)
	{
		this.stack = stack;
		this.current = stack.top();
		index = stack.size() - 1;
	}

	@Override
	public boolean hasNext()
	{
		if (current != null)
			return true;

		return false;
	}

	@Override
	public Object next()
	{
		Object old = current;
		try
		{
			current = stack.getIndex(--index);
		}
		catch (IndexOutOfBoundsException e)
		{
			current = null;
		}
		return old;
	}
}
