package design_patterns.builder;

import design_patterns.builder.builders.HamburgerBuilder;

/**
 * The director in control of builders.
 *
 * @author Jose Uusitalo
 */
public class RecipeMaster
{
	/**
	 * The {@link HamburgerBuilder} used to build a hamburger.
	 */
	private HamburgerBuilder builder;

	/**
	 */
	public RecipeMaster()
	{
	}

	@Override
	public String toString()
	{
		return "Recipe Master (Hamburger Director)";
	}

	/**
	 * Sets the {@link HamburgerBuilder} of this director.
	 *
	 * @param builder the new builder
	 */
	public void setBuilder(final HamburgerBuilder builder)
	{
		this.builder = builder;
	}

	/**
	 * Builds a hamburger with the {@link HamburgerBuilder} assigned to this director.
	 */
	public void buildHamburger()
	{
		if (builder != null)
		{
			builder.buildBun();

			builder.buildTomato();
			builder.buildCheese();
			builder.buildPatty();
			builder.buildLettuce();

			builder.buildBun();

			builder.buildPickles();
			builder.buildLettuce();
			builder.buildCheese();
			builder.buildPatty();

			builder.buildBun();
		}
		else
			System.out.println(this + ": Unable to build a hamburger without a builder.");
	}
}
