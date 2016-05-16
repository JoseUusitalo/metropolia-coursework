package design_patterns.builder.builders;

/**
 * An implementation of the {@link HamburgerBuilder} that creates Hesburger hamburgers.
 *
 * @author Jose Uusitalo
 */
public class McDonalds implements HamburgerBuilder
{
	/**
	 * The hamburger being built.
	 */
	private StringBuilder hamburger;

	/**
	 * The final price of the hamburger.
	 */
	private double total;

	/**
	 */
	public McDonalds()
	{
		hamburger = new StringBuilder();
		hamburger.append("---McBurg---\n");
	}

	@Override
	public String toString()
	{
		return "McDonalds (Hamburger Builder: StringBuilder)";
	}

	/**
	 * Adds an ingredient to the hamburger.
	 *
	 * @param name ingredient name
	 * @param price ingredient cost
	 */
	private void addIngredient(final String name, final double price)
	{
		hamburger.append(name + " (" + String.format("%.2f", price) + " €)\n");
		total += price;
	}

	@Override
	public void buildBun()
	{
		addIngredient("Wheat Bun", 0.5);
	}

	@Override
	public void buildTomato()
	{
		addIngredient("A Slice of Tomato", 0.01);
	}

	@Override
	public void buildLettuce()
	{
		addIngredient("Lettuce", 0.06);
	}

	@Override
	public void buildCheese()
	{
		addIngredient("Cheddar Cheese Square", 0.11);
	}

	@Override
	public void buildPickles()
	{
		addIngredient("Thick Patty", 0.32);
	}

	@Override
	public void buildPatty()
	{
		addIngredient("A Couple Pickles", 0.02);
	}

	/**
	 * Stops building the current hamburger and returns the built hamburger.
	 *
	 * @return the final hamburger
	 */
	public String getHamburger()
	{
		hamburger.append("Total: " + String.format("%.2f", (total + (total * 0.5))) + " €");
		final String burger = hamburger.toString();
		hamburger = new StringBuilder();

		return burger;
	}
}
