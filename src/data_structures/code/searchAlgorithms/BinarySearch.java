package data_structures.code.searchAlgorithms;

import java.util.ArrayList;
import java.util.List;

/**
 * Binary Search Algorithm.
 *
 * @author Jose Uusitalo
 */
public class BinarySearch
{
	/**
	 * The array is stored as an ArrayList for ease of use.
	 */
	private List<Integer> list;

	/**
	 * @param list
	 */
	public BinarySearch(final List<Integer> list)
	{
		this.list = new ArrayList<Integer>(list);
	}

	/**
	 * Gets the data store.
	 *
	 * @return the list with all the data
	 */
	public List<Integer> getList()
	{
		return list;
	}

	/**
	 * Finds the given {@link Comparable} in the array.
	 *
	 * @param o comparable object to search for
	 * @return the index of the object in the array or <code>-1</code> if the object is not in the array
	 */
	public int find(final int value)
	{
		System.out.println("Find " + value);
		int previousMiddle = list.size() - 1;
		int middle = Math.floorDiv(previousMiddle, 2);

		while (previousMiddle - middle > 0)
		{
			System.out.println("Prev " + previousMiddle);
			System.out.println("Mid " + middle);
			if (value < list.get(middle))
			{
				previousMiddle = middle;
				middle = Math.floorDiv(middle, 2);
			}
			else if (value > list.get(middle))
			{
				middle = (int) Math.ceil((middle + previousMiddle) / 2.0);
			}
			else
			{
				return middle;
			}
		}

		// i is the maximum value.
		return middle;
	}

	public boolean insert(final int value)
	{
		if (list.contains(value))
			return false;

		int currentValue = 0;
		final int lastIndex = list.size() - 1;

		for (int i = lastIndex; i >= 0; i--)
		{
			currentValue = list.get(i);

			if (currentValue < value)
			{
				if (i == lastIndex)
					list.add(value);
				else
					list.set(i + 1, value);
				return true;
			}

			if (i == lastIndex)
				list.add(currentValue);
			else
				list.set(i + 1, currentValue);
		}

		// Value to be inserted will be the first one in the list.
		list.set(0, value);
		return true;
	}
}
