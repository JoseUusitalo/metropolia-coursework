package data_structures.code.dataTypes;

/**
 * A hashtable implementation using a squared strategy.
 *
 * @author Jose Uusitalo
 */
public class HashTable
{
	/**
	 * The hashtable.
	 */
	private Integer[] hashtable;

	/**
	 * The number of elements in the hashtable.
	 */
	private int elements;

	/**
	 * The maximum number of elements the table can be guaranteed to fit.
	 */
	private int maxSize;

	/**
	 * @param maxSize
	 */
	public HashTable(final int maxSize)
	{
		this.maxSize = maxSize;
		this.hashtable = new Integer[(int) (Math.pow(maxSize, 2.0) + 1)];
	}

	/**
	 * Gets the hashtable.
	 *
	 * @return the hashtable
	 */
	public Integer[] getHashTable()
	{
		return hashtable;
	}

	/**
	 * Gets the maximum number of elements this hashtable can hold.
	 *
	 * @return the maximum size of this hashtable
	 */
	public int getMaxSize()
	{
		return maxSize;
	}

	/**
	 * Gets the number of elements in this hashtable.
	 *
	 * @return the size of this hashtable
	 */
	public int getSize()
	{
		return elements;
	}

	/**
	 * Inserts the given value into the hashtable.
	 *
	 * @param value value to insert
	 * @return the index at which the value was inserted
	 */
	public int insert(final int value) throws Exception
	{
		int collisions = 0;
		int index = hash(value, collisions);
		boolean success = false;

		if (elements <= maxSize - 1)
		{
			while (!success)
			{
				System.out.println("Adding value " + value + " to " + index);

				if (hashtable[index] == null)
				{
					hashtable[index] = value;
					elements++;
					collisions = 0;
					success = true;
				}
				else
				{
					collisions++;
					System.out.println("Collisions: " + collisions + " | " + hashtable[index] + " already exists at " + index);
					index = hash(value, collisions);
				}

			}
		}
		else
			throw new Exception("Maximum size reached.");

		return index;
	}

	/**
	 * A hash function with a squared collision strategy.
	 *
	 * @param value value to hash
	 * @param collisions number of collisions encountered when inserting this value
	 * @return the index of the value in the hashtable
	 */
	private int hash(final int value, final int collisions)
	{
		return Math.floorMod(value, (hashtable.length - 1)) + (int) Math.pow(collisions, 2.0);
	}

	/**
	 * Finds the given value in the hashtable.
	 *
	 * @param value value to search for
	 * @return the index of the value
	 */
	public int find(final int value)
	{
		int collisions = 0;
		int index = hash(value, collisions);

		System.out.println("Looking for value " + value);

		while (hashtable[index] != value)
		{
			collisions++;
			System.out.println("Collisions: " + collisions + " | " + hashtable[index] + " already exists at " + index);
			index = hash(value, collisions);
		}

		System.out.println("Found at " + index);
		return index;
	}
}
