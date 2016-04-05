package data_structures.code.dataTypes;

import java.util.ArrayList;
import java.util.List;

/**
 * A binary heap implementation.
 *
 * @author Jose Uusitalo
 */
public class BinaryHeap
{
	/**
	 * The heap array is stored as a list for easier manipulation.
	 */
	private List<Integer> heap;

	/**
	 * @param heap
	 */
	public BinaryHeap(final ArrayList<Integer> heap)
	{
		this.heap = new ArrayList<Integer>(heap);

		// Indices must start at 1.
		this.heap.add(0, null);
	}

	/**
	 * @param heap
	 */
	public BinaryHeap()
	{
		this.heap = new ArrayList<Integer>();
		this.heap.add(null);
	}

	/**
	 * Gets the index of the parent node of the given index.
	 *
	 * @param index index of the element in the heap
	 * @return index of the parent
	 */
	@SuppressWarnings("static-method")
	private int getParentIndex(final int index)
	{
		return Math.floorDiv(index, 2);
	}

	/**
	 * Gets the index of the left child node of the given index.
	 *
	 * @param index index of the element in the heap
	 * @return index of the left child
	 */
	@SuppressWarnings("static-method")
	private int getLeftChildIndex(final int index)
	{
		return 2 * index;
	}

	/**
	 * Gets the index of the right child node of the given index.
	 *
	 * @param index index of the element in the heap
	 * @return index of the right child
	 */
	@SuppressWarnings("static-method")
	private int getRightChildIndex(final int index)
	{
		return 2 * index + 1;
	}

	/**
	 * Gets the binary heap list.
	 *
	 * @return the heap
	 */
	public List<Integer> getHeap()
	{
		// Ignore the first value.
		return heap.subList(1, heap.size());
	}

	/**
	 * Gets the size of this binary heap.
	 *
	 * @return the size of this binary heap
	 */
	public int size()
	{
		return heap.size() - 1;
	}

	/**
	 * Inserts the given value into this binary heap.
	 *
	 * @param value integer to insert
	 * @return the index of the inserted value or <code>-1</code> if the given value already exists in this heap
	 */
	public int insert(final int value)
	{
		int currentIndex = heap.size();

		if (currentIndex == 1)
		{
			System.out.println("Add initial value.");

			// Add node to tree.
			heap.add(value);
			return currentIndex - 1;
		}

		int currentParentIndex = getParentIndex(currentIndex);
		int currentParentValue = heap.get(currentParentIndex);

		System.out.println("Current: " + "[" + currentIndex + "]");
		System.out.println("Parent: " + currentParentValue + " [" + currentParentIndex + "]");

		// Is the new value greater than the parent of the new node?
		if (currentParentValue < value)
		{
			System.out.println(currentParentValue + " < " + value);
			System.out.println("Add to [" + currentIndex + "]");

			// Add node to tree.
			heap.add(value);
			return currentIndex - 1;
		}
		else if (currentParentValue > value)
		{
			System.out.println(currentParentValue + " > " + value);

			while (currentIndex > 0)
			{
				// Move the parent of the new node down by one.
				if (currentIndex == heap.size())
				{
					System.out.println("Move parent to [" + currentIndex + "]");
					heap.add(currentParentValue);
				}
				else
				{
					System.out.println("Replace " + heap.get(currentIndex) + " with parent " + currentParentValue);
					heap.set(currentIndex, currentParentValue);
				}

				// Attempt to add the value to the old parent's index.
				currentIndex = currentParentIndex;
				currentParentIndex = getParentIndex(currentIndex);

				if (currentParentIndex == 0)
				{
					System.out.println(value + " is the smallest in the tree");
					System.out.println("Add to [" + currentIndex + "]");

					// Set the current value to the index of the old parent.
					heap.set(currentIndex, value);
					return currentIndex - 1;
				}

				currentParentValue = heap.get(currentParentIndex);

				System.out.println("Current: " + heap.get(currentIndex) + " [" + currentIndex + "]");
				System.out.println("Parent: " + heap.get(currentParentIndex) + " [" + currentParentIndex + "]");

				// Is the new value greater than the parent of this node?
				if (currentParentValue < value)
				{
					System.out.println(currentParentValue + " < " + value);
					System.out.println("Add to [" + currentIndex + "]");

					// Set the current value to the index of the old parent.
					heap.set(currentIndex, value);
					return currentIndex - 1;
				}
				else if (currentParentValue == value)
				{
					System.out.println("Duplicate " + value);
					return -1;
				}

				// Else, loop.
			}
		}

		System.out.println("Duplicate " + value);
		// Else parent value == value.
		return -1;
	}

	/**
	 * Deletes the minimum value in the binary heap.
	 */
	public void deleteMin()
	{
		if (heap.size() > 1)
		{
			int currentIndex = 1;
			int currentLeftChildIndex = -1;
			int currentRightChildIndex = -1;
			int currentLeftChildValue = 0;
			int currentRightChildValue = 0;
			int lastIndex = heap.size() - 1;

			System.out.println("Deleting " + heap.get(currentIndex));

			while (currentIndex <= lastIndex)
			{
				currentLeftChildIndex = getLeftChildIndex(currentIndex);
				currentRightChildIndex = getRightChildIndex(currentIndex);

				try
				{

					currentLeftChildValue = heap.get(currentLeftChildIndex);
					currentRightChildValue = heap.get(currentRightChildIndex);
				}
				catch (IndexOutOfBoundsException e)
				{
					// Reached the end of the tree. Delete the current node as it is a duplicate.
					System.out.println("Delete final node " + heap.get(currentIndex));
					heap.remove(currentIndex);

					// Done. Break the loop.
					break;
				}

				lastIndex = heap.size() - 1;

				System.out.println("Current: " + heap.get(currentIndex) + " [" + currentIndex + "]");
				System.out.println("Left: " + currentLeftChildValue + " [" + currentLeftChildIndex + "]");
				System.out.println("Right: " + currentRightChildValue + " [" + currentRightChildIndex + "]");

				// If left child is smaller than the right child.
				if (currentLeftChildValue < currentRightChildValue)
				{
					System.out.println("Replace " + heap.get(currentIndex) + " [" + currentIndex + "] with left child " + currentLeftChildValue + " ["
							+ currentLeftChildIndex + "]");
					// Move left child to current slot.
					heap.set(currentIndex, currentLeftChildValue);

					// Move index to left child.
					currentIndex = currentLeftChildIndex;
				}
				else
				{
					System.out.println("Replace " + heap.get(currentIndex) + " [" + currentIndex + "] with right child " + currentRightChildValue + " ["
							+ currentRightChildIndex + "]");

					// Move right child to current slot.
					heap.set(currentIndex, currentRightChildValue);

					// Move index to right child.
					currentIndex = currentRightChildIndex;
				}

				// Loop.
			}
		}
	}
}
