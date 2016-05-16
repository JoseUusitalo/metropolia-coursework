package design_patterns.prototype;

/**
 * A clock that consists of {@link ClockHand} objects that point the time.
 *
 * @author Jose Uusitalo
 */
public class Clock implements Cloneable
{
	/**
	 * The hour {@link ClockHand}.
	 */
	private ClockHand hourHand;

	/**
	 * The minute {@link ClockHand}.
	 */
	private ClockHand minuteHand;

	/**
	 */
	public Clock()
	{
		this.hourHand = new ClockHand(0);
		this.minuteHand = new ClockHand(0);
	}

	/**
	 * Performs a deep copy.
	 */
	@Override
	protected Clock clone()
	{
		Clock deepCopy = null;

		try
		{
			deepCopy = (Clock) super.clone();
			deepCopy.hourHand = this.hourHand.clone();
			deepCopy.minuteHand = this.minuteHand.clone();

			return deepCopy;
		}
		catch (CloneNotSupportedException e)
		{
			return null;
		}
	}

	@Override
	public String toString()
	{
		return super.toString() + " | Time: " + getTime();
	}

	/**
	 * Gets the time this clock is showing in the format:
	 * &lt;hours&gt;:&lt;minutes&gt;
	 *
	 * @return the time in hours and minutes
	 */
	public String getTime()
	{
		return String.format("%02d", hourHand.getValue()) + ":" + String.format("%02d", minuteHand.getValue());
	}

	/**
	 * Changes the value the hour {@link ClockHand} in this clock is pointing to.
	 *
	 * @param hours the new hour value
	 */
	public void setHours(final int hours)
	{
		if (hours > 23 || hours < 0)
			throw new IllegalArgumentException();

		hourHand.setValue(hours);
	}

	/**
	 * Changes the value the minute {@link ClockHand} in this clock is pointing to.
	 *
	 * @param minutes the new minute value
	 */
	public void setMinutes(final int minutes)
	{
		if (minutes > 59 || minutes < 0)
			throw new IllegalArgumentException();

		minuteHand.setValue(minutes);
	}

	/**
	 * A clock hand that points to a number on the clock face.
	 *
	 * @author Jose Uusitalo
	 */
	class ClockHand implements Cloneable
	{
		/**
		 * The time value this clock hand points to.
		 */
		private int value;

		/**
		 * @param timeValue the initial time value of this clock hand
		 */
		public ClockHand(final int timeValue)
		{
			this.value = timeValue;
		}

		/**
		 * Performs a shallow copy.
		 *
		 * @throws CloneNotSupportedException if the object's class does not support the Cloneable interface. Subclasses that override the clone method can also
		 *             throw this exception to indicate that an instance cannot be cloned.
		 */
		@Override
		protected ClockHand clone() throws CloneNotSupportedException
		{
			return (ClockHand) super.clone();
		}

		/**
		 * Gets the number this clock hand is pointing to.
		 *
		 * @return the time value
		 */
		public int getValue()
		{
			return value;
		}

		/**
		 * Changes the number this clock hand is pointing to.
		 *
		 * @param timeValue the new time value
		 */
		public void setValue(final int timeValue)
		{
			this.value = timeValue;
		}
	}
}
