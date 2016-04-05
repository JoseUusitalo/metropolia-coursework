package data_structures.code.dataTypes;

/**
 * A basic implementation of a queue data type.
 *
 * @author Jose Uusitalo
 */
public class Queue
{
	/**
	 * A reference to the first {@link QueueItem} in the queue.
	 */
	private QueueItem head; // Initially null.

	/**
	 * A reference to the last {@link QueueItem} in the queue.
	 */
	private QueueItem tail; // Initially null.

	/**
	 * The number of items in the queue.
	 */
	private int size; // Initially 0.

	/**
	 * Gets the number of items in the queue.
	 *
	 * @return the size of the queue
	 */
	public int size()
	{
		return size;
	}

	/**
	 * Gets the first {@link QueueItem} in the queue.
	 *
	 * @return the head of the queue
	 */
	public QueueItem head()
	{
		return head;
	}

	/**
	 * Removes the first {@link QueueItem} from the queue.
	 *
	 * @return the Object at the front of the queue
	 */
	public Object dequeue()
	{
		if (head == null)
			return null;

		final Object o = head.get();
		head = head.next();
		size--;

		return o;
	}

	/**
	 * Adds a new object to the back of the queue.
	 *
	 * @param o object to add to the back of the queue
	 */
	public void enqueue(final Object o)
	{
		QueueItem newItem = new QueueItem(o);

		if (tail != null)
			head.setNext(newItem);

		tail = newItem;

		if (size == 0)
			head = tail;

		size++;
	}

	/**
	 * Prints each queue item on its own line.
	 */
	public void print()
	{
		QueueItem current = head;

		while (current != null)
		{
			System.out.println(current.get());
			current = current.next();
		}
	}

	/**
	 * Look at the top item of this queue without removing it.
	 *
	 * @return the top Object of this queue or <code>null</code> if queue is empty
	 */
	public Object peek()
	{
		if (empty())
			return null;

		return head.get();
	}

	/**
	 * Checks if this queue is empty.
	 *
	 * @return <code>true</code> if this queue is empty
	 */
	public boolean empty()
	{
		return size == 0;
	}

	/**
	 * Gets the distance of the given object from the front of this queue.
	 * The first queue item has the distance of <code>0</code>.
	 * {@link Object#equals(Object)} method is used to compare the objects.
	 *
	 * @param o object to search for
	 * @return the number of queue items in front of the given object in this queue or <code>-1</code> if given object
	 * is not in the queue
	 */
	public int distance(final Object o)
	{
		QueueItem current = head;

		// The first item in the queue is considered to be at index 0.
		int index = 0;

		while (current != null)
		{
			if (current.get().equals(o))
				break;
			index++;
			current = current.next();
		}

		// Index is within the list?
		if (size > index)
			return index;
		return -1;
	}
}
