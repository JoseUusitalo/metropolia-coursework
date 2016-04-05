package data_structures.code.dataTypes;

import java.util.Iterator;

@SuppressWarnings("rawtypes")
public interface MyIterator extends Iterator
{
	/**
	 * Checks if this container has an item after the current item.
	 *
	 * @return <code>true</code> if this container has a next item
	 */
	@Override
	public abstract boolean hasNext();

	/**
	 * Gets the next item in the container.
	 *
	 * @return the next container item
	 */
	@Override
	public abstract Object next();
}
