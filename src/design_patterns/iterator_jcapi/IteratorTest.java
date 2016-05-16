package design_patterns.iterator_jcapi;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Some tests with the Java Collections API {@link Iterator} class.
 *
 * @author Jose Uusitalo
 */
public class IteratorTest
{
	/**
	 * Generates the specified number of consecutive integers.
	 *
	 * @param count number of integers to be generated
	 * @return a list of sequential integers
	 */
	private static List<Integer> getList(final int count)
	{
		final List<Integer> ints = new ArrayList<Integer>();

		for (int i = 0; i < count; i++)
			ints.add(i);

		return ints;
	}

	/**
	 * @param args arguments
	 */
	public static void main(final String[] args)
	{
		uniqueIterators();

		System.out.println("\n------------------\n");

		sameIterator();

		System.out.println("\n------------------\n");

		datasetBeingModified();

		System.out.println("\n------------------\n");

		sameIteratorDelete();
	}

	/**
	 * Tests two threads using their own iterators with the same dataset.
	 */
	private static void uniqueIterators()
	{
		System.out.println("Using a unique iterator in two threads.\n");

		final List<Integer> ints = getList(100);
		final Thread t1 = new ListManipulatorThread(0, ints);
		final Thread t2 = new ListManipulatorThread(1, ints);

		t1.start();
		t2.start();

		try
		{
			// Exit method only after both threads have finished.
			t1.join();
			t2.join();

			System.out.println("\nConclusion: Both threads print the list.");
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * Tests two threads using the same iterator alternatively on the same dataset.
	 */
	private static void sameIterator()
	{
		System.out.println("Using the same iterator in two threads.\n");

		final List<Integer> ints = getList(100);
		final Iterator<Integer> it = ints.iterator();

		System.out.println("List is:");
		System.out.println(ints);
		System.out.println();

		final ThreadAlternator ta = new ThreadAlternator(2);
		final Thread t1 = new ListManipulatorThread(ta, 0, it);
		final Thread t2 = new ListManipulatorThread(ta, 1, it);

		t1.start();
		t2.start();

		try
		{
			// Exit method only after both threads have finished.
			t1.join();
			t2.join();

			System.out.println("\nConclusion: The threads print numbers alternatively, as expected.");
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * Tests a thread printing a list while it is being modified. Sometimes the thread is faster than the loop.
	 */
	private static void datasetBeingModified()
	{
		System.out.println("Dataset of initial size 5 being modified while a thread is reading it.\n");

		final List<Integer> ints = getList(5);
		final Thread t1 = new ListManipulatorThread(0, ints);

		t1.start();

		System.out.println("Modifying dataset! Time to race!");

		for (int i = 10; i < 100; i++)
			ints.add(i);

		try
		{
			// Exit method only after the thread has finished.
			t1.join();

			System.out.println("\nConclusion: The for loop wins and the thread did not catch up unless there's a stacktrace above this print.");
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * Tests two threads using the same iterator alternatively on the same dataset but one of the threads will unexpectedly delete one of the items.
	 */
	private static void sameIteratorDelete()
	{
		System.out.println("Using the same iterator in two threads, surprise delete.\n");

		final List<Integer> ints = getList(100);
		final Iterator<Integer> it = ints.iterator();

		System.out.println("List is:");
		System.out.println(ints);
		System.out.println();

		final ThreadAlternator ta = new ThreadAlternator(2);
		final Thread t1 = new ListManipulatorThread(ta, 0, it);
		final Thread t2 = new ListManipulatorThread(ta, 1, it, 0);

		t1.start();
		t2.start();

		try
		{
			// Exit method only after both threads have finished.
			t1.join();
			t2.join();

			System.out.println(ints);

			System.out.println("\nConclusion: The second thread deletes every other number depending on which thread ran first. Sometimes.");
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
	}
}
