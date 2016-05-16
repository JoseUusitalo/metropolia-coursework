package design_patterns.iterator_jcapi;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * A {@link Thread} that manipulates (usually prints) the contents of a list of sequential integers using an iterator.
 *
 * @author Jose Uusitalo
 */
public class ListManipulatorThread extends Thread
{
	/**
	 * The list to be manipulated.
	 */
	private List<Integer> list;

	/**
	 * The given iterator of the list.
	 */
	private Iterator<Integer> iterator;

	/**
	 * The index of this thread.
	 */
	private int index;

	/**
	 * Keep working?
	 */
	private boolean work;

	/**
	 * The name of this list printer.
	 */
	private String name;

	/**
	 * A {@link ThreadAlternator} that controls when this thread is allowed to run.
	 */
	private ThreadAlternator alternator;

	/**
	 * Once the element with this value or greater has been reached, delete it and all the next elements.
	 */
	private int deleteValue;

	/**
	 * @param index the index of this thread
	 */
	private ListManipulatorThread(final int index)
	{
		this.name = index + "-T-" + Integer.toHexString(this.hashCode());
		this.index = index;
		this.work = true;
	}

	/**
	 * @param alternator the {@link ThreadAlternator} to be used
	 * @param index the index of this thread
	 * @param list the list to be manipulated
	 */
	public ListManipulatorThread(final ThreadAlternator alternator, final int index, final List<Integer> list)
	{
		this(index);

		this.alternator = alternator;
		this.list = list;
		this.deleteValue = Integer.MAX_VALUE;
	}

	/**
	 * @param alternator the {@link ThreadAlternator} to be used
	 * @param index the index of this thread
	 * @param iterator the iterator to be used
	 */
	public ListManipulatorThread(final ThreadAlternator alternator, final int index, final Iterator<Integer> iterator)
	{
		this(index);

		this.alternator = alternator;
		this.iterator = iterator;
		this.deleteValue = Integer.MAX_VALUE;
	}

	/**
	 * @param alternator the {@link ThreadAlternator} to be used
	 * @param index the index of this thread
	 * @param iterator the iterator to be used
	 * @param deleteValue the elements whose values are equal or greater than this will be removed
	 */
	public ListManipulatorThread(final ThreadAlternator alternator, final int index, final Iterator<Integer> iterator, final int deleteValue)
	{
		this(index);

		this.alternator = alternator;
		this.iterator = iterator;
		this.deleteValue = deleteValue;
	}

	/**
	 * @param index the index of this thread
	 * @param iterator the iterator to be used
	 */
	public ListManipulatorThread(final int index, final Iterator<Integer> iterator)
	{
		this(null, index, iterator);
	}

	/**
	 * @param index the index of this thread
	 * @param list the list to be manipulated
	 */
	public ListManipulatorThread(final int index, final List<Integer> list)
	{
		this(index);

		this.list = list;
		this.deleteValue = Integer.MAX_VALUE;
	}

	@Override
	public String toString()
	{
		return name;
	}

	@Override
	public void run()
	{
		if (work)
		{
			// Determine iterator to use.

			Iterator<Integer> it = null;
			int val = -1;

			if (list != null)
			{
				it = list.iterator();
				System.out.println(this + " uses its own iterator " + it);
			}
			else
			{
				if (iterator != null)
					it = iterator;

				System.out.println(this + " uses the given iterator " + it);
			}

			if (alternator != null)
			{
				// Use alternator.

				System.out.println(this + " is using alternator " + alternator);

				if (it != null)
				{
					while (work)
					{
						if (alternator.mayIRun(index))
						{
							if (it.hasNext())
							{
								try
								{
									val = it.next();

									// Do we delete it?

									if (val >= deleteValue)
									{
										it.remove();
										System.out.println(this + ": deleted " + val);
									}
									else
									{
										System.out.println(this + ": " + val);
									}
								}
								catch (final NoSuchElementException e)
								{
									System.out.println("Whoopsie daisy " + this + " tried to print a non-existent element!");
								}
							}
							else
							{
								System.out.println(this + " done.");
								stopWork();
							}
						}
					}
				}
				else
				{
					System.out.println(this + " is missing an iterator!");
				}
			}
			else
			{
				// Do not use alternator.

				if (it != null)
				{
					while (work)
					{
						while (it.hasNext())
						{
							try
							{
								System.out.println(this + ": " + it.next());
							}
							catch (final ConcurrentModificationException e)
							{
								System.out.println("\nConclusion: " + this + " was too fast for the for loop modifying the list and caught up.");
								e.printStackTrace();
								stopWork();

								// Break the iterator while loop.
								break;
							}
						}

						System.out.println(this + " done.");
						stopWork();
					}
				}
				else
				{
					System.out.println(this + " is missing an iterator!");
				}
			}
		}
	}

	/**
	 * Stops the thread from doing more work.
	 */
	public void stopWork()
	{
		work = false;
	}
}
