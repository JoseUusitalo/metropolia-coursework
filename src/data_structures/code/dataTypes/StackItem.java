package data_structures.code.dataTypes;

/**
 * An item in a {@link Stack}.
 *
 * @author Jose Uusitalo
 */
public class StackItem
{
	/**
	 * Data stored in this stack item.
	 */
	private Object data;

	/**
	 * The next item in the stack.
	 */
	private StackItem next;

	/**
	 * Creates a new item stack item with the given data and links the old topmost stack item to be the next item of
	 * this stack item.
	 *
	 * @param o data to store
	 * @param oldTop old topmost stack item
	 */
	public StackItem(final Object o, final StackItem oldTop)
	{
		data = o;
		next = oldTop;
	}

	/**
	 * Gets the data in this stack item.
	 *
	 * @return the data in this item
	 */
	public Object get()
	{
		return data;
	}

	/**
	 * Gets the reference to the next stack item.
	 *
	 * @return the next stack item
	 */
	public StackItem next()
	{
		return next;
	}

	/**
	 * Changes the data in this stack item.
	 *
	 * @param o new data
	 */
	public void set(final Object o)
	{
		data = o;
	}
}
