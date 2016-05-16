package design_patterns.observer;

import java.util.Observable;

/**
 * A clock that ticks time forward at the specified rate.
 *
 * @author Jose Uusitalo
 */
public class ClockTimer extends Observable implements Runnable
{
	/**
	 * Keep the clock ticking?
	 */
	private boolean run;

	/**
	 * How many milliseconds each clock tick takes.
	 */
	private int tickMilliseconds;

	/**
	 * The number of seconds.
	 */
	private int seconds;

	/**
	 * The number of minutes.
	 */
	private int minutes;

	/**
	 * The number of hours.
	 */
	private int hours;

	/**
	 * @param tickMilliseconds the number of milliseconds to sleep between each clock tick
	 */
	public ClockTimer(final int tickMilliseconds)
	{
		this.tickMilliseconds = tickMilliseconds;
		this.run = true;
	}

	/**
	 * @param tickMilliseconds the number of milliseconds to sleep between each clock tick
	 * @param startHour the initial hours
	 * @param startMinute the initial minute
	 * @param startSecond the initial second
	 */
	public ClockTimer(final int tickMilliseconds, final int startHour, final int startMinute, final int startSecond)
	{
		this(tickMilliseconds);

		this.hours = startHour;
		this.minutes = startMinute;
		this.seconds = startSecond;
	}

	/**
	 * Gets the number of seconds passed after the clock was started.
	 *
	 * @return the number of seconds
	 */
	public int getSeconds()
	{
		return seconds;
	}

	/**
	 * Gets the number of minutes passed after the clock was started.
	 *
	 * @return the number of minutes
	 */
	public int getMinutes()
	{
		return minutes;
	}

	/**
	 * Gets the number of hours passed after the clock was started.
	 *
	 * @return the number of hours
	 */
	public int getHours()
	{
		return hours;
	}

	@Override
	public void run()
	{
		while (run)
		{
			if (seconds < 59)
				seconds++;
			else
			{
				seconds = 0;

				if (minutes < 59)
					minutes++;
				else
				{
					minutes = 0;

					if (hours < 23)
						hours++;
					else
						hours = 0;
				}
			}

			setChanged();
			notifyObservers();

			try
			{
				Thread.sleep(tickMilliseconds);
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}
	}

	/**
	 * Stops the clock.
	 */
	public void stop()
	{
		run = false;
	}
}
