package design_patterns.builder.ingredients;

/**
 * Slices of pickles.
 *
 * @author Jose Uusitalo
 */
public class Pickles extends Ingredient
{
	/**
	 * @param name the name of these pickles
	 * @param price the price of these pickles
	 */
	public Pickles(final String name, final double price)
	{
		this.name = name;
		this.price = price;
	}

	@Override
	public String toString()
	{
		return "Pickles: " + super.toString();
	}
}
