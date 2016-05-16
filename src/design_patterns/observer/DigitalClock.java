package design_patterns.observer;

import java.util.Observable;
import java.util.Observer;

/**
 * A digital clock implementation that uses a {@link ClockTimer} to show the time.
 *
 * @author Jose Uusitalo
 */
public class DigitalClock implements Observer
{
	/**
	 * A clock.
	 */
	private ClockTimer clock;

	/**
	 * @param clock the {@link ClockTimer} whose output is to be displayed
	 */
	public DigitalClock(final ClockTimer clock)
	{
		this.clock = clock;
		clock.addObserver(this);
	}

	@Override
	public void update(final Observable o, final Object arg)
	{
		if (clock.equals(o))
			draw();
	}

	/**
	 * Prints the zero padded clock time to the console.
	 */
	private void draw()
	{
		final StringBuilder sb = new StringBuilder();
		final int[] times = { clock.getHours(), clock.getMinutes(), clock.getSeconds() };
		int time;

		for (int i = 0; i < 3; i++)
		{
			time = times[i];

			if (time < 10)
				sb.append("0");

			sb.append(time);

			if (i < 2)
				sb.append(":");
		}

		System.out.println(sb.toString());
	}

	/**
	 * Stops the clock.
	 */
	public void stop()
	{
		clock.stop();
	}
}
