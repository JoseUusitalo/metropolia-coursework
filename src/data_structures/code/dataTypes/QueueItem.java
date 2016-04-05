package data_structures.code.dataTypes;

/**
 * An item in a {@link Queue}.
 *
 * @author Jose Uusitalo
 */
public class QueueItem
{
	/**
	 * Data stored in this queue item.
	 */
	private Object data;

	/**
	 * The next item in the queue.
	 */
	private QueueItem next;

	/**
	 * Creates a new item queue item with the given data.
	 *
	 * @param o data to store
	 */
	public QueueItem(final Object o)
	{
		data = o;
		next = null;
	}

	/**
	 * Gets the data in this queue item.
	 *
	 * @return the data in this item
	 */
	public Object get()
	{
		return data;
	}

	/**
	 * Gets the reference to the next queue item.
	 *
	 * @return the next queue item
	 */
	public QueueItem next()
	{
		return next;
	}

	/**
	 * Changes the data in this queue item.
	 *
	 * @param o new data
	 */
	public void set(final Object o)
	{
		data = o;
	}

	/**
	 * Changes the reference to the next queue item.
	 *
	 * @param item the next queue item
	 */
	public void setNext(final QueueItem item)
	{
		next = item;
	}
}
