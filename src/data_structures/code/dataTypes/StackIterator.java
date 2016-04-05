package data_structures.code.dataTypes;

/**
 * An iterator for my {@link Stack} class.
 *
 * @author Jose Uusitalo
 */
public class StackIterator implements MyIterator
{
	/**
	 * Current {@link StackItem}.
	 */
	private StackItem current;

	StackIterator(final Stack stack)
	{
		this.current = stack.top();
	}

	@Override
	public boolean hasNext()
	{
		if (current != null)
			return true;

		return false;
	}

	@Override
	public StackItem next()
	{
		StackItem old = current;
		try
		{
			current = current.next();
		}
		catch (NullPointerException e)
		{
			// Do nothing, current is always null.
		}
		return old;
	}
}
