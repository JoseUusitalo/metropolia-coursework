package design_patterns.command;

/**
 * A projection screen that can either scroll up or down.
 *
 * @author Jose Uusitalo
 */
@SuppressWarnings("static-method")
public class ProjectionScreen
{
	/**
	 * Scrolls up the projection screen.
	 */
	public void scrollUp()
	{
		System.out.println("The projection screen is scrolling up.");
	}

	/**
	 * Scrolls down the projection screen.
	 */
	public void scrollDown()
	{
		System.out.println("The projection screen is scrolling down.");
	}
}
