package design_patterns.observer;

/**
 * Observe the clock ticking.
 *
 * @author Jose Uusitalo
 */
public class Observe
{
	/**
	 * @param args arguments
	 */
	public static void main(final String[] args)
	{
		final ClockTimer clock = new ClockTimer(100);
		final DigitalClock device = new DigitalClock(clock);

		Thread t = new Thread(clock);
		t.start();

		try
		{
			Thread.sleep(7000);
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}

		device.stop();
	}
}
