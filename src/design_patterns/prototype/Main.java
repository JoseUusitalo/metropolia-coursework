package design_patterns.prototype;

/**
 * Using the Prototype pattern.
 *
 * @author Jose Uusitalo
 */
public class Main
{
	/**
	 * @param args arguments
	 */
	public static void main(final String[] args)
	{
		final Clock protoTypeClock = new Clock();

		System.out.println("Prototype: " + protoTypeClock);

		final Clock clock1 = protoTypeClock.clone();
		clock1.setHours(3);
		clock1.setMinutes(21);

		final Clock clock2 = protoTypeClock.clone();
		clock2.setHours(23);

		System.out.println("\nPrototype cloned twice.\n");

		System.out.println("Prototype: " + protoTypeClock);
		System.out.println(clock1);
		System.out.println(clock2);

		clock1.setHours(4);
		clock1.setMinutes(5);

		System.out.println("\nThe first clone has changed.\n");

		System.out.println("Prototype: " + protoTypeClock);
		System.out.println(clock1);
		System.out.println(clock2);
	}
}
