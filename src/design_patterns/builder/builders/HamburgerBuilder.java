package design_patterns.builder.builders;

/**
 * An interface for building any kind of hamburger.
 *
 * @author Jose Uusitalo
 */
public interface HamburgerBuilder
{
	/**
	 * Builds a hamburger bun.
	 */
	public void buildBun();

	/**
	 * Builds a hamburger tomato slice.
	 */
	public void buildTomato();

	/**
	 * Builds a hamburger lettuce
	 */
	public void buildLettuce();

	/**
	 * Builds a hamburger cheese slice.
	 */
	public void buildCheese();

	/**
	 * Builds hamburger pickles
	 */
	public void buildPickles();

	/**
	 * Builds a hamburger patty.
	 */
	public void buildPatty();
}
