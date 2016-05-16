package design_patterns.builder.ingredients;

/**
 * A leaf of lettuce.
 *
 * @author Jose Uusitalo
 */
public class Lettuce extends Ingredient
{
	/**
	 * @param name the name of this lettuce
	 * @param price the price of this lettuce
	 */
	public Lettuce(final String name, final double price)
	{
		this.name = name;
		this.price = price;
	}

	@Override
	public String toString()
	{
		return "Lettuce: " + super.toString();
	}
}
