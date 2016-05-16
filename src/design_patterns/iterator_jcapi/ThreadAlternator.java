package design_patterns.iterator_jcapi;

/**
 * A lock object for alternating thread running.
 *
 * @author Jose Uusitalo
 */
public class ThreadAlternator
{
	/**
	 * The number of threads this alternator handles.
	 */
	final private int threadCount;

	/**
	 * The index of the thread that is allowed to run.
	 */
	private volatile int threadIndex;

	/**
	 * @param threadCount the number of threads this alternator handles
	 */
	public ThreadAlternator(final int threadCount)
	{
		this.threadCount = threadCount;
		this.threadIndex = 0;
	}

	/**
	 * Checks if the thread with the specified index is allowed to run.
	 * If it is, the thread alternator will allow the the thread with the next larger index to run.
	 * If it is not, nothing else happens.
	 * This method is meant to be called from within the thread run loop as this is not a simple checker method, it modifies the index of the next allowed
	 * thread internally.
	 *
	 * @param thisThreadIndex index of the thread that called this method
	 * @return <code>true</code> if the calling thread may run
	 */
	public synchronized boolean mayIRun(final int thisThreadIndex)
	{
		if (threadIndex != thisThreadIndex)
			return false;

		threadIndex = (threadIndex + 1) % threadCount;

		return true;
	}
}
